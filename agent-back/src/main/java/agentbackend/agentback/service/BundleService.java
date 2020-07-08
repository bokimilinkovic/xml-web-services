package agentbackend.agentback.service;

import agentbackend.agentback.controller.dto.BookingDTO;
import agentbackend.agentback.controller.dto.GetBundleDTO;
import agentbackend.agentback.model.*;
import agentbackend.agentback.repository.AdRepository;
import agentbackend.agentback.repository.BookingRepository;
import agentbackend.agentback.repository.BundleRepository;
import agentbackend.agentback.repository.UserRepository;
import agentbackend.agentback.soapClient.BookingSoapClient;
import com.car_rent.agent_api.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BundleService {

    @Autowired
    BundleRepository bundleRepository;

    @Autowired
    BookingRepository bookingRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdService adService;

    @Autowired
    BookingSoapClient bookingSoapClient;

    @Autowired
    AdRepository adRepository;

    public boolean acceptBundleRequest(Long id, String name) {

        User user = userRepository.findByEmail(name);
        if (user == null)
            return false;

        Optional<Bundle> bundle = bundleRepository.findById(id);
        if (!bundle.isPresent())
            return false;

        List<Ad> ads = new ArrayList<>();

        for (Booking b : bundle.get().getBookings()) {
            b.setState(RequestState.PAID);
            bookingRepo.save(b);
            adService.deactivateAd(b.getAd().getId(), name);
            ads.add(b.getAd());
        }


        for (Ad ad : ads) {
            List<Booking> bookings = bookingRepo.findAllByAd(ad);
            for (Booking b : bookings) {
                if (!bundle.get().getBookings().contains(b)) {
                    b.setState(RequestState.CANCELED);
                    bookingRepo.save(b);
                }

            }

        }

        AcceptBundleResponse response = bookingSoapClient.acceptBundle(bundle.get().getServiceId(), name);
        if (response == null)
            return false;

        return true;
    }


    public boolean rejectBundleRequest(Long id, String name) {

        User user = userRepository.findByEmail(name);
        if (user == null)
            return false;

        Optional<Bundle> bundle = bundleRepository.findById(id);
        if (!bundle.isPresent())
            return false;

        for (Booking b : bundle.get().getBookings()) {
            if (b.getState().equals(RequestState.PENDING)) {
                b.setState(RequestState.CANCELED);
                bookingRepo.save(b);
            }
        }

        RejectBundleResponse response = bookingSoapClient.rejectBundle(bundle.get().getServiceId(), name);
        if (response == null)
            return false;

        return true;
    }

    public Set<GetBundleDTO> getAllReceivedBundleRequests(String email) {
        Set<GetBundleDTO> bundles = new HashSet<>();
        // soap
        User user = userRepository.findByEmail(email);
        if (user == null)
            return bundles;

        GetBundlesResponse serviceBundles = bookingSoapClient.getBundles(user.getEmail());
        for (BundleDetail bundleDetail : serviceBundles.getResponse()) {
            Optional<Bundle> bundle = bundleRepository.findById(bundleDetail.getId());
            if (!bundle.isPresent()) {
                Bundle newBundle = new Bundle();
                newBundle.setServiceId(bundleDetail.getId());
                newBundle.setLoaner(bundleDetail.getLoaner());
                bundleRepository.save(newBundle);
                for (BookingDetails booking : bundleDetail.getBooksDetails()) {
                    Ad ad = adRepository.findByServiceId(booking.getAd());
                    Booking newBooking = new Booking(booking, ad, newBundle);
                    bookingRepo.save(newBooking);
                    newBundle.getBookings().add(newBooking);
                    bundleRepository.save(newBundle);
                }
            }
        }

        List<Ad> ads = adRepository.findAllByOwner(user.getEmail());
        if (ads == null)
            return bundles;

        HashMap<Long, Bundle> bundlesAgent = new HashMap<>();

        for (Ad ad : ads) {
            List<Booking> bookings = bookingRepo.findAllByAdAndBundleIdNotNull(ad);
            for (Booking book : bookings) {
                if (!bundlesAgent.containsKey(book.getBundle().getId()))
                    bundlesAgent.put(book.getBundle().getId(), book.getBundle());
            }
        }

        for (Bundle bundle : bundlesAgent.values()) {
            GetBundleDTO getBundleDTO = new GetBundleDTO(bundle);
            bundles.add(getBundleDTO);
        }

        return bundles;
    }
}
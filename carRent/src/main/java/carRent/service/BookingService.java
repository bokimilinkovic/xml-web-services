package carRent.service;

import carRent.model.Booking;
import carRent.model.RequestState;
import carRent.model.User;
import carRent.model.dto.AdDTO;
import carRent.model.dto.BookDTO;
import carRent.model.dto.BookingDTO;
import carRent.model.dto.BundleDTO;
import carRent.repository.BookingRepository;
import carRent.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserRepository userRepo;

    public boolean createBookingRequest(BundleDTO bundleDTO, String name) throws JSONException {

        // provera da li user sa name postoji
        User user = userRepo.findByEmail(name);
        if (user == null)
            return false;

        for (BookDTO bookDTO : bundleDTO.getBooks()) {

            if (bookDTO == null || bookDTO.getAdId() == null || bookDTO.getEndDate() == null || bookDTO.getStartDate() == null || bookDTO.getPlace() == null)
                return false;

            if (bookDTO.getPlace().equals(""))
                return false;

            if (bookDTO.getStartDate().isAfter(bookDTO.getEndDate()))
                return false;

            AdDTO ad = new RestTemplate().getForObject("http://localhost:8080/cars/api/ads/" + bookDTO.getAdId(),
                    AdDTO.class);

            if (ad == null)
                return false;

            Booking booking = new Booking(bookDTO.getStartDate(), bookDTO.getEndDate(), RequestState.PENDING, bookDTO.getPlace(), LocalDateTime.now(), ad.getId(), user.getId());
            bookingRepo.save(booking);

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            if (booking.getState().equals(RequestState.PENDING)) {
                                booking.setState(RequestState.CANCELED);
                                bookingRepo.save(booking);
                                cancel();
                            }
                        }
                    },
                    24 * 60 * 60 * 1000
            );
        }

        return true;
    }

    public boolean reserveBookingRequest(BundleDTO bundleDTO, String name) throws JSONException {
        // provera da li user sa name postoji
        User user = userRepo.findByEmail(name);
        if (user == null || bundleDTO.getLoaner() == null)
            return false;

        if (bundleDTO.getLoaner().equals(""))
            return false;

        User loaner = userRepo.findByEmail(bundleDTO.getLoaner());
        if (loaner == null)
            return false;

        for (BookDTO bookDTO : bundleDTO.getBooks()) {

            if (bookDTO == null || bookDTO.getAdId() == null || bookDTO.getEndDate() == null || bookDTO.getStartDate() == null || bookDTO.getPlace() == null)
                return false;

            if (bookDTO.getPlace().equals(""))
                return false;

            if (bookDTO.getStartDate().isAfter(bookDTO.getEndDate()))
                return false;


            AdDTO ad = new RestTemplate().getForObject("http://localhost:8080/cars/api/ads/" + bookDTO.getAdId(),
                    AdDTO.class);

            if (ad == null)
                return false;

            Booking booking = new Booking(bookDTO.getStartDate(), bookDTO.getEndDate(), RequestState.PAID, bookDTO.getPlace(), LocalDateTime.now(), ad.getId(), loaner.getId());
            bookingRepo.save(booking);

            //canceluj sve ostale bookinge koju su vezani za taj ad, mozda ne izvlaci kako treba iz baze, proveri kasnije
            ArrayList<Booking> bookings = bookingRepo.findAllByAds(ad.getId());
            for(Booking b:bookings){
                b.setState(RequestState.CANCELED);
                bookingRepo.save(b);
            }

        }

        return true;
    }

    public boolean acceptBookingRequest(Long id, String name) throws JSONException {

        // provera da li user sa name postoji
        User user = userRepo.findByEmail(name);
        if (user == null)
            return false;

        Optional<Booking> booking = bookingRepo.findById(id);
        if (!booking.isPresent())
            return false;

        booking.get().setState(RequestState.RESERVED);
        bookingRepo.save(booking.get());

        for (Long ad : booking.get().getAds()) {
            Map<String, Long> params = new HashMap<String, Long>();
            params.put("id", ad);
            new RestTemplate().delete("http://cars-ads/api/ad/deactivate/{id}", params);
        }

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        if (booking.get().getState().equals(RequestState.RESERVED)) {
                            booking.get().setState(RequestState.CANCELED);
                            bookingRepo.save(booking.get());
                            cancel();
                        }
                    }
                },
                12 * 60 * 60 * 1000
        );


        return true;
    }

    public boolean cancelBookingRequest(Long id, String name) {

        // provera da li user sa name postoji
        User user = userRepo.findByEmail(name);
        if (user == null)
            return false;

        Optional<Booking> booking = bookingRepo.findById(id);
        if (!booking.isPresent() || booking.get().getState() != RequestState.RESERVED || user.getId() != booking.get().getLoaner())
            return false;

        booking.get().setState(RequestState.CANCELED);
        bookingRepo.save(booking.get());


        return true;
    }

    public boolean rejectBookingRequest(Long id, String name) throws JSONException {

        // provera da li user sa name postoji, provera da li je ad userov
        User user = userRepo.findByEmail(name);
        if (user == null)
            return false;

        Optional<Booking> booking = bookingRepo.findById(id);
        if (!booking.isPresent() || booking.get().getState() != RequestState.PENDING)
            return false;

        //provera da li je ad ili ads userov
        JSONArray array = new JSONArray();
        for (Long ad : booking.get().getAds())
            array.put(ad);
        JSONObject object = new JSONObject();
        object.put("array", array);

        Boolean check = new RestTemplate().postForObject("http://localhost:8080/cars-ads/api/ad/check", object, Boolean.class);

        if (check == null || !check)
            return false;

        booking.get().setState(RequestState.CANCELED);
        bookingRepo.save(booking.get());


        return true;
    }

    public ArrayList<BookingDTO> getAllBookingRequests(String name) {
        // provera da li user sa name postoji
        ArrayList<BookingDTO> bookingDTOS = new ArrayList<>();
        User user = userRepo.findByEmail(name);
        if (user == null)
            return bookingDTOS;

        ArrayList<Booking> bookings = bookingRepo.findAllByLoaner(user.getId());
        for (Booking booking : bookings) {
            BookingDTO dto = new BookingDTO(booking);
            bookingDTOS.add(dto);
        }

        return bookingDTOS;

    }


}

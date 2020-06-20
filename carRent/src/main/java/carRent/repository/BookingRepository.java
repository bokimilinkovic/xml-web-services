package carRent.repository;

import carRent.model.Booking;
import carRent.model.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    ArrayList<Booking> findAllByLoaner(Long id);
    ArrayList<Booking> findAllByAd(Long id);

    List<Booking> findAllByState(RequestState paid);
}

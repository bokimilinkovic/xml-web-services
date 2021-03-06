package carRent.model.dto;

import carRent.model.Booking;
import carRent.model.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GetBundleDTO {

    private Long id;
    private Long loaner;
    private String loanerEmail;
    private List<BookingDTO> bookings = new ArrayList<>();

    public GetBundleDTO() {
    }

    public GetBundleDTO(Bundle bundle, String loanerEmail) {
        this.id = bundle.getId();
        this.loaner = bundle.getLoaner();
        this.loanerEmail = loanerEmail;
        for (Booking b : bundle.getBookings())
            this.bookings.add(new BookingDTO(b));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoaner() {
        return loaner;
    }

    public void setLoaner(Long loaner) {
        this.loaner = loaner;
    }

    public String getLoanerEmail() {
        return loanerEmail;
    }

    public void setLoanerEmail(String loanerEmail) {
        this.loanerEmail = loanerEmail;
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }
}

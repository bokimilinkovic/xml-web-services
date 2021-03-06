package carRent.model.dto;

import com.car_rent.agent_api.BookDetails;
import com.car_rent.agent_api.BundleDetails;

import java.util.ArrayList;
import java.util.List;

public class BundleDTO {

    private List<BookDTO> books;

    // Samo kod samostalnog zauzeca se koristi
    private String loaner;

    public BundleDTO(List<BookDTO> books) {
        this.books = books;
    }

    public BundleDTO(List<BookDTO> books, String loaner) {
        this.books = books;
        this.loaner = loaner;
    }

    public BundleDTO(BundleDetails bundleDetails) {
        this.books = new ArrayList<>();
        for (BookDetails bookDetails : bundleDetails.getBooksDetails())
            this.books.add(new BookDTO(bookDetails));

        this.loaner = bundleDetails.getLoaner();
    }

    public BundleDTO() {
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public String getLoaner() {
        return loaner;
    }

    public void setLoaner(String loaner) {
        this.loaner = loaner;
    }
}

package Model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class BookingResponse {
    private int numPage;
    private List<BookingDisplay> bookingDisplayList;

    public BookingResponse(int numPage, List<BookingDisplay> bookingDisplayList) {
        this.numPage = numPage;
        this.bookingDisplayList = bookingDisplayList;
    }

    public BookingResponse() {
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public List<BookingDisplay> getBookingDisplayList() {
        return bookingDisplayList;
    }

    public void setBookingDisplayList(List<BookingDisplay> bookingDisplayList) {
        this.bookingDisplayList = bookingDisplayList;
    }
}

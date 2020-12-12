package Interface;

import Model.Booking;
import Model.BookingDisplay;
import Model.Customer;

import java.util.List;

public interface BookingInterface {
    //Xem danh sach Book van con hieu luc
    public List<BookingDisplay> viewBooking(int offset, int size);
    //tao Booking
    public boolean newBooking(Customer customer,Booking booking);
}

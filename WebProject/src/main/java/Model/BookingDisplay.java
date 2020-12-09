package Model;

public class BookingDisplay {
    private Customer customer;
    private Booking booking;
    private Account account;

    public BookingDisplay(Customer customer, Booking booking, Account account) {
        this.customer = customer;
        this.booking = booking;
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

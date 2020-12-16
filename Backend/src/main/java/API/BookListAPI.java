package API;

import Controller.BookingController;
import Model.Booking;
import Model.BookingDisplay;
import Model.BookingResponse;
import Model.Customer;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.List;
@Path("/book")
public class BookListAPI {
    //checked
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BookingResponse getBooking(@QueryParam("size") int size,
                                      @QueryParam("page") int page){
        BookingResponse bookingResponse=new BookingResponse();
        bookingResponse.setNumPage(new BookingController().getNumPage(size));
        bookingResponse.setBookingDisplayList(new BookingController().viewBooking(size,page));
        return bookingResponse;
    }
    //checked
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String booking(String json){
        JSONObject jsonObject=new JSONObject(json);
        String name_customer=jsonObject.getString("name_customer");
        String age=jsonObject.getString("age");
        String id_admin=jsonObject.getString("id_admin");
        String noid=jsonObject.getString("noid");
        String phone=jsonObject.getString("phone");
        String note=jsonObject.getString("note");
        String id_room=jsonObject.getString("id_room");
        String start=jsonObject.getString("start");
        String end=jsonObject.getString("end");
        if(new BookingController().newBooking(new Customer(name_customer,Integer.valueOf(age),Integer.valueOf(id_admin),phone,note,noid),new Booking(0,Integer.valueOf(id_room), Date.valueOf(start),Date.valueOf(end)))){
            return "true";
        }
        return "false";
    }
}

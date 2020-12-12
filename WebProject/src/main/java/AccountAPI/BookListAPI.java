package AccountAPI;

import Controller.BookingController;
import Model.Booking;
import Model.BookingDisplay;
import Model.Customer;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.List;
@Path("/book")
public class BookListAPI {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookingDisplay> getList(){
        return new BookingController().viewBooking(0,5);
    }

    @POST
    public boolean booking(String json){
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
        return new BookingController().newBooking(new Customer(name_customer,Integer.valueOf(age),Integer.valueOf(id_admin),phone,note,noid),new Booking(Integer.valueOf(id_room),0, Date.valueOf(start),Date.valueOf(end)));
    }
}

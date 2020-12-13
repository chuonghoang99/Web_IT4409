package API;

import Controller.RoomController;
import Model.RoomResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.sql.Date;

@Path("room")
public class RoomAPI {
    //checked
    @GET
    public RoomResponse getNumPage(@QueryParam("from")String from,
                                   @QueryParam("to") String to,
                                   @QueryParam("size") int size,
                                   @QueryParam("page") int page){
        RoomResponse roomResponse=new RoomResponse();
        roomResponse.setNumPage(new RoomController().getNumPage(Date.valueOf(from),Date.valueOf(to),size));
        roomResponse.setRoomList(new RoomController().getPageRoom(Date.valueOf(from),Date.valueOf(to),size,page));
        return roomResponse;
    }
}

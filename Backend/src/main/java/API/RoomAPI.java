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
                                   @QueryParam("page") int page,
                                   @QueryParam("type")int type){
        RoomResponse roomResponse=new RoomResponse();
        roomResponse.setNumPage(new RoomController().getNumPage(Date.valueOf(from),Date.valueOf(to),size,type));
        roomResponse.setRoomList(new RoomController().getPageRoom(Date.valueOf(from),Date.valueOf(to),size,page,type));
        return roomResponse;
    }
}

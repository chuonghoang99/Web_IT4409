package Model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class RoomResponse {
    private int numPage;
    private List<Room> roomList;
    public RoomResponse() {
    }

    public RoomResponse(int numPage, List<Room> roomList) {
        this.numPage = numPage;
        this.roomList = roomList;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}

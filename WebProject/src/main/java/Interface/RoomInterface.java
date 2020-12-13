package Interface;

import Model.Room;

import java.sql.Date;
import java.util.List;

public interface RoomInterface {
    public List<Room> getPageRoom(Date from, Date to, int size, int page);
    public int getNumPage(Date from,Date to,int size);
}

package Interface;

import Model.Account;

import java.sql.Date;
import java.util.List;

public interface RoomInterface {
    public List<String> roomAvailable(Date from,Date to);
    public List<String> roomExpiredInTime(Date date);
    public void bookRoom(String name, String id, Date start,Date expire);

}

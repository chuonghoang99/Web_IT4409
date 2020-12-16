package Controller;

import Interface.RoomInterface;
import Model.Room;
import Model.TypeRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomController implements RoomInterface {
    //checked
    @Override
    public List<Room> getPageRoom(Date from, Date to, int size, int page, int type){
        Connection connection=DAO.getConnection();
        List<Room> list=new ArrayList<>();
        String sql="SELECT * FROM Room, TypeRoom WHERE Room.id_room not in " +
                "(SELECT BookRoom.id_room FROM BookRoom where (BookRoom.start > '"+from+"' AND BookRoom.start < '"+to+"') OR (BookRoom.start < '"+from+"' AND BookRoom.expire > '"+from+"')) " +
                "AND Room.type_room=TypeRoom.id " +
                "AND TypeRoom.id='" +type+"' "+
                "ORDER BY id_room OFFSET "+(page-1)*size+" ROWS FETCH NEXT "+size+" ROWS ONLY";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Room room=new Room();
                room.setId_room(resultSet.getInt("id_room"));
                room.setType_room(resultSet.getInt("type_room"));
                room.setStatus_room(resultSet.getNString("status_room"));
                TypeRoom typeRoom=new TypeRoom();
                typeRoom.setId(resultSet.getInt("type_room"));
                typeRoom.setName(resultSet.getNString("name"));
                typeRoom.setNum_bed(resultSet.getInt("num_bed"));
                typeRoom.setPrice(resultSet.getInt("price"));
                room.setTypeRoom(typeRoom);
                list.add(room);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    //checked
    @Override
    public int getNumPage(Date from,Date to,int size,int type){
        Connection connection=DAO.getConnection();
        String sql="SELECT COUNT(*) FROM Room, TypeRoom WHERE Room.id_room not in " +
                "(SELECT BookRoom.id_room FROM BookRoom where (BookRoom.start > '"+from+"' AND BookRoom.start < '"+to+"') OR (BookRoom.start < '"+from+"' AND BookRoom.expire > '"+from+"')) " +
                "AND Room.type_room=TypeRoom.id " +
                "AND TypeRoom.id='" +type+"' ";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int numRecord=resultSet.getInt(1);
            return numRecord%size==0?numRecord/size:numRecord/size+1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new RoomController().getNumPage(Date.valueOf("2020-12-23"),Date.valueOf("2020-12-25"),1,1));
    }
}

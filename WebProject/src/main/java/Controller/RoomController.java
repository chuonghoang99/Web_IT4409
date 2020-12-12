package Controller;

import Interface.RoomInterface;
import Model.Account;
import Model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomController implements RoomInterface {
    public List<String> roomAvailable(Date from,Date to){
        Connection connection=DAO.getConnection();
        List<String> list=new ArrayList<>();
        String sql="SELECT * FROM Room, TypeRoom WHERE Room.id_room in " +
                "(SELECT BookRoom.name FROM BookRoom where (BookRoom.start < '"+from+"' AND BookRoom.expire < '"+from+"') OR (BookRoom.start > '"+to+"' AND BookRoom.expire > '"+to+"')) " +
                "AND Room.type_room=TypeRoom.id";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(resultSet.getString(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> roomExpiredInTime(Date date) {
        return null;
    }

    @Override
    public void bookRoom(String name, String id, Date start,Date expire) {
        Connection connection=DAO.getConnection();
        String sql="INSERT into BookRoom(name,start,expire,id) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setDate(2,start);
            preparedStatement.setDate(3,expire);
            preparedStatement.setString(4,id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new RoomController().bookRoom("102","3",Date.valueOf("2020-03-10"),Date.valueOf("2020-04-10"));
    }
}

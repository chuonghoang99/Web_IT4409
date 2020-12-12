package Controller;

import Interface.BookingInterface;
import Model.Account;
import Model.Booking;
import Model.BookingDisplay;
import Model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookingController implements BookingInterface {

    @Override
    public List<BookingDisplay> viewBooking(int offset, int size) {
        Connection connection=DAO.getConnection();
        List<BookingDisplay> list=new ArrayList<>();
        String sql="SELECT * FROM Customer, Bookroom, Account " +
                "WHERE Customer.id_admin=Account.id " +
                "AND Customer.id_customer=Bookroom.id_customer " +
                "AND BookRoom.expire > GETDATE() " +
                "ORDER BY Customer.id_customer OFFSET "+offset+" ROWS FETCH NEXT "+size+" ROWS ONLY";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Account account=new Account();
                account.setUsername(resultSet.getString("username"));
                Customer customer=new Customer();
                customer.setName_customer(resultSet.getString("name_customer"));
                customer.setPhone(resultSet.getString("phone"));
                Booking booking=new Booking();
                booking.setId_room(resultSet.getInt("id_room"));
                booking.setStart(resultSet.getDate("start"));
                booking.setExpire(resultSet.getDate("expire"));
                list.add(new BookingDisplay(customer,booking,account));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean newBooking(Customer customer, Booking booking) {
        Connection connection=DAO.getConnection();
        String sql="INSERT INTO Customer(name_customer,age,id_admin,noid,phone,note) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,customer.getName_customer());
            preparedStatement.setInt(2,customer.getAge());
            preparedStatement.setInt(3,customer.getId_admin());
            preparedStatement.setString(4,customer.getNoid());
            preparedStatement.setString(5,customer.getPhone());
            preparedStatement.setString(6,customer.getNote());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        sql="SELECT TOP 1 id_customer FROM Customer ORDER BY id_customer DESC ";
        int id = 0;
        try {
            preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            id=resultSet.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        sql="INSERT INTO BookRoom(id_room,id_customer,start,expire) VALUES (?,?,?,?)";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,booking.getId_room());
            preparedStatement.setInt(2,id);
            preparedStatement.setDate(3,booking.getStart());
            preparedStatement.setDate(4,booking.getExpire());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
    }
}

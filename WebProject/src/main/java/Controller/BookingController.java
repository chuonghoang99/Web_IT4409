package Controller;

import Interface.BookingInterface;
import Model.Account;
import Model.Booking;
import Model.BookingDisplay;
import Model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingController implements BookingInterface {

    @Override
    public List<BookingDisplay> viewBooking(int size, int page) {
        Connection connection=DAO.getConnection();
        List<BookingDisplay> list=new ArrayList<>();
        String sql="SELECT * FROM Customer, Bookroom, Account " +
                "WHERE Customer.id_admin=Account.id " +
                "AND Customer.id_customer=Bookroom.id_customer " +
                "AND BookRoom.expire > GETDATE() " +
                "ORDER BY Customer.id_customer OFFSET "+(page-1)*size+" ROWS FETCH NEXT "+size+" ROWS ONLY";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Account account=new Account();
                account.setRole(resultSet.getInt("role"));
                account.setUsername(resultSet.getString("username"));
                Customer customer=new Customer();
                customer.setAge(resultSet.getInt("age"));
                customer.setId_admin(resultSet.getInt("id_customer"));
                customer.setName_customer(resultSet.getString("name_customer"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setNoid(resultSet.getString("noid"));
                customer.setNote(resultSet.getNString("note"));
                Booking booking=new Booking();
                booking.setId_customer(resultSet.getInt("id_customer"));
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

    @Override
    public int getNumPage(int size) {
        Connection connection=DAO.getConnection();
        String sql="SELECT COUNT(*) FROM Customer, Bookroom, Account " +
                "WHERE Customer.id_admin=Account.id " +
                "AND Customer.id_customer=Bookroom.id_customer " +
                "AND BookRoom.expire > GETDATE() ";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int numRecords=resultSet.getInt(1);
            return numRecords%size==0?numRecords/size:numRecords/size+1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new BookingController().viewBooking(1,1).get(0).getCustomer().getId_admin());
    }
}

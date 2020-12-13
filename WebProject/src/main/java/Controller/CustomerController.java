package Controller;

import Interface.CustomerInterface;
import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerController implements CustomerInterface {

    @Override
    public boolean addCustomer(Customer customer) {
        Connection connection=DAO.getConnection();
        String sql="INSERT INTO Customer(name_customer,age,id_admin) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,customer.getName_customer());
            preparedStatement.setInt(2,customer.getAge());
            preparedStatement.setInt(3,customer.getId_admin());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Customer> getPaggingCustomer(int offset, int size) {
        Connection connection=DAO.getConnection();
        List<Customer> list=new ArrayList<>();
        String sql="SELECT * FROM Customer ORDER BY id_customer OFFSET "+offset+" ROWS FETCH NEXT "+size+" ROWS ONLY";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer=new Customer();
                customer.setName_customer(resultSet.getString("name_customer"));
                customer.setAge(resultSet.getInt("age"));
                customer.setId_admin(resultSet.getInt("id_admin"));
                list.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        return list;
    }
    //checked
    @Override
    public List<Customer> getCustomer(String name) {
        Connection connection=DAO.getConnection();
        List<Customer> list=new ArrayList<>();
        String sql="SELECT * FROM Customer WHERE name_customer=N'"+name+"'";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer=new Customer();
                customer.setId_admin(resultSet.getInt("id_admin"));
                customer.setAge(resultSet.getInt("age"));
                customer.setName_customer(resultSet.getString("name_customer"));
                list.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    public static void main(String[] args) {
        List<Customer> list=new CustomerController().getCustomer("Phạm Thành Phong");
        for (Customer customer:list){
            System.out.println(customer.getName_customer());
        }
    }
}

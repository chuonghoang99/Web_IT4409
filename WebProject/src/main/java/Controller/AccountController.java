package Controller;

import Interface.AccountInterface;
import Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountController implements AccountInterface {
    @Override
    public boolean checkSignIn(Account account) {
        Connection connection=DAO.getConnection();
        String sql="SELECT * FROM Account WHERE username='"+account.getUsername()+"' AND password='"+account.getPassword()+"'";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean signUp(Account account) {
        if(checkSignIn(account)==true){
            return false;
        }else {
            Connection connection = DAO.getConnection();
            String sql = "INSERT INTO Account(username,password,role) VALUES (?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, account.getUsername());
                preparedStatement.setString(2, account.getPassword());
                preparedStatement.setInt(3, account.getRole());
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public int getRole(Account account) {
        Connection connection=DAO.getConnection();
        String sql="SELECT * FROM Account WHERE username='"+account.getUsername()+"' AND password='"+account.getPassword()+"'";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt("role");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new AccountController().getRole(new Account("phamphong","12345")));
    }
}

package Controller;

import Interface.AccountInterface;
import Model.Account;
import Model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountController implements AccountInterface {
    @Override
    public boolean checkSignIn(Account account) {
        Connection connection=DAO.getConnection();
        String sql="SELECT * FROM Admin WHERE username_admin='"+account.getUsername()+"' AND password_admin='"+account.getPassword()+"'";
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
            Connection connection=DAO.getConnection();
            String sql="INSERT INTO Account(username,password) VALUES (?,?)";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,account.getUsername());
                preparedStatement.setString(2,account.getPassword());
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            sql="SELECT id FROM Account WHERE username='"+account.getUsername()+"'";
            int id=0;
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                ResultSet resultSet=preparedStatement.executeQuery();
                resultSet.next();
                id=resultSet.getInt("id");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            sql="INSERT INTO Person(id,fullName,age,address,indentityCardNumber,bank,bankNumer) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,account.getPerson().getFullName());
                preparedStatement.setInt(3,account.getPerson().getAge());
                preparedStatement.setString(4,account.getPerson().getAddress());
                preparedStatement.setString(5,account.getPerson().getIndentityCardNumber());
                preparedStatement.setString(6,account.getPerson().getBank());
                preparedStatement.setString(7,account.getPerson().getBankNumber());
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new AccountController().checkSignIn(new Account("chuonghoang","1")));
    }
}

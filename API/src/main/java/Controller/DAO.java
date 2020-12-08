package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static Connection connection = null;
    private static String DB_URL = "jdbc:mysql://localhost:3306/techWebDB";
    private static String USER_NAME = "root";
    private static String PASSWORD = "password";
    public static Connection getConnection(){
        if(connection==null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection= DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                return connection;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}

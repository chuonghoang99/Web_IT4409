package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private static Connection connection = null;
    public static Connection getConnection(){
        if(connection==null){
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=WebProject;username=sa;password=emsehanhphuc");
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

package connection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection(){
        return getMySQLConnection();
    }

    private static Connection getMySQLConnection(){

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            System.out.println("Could not find class");
            System.out.println(ex.getMessage());
        }

        Properties properties = new Properties();

        try(InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("database.properties")){
            properties.load(inputStream);
        }catch (IOException ex){
            System.out.println("Could not find file ");
            System.out.println (ex.getMessage());
        }
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        try {
             connection = DriverManager.getConnection(url, username, password);
        }catch (SQLException ex){
            System.out.println("Could not get connection");
            System.out.println(ex.getMessage());
        }
        return connection;
    }


    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rollbackConnection(Connection connection) {
        try {
            connection.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

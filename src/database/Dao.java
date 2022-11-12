package database;

import java.sql.*;

public class Database {
    public static Connection getConnection() {
        String connString = "jdbc:mysql://localhost:3306/venue_management";
        String userName = "<enter username>";
        String password = "<enter password>";
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connString, userName, password);
            System.out.println("The connection has been Established");
        } catch (Exception e) {
            System.out.println("Sorry, The connection could not be Established");
            e.printStackTrace();
        }
        return conn;
    }
}
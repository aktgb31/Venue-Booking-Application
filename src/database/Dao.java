package database;

import java.sql.*;

public class Dao {
    private Connection connection;
    private static Dao instance;

    private Dao(){
        String connString = "jdbc:mysql://localhost:3306/venue_management";
        String userName = "root";
        String password = "Nishant*1";
        this.connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(connString, userName, password);
            System.out.println("The connection has been Established");
        } catch (Exception e) {
            System.out.println("Sorry, The connection could not be Established");
            e.printStackTrace();
        }
    }

    private  static  Dao getInstance(){
        if(instance == null){
            instance = new Dao();
        }
        return instance;
    }
    public static Connection getConnection() {
        var conn= getInstance().connection;
        assert conn != null;
        return getInstance().connection;
    }
}
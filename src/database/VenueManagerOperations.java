package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VenueManagerOperations {
    public static void addVenueManager(String name, String emailId, String password, String contactNumber, String hallName, String hallAddress, int hallCapacity, String hallDescription) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "INSERT INTO VenueManagers VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, contactNumber);
            statement.setString(5, hallName);
            statement.setString(6, hallAddress);
            statement.setInt(7, hallCapacity);
            statement.setString(8, hallDescription);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error while creating venue manager");
        }
    }

    public static ResultSet getVenueManager(String emailId) throws Exception {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM VenueManagers WHERE emailId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            ResultSet resultSet = statement.executeQuery();
           return resultSet;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error while getting venue manager");
        }
    }

    public static ResultSet getVenueManagers() throws Exception {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM VenueManagers";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error while getting venue managers");
        }
    }

    public static void updateVenueManagerProfile(String emailId, String name, String contactNumber, String password, String hallName, String hallAddress, int hallCapacity, String hallDescription) throws Exception {
        try {
            Connection connection = Dao.getConnection();
            String sql = "UPDATE VenueManagers SET name = ?, password = ?, contactNumber = ?, hallName = ?, hallAddress = ?,hallCapacity = ?, hallDescription = ? WHERE emailId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, contactNumber);
            statement.setString(4, hallName);
            statement.setString(5, hallAddress);
            statement.setInt(6, hallCapacity);
            statement.setString(7, hallDescription);
            statement.setString(8, emailId);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error while updating venue manager profile");
        }
    }

    public static boolean validateLoginVenueManager(String emailId, String password) throws Exception {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM VenueManagers WHERE emailId = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error while validating venue manager login");
        }
    }

    public static boolean isVenueManagerRegistered(String emailId) throws Exception {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM VenueManagers WHERE emailId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error while checking if venue manager is registered");
        }
    }
}

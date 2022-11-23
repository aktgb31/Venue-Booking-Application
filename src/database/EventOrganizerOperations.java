package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EventOrganizerOperations {
    public static int addEventOrganizer(String name, String emailId, String password, String contactNumber, String organisationName, String organisationAddress) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "INSERT INTO EventOrganizers VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, contactNumber);
            statement.setString(5, organisationName);
            statement.setString(6, organisationAddress);
            statement.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static ResultSet getEventOrganizer(String emaiId) {

        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM EventOrganizers WHERE emailId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emaiId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static int updateEventOrganizerProfile(String name, String emailId, String password, String contactNumber, String organisationName, String organisationAddress) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "UPDATE EventOrganizers SET name = ?, password = ?, contactNumber = ?, organizationName = ?, organizationAddress = ? WHERE emailId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, contactNumber);
            statement.setString(4, organisationName);
            statement.setString(5, organisationAddress);
            statement.setString(6, emailId);
            statement.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static boolean validateLoginEventOrganizer(String emailId, String password) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM EventOrganizers WHERE emailId = ? AND password = ?";
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
            return false;
        }
    }

    public static boolean isEventOrganizerRegistered(String emailId) throws Exception {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM EventOrganizers WHERE emailId = ?";
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
            throw e;
        }
    }
}

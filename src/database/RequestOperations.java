package database;


import models.Request.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RequestOperations {

    public static int createBooking(String eventName, String startDateTime, String endDateTime, String eventOrganizerEmailId, String venueManagerEmailId, String description) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "INSERT INTO Requests VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventName);
            statement.setString(2, eventOrganizerEmailId);
            statement.setString(3, venueManagerEmailId);
            statement.setString(4, description);
            statement.setString(5, startDateTime);
            statement.setString(6, endDateTime);
            statement.setString(7, Status.PENDING.toString());
            statement.setString(8, null);
            statement.executeUpdate();

            sql = "SELECT LAST_INSERT_ID()";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }


    public static ResultSet getVenueManagerRequests(String emailId) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM Requests WHERE managerId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            ResultSet resultSet = statement.executeQuery();

            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static ResultSet getEventOrganizerBookings(String emailId) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM Requests WHERE organizerId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            ResultSet result = statement.executeQuery();
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return null;

        }
    }

    public static int acceptRequest(int eventId, String feedback) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "UPDATE Requests SET status = ?, feedback = ? WHERE requestId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Status.ACCEPTED.toString());
            statement.setString(2, feedback);
            statement.setInt(3, eventId);
            statement.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int rejectRequest(int eventId, String feedback) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "UPDATE Requests SET status = ?, feedback = ? WHERE requestId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Status.REJECTED.toString());
            statement.setString(2, feedback);
            statement.setInt(3, eventId);
            statement.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int cancelRequest(int eventId) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "UPDATE Requests SET status = ? WHERE requestId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Status.CANCELLED.toString());
            statement.setInt(2, eventId);
            statement.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

}

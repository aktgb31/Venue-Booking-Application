package database;


import models.Request.Status;

import java.sql.*;

public class Operations {
    public static int addVenueManager(String emailId, String name,String contactNumber,String password,String hallName,String hallAddress,int hallCapacity,String hallDescription) {
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
            statement.setString(8,hallDescription);
            statement.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static ResultSet getVenueManager(String emailId) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM VenueManagers WHERE emailId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet;
            }
            connection.close();
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static ResultSet getVenueManagers() {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM VenueManagers";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static int addEventOrganizer(String name,String emaiilId,String password,String contactNumber,String organisationName,String organisationAddress) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "INSERT INTO EventOrganizers VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emaiilId);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, contactNumber);
            statement.setString(5, organisationName);
            statement.setString(6, organisationAddress);
            statement.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static ResultSet getEventOrganizer(String emaiId) {

        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM EventOrganizers WHERE email_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emaiId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static int createBooking(String eventName, String startDateTime, String endDateTime, String eventOrganizerEmailId, String venueManagerEmailId, String description) {
        try{
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
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
            connection.close();

            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }




    public static ResultSet getVenueManagerRequests(String emailId){
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM Requests WHERE managerId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            ResultSet resultSet = statement.executeQuery();
            connection.close();
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public static ResultSet getEventOrganizerBookings(String emailId){
        try{
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

    public static int acceptRequest(int eventId,String feedback){
        try{
            Connection connection = Dao.getConnection();
            String sql = "UPDATE Requests SET status = ?, feedback = ? WHERE requestId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,Status.ACCEPTED.toString());
            statement.setString(2, feedback);
            statement.setInt(3, eventId);
            statement.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int rejectRequest(int eventId,String feedback){
        try{
            Connection connection = Dao.getConnection();
            String sql = "UPDATE Requests SET status = ?, feedback = ? WHERE requestId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Status.REJECTED.toString());
            statement.setString(2, feedback);
            statement.setInt(3, eventId);
            statement.executeUpdate();
            connection.close();
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
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int updateEventOrganizerProfile(String name, String emailId, String password, String contactNumber, String organisationName, String organisationAddress){
        try {
            Connection connection = Dao.getConnection();
            String sql = "UPDATE EventOrganizers SET name = ?, password = ?, contactNumber = ?, organisationName = ?, organisationAddress = ? WHERE emailId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, contactNumber);
            statement.setString(4, organisationName);
            statement.setString(5, organisationAddress);
            statement.setString(6, emailId);
            statement.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int updateVenueManagerProfile(String emailId, String name,String contactNumber,String password,String hallName,String hallAddress,int hallCapacity,String hallDescription){
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
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int validateLogin(String emailId, String password) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "SELECT * FROM VenueManagers WHERE emailId = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                connection.close();
                return 1;
            } else {
                sql = "SELECT * FROM EventOrganizers WHERE emailId = ? AND password = ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, emailId);
                statement.setString(2, password);
                result = statement.executeQuery();
                if (result.next()) {
                    connection.close();
                    return 2;
                } else {
                    connection.close();
                    return 0;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}

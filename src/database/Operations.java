package database;

import models.EventOrganizer;
import models.EventOrganizerRequest;
import models.VenueManager;

import java.sql.*;

public class Operations {
    public static int addVenueManager(VenueManager venueManager) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "INSERT INTO venue_manager VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, venueManager.getEmailId());
            statement.setString(2, venueManager.getName());
            statement.setString(3, venueManager.getPassword());
            statement.setString(4, venueManager.getContactNumber());
            statement.setString(5, venueManager.getHallName());
            statement.setString(6, venueManager.getHallAddress());
            statement.setString(7, venueManager.getHallCapacity());
            statement.setString(8, venueManager.getHallDescription());
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
            String sql = "SELECT * FROM venue_manager WHERE email_id = ?";
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
            String sql = "SELECT * FROM venue_manager";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static int addEventOrganizer(EventOrganizer eventOrganizer) {
        try {
            Connection connection = Dao.getConnection();
            String sql = "INSERT INTO event_organizer VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventOrganizer.getEmailId());
            statement.setString(2, eventOrganizer.getName());
            statement.setString(3, eventOrganizer.getPassword());
            statement.setString(4, eventOrganizer.getContactNumber());
            statement.setString(5, eventOrganizer.getOrganisationName());
            statement.setString(6, eventOrganizer.getOrganisationAddress());
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
            String sql = "SELECT * FROM event_organizer WHERE email_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emaiId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
        
    }

    public static int createBooking(EventOrganizerRequest request) {
        try{
            Connection connection = Dao.getConnection();
            String sql = "INSERT INTO event VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            //statement.setString(1, event.getEventId());
            statement.setString(2, request.getEventName());
            statement.setString(7, request.getVenueManager().getEmailId());
            statement.setString(8, request.getEventOrganizer().getEmailId());
            statement.setString(6, request.getDescription());            
            statement.setString(3, request.getStartDateTime());
            statement.setString(4, request.getEndDateTime());
            statement.setString(5, request.getStatus());
            statement.setString(9, request.getFeedback()); 
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
            String sql = "SELECT * FROM event WHERE manager_id = ?";
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
            String sql = "SELECT * FROM event WHERE organizer_id = ?";
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
            String sql = "UPDATE event SET status = 'accepted', feedback = ? WHERE event_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, feedback);
            statement.setInt(2, eventId);
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
            String sql = "UPDATE event SET status = 'rejected', feedback = ? WHERE event_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, feedback);
            statement.setInt(2, eventId);
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
            String sql = "UPDATE event SET status = 'cancelled' WHERE event_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, eventId);
            statement.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int updateEventOrganizerProfile(EventOrganizer eventOrganizer){
        try {
            Connection connection = Dao.getConnection();
            String sql = "UPDATE event_organizer SET name = ?, password = ?, contact_number = ?, organisation_name = ?, organisation_address = ? WHERE email_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventOrganizer.getName());
            statement.setString(2, eventOrganizer.getPassword());
            statement.setString(3, eventOrganizer.getContactNumber());
            statement.setString(4, eventOrganizer.getOrganisationName());
            statement.setString(5, eventOrganizer.getOrganisationAddress());
            statement.setString(6, eventOrganizer.getEmailId());
            statement.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int updateVenueManagerProfile(VenueManager venueManager){
        try {
            Connection connection = Dao.getConnection();
            String sql = "UPDATE venue_manager SET name = ?, password = ?, contact_number = ?, venue_name = ?, venue_address = ? WHERE email_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, venueManager.getName());
            statement.setString(2, venueManager.getPassword());
            statement.setString(3, venueManager.getContactNumber());
            statement.setString(4, venueManager.getHallName());
            statement.setString(5, venueManager.getHallAddress());
            statement.setString(6, venueManager.getEmailId());
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
            String sql = "SELECT * FROM venue_manager WHERE email_id = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                connection.close();
                return 1;
            } else {
                sql = "SELECT * FROM event_organizer WHERE email_id = ? AND password = ?";
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

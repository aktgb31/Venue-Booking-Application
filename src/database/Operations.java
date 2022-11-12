package database;

import app.*;
import java.sql.*;
import java.util.ArrayList;

public class Operations {
    public static int addVenueManager(VenueManager venueManager) {
        try {
            Connection connection = Database.getConnection();
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

    public static ResultSet getVenueManager (String emailId) {
        try {
            Connection connection = Database.getConnection();
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
        ArrayList<VenueManager> venueManagers = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            String sql = "SELECT * FROM venue_manager";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet
        } catch (Exception e) {
            System.out.println(e);
        }
        return venueManagers;
    }

    public static int addEventOrganizer(EventOrganizer eventOrganizer) {
        try {
            Connection connection = Database.getConnection();
            String sql = "INSERT INTO event_organizer VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventOrganizer.getEmailId());
            statement.setString(2, eventOrganizer.getName());
            statement.setString(3, eventOrganizer.getPassword());
            statement.setString(4, eventOrganizer.getContactNumber());
            statement.setString(5, eventOrganizer.getOrganizerName());
            statement.setString(6, eventOrganizer.getOrganizerAddress());
            statement.executeUpdate();
            connection.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static ResultSet getEventOrganizer (String emaiId) {
        
        try {
            Connection connection = Database.getConnection();
            String sql = "SELECT * FROM event_organizer WHERE email_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emaiId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public static int addEvent(Event event) {
        try{
            Connection connection = Database.getConnection();
            String sql = "INSERT INTO event VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, event.getEventId());
            statement.setString(2, event.getEventName());
            statement.setString(7, event.getOrganizerId());
            statement.setString(8, event.getManagerId());
            statement.setString(6, event.getEventDescription());            
            statement.setString(3, event.getStartTime());
            statement.setString(4, event.getEndTime());
            statement.setString(5, event.getStatus());
            statement.setString(9, event.getFeedback());          
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
 

    public static ResultSet getPendingRequests() {
        try {
            Connection connection = Database.getConnection();
            String sql = "SELECT * FROM event WHERE status = 'pending'";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ArrayList<Request> requests = new ArrayList<Request>();
            String name, organizationName, contactNumber, emailId;
            return result;
               
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static ResultSet getEventOrganizerBookings(String emailId){
        try{
            Connection connection = Database.getConnection();
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

    public static ResultSet getVenueManagerNonPendingBookings(String emailId){
        try{
            Connection connection = Database.getConnection();
            String sql = "SELECT * FROM event WHERE manager_id = ? AND status != 'pending'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailId);
            ResultSet result = statement.executeQuery();
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return null;

        }
    }

    public static int acceptRequest(int eventId) {
        try {
            Connection connection = Database.getConnection();
            String sql = "UPDATE event SET status = 'accepted' WHERE event_id = ?";
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

    public static int rejectRequest(int eventId) {
        try {
            Connection connection = Database.getConnection();
            String sql = "UPDATE event SET status = 'rejected' WHERE event_id = ?";
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

    public static int cancelRequest(int eventId) {
        try {
            Connection connection = Database.getConnection();
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

    public static int updateEventFeedback(int eventId, String feedback) {
        try {
            Connection connection = Database.getConnection();
            String sql = "UPDATE event SET feedback = ? WHERE event_id = ?";
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

    public static int updateEventOrganizerProfile()

    public static int validateLogin(String emailId, String password) {
        try {
            Connection connection = Database.getConnection();
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

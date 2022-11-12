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

    public static ArrayList<VenueManager> getVenueManagers() {
        ArrayList<VenueManager> venueManagers = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            String sql = "SELECT * FROM venue_manager";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                VenueManager venueManager = new VenueManager();
                venueManager.setEmailId(resultSet.getString(1));
                venueManager.setName(resultSet.getString(2));
                venueManager.setPassword(resultSet.getString(3));
                venueManager.setContactNumber(resultSet.getString(4));
                venueManager.setHallName(resultSet.getString(5));
                venueManager.setHallAddress(resultSet.getString(6));
                venueManager.setHallCapacity(resultSet.getString(7));
                venueManager.setHallDescription(resultSet.getString(8));
                venueManagers.add(venueManager);
            }
            connection.close();
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

    public static ArrayList<EventOrganizer> getEventOrganizers() {
        ArrayList<EventOrganizer> eventOrganizers = new ArrayList<>();
        try {
            Connection connection = Database.getConnection();
            String sql = "SELECT * FROM event_organizer";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                EventOrganizer eventOrganizer = new EventOrganizer();
                eventOrganizer.setEmailId(resultSet.getString(1));
                eventOrganizer.setName(resultSet.getString(2));
                eventOrganizer.setPassword(resultSet.getString(3));
                eventOrganizer.setContactNumber(resultSet.getString(4));
                eventOrganizer.setOrganizerName(resultSet.getString(5));
                eventOrganizer.setOrganizerAddress(resultSet.getString(6));
                eventOrganizers.add(eventOrganizer);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return eventOrganizers;
    }

    public static int addEvent(Event events) {
        try{
            Connection connection = Database.getConnection();
            String sql = "INSERT INTO event VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, events.getEventId());
            statement.setString(2, events.getEventName());
            statement.setString(7, events.getOrganizerId());
            statement.setString(8, events.getManagerId());
            statement.setString(6, events.getEventDescription());            
            statement.setString(3, events.getStartTime());
            statement.setString(4, events.getEndTime());
            statement.setString(5, events.getStatus());
            statement.setString(9, events.getFeedback());          
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static ArrayList<Event> getEvents() {
        try {
            Connection connection = Database.getConnection();
            String sql = "SELECT * FROM event";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ArrayList<Event> events = new ArrayList<Event>();
            while (result.next()) {
                Event event = new Event();
                event.setEventId(result.getString("event_id"));
                event.setEventName(result.getString("event_name"));
                event.setOrganizerId(result.getString("organizer_id"));
                event.setManagerId(result.getString("manager_id"));
                event.setEventDescription(result.getString("event_description"));
                event.setStartTime(result.getString("start_time"));
                event.setEndTime(result.getString("end_time"));
                event.setStatus(result.getString("status"));
                event.setFeedback(result.getString("feedback"));
                events.add(event);
            }
            connection.close();
            return events;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static int updateEventRequest(int eventId, String status) {
        try {
            Connection connection = Database.getConnection();
            String sql = "UPDATE event SET status = ? WHERE event_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, status);
            statement.setInt(2, eventId);
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
    public static int validdateLogin(String emailId, String password) {
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

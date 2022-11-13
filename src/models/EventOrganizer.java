package models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import models.Request.Status;

public class EventOrganizer extends Person {
    private String organisationName;
    private String organisationAddress;

    private HashMap<Integer, EventOrganizerRequest> events;

    public EventOrganizer() {
    }

    public EventOrganizer(String emailId, String password) {
        super(emailId, password);

        ResultSet resultSet = database.Operations.getEventOrganizer(emailId);
        try {
            if (resultSet.next()) {
                this.name = resultSet.getString("name");
                this.contactNumber = resultSet.getString("contactNumber");
                this.organisationName = resultSet.getString("organisationName");
                this.organisationAddress = resultSet.getString("organisationAddress");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String venueManagerEmailID,eventName,startTime,endTime,eventDescription,feedback;
        int eventId;
        Status status;
        
        ResultSet resultSet1 = database.Operations.getEventOrganizerBookings(emailId);
        try {
            while (resultSet1.next()) {
                eventId = resultSet1.getInt("eventId");
                eventName = resultSet1.getString("eventName");
                startTime = resultSet1.getString("startTime");
                endTime = resultSet1.getString("endTime");
                eventDescription = resultSet1.getString("eventDescription");
                venueManagerEmailID = resultSet1.getString("managerId");
                status = Status.valueOf(resultSet1.getString("status"));
                feedback = resultSet1.getString("feedback");

                ResultSet resultSet2 = database.Operations.getVenueManager(venueManagerEmailID);
                VenueManager venueManager = new VenueManager();
                try {
                    if (resultSet2.next()) {
                        
                        venueManager.setName(resultSet2.getString("name"));
                        venueManager.setHallName(resultSet2.getString("hallName"));
                        venueManager.setHallAddress(resultSet2.getString("hallAddress"));
                        venueManager.setHallCapacity(resultSet2.getString("hallCapacity"));
                        venueManager.setHallDescription(resultSet2.getString("hallDescription"));
                        
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                EventOrganizerRequest eventOrganizerRequest = new Request(eventId,eventName,startTime,endTime,this,venueManager,eventDescription,feedback,status);
                events.put(eventId, eventOrganizerRequest);   
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    };

    public EventOrganizer(String name, String emailId, String password, String contactNumber, String organisationName,
            String organisationAddress) {
        super(name, emailId, password, contactNumber);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
        database.Operations.addEventOrganizer(this);
    }

    public EventOrganizer(String emailId, String organisationName, String organisationAddress) {
        super(emailId);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
        database.Operations.addEventOrganizer(this);
    }

    public void addBooking(EventOrganizerRequest eventOrganizerRequest) {
        events.put(eventOrganizerRequest.getRequestId(), eventOrganizerRequest);
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getOrganisationAddress() {
        return organisationAddress;
    }

    public void setOrganisationAddress(String organisationAddress) {
        this.organisationAddress = organisationAddress;
    }

    public HashMap<Integer, EventOrganizerRequest> getEvents() {
        return events;
    }

    public void setEvents(HashMap<Integer, EventOrganizerRequest> events) {
        this.events = events;
    }

    public void updateDetails() {
        database.Operations.updateEventOrganizerProfile(this);
    }

    public HashMap<Integer, EventOrganizerRequest> getBookings() {
        return events;
    }

    public static ArrayList<VenueManager> getVenueDetails() {
        ArrayList<VenueManager> venueDetails = new ArrayList<>();
        ResultSet resultSet = database.Operations.getVenueManagers();
        try {
            while (resultSet.next()) {
                VenueManager venueManager = new VenueManager();
                venueManager.setName(resultSet.getString("name"));
                venueManager.setHallName(resultSet.getString("hallName"));
                venueManager.setHallAddress(resultSet.getString("hallAddress"));
                venueManager.setHallCapacity(resultSet.getString("hallCapacity"));
                venueManager.setHallDescription(resultSet.getString("hallDescription"));
                venueDetails.add(venueManager);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return venueDetails;
    }

}

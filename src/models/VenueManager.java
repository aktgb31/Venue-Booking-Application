package models;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class VenueManager extends Person{
    protected String hallName;
    protected String hallAddress;
    protected String hallCapacity;
    protected String hallDescription;

    protected HashMap<Integer,VenueManagerRequest> requestedEvents;

    public VenueManager(){
        super();
    }

    public VenueManager(String name, String emailId, String password, String contactNumber, String hallName, String hallAddress, String hallCapacity, String hallDescription) {
        super(name, emailId, password, contactNumber);
        this.hallName = hallName;
        this.hallAddress = hallAddress;
        this.hallCapacity = hallCapacity;
        this.hallDescription = hallDescription;
    }
    public VenueManager(String emailId, String password) {
        super(emailId, password);
        //getVenueManager from Operations
        ResultSet result = database.Operations.getVenueManager(emailId);
        try {
            if(result.next()) {
                this.name = result.getString("name");
                this.contactNumber = result.getString("contactNumber");
                this.hallName = result.getString("hallName");
                this.hallAddress = result.getString("hallAddress");
                this.hallCapacity = result.getString("hallCapacity");
                this.hallDescription = result.getString("hallDescription");
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        String eventOrganizerEmailID;
        ResultSet resultSet1=database.Operations.getVenueManagerRequests(emailId);
        try {
            while(resultSet1.next()) {
                VenueManagerRequest venueManagerRequest = new Request();
                venueManagerRequest.setEventName(resultSet1.getString("eventName"));
                venueManagerRequest.setStartDateTime(resultSet1.getString("startTime"));
                venueManagerRequest.setEndDateTime(resultSet1.getString("endTime"));
                eventOrganizerEmailID = resultSet1.getString("organizerId");
                ResultSet resultSet2=database.Operations.getEventOrganizer(eventOrganizerEmailID);
                try {
                    if(resultSet2.next()) {
                        EventOrganizer eventOrganizer = new EventOrganizer();
                        eventOrganizer.setName(resultSet2.getString("name"));
                        eventOrganizer.setOrganisationName(resultSet2.getString("organisationName"));
                        eventOrganizer.setOrganisationAddress(resultSet2.getString("organisationAddress"));
                        venueManagerRequest.setEventOrganizer(eventOrganizer);
                    }
                } catch(Exception e) {
                    System.out.println(e);
                }
                venueManagerRequest.setDescription(resultSet1.getString("eventDescription"));
                requestedEvents.put(venueManagerRequest.getRequestId(),venueManagerRequest);

                
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateDetails(){
        database.Operations.updateVenueManagerProfile(this);
    }

    //getters and setters
    public String getHallName() {
        return hallName;
    }
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
    public String getHallAddress() {
        return hallAddress;
    }
    public void setHallAddress(String hallAddress) {
        this.hallAddress = hallAddress;
    }
    public String getHallCapacity() {
        return hallCapacity;
    }
    public void setHallCapacity(String hallCapacity) {
        this.hallCapacity = hallCapacity;
    }
    public String getHallDescription() {
        return hallDescription;
    }
    public void setHallDescription(String hallDescription) {
        this.hallDescription = hallDescription;
    }
    public HashMap<Integer,VenueManagerRequest> getRequestedEvents() {
        return requestedEvents;
    }
    public void setRequestedEvents(HashMap<Integer,VenueManagerRequest> requestedEvents) {
        this.requestedEvents = requestedEvents;
    }

    
}

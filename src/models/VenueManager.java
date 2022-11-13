package models;

import java.sql.ResultSet;
import java.util.HashMap;

import models.Request.Status;

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

        String eventOrganizerEmailID,eventName,startTime,endTime,eventDescription,feedback;
        int eventId;
        Status status;
        ResultSet resultSet1=database.Operations.getVenueManagerRequests(emailId);
        try {
            while(resultSet1.next()) {
                eventId=resultSet1.getInt("eventId");
                eventName=resultSet1.getString("eventName");
                startTime=resultSet1.getString("startTime");
                endTime=resultSet1.getString("endTime");
                eventDescription=resultSet1.getString("eventDescription");
                eventOrganizerEmailID=resultSet1.getString("organizerId");
                status=Status.valueOf(resultSet1.getString("status"));
                feedback=resultSet1.getString("feedback");
                  
                ResultSet resultSet2=database.Operations.getEventOrganizer(eventOrganizerEmailID);
                EventOrganizer eventOrganizer = new EventOrganizer();
                try {
                    if(resultSet2.next()) {
                        eventOrganizer.setName(resultSet2.getString("name"));
                        eventOrganizer.setOrganisationName(resultSet2.getString("organisationName"));
                        eventOrganizer.setOrganisationAddress(resultSet2.getString("organisationAddress"));
                    }
                } catch(Exception e) {
                    System.out.println(e);
                }
                VenueManagerRequest venueManagerRequest = new Request(eventId,eventName,startTime,endTime,eventOrganizer,this,eventDescription,feedback,status);
                requestedEvents.put(eventId,venueManagerRequest);   
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateDetails(){
        database.Operations.updateVenueManagerProfile(this);
    }

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

package models;

import javax.swing.*;

public interface EventOrganizerRequest {
    
    public void cancelRequest();

    public JFrame venueManagerScreen();

    public JFrame eventDetailsScreen();

    public void createRequest(String eventName,String startDateTime, String endDateTime, EventOrganizer eventOrganizer, VenueManager venueManager,String description);

    //getter and setters
    public int getRequestId();
    public void setRequestId(int requestId);
    public String getEventName();
    public void setEventName(String eventName);
    public String getStartDateTime();
    public void setStartDateTime(String startDateTime);
    public String getEndDateTime();
    public void setEndDateTime(String endDateTime);
    public VenueManager getVenueManager();
    public void setVenueManager(VenueManager venueManager);
    public EventOrganizer getEventOrganizer();
    public void setEventOrganizer(EventOrganizer eventOrganizer);
    public String getDescription();
    public void setDescription(String description);
    public String getFeedback();
    public void setFeedback(String feedback);
    public String getStatus();


    
}

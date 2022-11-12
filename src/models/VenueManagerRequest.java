package models;

import javax.swing.*;

public interface VenueManagerRequest {
    public void approveRequest();
    public void rejectRequest();

    public JFrame eventOrganiserScreen();

    public JFrame eventDetailsScreen();


    //getter and setter
    public int getRequestId();
    public void setRequestId(int requestId);
    public String getEventName();
    public void setEventName(String eventName);
    public String getStartDateTime();
    public void setStartDateTime(String startDateTime);
    public String getEndDateTime();
    public void setEndDateTime(String endDateTime);
    public EventOrganizer getEventOrganizer();
    public void setEventOrganizer(EventOrganizer eventOrganizer);
    public String getDescription();
    public void setDescription(String description);
    public String getFeedback();
    public void setFeedback(String feedback);
    public String getStatus();
    public void setStatus(String status);
    
}

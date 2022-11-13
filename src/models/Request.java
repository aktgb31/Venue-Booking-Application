package models;

import javax.swing.*;

public class Request implements EventOrganizerRequest, VenueManagerRequest {

    protected int requestId;
    protected String eventName;
    protected String startDateTime;
    protected String endDateTime;

    protected EventOrganizer eventOrganizer;
    protected VenueManager venueManager;
    protected String description;
    protected String feedback;
    public enum Status {PENDING, ACCEPTED, REJECTED,CANCELLED};
    protected String status;
    public Request() {
    }

    @Override
    public void createRequest(String eventName,String startDateTime, String endDateTime, EventOrganizer eventOrganizer, VenueManager venueManager,String description) {
        this.eventName = eventName;
        this.eventOrganizer = eventOrganizer;
        this.venueManager = venueManager;
        this.description = description;
        this.feedback = "";
        this.status = "Pending";
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.requestId = database.Operations.createBooking(this);
    }

    @Override
    public void cancelRequest() {
        this.status = "Cancelled";
        database.Operations.cancelRequest(this.requestId);
    }

    @Override
    public void acceptRequest() {
        this.status = "Accepted";
    }

    @Override
    public void rejectRequest() {
        this.status = "Rejected";
    }

    //getter and setter
    public int getRequestId() {
        return requestId;
    }
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public String getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }
    public String getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }
    public EventOrganizer getEventOrganizer() {
        return eventOrganizer;
    }
    public void setEventOrganizer(EventOrganizer eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }
    public VenueManager getVenueManager() {
        return venueManager;
    }
    public void setVenueManager(VenueManager venueManager) {
        this.venueManager = venueManager;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public JFrame eventOrganiserScreen() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JFrame venueManagerScreen() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JFrame eventDetailsScreen() {
        // TODO Auto-generated method stub
        return null;
    }


}

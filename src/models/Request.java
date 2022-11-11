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
    protected Status status;


    @Override
    public void createRequest(String eventName, EventOrganizer eventOrganizer, VenueManager venueManager,String description) {
        this.event = event;
        this.eventOrganizer = eventOrganizer;
        this.venueManager = venueManager;
        this.description = description;
        this.feedback = "";
        this.status = Status.PENDING;
    }

    @Override
    public void cancelRequest() {
        this.status = Status.CANCELLED;
    }

    @Override
    public void approveRequest() {
        this.status = Status.ACCEPTED;
    }

    @Override
    public void rejectRequest() {
        this.status = Status.REJECTED;
    }


}

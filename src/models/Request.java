package models;

import database.RequestOperations;

public class Request implements EventOrganizerRequest, VenueManagerRequest {

    private int requestId;
    private String eventName;
    private String startDateTime;
    private String endDateTime;

    private EventOrganizer eventOrganizer;
    private VenueManager venueManager;
    private String description;
    private String feedback;

    public enum Status {
        PENDING, ACCEPTED, REJECTED, CANCELLED
    };

    private Status status;

    public Request(String eventName, String startDateTime, String endDateTime, EventOrganizer eventOrganizer,
            VenueManager venueManager, String description) throws Exception {
        this.eventName = eventName;
        this.eventOrganizer = eventOrganizer;
        this.venueManager = venueManager;
        this.description = description;
        this.feedback = "";
        this.status = Status.PENDING;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.requestId = RequestOperations.createBooking(this.eventName, this.startDateTime, this.endDateTime,
                this.eventOrganizer.getEmailId(), this.venueManager.getEmailId(), this.description);
    }

    public Request(int requestId, String eventName, String startDateTime, String endDateTime,
            EventOrganizer eventOrganizer,
            VenueManager venueManager, String description, String feedback, Status status) {
        this.requestId = requestId;
        this.eventName = eventName;
        this.eventOrganizer = eventOrganizer;
        this.venueManager = venueManager;
        this.description = description;
        this.feedback = feedback;
        this.status = status;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public void cancelRequest() throws Exception {
        this.status = Status.CANCELLED;
        RequestOperations.cancelRequest(this.requestId);
    }

    public void acceptRequest(String feedBack) throws Exception {
        this.status = Status.ACCEPTED;
        this.feedback = feedBack;
        RequestOperations.acceptRequest(requestId, feedBack);
    }

    public void rejectRequest(String feedBack) throws Exception {
        this.status = Status.REJECTED;
        this.feedback = feedBack;
        RequestOperations.rejectRequest(requestId, feedBack);
    }

    public int getRequestId() {
        return requestId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public EventOrganizer getEventOrganizer() {
        return eventOrganizer;
    }

    public String getDescription() {
        return description;
    }

    public String getFeedback() {
        return feedback;
    }

    public VenueManager getVenueManager() {
        return venueManager;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Status getStatus() {
        return status;
    }

}

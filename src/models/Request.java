package models;

public class Request implements EventOrganizerRequest, VenueManagerRequest {

    protected int requestId;
    protected String eventName;
    protected String startDateTime;
    protected String endDateTime;

    protected EventOrganizer eventOrganizer;
    protected VenueManager venueManager;
    protected String description;
    protected String feedback;

    public enum Status {
        PENDING, ACCEPTED, REJECTED, CANCELLED
    };

    protected Status status;

    public Request() {
    }

    public Request(int requestId, String eventName, String startDateTime, String endDateTime, EventOrganizer eventOrganizer, VenueManager venueManager, String description, String feedback, Status status) {
        this.requestId = requestId;
        this.eventName = eventName;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.eventOrganizer = eventOrganizer;
        this.venueManager = venueManager;
        this.description = description;
        this.feedback = feedback;
        this.status = status;
    }

    @Override
    public void createRequest(String eventName, String startDateTime, String endDateTime, EventOrganizer eventOrganizer,
            VenueManager venueManager, String description) {
        this.eventName = eventName;
        this.eventOrganizer = eventOrganizer;
        this.venueManager = venueManager;
        this.description = description;
        this.feedback = "";
        this.status = Status.PENDING;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.requestId = database.Operations.createBooking(this.eventName, this.startDateTime, this.endDateTime, this.eventOrganizer.getEmailId(), this.venueManager.getEmailId(), this.description);
    }

    @Override
    public void cancelRequest() {
        this.status = Status.CANCELLED;
        database.Operations.cancelRequest(this.requestId);
    }

    @Override
    public void acceptRequest(String feedBack) {
        this.status = Status.ACCEPTED;
        this.feedback = feedBack;
        database.Operations.acceptRequest(requestId, feedBack);
    }

    @Override
    public void rejectRequest(String feedBack) {
        this.status = Status.REJECTED;
        this.feedback = feedBack;
        database.Operations.rejectRequest(requestId, feedBack);
    }

    public int getRequestId() {
        return requestId;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getStatus() {
        return status.toString();
    }

}

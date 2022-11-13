package models;

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
            VenueManager venueManager, String description) {
        this.eventName = eventName;
        this.eventOrganizer = eventOrganizer;
        this.venueManager = venueManager;
        this.description = description;
        this.feedback = "";
        this.status = Status.PENDING;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.requestId = database.Operations.createBooking(this.eventName, this.startDateTime, this.endDateTime,
                this.eventOrganizer.getEmailId(), this.venueManager.getEmailId(), this.description);
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

    @Override
    public int getRequestId() {
        return requestId;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Status getStatus() {
        return status;
    }
}

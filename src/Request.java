import javax.swing.*;

public class Request implements EventOrganizerRequest, VenueManagerRequest {

    protected int requestId;
    protected Event event;
    protected EventOrganizer eventOrganizer;
    protected VenueManager venueManager;
    protected String description;
    protected String feedback;
    public enum Status {PENDING, ACCEPTED, REJECTED,CANCELLED};
    protected Status status;


    @Override
    public void createRequest(Event event, EventOrganizer eventOrganizer, VenueManager venueManager,String description) {
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

    @Override
    public JFrame eventOrganiserScreen() {
        // Add code here
        return null;
    }

    @Override
    public JFrame venueManagerScreen() {
        // Add code here
        return null;
    }

    @Override
    public JFrame eventDetailsScreen() {
        return event.viewDetailsPanel();
    }

    @Override
    public Status getStatus() {
        return this.status;
    }
}

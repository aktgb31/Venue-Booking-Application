import javax.swing.*;

public interface EventOrganizerRequest {
    public void createRequest(Event event, EventOrganizer eventOrganizer, VenueManager venueManager,String description);
    public void cancelRequest();

    public JFrame venueManagerScreen();

    public JFrame eventDetailsScreen();

    public Request.Status getStatus();
}

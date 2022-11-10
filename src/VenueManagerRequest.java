import javax.swing.*;

public interface VenueManagerRequest {
    public void approveRequest();
    public void rejectRequest();

    public JFrame eventOrganiserScreen();

    public JFrame eventDetailsScreen();

    public Request.Status getStatus();
}

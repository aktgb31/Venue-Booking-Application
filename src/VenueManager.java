import javax.swing.*;
import java.util.ArrayList;

public class VenueManager extends Person{
    protected String hallName;
    protected String hallAddress;
    protected String hallCapacity;
    protected String hallDescription;

    protected ArrayList<VenueManagerRequest> events;

    public VenueManager(String name, String emailId, String password, String contactNumber, String hallName, String hallAddress, String hallCapacity, String hallDescription) {
        super(name, emailId, password, contactNumber);
        this.hallName = hallName;
        this.hallAddress = hallAddress;
        this.hallCapacity = hallCapacity;
        this.hallDescription = hallDescription;
    }

    private void updateDetails(String name, String password, String contactNumber, String hallName, String hallAddress, String hallCapacity, String hallDescription) {
        this.name = name;
        this.password = password;
        this.contactNumber = contactNumber;
        this.hallName = hallName;
        this.hallAddress = hallAddress;
        this.hallCapacity = hallCapacity;
        this.hallDescription = hallDescription;

    }

    @Override
    public JFrame dashboardScreen() {
        // Add code here
        return null;
    }

    private JFrame updateProfileScreen() {
        // Add code here
        return null;
    }

    private JFrame viewRequestsScreen() {
        // Add code here
        return null;
    }

    private JFrame viewScheduledEventsScreen() {
        // Add code here
        return null;
    }

    public JFrame viewDetailsPanel() {
        // Add code here
        return null;
    }
}

import javax.swing.*;
import java.util.ArrayList;

public class EventOrganizer extends Person{
    protected  String organisationName;
    protected  String organisationAddress;

    protected ArrayList<EventOrganizerRequest> events;

    public EventOrganizer(String name, String emailId, String password, String contactNumber, String organisationName, String organisationAddress) {
        super(name, emailId, password, contactNumber);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
    }

    private void updateDetails(String name, String password, String contactNumber, String organisationName, String organisationAddress) {
        this.name = name;
        this.password = password;
        this.contactNumber = contactNumber;
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
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

    private JFrame createRequestScreen() {
        // Add code here
        return null;
    }

    private JFrame viewRequestsScreen() {
        // Add code here
        return null;
    }

    public JFrame viewDetailsPanel() {
        // Add code here
        return null;
    }
}

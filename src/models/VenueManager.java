package models;

import javax.swing.*;
import java.util.ArrayList;

public class VenueManager extends Person{
    protected String hallName;
    protected String hallAddress;
    protected String hallCapacity;
    protected String hallDescription;

    protected ArrayList<VenueManagerRequest> requestedEvents;
    protected ArrayList<VenueManagerRequest> nonPendingRequests;

    public VenueManager(String name, String emailId, String password, String contactNumber, String hallName, String hallAddress, String hallCapacity, String hallDescription) {
        super(name, emailId, password, contactNumber);
        this.hallName = hallName;
        this.hallAddress = hallAddress;
        this.hallCapacity = hallCapacity;
        this.hallDescription = hallDescription;
    }
}

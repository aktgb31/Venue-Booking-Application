package models;

import database.EventOrganizerOperations;
import database.RequestOperations;
import database.VenueManagerOperations;
import models.Request.Status;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class VenueManager extends Person implements ReadOnlyVenueManager {
    private String hallName;
    private String hallAddress;
    private int hallCapacity;
    private String hallDescription;

    private HashMap<Integer, VenueManagerRequest> requests;

    public VenueManager(String name, String emailId, String password, String contactNumber, String hallName, String hallAddress, int hallCapacity, String hallDescription) throws Exception {
        super(name, emailId, password, contactNumber);
        boolean isRegistered = VenueManagerOperations.isVenueManagerRegistered(emailId);
        if (isRegistered) {
            throw new Exception("Email Id already registered");
        }
        this.hallName = hallName;
        this.hallAddress = hallAddress;
        this.hallCapacity = hallCapacity;
        this.hallDescription = hallDescription;
        this.requests = new HashMap<Integer, VenueManagerRequest>();
        VenueManagerOperations.addVenueManager(this.name, this.emailId, this.password, this.contactNumber, this.hallName, this.hallAddress, this.hallCapacity, this.hallDescription);
    }

    public VenueManager(String name, String emailId, String contactNumber, String hallName, String hallAddress, int hallCapacity, String hallDescription) {
        super(name, emailId, null, contactNumber);
        this.hallName = hallName;
        this.hallAddress = hallAddress;
        this.hallCapacity = hallCapacity;
        this.hallDescription = hallDescription;
        this.requests = new HashMap<Integer, VenueManagerRequest>();
    }

    public VenueManager(String emailId, String password) throws Exception {
        System.out.println(emailId);
        boolean loginSuccessful = VenueManagerOperations.validateLoginVenueManager(emailId, password);
        System.out.println(loginSuccessful);
        if (!loginSuccessful) {
            throw new Exception("Invalid login credentials");
        }
        ResultSet result = VenueManagerOperations.getVenueManager(emailId);
        try {
            if (result.next()) {
                this.name = result.getString("name");
                this.emailId = result.getString("emailId");
                this.password = result.getString("password");
                this.contactNumber = result.getString("contactNumber");
                this.hallName = result.getString("hallName");
                this.hallAddress = result.getString("hallAddress");
                this.hallCapacity = result.getInt("hallCapacity");
                this.hallDescription = result.getString("hallDescription");
                this.requests = new HashMap<Integer, VenueManagerRequest>();
            }

            String eventOrganizerEmailID, eventName, startTime, endTime, eventDescription, feedback;
            int eventId;
            Status status;
            ResultSet resultSet1 = RequestOperations.getVenueManagerRequests(emailId);

            while (resultSet1.next()) {
                eventId = resultSet1.getInt("requestId");
                eventName = resultSet1.getString("eventName");
                startTime = resultSet1.getString("startTime");
                endTime = resultSet1.getString("endTime");
                eventDescription = resultSet1.getString("bookingDescription");
                eventOrganizerEmailID = resultSet1.getString("organizerId");
                status = Status.valueOf(resultSet1.getString("status"));
                feedback = resultSet1.getString("feedback");

                ResultSet resultSet2 = EventOrganizerOperations.getEventOrganizer(eventOrganizerEmailID);
                EventOrganizer eventOrganizer = null;
                if (resultSet2.next()) {
                    String name = resultSet2.getString("name");
                    String email = resultSet2.getString("emailId");
                    String contactNumber = resultSet2.getString("contactNumber");
                    String organisationName = resultSet2.getString("organizationName");
                    String organisationAddress = resultSet2.getString("organizationAddress");
                    eventOrganizer = new EventOrganizer(name, email, contactNumber, organisationName, organisationAddress);
                }

                VenueManagerRequest venueManagerRequest = new Request(eventId, eventName, startTime, endTime, eventOrganizer, this, eventDescription, feedback, status);
                requests.put(eventId, venueManagerRequest);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Error while fetching data");
        }
    }

    public static ArrayList<ReadOnlyVenueManager> getVenueDetails() throws Exception {
        ArrayList<ReadOnlyVenueManager> venueManagers = new ArrayList<ReadOnlyVenueManager>();
        ResultSet result = VenueManagerOperations.getVenueManagers();
        try {
            while (result.next()) {
                String name = result.getString("name");
                String emailId = result.getString("emailId");
                String contactNumber = result.getString("contactNumber");
                String hallName = result.getString("hallName");
                String hallAddress = result.getString("hallAddress");
                int hallCapacity = result.getInt("hallCapacity");
                String hallDescription = result.getString("hallDescription");
                ReadOnlyVenueManager venueManager = new VenueManager(name, emailId, contactNumber, hallName, hallAddress, hallCapacity, hallDescription);

                venueManagers.add(venueManager);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Error in fetching venue managers");
        }
        return venueManagers;
    }

    public void updateDetails() throws Exception {
        VenueManagerOperations.updateVenueManagerProfile(this.emailId, this.name, this.contactNumber, this.password, this.hallName, this.hallAddress, this.hallCapacity, this.hallDescription);
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallAddress() {
        return hallAddress;
    }

    public void setHallAddress(String hallAddress) {
        this.hallAddress = hallAddress;
    }

    public int getHallCapacity() {
        return hallCapacity;
    }

    public void setHallCapacity(int hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public String getHallDescription() {
        return hallDescription;
    }

    public void setHallDescription(String hallDescription) {
        this.hallDescription = hallDescription;
    }

    public HashMap<Integer, VenueManagerRequest> getRequests() {
        return requests;
    }
}

package models;

import database.EventOrganizerOperations;
import database.RequestOperations;
import database.VenueManagerOperations;
import models.Request.Status;

import java.sql.ResultSet;
import java.util.HashMap;

public class EventOrganizer extends Person implements ReadOnlyEventOrganizer {
    private String organisationName;
    private String organisationAddress;

    private HashMap<Integer, EventOrganizerRequest> requests;

    public EventOrganizer(String name, String emailId, String password, String contactNumber, String organisationName, String organisationAddress) throws Exception {
        super(name, emailId, password, contactNumber);
        boolean isRegistered = EventOrganizerOperations.isEventOrganizerRegistered(emailId);
        if (isRegistered) {
            throw new Exception("Email Id already registered");
        }
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
        this.requests = new HashMap<Integer, EventOrganizerRequest>();
        EventOrganizerOperations.addEventOrganizer(this.name, this.emailId, this.password, this.contactNumber, this.organisationName, this.organisationAddress);
    }

    public EventOrganizer(String name, String emailId, String contactNumber, String organisationName, String organisationAddress) {
        super(name, emailId, null, contactNumber);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
        this.requests = new HashMap<Integer, EventOrganizerRequest>();
    }

    public EventOrganizer(String emailId, String password) throws Exception {
        boolean loginSuccessful = EventOrganizerOperations.validateLoginEventOrganizer(emailId, password);
        if (!loginSuccessful) {
            throw new Exception("Invalid login credentials");
        }
        ResultSet resultSet = EventOrganizerOperations.getEventOrganizer(emailId);
        try {
            if (resultSet.next()) {
                this.name = resultSet.getString("name");
                this.emailId = resultSet.getString("emailId");
                this.password = resultSet.getString("password");
                this.contactNumber = resultSet.getString("contactNumber");
                this.organisationName = resultSet.getString("organizationName");
                this.organisationAddress = resultSet.getString("organizationAddress");
                this.requests = new HashMap<Integer, EventOrganizerRequest>();
            }

            String venueManagerEmailID, eventName, startTime, endTime, eventDescription, feedback;
            int eventId;
            Status status;

            ResultSet resultSet1 = RequestOperations.getEventOrganizerBookings(emailId);

            while (resultSet1.next()) {
                eventId = resultSet1.getInt("requestId");
                eventName = resultSet1.getString("eventName");
                startTime = resultSet1.getString("startTime");
                endTime = resultSet1.getString("endTime");
                eventDescription = resultSet1.getString("bookingDescription");
                venueManagerEmailID = resultSet1.getString("managerId");
                status = Status.valueOf(resultSet1.getString("status"));
                feedback = resultSet1.getString("feedback");

                ResultSet resultSet2 = VenueManagerOperations.getVenueManager(venueManagerEmailID);
                VenueManager venueManager = null;

                if (resultSet2.next()) {
                    String name = resultSet2.getString("name");
                    String email = resultSet2.getString("emailId");
                    String contactNumber = resultSet2.getString("contactNumber");
                    String hallName = resultSet2.getString("hallName");
                    String hallAddress = resultSet2.getString("hallAddress");
                    int hallCapacity = resultSet2.getInt("hallCapacity");
                    String hallDescription = resultSet2.getString("hallDescription");
                    venueManager = new VenueManager(name, email, contactNumber, hallName, hallAddress, hallCapacity, hallDescription);

                }
                EventOrganizerRequest eventOrganizerRequest = new Request(eventId, eventName, startTime, endTime, this, venueManager, eventDescription, feedback, status);
                requests.put(eventId, eventOrganizerRequest);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Error while fetching data");
        }
    }

    public void updateDetails() throws Exception {
        EventOrganizerOperations.updateEventOrganizerProfile(this.name, this.emailId, this.password, this.contactNumber, this.organisationName, this.organisationAddress);
    }

    public void addBooking(EventOrganizerRequest eventOrganizerRequest) {
        requests.put(eventOrganizerRequest.getRequestId(), eventOrganizerRequest);
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getOrganisationAddress() {
        return organisationAddress;
    }

    public void setOrganisationAddress(String organisationAddress) {
        this.organisationAddress = organisationAddress;
    }

    public HashMap<Integer, EventOrganizerRequest> getBookings() {
        return requests;
    }
}

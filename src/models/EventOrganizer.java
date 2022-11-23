package models;

import java.sql.ResultSet;
import java.util.HashMap;

import models.Request.Status;

public class EventOrganizer extends Person implements ReadOnlyEventOrganizer {
    private String organisationName;
    private String organisationAddress;

    private HashMap<Integer, EventOrganizerRequest> requests;

    public EventOrganizer(String name, String emailId, String password, String contactNumber, String organisationName,
            String organisationAddress) {
        super(name, emailId, password, contactNumber);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
        database.Operations.addEventOrganizer(this.name, this.emailId, this.password, this.contactNumber,
                this.organisationName, this.organisationAddress);
    }

    public EventOrganizer(String name, String emailId, String contactNumber, String organisationName,
            String organisationAddress) {
        super(name, emailId, null, contactNumber);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
    }

    public EventOrganizer(String emailId, String password) {

        ResultSet resultSet = database.Operations.getEventOrganizer(emailId);
        try {
            if (resultSet.next()) {
                this.name = resultSet.getString("name");
                this.emailId = resultSet.getString("emailId");
                this.contactNumber = resultSet.getString("contactNumber");
                this.organisationName = resultSet.getString("organisationName");
                this.organisationAddress = resultSet.getString("organisationAddress");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String venueManagerEmailID, eventName, startTime, endTime, eventDescription, feedback;
        int eventId;
        Status status;

        ResultSet resultSet1 = database.Operations.getEventOrganizerBookings(emailId);
        try {
            while (resultSet1.next()) {
                eventId = resultSet1.getInt("eventId");
                eventName = resultSet1.getString("eventName");
                startTime = resultSet1.getString("startTime");
                endTime = resultSet1.getString("endTime");
                eventDescription = resultSet1.getString("eventDescription");
                venueManagerEmailID = resultSet1.getString("managerId");
                status = Status.valueOf(resultSet1.getString("status"));
                feedback = resultSet1.getString("feedback");

                ResultSet resultSet2 = database.Operations.getVenueManager(venueManagerEmailID);
                VenueManager venueManager = null;
                try {
                    if (resultSet2.next()) {
                        String name = resultSet2.getString("name");
                        String email = resultSet2.getString("emailId");
                        String contactNumber = resultSet2.getString("contactNumber");
                        String hallName = resultSet2.getString("hallName");
                        String hallAddress = resultSet2.getString("hallAddress");
                        int hallCapacity = resultSet2.getInt("hallCapacity");
                        String hallDescription = resultSet2.getString("hallDescription");

                        venueManager = new VenueManager(name, email, contactNumber, hallName, hallAddress,
                                hallCapacity, hallDescription);

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                EventOrganizerRequest eventOrganizerRequest = new Request(eventId, eventName, startTime, endTime, this,
                        venueManager, eventDescription, feedback, status);
                requests.put(eventId, eventOrganizerRequest);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    };

    public void updateDetails() {
        database.Operations.updateEventOrganizerProfile(this.name,this.emailId,this.password,this.contactNumber,this.organisationName,this.organisationAddress);
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

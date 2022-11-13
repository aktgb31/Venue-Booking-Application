package services;

import java.util.ArrayList;
import java.util.HashMap;

import models.EventOrganizer;
import models.EventOrganizerRequest;
import models.ReadOnlyVenueManager;
import models.VenueManager;

public class EventOrganiserService {
    private EventOrganizer eventOrganizer;

    private EventOrganiserService(EventOrganizer eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    public static EventOrganiserService login(String emailId, String password) {
        EventOrganizer eventOrganizer = new EventOrganizer(emailId, password);
        return new EventOrganiserService(eventOrganizer);
    }

    public static EventOrganiserService register(String name, String emailId, String password,
            String contactNumber, String organizationName, String organizationAddress) {
        EventOrganizer eventOrganizer = new EventOrganizer(name, emailId, password, contactNumber, organizationName,
                organizationAddress);
        return new EventOrganiserService(eventOrganizer);
    }

    public void updateProfile(String name, String password, String contactNumber, String organisationName,
            String organisationAddress) {
        eventOrganizer.setName(name);
        eventOrganizer.setPassword(password);
        eventOrganizer.setContactNumber(contactNumber);
        eventOrganizer.setOrganisationName(organisationName);
        eventOrganizer.setOrganisationAddress(organisationAddress);
        eventOrganizer.updateDetails();
    }

    public void createBooking(VenueManager venueManager, String startDateTime, String endDateTime,
            String eventName, String description) {
        EventOrganizerRequest newRequest = EventOrganizerRequest.createRequest(eventName, startDateTime, endDateTime,
                eventOrganizer, venueManager, description);
        eventOrganizer.addBooking(newRequest);
    }

    public void cancelBooking(int requestId) {
        eventOrganizer.getBookings().get(requestId).cancelRequest();
    }

    public ArrayList<EventOrganizerRequest> getBookingHistory() {
        HashMap<Integer, EventOrganizerRequest> allBookings = eventOrganizer.getBookings();
        ArrayList<EventOrganizerRequest> bookingHistory = new ArrayList<EventOrganizerRequest>();
        for (EventOrganizerRequest booking : allBookings.values()) {
            bookingHistory.add(booking);
        }
        return bookingHistory;
    }

    public EventOrganizer getProfile() {
        return eventOrganizer;
    }

    public ArrayList<ReadOnlyVenueManager> getVenueDetails() {

        return VenueManager.getVenueDetails();
    }

    public void logoutService() {
        eventOrganizer = null;
    }
}

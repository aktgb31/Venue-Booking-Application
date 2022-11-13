package services;

import java.util.ArrayList;
import java.util.HashMap;

import models.EventOrganizer;
import models.EventOrganizerRequest;
import models.Request;
import models.VenueManager;

public class EventOrganiserService{
    private EventOrganizer eventOrganizer;
    public EventOrganiserService(){
        this.eventOrganizer = new EventOrganizer();
    }
    
    public void loginService(String emailId, String password) {
        this.eventOrganizer = new EventOrganizer(emailId, password);
    }

    public void registrationService(String name, String emailId, String password, String contactNumber, String organizationName, String organizationAddress) {
        this.eventOrganizer = new EventOrganizer(name, emailId, password, contactNumber, organizationName, organizationAddress);
    }
          
    public void updateProfileService(String name, String password, String contactNumber, String organisationName, String organisationAddress) {
        eventOrganizer.setName(name);
        eventOrganizer.setPassword(password);
        eventOrganizer.setContactNumber(contactNumber);
        eventOrganizer.setOrganisationName(organisationName);
        eventOrganizer.setOrganisationAddress(organisationAddress);
        eventOrganizer.updateDetails();
    }

    public void createBookingService(VenueManager venueManager, String startDateTime, String endDateTime, String eventName, String description) {
        EventOrganizerRequest newRequest = new Request();
        newRequest.createRequest(eventName,  startDateTime, endDateTime, eventOrganizer, venueManager, description);
        eventOrganizer.addBooking(newRequest);
    }

    public void cancelBookingService(int requestId) {
        eventOrganizer.getEvents().get(requestId).cancelRequest();
    }

    public ArrayList<EventOrganizerRequest> getBookingHistoryService() {
        HashMap<Integer,EventOrganizerRequest> allBookings = eventOrganizer.getBookings();
        ArrayList<EventOrganizerRequest> bookingHistory = new ArrayList<EventOrganizerRequest>();
        for(EventOrganizerRequest booking : allBookings.values()){
            bookingHistory.add(booking);  
        }
        return bookingHistory;
    }

    public EventOrganizer getProfileService() {
        return eventOrganizer;
    }

    public ArrayList<VenueManager> getVenueDetails() {
        return eventOrganizer.getVenueDetails();
    }

    public void logoutService(){
        eventOrganizer = null;
    }
}

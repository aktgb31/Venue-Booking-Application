package services;

import models.EventOrganizer;

public class EventOrganiserService{
    private EventOrganizer eventOrganizer;
    public EventOrganiserService(){
        this.eventOrganizer = new EventOrganizer();
    }
    
    public void loginService(String emailId, String password) {
        this.eventOrganizer = new EventOrganizer(emailId, password);
    }
       
    public void updateDetailsService(String name, String password, String contactNumber, String organisationName, String organisationAddress) {
        eventOrganizer.setName(name);
        eventOrganizer.setPassword(password);
        eventOrganizer.setContactNumber(contactNumber);
        eventOrganizer.setOrganisationName(organisationName);
        eventOrganizer.setOrganisationAddress(organisationAddress);
        eventOrganizer.updateDetails();
    }

    public void createBookingService(String hallName, String startDateTime, String endDateTime, String eventName, String description) {
        eventOrganizer.createBooking(hallName, startDateTime, endDateTime, eventName, description);
    }

    public void cancelBookingService(int requestId) {
        eventOrganizer.cancelBooking(requestId);
    }



    public EventOrganizer getEventOrganizer() {
        return eventOrganizer;
    }
}

package models;

public interface EventOrganizerRequest {

    public void cancelRequest();

    public void createRequest(String eventName, String startDateTime, String endDateTime, EventOrganizer eventOrganizer,
            VenueManager venueManager, String description);

    public int getRequestId();

}

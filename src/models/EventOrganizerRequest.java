package models;

public interface EventOrganizerRequest {

    public void cancelRequest();

    public static EventOrganizerRequest createRequest(String eventName, String startDateTime, String endDateTime,
            EventOrganizer eventOrganizer,
            VenueManager venueManager, String description) {
        return new Request(eventName, startDateTime, endDateTime, eventOrganizer, venueManager, description);
    }

    public int getRequestId();

    public String getEventName();

    public String getStartDateTime();

    public String getEndDateTime();

    public ReadOnlyVenueManager getVenueManager();

    public String getDescription();

    public String getFeedback();

    public Request.Status getStatus();

}

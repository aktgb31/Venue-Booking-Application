package models;

public interface VenueManagerRequest {

    public void acceptRequest(String feedBack);

    public void rejectRequest(String feedBack);

    public int getRequestId();

    public String getEventName();

    public String getStartDateTime();

    public String getEndDateTime();

    public ReadOnlyEventOrganizer getEventOrganizer();

    public String getDescription();

    public String getFeedback();

    public void setFeedback(String feedback);

    public Request.Status getStatus();

}

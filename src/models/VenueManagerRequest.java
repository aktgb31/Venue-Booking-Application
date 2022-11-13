package models;

public interface VenueManagerRequest {
    public void acceptRequest(String feedBack);

    public void rejectRequest(String feedBack);

    public void setFeedback(String feedback);

    public String getStatus();

}

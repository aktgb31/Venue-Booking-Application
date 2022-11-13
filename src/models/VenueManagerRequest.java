package models;

public interface VenueManagerRequest {
    public void acceptRequest(String feedBack);

    public void rejectRequest(String feedBack);

<<<<<<< HEAD
    public int getRequestId();

    public String getEventName();

    public String getStartDateTime();

    public String getEndDateTime();

    public EventOrganizer getEventOrganizer();

    public String getDescription();

    public String getFeedback();

    public void setFeedback(String feedback);

    public Request.Status getStatus();
=======
    public void setFeedback(String feedback);

    public String getStatus();
>>>>>>> 4c368ba848d72dfbb0e287c21397830b1c629876

}

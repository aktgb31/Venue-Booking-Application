package services;

public class EventOrganiserService extends models.EventOrganizer{

    private EventOrganiserService(String emailId, String password) {
        super(emailId,password);
        // Do Nothing
    }



    public static EventOrganiserService login(String emailId, String password) {
        EventOrganiserService eventOrganiserService=new EventOrganiserService(emailId,password);
        return eventOrganiserService;
    }
        return null;
    }
    public static void updateDetails(String name, String password, String contactNumber, String organisationName, String organisationAddress) {
        // Add code here
    }
}

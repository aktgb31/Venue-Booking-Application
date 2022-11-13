package models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class EventOrganizer extends Person{
    private  String organisationName;
    private  String organisationAddress;

    private HashMap<Integer,EventOrganizerRequest> events;

    public EventOrganizer() {
    }

    public EventOrganizer(String emailId,String password){
        super(emailId,password);
        
        ResultSet resultSet=database.Operations.getEventOrganizer(emailId);
        try{
            if(resultSet.next()){
                this.name=resultSet.getString("name");
                this.contactNumber=resultSet.getString("contact_number");
                this.organisationName=resultSet.getString("organisation_name");
                this.organisationAddress=resultSet.getString("organisation_address");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        String venueManagerEmailID;
        ResultSet resultSet1=database.Operations.getEventOrganizerBookings(emailId);
        try{
            while(resultSet1.next()){
                EventOrganizerRequest eventOrganizerRequest=new Request();
                eventOrganizerRequest.setRequestId(resultSet1.getInt("request_id"));
                eventOrganizerRequest.setEventName(resultSet1.getString("eventName"));
                eventOrganizerRequest.setStartDateTime(resultSet1.getString("startTime"));
                eventOrganizerRequest.setEndDateTime(resultSet1.getString("endTime"));
                venueManagerEmailID = resultSet1.getString("managerId");
                ResultSet resultSet2=database.Operations.getVenueManager(venueManagerEmailID);
                try{
                    if(resultSet2.next()){
                        VenueManager venueManager=new VenueManager();
                        venueManager.setName(resultSet2.getString("name"));
                        venueManager.setHallName(resultSet2.getString("hallName"));
                        venueManager.setHallAddress(resultSet2.getString("hallAddress"));
                        venueManager.setHallCapacity(resultSet2.getString("hallCapacity"));
                        venueManager.setHallDescription(resultSet2.getString("hallDescription"));
                        eventOrganizerRequest.setVenueManager(venueManager);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                eventOrganizerRequest.setDescription(resultSet1.getString("eventDescription"));
                events.put(eventOrganizerRequest.getRequestId(),eventOrganizerRequest);
            }
        }catch(Exception e){
            System.out.println(e);
        }



    };

    public EventOrganizer(String name, String emailId, String password, String contactNumber, String organisationName, String organisationAddress) {
        super(name, emailId, password, contactNumber);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;
        database.Operations.addEventOrganizer(this);
    }

    public void addBooking(EventOrganizerRequest eventOrganizerRequest){
        events.put(eventOrganizerRequest.getRequestId(),eventOrganizerRequest);
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
    public HashMap<Integer,EventOrganizerRequest> getEvents() {
        return events;
    }
    public void setEvents(HashMap<Integer,EventOrganizerRequest> events) {
        this.events = events;
    }

    public void updateDetails(){
        database.Operations.updateEventOrganizerProfile(this);
    }

    public HashMap<Integer,EventOrganizerRequest> getBookings(){
        return events;
    }

    public ArrayList<VenueManager> getVenueDetails(){
        ArrayList<VenueManager> venueDetails = new ArrayList<>();
        ResultSet resultSet=database.Operations.getVenueManagers();
        try{
            while(resultSet.next()){
                VenueManager venueManager=new VenueManager();
                venueManager.setName(resultSet.getString("name"));
                venueManager.setHallName(resultSet.getString("hallName"));
                venueManager.setHallAddress(resultSet.getString("hallAddress"));
                venueManager.setHallCapacity(resultSet.getString("hallCapacity"));
                venueManager.setHallDescription(resultSet.getString("hallDescription"));
                venueDetails.add(venueManager);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return venueDetails;
    }

}

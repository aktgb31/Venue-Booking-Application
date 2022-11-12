package models;

import javax.swing.*;

import java.sql.ResultSet;
import java.util.ArrayList;

public class EventOrganizer extends Person{
    private  String organisationName;
    private  String organisationAddress;

    private ArrayList<EventOrganizerRequest> events;

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
                eventOrganizerRequest.setEventName(resultSet1.getString("event_name"));
                eventOrganizerRequest.setStartDateTime(resultSet1.getString("startTime"));
                eventOrganizerRequest.setEndDateTime(resultSet1.getString("endTime"));
                venueManagerEmailID = resultSet1.getString("managerId");
                ResultSet resultSet2=database.Operations.getVenueManager(venueManagerEmailID);
                try{
                    if(resultSet2.next()){
                        VenueManager venueManager=new VenueManager();
                        venueManager.setName(resultSet2.getString("name"));
                        venueManager.setHallName(resultSet2.getString("hall_name"));
                        venueManager.setHallAddress(resultSet2.getString("hall_address"));
                        venueManager.setHallCapacity(resultSet2.getString("hall_capacity"));
                        venueManager.setHallDescription(resultSet2.getString("hall_description"));
                        eventOrganizerRequest.setVenueManager(venueManager);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
                eventOrganizerRequest.setDescription(resultSet1.getString("description"));
                events.add(eventOrganizerRequest);
            }
        }catch(Exception e){
            System.out.println(e);
        }



    };

    public EventOrganizer(String name, String emailId, String password, String contactNumber, String organisationName, String organisationAddress) {
        super(name, emailId, password, contactNumber);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;

    }

    public void createBooking(String hallName, String startDateTime, String endDateTime, String eventName, String description) {
        EventOrganizerRequest eventOrganizerRequest=new Request();
        eventOrganizerRequest.setEventName(eventName);
        eventOrganizerRequest.setStartDateTime(startDateTime);
        eventOrganizerRequest.setEndDateTime(endDateTime);
        eventOrganizerRequest.setDescription(description);
        VenueManager venueManager=new VenueManager();
        ResultSet resultSet=database.Operations.getVenueManager(hallName);
        try{
            if(resultSet.next()){
                venueManager.setName(resultSet.getString("name"));
                venueManager.setHallName(resultSet.getString("hallName"));
                venueManager.setHallAddress(resultSet.getString("hallAddress"));
                venueManager.setHallCapacity(resultSet.getString("hallCapacity"));
                venueManager.setHallDescription(resultSet.getString("hallDescription"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        eventOrganizerRequest.setEventOrganizer(this);
        eventOrganizerRequest.setVenueManager(venueManager);
        database.Operations.createBooking(eventOrganizerRequest);
        events.add(eventOrganizerRequest);
    }
    //getters and setters
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
    public ArrayList<EventOrganizerRequest> getEvents() {
        return events;
    }
    public void setEvents(ArrayList<EventOrganizerRequest> events) {
        this.events = events;
    }

    public void updateDetails(){
        database.Operations.updateEventOrganizerProfile(this);
    }


}

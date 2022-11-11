package models;

import javax.swing.*;
import java.util.ArrayList;

public class EventOrganizer extends Person{
    protected  String organisationName;
    protected  String organisationAddress;

    protected ArrayList<EventOrganizerRequest> events;

    protected EventOrganizer(String emailId,String password){
    // Try to search in database
    };

    protected EventOrganizer(String name, String emailId, String password, String contactNumber, String organisationName, String organisationAddress) {
        super(name, emailId, password, contactNumber);
        this.organisationName = organisationName;
        this.organisationAddress = organisationAddress;

    //  Store this data in table
    }

}

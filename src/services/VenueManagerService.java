package services;

import models.VenueManager;
public class VenueManagerService{
    private VenueManager venueManager;

    public VenueManagerService(){
        this.venueManager = new VenueManager();
    }


    public void login(String emailId, String password) {
         this.venueManager = new VenueManager(emailId, password);
    }


    private void updateDetails(String name, String password, String contactNumber, String hallName, String hallAddress, String hallCapacity, String hallDescription) {
        venueManager.setName(name);
        venueManager.setPassword(password);
        venueManager.setContactNumber(contactNumber);
        venueManager.setHallName(hallName);
        venueManager.setHallAddress(hallAddress);
        venueManager.setHallCapacity(hallCapacity);
        venueManager.setHallDescription(hallDescription);
        venueManager.updateDetails();

    }

}

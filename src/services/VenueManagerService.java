package services;

import java.util.ArrayList;
import java.util.HashMap;

import models.VenueManager;
import models.VenueManagerRequest;

public class VenueManagerService{
    private VenueManager venueManager;

    public VenueManagerService(){
        this.venueManager = new VenueManager();
    }


    public void login(String emailId, String password) {
         this.venueManager = new VenueManager(emailId, password);
    }

    public void registrationService(String name, String emailId, String password, String contactNumber, String hallName, String hallAddress, String hallCapacity, String hallDescription) {
        this.venueManager = new VenueManager(name, emailId, password, contactNumber, hallName, hallAddress, hallCapacity, hallDescription);
    }


    public void updateProfileService(String name, String password, String contactNumber, String hallName, String hallAddress, String hallCapacity, String hallDescription) {
        venueManager.setName(name);
        venueManager.setPassword(password);
        venueManager.setContactNumber(contactNumber);
        venueManager.setHallName(hallName);
        venueManager.setHallAddress(hallAddress);
        venueManager.setHallCapacity(hallCapacity);
        venueManager.setHallDescription(hallDescription);
        venueManager.updateDetails();
    }

    public ArrayList<VenueManagerRequest> getPendingRequestsService(){
        HashMap<Integer,VenueManagerRequest> eventRequests = venueManager.getRequestedEvents();
        ArrayList<VenueManagerRequest> pendingRequests = new ArrayList<VenueManagerRequest>();
        for(VenueManagerRequest event : eventRequests.values()){
            if(event.getStatus().equals("Pending")){
                pendingRequests.add(event);
            }
        }
        return pendingRequests;
    }

    public ArrayList<VenueManagerRequest> getNonPendingRequestsService(){
        HashMap<Integer,VenueManagerRequest> eventsMap = venueManager.getRequestedEvents();
        ArrayList<VenueManagerRequest> nonPendingRequests = new ArrayList<VenueManagerRequest>();
        for(VenueManagerRequest event : eventsMap.values()){
            if(event.getStatus().equals("Pending") == false){
                nonPendingRequests.add(event);
            }
        }
        return nonPendingRequests;
    }

    public VenueManager getProfileService() {
        return venueManager;
    }

    public void acceptRequestService(int requestId,String feedBack) {
        venueManager.getRequestedEvents().get(requestId).acceptRequest(feedBack);
    }

    public void rejectRequestService(int requestId,String feedBack) {
        venueManager.getRequestedEvents().get(requestId).rejectRequest(feedBack);
        venueManager.getRequestedEvents().get(requestId).setFeedback(feedBack);
    }

    public void logoutService(){
        venueManager = null;
    }






}

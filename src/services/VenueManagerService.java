package services;

import models.Request.Status;
import models.VenueManager;
import models.VenueManagerRequest;

import java.util.ArrayList;
import java.util.HashMap;

public class VenueManagerService {
    private VenueManager venueManager;

    private VenueManagerService(VenueManager venueManager) {
        this.venueManager = venueManager;
    }

    public static VenueManagerService login(String emailId, String password) throws Exception {
        VenueManager venueManager = new VenueManager(emailId, password);
        System.out.println(venueManager.getHallName());
        return new VenueManagerService(venueManager);
    }

    public static VenueManagerService register(String name, String emailId, String password,
                                               String contactNumber, String hallName, String hallAddress, int hallCapacity, String hallDescription) throws Exception {
        try {
            VenueManager venueManager = new VenueManager(name, emailId, password, contactNumber, hallName, hallAddress,
                    hallCapacity, hallDescription);
            return new VenueManagerService(venueManager);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateProfile(String name, String password, String contactNumber, String hallName,
                              String hallAddress, int hallCapacity, String hallDescription) {
        venueManager.setName(name);
        venueManager.setPassword(password);
        venueManager.setContactNumber(contactNumber);
        venueManager.setHallName(hallName);
        venueManager.setHallAddress(hallAddress);
        venueManager.setHallCapacity(hallCapacity);
        venueManager.setHallDescription(hallDescription);
        venueManager.updateDetails();
    }

    public ArrayList<VenueManagerRequest> getPendingRequests() {
        HashMap<Integer, VenueManagerRequest> eventRequests = venueManager.getRequests();
        ArrayList<VenueManagerRequest> pendingRequests = new ArrayList<VenueManagerRequest>();
        for (VenueManagerRequest event : eventRequests.values()) {
            if (event.getStatus().equals(Status.PENDING)) {
                pendingRequests.add(event);
            }
        }
        return pendingRequests;
    }

    public ArrayList<VenueManagerRequest> getNonPendingRequests() {
        HashMap<Integer, VenueManagerRequest> eventsMap = venueManager.getRequests();
        ArrayList<VenueManagerRequest> nonPendingRequests = new ArrayList<VenueManagerRequest>();
        for (VenueManagerRequest event : eventsMap.values()) {
            if (event.getStatus().equals(Status.PENDING) != true) {
                nonPendingRequests.add(event);
            }
        }
        return nonPendingRequests;
    }

    public VenueManager getProfile() {
        return venueManager;
    }

    public void acceptRequest(int requestId, String feedBack) {
        venueManager.getRequests().get(requestId).acceptRequest(feedBack);
    }

    public void rejectRequest(int requestId, String feedBack) {
        venueManager.getRequests().get(requestId).rejectRequest(feedBack);
    }

    public void logout() {
        venueManager = null;
    }

}

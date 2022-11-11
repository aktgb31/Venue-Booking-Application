package services;

import models.VenueManager;
public class VenueManagerService extends models.VenueManager{
    private void updateDetails(String name, String password, String contactNumber, String hallName, String hallAddress, String hallCapacity, String hallDescription) {
        this.name = name;
        this.password = password;
        this.contactNumber = contactNumber;
        this.hallName = hallName;
        this.hallAddress = hallAddress;
        this.hallCapacity = hallCapacity;
        this.hallDescription = hallDescription;

    }
}

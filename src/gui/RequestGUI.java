package gui;

import javax.swing.*;

public class RequestGUI {
    @Override
    public JFrame eventOrganiserScreen() {
        // Add code here
        return null;
    }

    @Override
    public JFrame venueManagerScreen() {
        // Add code here
        return null;
    }

    @Override
    public JFrame eventDetailsScreen() {
        return event.viewDetailsPanel();
    }

    @Override
    public models.Request.Status getStatus() {
        return this.status;
    }
}

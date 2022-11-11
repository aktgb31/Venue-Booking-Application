package gui;

import services.EventOrganiserService;
import services.VenueManagerService;

import javax.swing.*;

abstract public class PersonGUI {
    abstract public void dashboardScreen();

    // Entry Point of the application
    static public PersonGUI loginScreen() {
        JFrame f = new JFrame("Login");
        f.setSize(600, 600);

        JLabel heading = new JLabel("Venue Booking Application");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JLabel l1 = new JLabel("Email ID");
        JLabel l2 = new JLabel("Password");
        JLabel l3 = new JLabel("User Type");

        JTextField t1 = new JTextField();
        JPasswordField t2 = new JPasswordField();
        String[] usertype = {"Event Organizer", "Venue Manager"};
        JComboBox cb = new JComboBox(usertype);

        JButton b1 = new JButton("Login");
        JButton b2 = new JButton("Register as Venue Manager");
        JButton b3 = new JButton("Register as Event Organizer");

        l1.setBounds(50, 100, 100, 30);
        l2.setBounds(50, 150, 100, 30);
        l3.setBounds(50, 200, 100, 30);
        t1.setBounds(150, 100, 200, 30);
        t2.setBounds(150, 150, 200, 30);
        cb.setBounds(150, 200, 200, 30);
        b1.setBounds(100, 250, 100, 30);
        b2.setBounds(100, 300, 200, 30);
        b3.setBounds(100, 350, 200, 30);

        b1.setHorizontalAlignment(JButton.CENTER);
        b2.setHorizontalAlignment(JButton.CENTER);
        b3.setHorizontalAlignment(JButton.CENTER);

        f.add(heading);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(t1);
        f.add(t2);
        f.add(cb);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String type = cb.getSelectedItem().toString();
        String emailId = t1.getText();
        String password = String.valueOf(t2.getPassword());
        try {
            if (type.equals("EventOrganizer")) {
                new EventOrganizerGUI(EventOrganiserService.login(emailId, password));
            } else {
                new VenueManagerGUI(VenueManagerService.login(emailId, password));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    abstract public void registerScreen();
}

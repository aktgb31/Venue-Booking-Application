package gui;

import services.EventOrganiserService;
import services.VenueManagerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame mainFrame;
    private JPanel activePanel;
    private static GUI instance;
    private GUI(){
        this.activePanel=new JPanel();
        this.mainFrame = new JFrame("Venue Management System");
        mainFrame.setSize(1200,1200);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.add(this.activePanel);
        mainFrame.setVisible(true);
    }

    public static GUI getInstance(){
        if(instance == null){
            instance = new GUI();
        }
        return instance;
    }
    public void setPanel(JPanel panel){
//        mainFrame.setVisible(false);
        mainFrame.remove(this.activePanel);
        mainFrame.add(panel);
        this.activePanel = panel;
        mainFrame.revalidate();
        mainFrame.repaint();
//        mainFrame.setVisible(true);

    }
    static public void login() {
        JPanel panel = new JPanel(null);
        panel.setSize(1200, 1200);

        JLabel heading = new JLabel("Venue Booking Application");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JLabel l1 = new JLabel("Email ID");
        JLabel l2 = new JLabel("Password");
        JLabel l3 = new JLabel("User Type");

        JTextField t1 = new JTextField();
        JPasswordField t2 = new JPasswordField();
        String[] usertype = { "Event Organizer", "Venue Manager" };
        JComboBox cb = new JComboBox(usertype);

        JButton b1 = new JButton("Login");
        JButton b2 = new JButton("Register as Venue Manager");
        JButton b3 = new JButton("Register as Event Organizer");

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.getInstance().setPanel(VenueManagerGUI.signUp());
            }
        });


        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.getInstance().setPanel(EventOrganizerGUI.signUp());
            }
        });


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

        panel.add(heading);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(t1);
        panel.add(t2);
        panel.add(cb);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        String type = cb.getSelectedItem().toString();
        String emailId = t1.getText();
        String password = String.valueOf(t2.getPassword());
        try {
            if (type.equals("EventOrganizer")) {
                EventOrganiserService eventOrganiserService = EventOrganiserService.login(emailId, password);
//                new EventOrganizerGUI(eventOrganiserService);
            } else {
                VenueManagerService venueManagerService = VenueManagerService.login(emailId, password);
//                new VenueManagerGUI(venueManagerService);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        GUI.getInstance().setPanel(panel);
    }

}

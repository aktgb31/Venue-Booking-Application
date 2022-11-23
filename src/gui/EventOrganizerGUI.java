package gui;

import models.EventOrganizer;
import models.EventOrganizerRequest;
import models.ReadOnlyVenueManager;
import models.VenueManager;
import services.EventOrganiserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class EventOrganizerGUI {
    private static EventOrganizerGUI instance;
    private EventOrganiserService eventOrganiserService;

    private EventOrganizerGUI(EventOrganiserService eventOrganiserService) {
        this.eventOrganiserService = eventOrganiserService;
    }

    public static void initialize(EventOrganiserService eventOrganiserService) throws IllegalStateException {
        if (instance == null) {
            instance = new EventOrganizerGUI(eventOrganiserService);
        } else {
            throw new IllegalStateException("Event Organizer GUI already initialized");
        }
    }

    public static EventOrganizerGUI getInstance() throws RuntimeException {
        if (instance == null) {
            throw new RuntimeException("Event Organizer GUI not initialized");
        }
        return instance;
    }

    public static JPanel signUp() {

        JPanel panel = new JPanel(null);
        panel.setSize(1200, 1200);

        JLabel heading = new JLabel("Event Organizer Registration");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JLabel l1 = new JLabel("Name");
        JLabel l2 = new JLabel("Email ID");
        JLabel l3 = new JLabel("Password");
        JLabel l4 = new JLabel("Contact Number");
        JLabel l5 = new JLabel("Organization Name");
        JLabel l6 = new JLabel("Organization Address");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JPasswordField t3 = new JPasswordField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();

        JButton b1 = new JButton("Register");
        JButton b2 = new JButton("Login");

        //setbounds
        heading.setBounds(50, 10, 400, 50);
        l1.setBounds(50, 70, 200, 30);
        l2.setBounds(50, 110, 200, 30);
        l3.setBounds(50, 150, 200, 30);
        l4.setBounds(50, 190, 200, 30);
        l5.setBounds(50, 230, 200, 30);
        l6.setBounds(50, 270, 200, 30);
        t1.setBounds(300, 70, 300, 30);
        t2.setBounds(300, 110, 300, 30);
        t3.setBounds(300, 150, 300, 30);
        t4.setBounds(300, 190, 300, 30);
        t5.setBounds(300, 230, 300, 30);
        t6.setBounds(300, 270, 300, 30);
        b1.setBounds(50, 310, 200, 30);
        b2.setBounds(300, 310, 200, 30);

        //event handling on buttons
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = t1.getText();
                    String email = t2.getText();
                    String password = t3.getText();
                    String contactNumber = t4.getText();
                    String organizationName = t5.getText();
                    String organizationAddress = t6.getText();

                    if (name.equals("") || email.equals("") || password.equals("") || contactNumber.equals("") || organizationName.equals("") || organizationAddress.equals("")) {
                        throw new RuntimeException("All fields are mandatory");
                    } else {
                        if (password.length() < 8) {
                            throw new RuntimeException("Password must be at least 8 characters long");
                        } else {
                            if (contactNumber.length() != 10) {
                                throw new RuntimeException("Contact number must be 10 digits long");
                            } else {
                                if (!email.contains("@") || !email.contains(".")) {
                                    throw new RuntimeException("Invalid email ID");
                                } else {
                                    EventOrganiserService service = EventOrganiserService.register(name, email, password, contactNumber, organizationName, organizationAddress);
                                    JOptionPane.showMessageDialog(null, "Registration Successful");
                                    EventOrganizerGUI.initialize(service);
                                    PersonGUI.getInstance().setPanel(EventOrganizerGUI.getInstance().dashboardScreen());
                                }
                            }
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(PersonGUI.login());
            }
        });

        //add to panel
        panel.add(heading);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        panel.add(t1);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(t5);
        panel.add(t6);
        panel.add(b1);
        panel.add(b2);


        return panel;

    }

    public JPanel dashboardScreen() {
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(1200, 800);

        JLabel heading = new JLabel("Event Organizer Dashboard");
        heading.setBounds(100, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JButton b1 = new JButton("Book Venue");
        JButton b2 = new JButton("View Bookings");
        JButton b3 = new JButton("Profile");
        JButton b4 = new JButton("Logout");

        b1.setBounds(200, 100, 200, 30);
        b2.setBounds(200, 150, 200, 30);
        b3.setBounds(200, 200, 200, 30);
        b4.setBounds(200, 250, 200, 30);

        mainPanel.add(heading);
        mainPanel.add(b1);
        mainPanel.add(b2);
        mainPanel.add(b3);
        mainPanel.add(b4);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(EventOrganizerGUI.getInstance().bookVenueScreen());
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(EventOrganizerGUI.getInstance().viewBookingsScreen());
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(EventOrganizerGUI.getInstance().profileScreen());
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventOrganizerGUI.getInstance().eventOrganiserService.logoutService();
                EventOrganizerGUI.getInstance().eventOrganiserService = null;
                PersonGUI.getInstance().setPanel(PersonGUI.login());
            }
        });
        return mainPanel;
    }

    private JPanel profileScreen() {
        EventOrganizer myProfile = eventOrganiserService.getProfile();
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(1200, 800);

        JLabel heading = new JLabel("Event Organizer Profile");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JLabel l1 = new JLabel("Name");
        JLabel l2 = new JLabel("Email ID");
        JLabel l3 = new JLabel("Password");
        JLabel l4 = new JLabel("Contact Number");
        JLabel l5 = new JLabel("Organisation Name");
        JLabel l6 = new JLabel("Organisation Address");

        JTextField t1 = new JTextField();
        t1.setText(myProfile.getName());

        JTextField t2 = new JTextField();
        t2.setText(myProfile.getEmailId());
        t2.setEditable(false);

        JTextField t3 = new JTextField();
        t3.setText(myProfile.getPassword());

        JTextField t4 = new JTextField();
        t4.setText(myProfile.getContactNumber());

        JTextField t5 = new JTextField();
        t5.setText(myProfile.getOrganisationName());

        JTextField t6 = new JTextField();
        t6.setText(myProfile.getOrganisationAddress());

        JButton b1 = new JButton("Update");
        JButton b2 = new JButton("Dashboard");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myProfile.setName(t1.getText());
                    myProfile.setPassword(t3.getText());
                    myProfile.setContactNumber(t4.getText());
                    myProfile.setOrganisationName(t5.getText());
                    myProfile.setOrganisationAddress(t6.getText());
                    myProfile.updateDetails();
                    JOptionPane.showMessageDialog(null, "Profile updated successfully");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Profile update failed");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(EventOrganizerGUI.getInstance().dashboardScreen());
            }
        });

        l1.setBounds(50, 100, 200, 30);
        l2.setBounds(50, 150, 200, 30);
        l3.setBounds(50, 200, 200, 30);
        l4.setBounds(50, 250, 200, 30);
        l5.setBounds(50, 300, 200, 30);
        l6.setBounds(50, 350, 200, 30);
        t1.setBounds(250, 100, 200, 30);
        t2.setBounds(250, 150, 200, 30);
        t3.setBounds(250, 200, 200, 30);
        t4.setBounds(250, 250, 200, 30);
        t5.setBounds(250, 300, 200, 30);
        t6.setBounds(250, 350, 200, 30);
        b1.setBounds(75, 400, 100, 30);
        b2.setBounds(200, 400, 100, 30);

        mainPanel.add(heading);
        mainPanel.add(l1);
        mainPanel.add(l2);
        mainPanel.add(l3);
        mainPanel.add(l4);
        mainPanel.add(l5);
        mainPanel.add(l6);
        mainPanel.add(t1);
        mainPanel.add(t2);
        mainPanel.add(t3);
        mainPanel.add(t4);
        mainPanel.add(t5);
        mainPanel.add(t6);
        mainPanel.add(b1);
        mainPanel.add(b2);

        return mainPanel;
    }

    private JPanel bookVenueScreen() {
        ArrayList<ReadOnlyVenueManager> venueManagers = eventOrganiserService.getVenueDetails();
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(1200, 800);

        JLabel heading = new JLabel("Create Booking");
        heading.setBounds(100, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JLabel l1 = new JLabel("Venue");
        JLabel l2 = new JLabel("Start Date Time");
        JLabel l3 = new JLabel("End Date Time");
        JLabel l4 = new JLabel("Event Name");
        JLabel l5 = new JLabel("Booking Description");

        String[] venueNames = new String[venueManagers.size()];
        for (int i = 0; i < venueManagers.size(); i++) {
            venueNames[i] = venueManagers.get(i).getHallName();
        }

        JComboBox cb = new JComboBox(venueNames);

        JTextField t1 = new JTextField();

        JTextField t2 = new JTextField();

        JTextField t3 = new JTextField();

        JTextArea t4 = new JTextArea();

        JButton b1 = new JButton("Create Booking");
        JButton b2 = new JButton("Cancel");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eventOrganiserService.createBooking((VenueManager) venueManagers.get(cb.getSelectedIndex()), t1.getText(), t2.getText(), t3.getText(), t4.getText());
                    JOptionPane.showMessageDialog(null, "Booking created successfully");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Booking creation failed");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(EventOrganizerGUI.getInstance().dashboardScreen());
            }
        });

        l1.setBounds(50, 100, 150, 30);
        l2.setBounds(50, 150, 150, 30);
        l3.setBounds(50, 200, 150, 30);
        l4.setBounds(50, 250, 150, 30);
        l5.setBounds(50, 300, 150, 30);
        cb.setBounds(200, 100, 200, 30);
        t1.setBounds(200, 150, 200, 30);
        t2.setBounds(200, 200, 200, 30);
        t3.setBounds(200, 250, 200, 30);
        t4.setBounds(200, 300, 200, 100);
        b1.setBounds(100, 450, 150, 30);
        b2.setBounds(300, 450, 150, 30);

        b1.setHorizontalAlignment(JButton.CENTER);
        b2.setHorizontalAlignment(JButton.CENTER);

        mainPanel.add(heading);
        mainPanel.add(l1);
        mainPanel.add(l2);
        mainPanel.add(l3);
        mainPanel.add(l4);
        mainPanel.add(l5);
        mainPanel.add(cb);
        mainPanel.add(t1);
        mainPanel.add(t2);
        mainPanel.add(t3);
        mainPanel.add(t4);
        mainPanel.add(b1);
        mainPanel.add(b2);

        String[] columnNames = {"Hall Name", "Hall Capacity", "Hall Description", "Hall Address"};
        String[][] data = new String[venueManagers.size()][4];
        for (int i = 0; i < venueManagers.size(); i++) {
            data[i][0] = venueManagers.get(i).getHallName();
            data[i][1] = Integer.toString(venueManagers.get(i).getHallCapacity());
            data[i][2] = venueManagers.get(i).getHallDescription();
            data[i][3] = venueManagers.get(i).getHallAddress();
        }
        JTable table = new JTable(data, columnNames);
        table.setBounds(450, 100, 700, 300);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(450, 100, 700, 300);
        mainPanel.add(sp);
        return mainPanel;
    }

    private JPanel viewBookingsScreen() {
        ArrayList<EventOrganizerRequest> bookings = eventOrganiserService.getBookingHistory();
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(1200, 800);

        String[] columnNames = {"Event Name", "Start Time", "End Time", "Status", "Contact Number", "Venue", "Hall Capacity", "feedback", "Hall Description"};
        String[][] data = new String[bookings.size()][9];
        for (int i = 0; i < bookings.size(); i++) {
            data[i][0] = bookings.get(i).getEventName();
            data[i][1] = bookings.get(i).getStartDateTime();
            data[i][2] = bookings.get(i).getEndDateTime();
            data[i][3] = bookings.get(i).getStatus().toString();
            data[i][4] = bookings.get(i).getVenueManager().getContactNumber();
            data[i][5] = bookings.get(i).getVenueManager().getHallName();
            data[i][6] = Integer.toString(bookings.get(i).getVenueManager().getHallCapacity());
            data[i][7] = bookings.get(i).getFeedback();
            data[i][8] = bookings.get(i).getVenueManager().getHallDescription();
        }

        JTable table = new JTable(data, columnNames);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(250);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane);

        return mainPanel;
    }
}

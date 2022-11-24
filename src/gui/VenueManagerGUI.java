package gui;

import models.ReadOnlyEventOrganizer;
import models.VenueManager;
import models.VenueManagerRequest;
import services.VenueManagerService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class VenueManagerGUI {
    private static VenueManagerGUI instance;
    private VenueManagerService venueManagerService;

    private VenueManagerGUI(VenueManagerService service) {
        this.venueManagerService = service;
    }

    public static void initialize(VenueManagerService service) throws RuntimeException {
        instance = new VenueManagerGUI(service);
    }

    public static VenueManagerGUI getInstance() throws RuntimeException {
        if (instance == null) {
            throw new RuntimeException("VenueManagerGUI not initialized");
        }
        return instance;
    }

    public static JPanel signUp() {
        JPanel panel = new JPanel(null);
        panel.setSize(1200, 800);

        JLabel heading = new JLabel("Venue Manager Registration");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JLabel l1 = new JLabel("Name");
        JLabel l2 = new JLabel("Email ID");
        JLabel l3 = new JLabel("Password");
        JLabel l4 = new JLabel("Contact Number");
        JLabel l5 = new JLabel("Hall Name");
        JLabel l6 = new JLabel("Hall Address");
        JLabel l7 = new JLabel("Hall Capacity");
        JLabel l8 = new JLabel("Hall Description");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JPasswordField t3 = new JPasswordField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();
        JTextField t7 = new JTextField();
        t7.setText("Example: 1000");
        JTextField t8 = new JTextField();
        t8.setText("Example: AC/Non AC, Projector,Cost, Wifi, etc.");
        t7.setForeground(Color.GRAY);
        t8.setForeground(Color.GRAY);

        JButton b1 = new JButton("Register");
        JButton b2 = new JButton("Login");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = t1.getText();
                    String email = t2.getText();
                    String password = new String(t3.getPassword());
                    String contact = t4.getText();
                    String hallName = t5.getText();
                    String hallAddress = t6.getText();
                    String hallCapacity = t7.getText();
                    String hallDescription = t8.getText();
                    if (name.equals("") || email.equals("") || password.equals("") || contact.equals("") || hallName.equals("") || hallAddress.equals("") || hallCapacity.equals("") || hallDescription.equals("")) {
                        throw new RuntimeException("Please fill all the fields");
                    } else {
                        if (hallCapacity.equals("Example: 1000")) {
                            throw new RuntimeException("Please enter hall capacity");
                        } else if (hallDescription.equals("Example: AC/Non AC, Projector,Cost, Wifi, etc.")) {
                            throw new RuntimeException("Please enter hall description");
                        } else {

                            int capacity = Integer.parseInt(hallCapacity);
                            if (capacity <= 0) {
                                throw new RuntimeException("Hall capacity should be greater than 0");
                            } else {
                                VenueManagerService service = VenueManagerService.register(name, email, password, contact, hallName, hallAddress, capacity, hallDescription);
                                JOptionPane.showMessageDialog(null, "Venue Manager Registered Successfully");
                                VenueManagerGUI.initialize(service);
                                PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().dashboardScreen());
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

        l1.setBounds(50, 100, 200, 30);
        l2.setBounds(50, 150, 200, 30);
        l3.setBounds(50, 200, 200, 30);
        l4.setBounds(50, 250, 200, 30);
        l5.setBounds(50, 300, 200, 30);
        l6.setBounds(50, 350, 200, 30);
        l7.setBounds(50, 400, 200, 30);
        l8.setBounds(50, 450, 200, 30);
        t1.setBounds(250, 100, 300, 30);
        t2.setBounds(250, 150, 300, 30);
        t3.setBounds(250, 200, 300, 30);
        t4.setBounds(250, 250, 300, 30);
        t5.setBounds(250, 300, 300, 30);
        t6.setBounds(250, 350, 300, 30);
        t7.setBounds(250, 400, 300, 30);
        t8.setBounds(250, 450, 300, 30);
        b1.setBounds(75, 500, 100, 30);
        b2.setBounds(200, 500, 100, 30);

        t7.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                t7.setText("");
                t7.setForeground(Color.BLACK);

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (t7.getText().isEmpty()) {
                    t7.setText("Example: 1000");
                    t7.setForeground(Color.GRAY);
                }
            }
        });
        t8.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                t8.setText("");
                t8.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (t8.getText().isEmpty()) {
                    t8.setForeground(Color.GRAY);
                    t8.setText("Example: AC/Non AC, Projector,Cost, Wifi, etc.");
                }
            }
        });

        panel.add(heading);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        panel.add(l7);
        panel.add(l8);
        panel.add(t1);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(t5);
        panel.add(t6);
        panel.add(t7);
        panel.add(t8);
        panel.add(b1);
        panel.add(b2);

        return panel;
    }

    public JPanel dashboardScreen() {
        JPanel panel = new JPanel(null);
        panel.setSize(800, 800);

        JLabel heading = new JLabel("Venue Manager Dashboard");
        heading.setBounds(100, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JButton b1 = new JButton("View Booking Requests");
        JButton b2 = new JButton("View Bookings");
        JButton b3 = new JButton("Profile");
        JButton b4 = new JButton("Logout");

        b1.setBounds(200, 100, 200, 30);
        b2.setBounds(200, 150, 200, 30);
        b3.setBounds(200, 200, 200, 30);
        b4.setBounds(200, 250, 200, 30);

        panel.add(heading);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().viewBookingRequestsScreen());
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().viewBookingsScreen());
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().profileScreen());
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VenueManagerGUI.getInstance().venueManagerService.logout();
                VenueManagerGUI.getInstance().venueManagerService = null;
                PersonGUI.getInstance().setPanel(PersonGUI.login());
            }
        });
        return panel;
    }

    private JPanel profileScreen() {
        VenueManager myProfile = venueManagerService.getProfile();
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(1200, 800);

        JLabel heading = new JLabel("Venue Manager Profile");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);

        JLabel l1 = new JLabel("Name");
        JLabel l2 = new JLabel("Email ID");
        JLabel l3 = new JLabel("Password");
        JLabel l4 = new JLabel("Contact Number");
        JLabel l5 = new JLabel("Hall Name");
        JLabel l6 = new JLabel("Hall Address");
        JLabel l7 = new JLabel("Hall Capacity");
        JLabel l8 = new JLabel("Hall Description");

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
        t5.setText(myProfile.getHallName());

        JTextField t6 = new JTextField();
        t6.setText(myProfile.getHallAddress());

        JTextField t7 = new JTextField();
        t7.setText(Integer.toString(myProfile.getHallCapacity()));

        JTextField t8 = new JTextField();
        t8.setText(myProfile.getHallDescription());

        JButton b1 = new JButton("Update");
        JButton b2 = new JButton("Dashboard");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myProfile.setName(t1.getText());
                    myProfile.setPassword(t3.getText());
                    myProfile.setContactNumber(t4.getText());
                    myProfile.setHallName(t5.getText());
                    myProfile.setHallAddress(t6.getText());
                    myProfile.setHallCapacity(Integer.parseInt(t7.getText()));
                    myProfile.setHallDescription(t8.getText());
                    myProfile.updateDetails();
                    JOptionPane.showMessageDialog(null, "Profile Updated Successfully");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error in Updating Profile : " + ex.getMessage());
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().dashboardScreen());
            }
        });

        l1.setBounds(50, 100, 200, 30);
        l2.setBounds(50, 150, 200, 30);
        l3.setBounds(50, 200, 200, 30);
        l4.setBounds(50, 250, 200, 30);
        l5.setBounds(50, 300, 200, 30);
        l6.setBounds(50, 350, 200, 30);
        l7.setBounds(50, 400, 200, 30);
        l8.setBounds(50, 450, 200, 30);
        t1.setBounds(250, 100, 300, 30);
        t2.setBounds(250, 150, 300, 30);
        t3.setBounds(250, 200, 300, 30);
        t4.setBounds(250, 250, 300, 30);
        t5.setBounds(250, 300, 300, 30);
        t6.setBounds(250, 350, 300, 30);
        t7.setBounds(250, 400, 300, 30);
        t8.setBounds(250, 450, 300, 30);
        b1.setBounds(50, 500, 200, 30);
        b2.setBounds(250, 500, 200, 30);

        mainPanel.add(heading);
        mainPanel.add(l1);
        mainPanel.add(l2);
        mainPanel.add(l3);
        mainPanel.add(l4);
        mainPanel.add(l5);
        mainPanel.add(l6);
        mainPanel.add(l7);
        mainPanel.add(l8);
        mainPanel.add(t1);
        mainPanel.add(t2);
        mainPanel.add(t3);
        mainPanel.add(t4);
        mainPanel.add(t5);
        mainPanel.add(t6);
        mainPanel.add(t7);
        mainPanel.add(t8);
        mainPanel.add(b1);
        mainPanel.add(b2);

        return mainPanel;
    }

    private JPanel viewBookingRequestsScreen() {
        ArrayList<VenueManagerRequest> bookingRequests = venueManagerService.getPendingRequests();
        if (bookingRequests.size() == 0) {
            JOptionPane.showMessageDialog(null, "No Booking Requests");
            return dashboardScreen();
        }
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(1200, 800);

        JButton dashboard = new JButton("Dashboard");
        dashboard.setBounds(50, 50, 200, 30);
        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().dashboardScreen());
            }
        });
        mainPanel.add(dashboard);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(bookingRequests.size()+1, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel Title = new JLabel("Booking Requests");
        Title.setFont(new Font("Serif", Font.BOLD, 20));
        Title.setHorizontalAlignment(JLabel.CENTER);
        panel.add(Title);

        int yCoordinate = 90;

        for (VenueManagerRequest request : bookingRequests) {

            JPanel requestPanel = new JPanel();
            JLabel heading = new JLabel(request.getEventName());
            heading.setFont(new Font("Serif", Font.BOLD, 15));
            heading.setHorizontalAlignment(JLabel.CENTER);
            heading.setBounds(50, yCoordinate, 1000, 30);
            yCoordinate+= 20;
            requestPanel.add(heading);

            JLabel starttimeL = new JLabel("Start : " + request.getStartDateTime());
            JLabel endtimeL = new JLabel("End : " + request.getEndDateTime());
            JLabel statusL = new JLabel("Status : " + request.getStatus());

            starttimeL.setBounds(50, yCoordinate, 100, 30);
            endtimeL.setBounds(150, yCoordinate, 100, 30);
            statusL.setBounds(250, yCoordinate, 100, 30);
            yCoordinate+= 20;

            requestPanel.add(starttimeL);
            requestPanel.add(endtimeL);
            requestPanel.add(statusL);

            ReadOnlyEventOrganizer eventOrganizer = request.getEventOrganizer();
            JLabel name = new JLabel("Organizer : " + eventOrganizer.getName());
            JLabel organization = new JLabel("Organization : " + eventOrganizer.getOrganizationName());
            JLabel phone = new JLabel("Contact Number : " + eventOrganizer.getContactNumber());

            name.setBounds(50, yCoordinate, 100, 30);
            organization.setBounds(150, yCoordinate, 100, 30);
            phone.setBounds(250, yCoordinate, 100, 30);
            yCoordinate+= 20;

            requestPanel.add(name);
            requestPanel.add(organization);
            requestPanel.add(phone);

            JButton accept = new JButton("Accept");
            JButton reject = new JButton("Reject");
            accept.setBounds(50, yCoordinate, 100, 30);
            reject.setBounds(150, yCoordinate, 100, 30);
            yCoordinate+= 20;

            requestPanel.add(accept);
            requestPanel.add(reject);

            JLabel description = new JLabel("Booking Description : " + request.getDescription());
            description.setBounds(50, yCoordinate, 100, 30);
            yCoordinate+= 20;
            requestPanel.add(description);

            JLabel feedback = new JLabel("Feedback");
            feedback.setBounds(50, yCoordinate, 100, 30);
            yCoordinate+= 20;
            JTextField feedbackText = new JTextField();

            requestPanel.add(feedback);
            requestPanel.add(feedbackText);

            JSeparator line = new JSeparator();
            line.setBounds(50, yCoordinate, 500, 30);
            yCoordinate+=20;

            requestPanel.add(line);

            accept.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        venueManagerService.acceptRequest(request.getRequestId(),feedbackText.getText());
                        JOptionPane.showMessageDialog(null, "Request Accepted");
                        PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().viewBookingRequestsScreen());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error in Accepting Request : " + ex.getMessage());
                    }
                }
            });

            reject.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        venueManagerService.rejectRequest(request.getRequestId(), feedbackText.getText());
                        JOptionPane.showMessageDialog(null, "Request Rejected");
                        PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().viewBookingRequestsScreen());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error in Rejecting Request : " + ex.getMessage());
                    }
                }
            });

            panel.add(requestPanel);
        }

        JScrollPane scroll = new JScrollPane(panel);
        mainPanel.add(scroll);
        mainPanel.setVisible(true);
        return mainPanel;
    }

    private JPanel viewBookingsScreen() {
        ArrayList<VenueManagerRequest> bookings = venueManagerService.getNonPendingRequests();
        if (bookings.size() == 0) {
            JOptionPane.showMessageDialog(null, "No Bookings");
            return dashboardScreen();
        }
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(1200, 800);

        String[] columnNames = {"Event Name", "Start Time", "End Time", "Status", "Contact Number", "Organizer"};
        String[][] data = new String[bookings.size()][6];

        for (int i = 0; i < bookings.size(); i++) {
            VenueManagerRequest booking = bookings.get(i);
            data[i][0] = booking.getEventName();
            data[i][1] = booking.getStartDateTime();
            data[i][2] = booking.getEndDateTime();
            data[i][3] = booking.getStatus().toString();
            data[i][4] = booking.getEventOrganizer().getContactNumber();
            data[i][5] = booking.getEventOrganizer().getName();
        }

        JButton dashboard = new JButton("Dashboard");
        dashboard.setBounds(50, 50, 200, 30);
        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonGUI.getInstance().setPanel(VenueManagerGUI.getInstance().dashboardScreen());
            }
        });
        mainPanel.add(dashboard);

        JTable table = new JTable(data, columnNames);

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 100, 1100, 600);

        mainPanel.add(scrollPane);
        mainPanel.setVisible(true);
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);

        return mainPanel;
    }
}

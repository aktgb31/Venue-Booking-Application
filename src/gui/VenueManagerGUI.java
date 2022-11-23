package gui;

import services.VenueManagerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class VenueManagerGUI {
    private VenueManagerService venueManagerService;
    public VenueManagerGUI(VenueManagerService service){
        this.venueManagerService = service;
    }

    public static JPanel signUp(){
        JPanel panel = new JPanel(null);
        panel.setSize(1200, 1200);

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
                String name = t1.getText();
                String email = t2.getText();
                String password = t3.getText();
                String contact = t4.getText();
                String hallName = t5.getText();
                String hallAddress = t6.getText();
                String hallCapacity = t7.getText();
                String hallDescription = t8.getText();
                if(name.equals("") || email.equals("") || password.equals("") || contact.equals("") || hallName.equals("") || hallAddress.equals("") || hallCapacity.equals("") || hallDescription.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                else{
                    if(hallCapacity.equals("Example: 1000")){
                        JOptionPane.showMessageDialog(null, "Please enter hall capacity");
                    }
                    else if(hallDescription.equals("Example: AC/Non AC, Projector,Cost, Wifi, etc.")){
                        JOptionPane.showMessageDialog(null, "Please enter hall description");
                    }
                    else{
                        try{
                            int capacity = Integer.parseInt(hallCapacity);
                            if(capacity <= 0){
                                JOptionPane.showMessageDialog(null, "Please enter valid hall capacity");
                            }
                            else{
                                try {
                                    VenueManagerService service = VenueManagerService.register(name, email, password, contact, hallName, hallAddress, capacity, hallDescription);
                                    if (service != null) {
                                        JOptionPane.showMessageDialog(null, "Venue Manager Registered Successfully");
//                                    GUI.getInstance().setPanel(GUI.login());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Venue Manager Registration Failed");
                                    }
                                } catch (Exception exception) {
                                    JOptionPane.showMessageDialog(null, "EmailId already exists");
                                }
                            }
                        }
                        catch (Exception exception){
                            JOptionPane.showMessageDialog(null, "Please enter valid hall capacity");
                        }
                    }
                }
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
    public JFrame dashboardScreen() {
        // Add code here
        return null;
    }

    private JFrame updateProfileScreen() {
        // Add code here
        return null;
    }

    private JFrame viewRequestsScreen() {
        // Add code here
        return null;
    }

    private JFrame viewScheduledEventsScreen() {
        // Add code here
        return null;
    }

    public JFrame viewDetailsPanel() {
        // Add code here
        return null;
    }
}

package gui;

import services.EventOrganiserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;



public class EventOrganizerGUI  {
    private EventOrganiserService eventOrganiserService;

    public EventOrganizerGUI(EventOrganiserService eventOrganiserService) {
        this.eventOrganiserService = eventOrganiserService;
    }


    public static JPanel signUp(){

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
                String name = t1.getText();
                String email = t2.getText();
                String password = t3.getText();
                String contactNumber = t4.getText();
                String organizationName = t5.getText();
                String organizationAddress = t6.getText();

                if(name.equals("") || email.equals("") || password.equals("") || contactNumber.equals("") || organizationName.equals("") || organizationAddress.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                else{
                    if(password.length() < 8){
                        JOptionPane.showMessageDialog(null, "Password should be atleast 8 characters");
                    }
                    else{
                        if(contactNumber.length() != 10){
                            JOptionPane.showMessageDialog(null, "Contact number should be 10 digits");
                        }
                        else{
                            if(!email.contains("@") || !email.contains(".")){
                                JOptionPane.showMessageDialog(null, "Please enter a valid email");
                            }
                            else{
                                EventOrganiserService service = EventOrganiserService.register(name, email, password, contactNumber, organizationName, organizationAddress);
                                if(service == null){
                                    JOptionPane.showMessageDialog(null, "Registration failed");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Registration Successful");

                                    
                                }
                            }
                        }
                    }
                }

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

    public void dashboardScreen() {
        // Add code here
    }

    private JFrame updateProfileScreen() {
        // Add code here
        return null;
    }

    private JFrame createRequestScreen() {
        // Add code here
        return null;
    }

    private JFrame viewRequestsScreen() {
        // Add code here
        return null;
    }

    public JFrame viewDetailsPanel() {
        // Add code here
        return null;
    }

    
}

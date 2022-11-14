import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class EventOrganizerDashboard {
    public static void main(String[] args) {
        new EventOrganizerDashboard();
    }
    public EventOrganizerDashboard(){
        JFrame frame = new JFrame("Dashboard");
        frame.setSize(1200, 800);
       
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
        
        frame.add(heading);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

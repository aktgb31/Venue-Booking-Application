import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


public class VenueManagerDashboard {
    public static void main(String[] args) {
        new VenueManagerDashboard();
    }
    public VenueManagerDashboard(){
        JFrame f = new JFrame("Dashboard");
        f.setSize(600, 600);
       
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
        
        f.add(heading);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}

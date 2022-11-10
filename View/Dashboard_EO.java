import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


//screen with four buttons
//1. Book Venue
//2. View Bookings
//3. Profile
//4. Logout

public class Dashboard_EO {
    public static void main(String[] args) {
        new Dashboard_EO();
    }
    public Dashboard_EO(){
        JFrame f = new JFrame("Dashboard");
        f.setSize(600, 600);
        //heading = Venue Manager Registration
        JLabel heading = new JLabel("Event Organizer Dashboard");
        heading.setBounds(100, 10, 400, 50);
        //change fontsize
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        //center heading
        heading.setHorizontalAlignment(JLabel.CENTER);
        //name,emailid,password,contactnumber,hallname,halladdress,hallcapacity,halldescription
        JButton b1 = new JButton("Book Venue");
        JButton b2 = new JButton("View Bookings");
        JButton b3 = new JButton("Profile");
        JButton b4 = new JButton("Logout");
        //center b1 b2 b3 b4 in  600 * 6)) page
        b1.setBounds(200, 100, 200, 30);
        b2.setBounds(200, 150, 200, 30);
        b3.setBounds(200, 200, 200, 30);
        b4.setBounds(200, 250, 200, 30);
        
     
        //add to frame
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

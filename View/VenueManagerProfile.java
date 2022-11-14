import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class VenueManagerProfile {
   
    public static void main(String[] args) {
        new VenueManagerProfile();
    }
    public VenueManagerProfile(){
        JFrame frame = new JFrame("Profile");
        frame.setSize(1200, 800);
        
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
        t1.setText("Sakthivel");

        JTextField t2 = new JTextField();
        t2.setText("sakhtivel456@gmail.com");

        t2.setEditable(false);
        JTextField t3 = new JTextField();

        t3.setText("sk1234");
        JTextField t4 = new JTextField();

        t4.setText("1234567890");
        JTextField t5 = new JTextField();

        t5.setText("Main Hall");
        JTextField t6 = new JTextField();

        t6.setText("Chennai");
        JTextField t7 = new JTextField();
        
        t7.setText("1000");
        JTextField t8 = new JTextField();
        t8.setText("AC Hall with Projector and Wifi");

        JButton b1 = new JButton("Update");
        JButton b2 = new JButton("Dashboard");

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

        frame.add(heading);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        frame.add(t6);
        frame.add(t7);
        frame.add(t8);
        frame.add(b1);
        frame.add(b2);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    }
    
}

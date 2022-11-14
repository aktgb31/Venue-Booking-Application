//Login screen using swing java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;


class Login{
    public static void main(String[] args) {
        new Login();
    }
    public Login(){
        JFrame frame = new JFrame("Login");
        frame.setSize(1200, 800);
       
        JLabel heading = new JLabel("Venue Booking Application");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel l1 = new JLabel("Email ID");
        JLabel l2 = new JLabel("Password");
        JLabel l3 = new JLabel("User Type");

        JTextField t1 = new JTextField();
        JPasswordField t2 = new JPasswordField();
        String[] usertype = {"Event Organizer","Venue Manager"};
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

        frame.add(heading);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(t1);
        frame.add(t2);
        frame.add(cb);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      
    }
}
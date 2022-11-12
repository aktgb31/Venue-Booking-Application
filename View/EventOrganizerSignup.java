import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;



public class EventOrganizerSignup {
    public static void main(String[] args) {
        new EventOrganizerSignup();
    }
    public EventOrganizerSignup(){
        JFrame frame = new JFrame("Register");
        frame.setSize(800, 800);
        
        JLabel heading = new JLabel("Event Organizer Registration");
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
        JTextField t2 = new JTextField();
        JPasswordField t3 = new JPasswordField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();
        
        JButton b1 = new JButton("Register");
        JButton b2 = new JButton("Login");

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
       
        frame.add(heading);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        frame.add(t6);
        frame.add(b1);
        frame.add(b2);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}

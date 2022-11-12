import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class CreateBooking {
    public static void main(String[] args) {
        new CreateBooking();
    }
    public CreateBooking(){
        JFrame frame = new JFrame("Create Booking");
        frame.setSize(800, 800);
        
        JLabel heading = new JLabel("Create Booking");
        heading.setBounds(100, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel l1 = new JLabel("Venue");
        JLabel l2 = new JLabel("Start Date Time");
        JLabel l3 = new JLabel("End Date Time");
        JLabel l4 = new JLabel("Event Name");
        JLabel l5 = new JLabel("Booking Description");

        String[] venue = {"Main Hall"," Aryabhatta","Ambedkar"};
        JComboBox cb = new JComboBox(venue);
       
        JTextField t1 = new JTextField();
        t1.setText("2022-06-21 12:30:00");
        JTextField t2 = new JTextField();
        t2.setText("2022-06-21 14:30:00");
        JTextField t3 = new JTextField();  
        t3.setText("TedX Talk");
        
        JTextArea t4 = new JTextArea();
        t4.setText("Would need projector and sound system");

        JButton b1 = new JButton("Create Booking");
        JButton b2 = new JButton("Cancel");
        
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
       
        frame.add(heading);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(cb);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(b1);
        frame.add(b2);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

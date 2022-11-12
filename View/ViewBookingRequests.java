import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.sql.*;
import java.util.*;




public class ViewBookingRequests {
    public static void main(String[] args) {
        new ViewBookingRequests();
    }

    public ViewBookingRequests(){
        
        JFrame frame = new JFrame("View Booking Requests");
        frame.setSize(800, 800);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE);

        TitledBorder border = new TitledBorder("Booking Requests ");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.BLACK);
        border.setTitleFont(new Font("Arial", Font.BOLD, 20));
      
        frame.getRootPane().setBorder(border);

        JLabel heading = new JLabel("TedX Talks");
        heading.setFont(new Font("Serif", Font.BOLD, 15));
        heading.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading);
      
        JLabel starttimeL = new JLabel("Start : "+"2022-06-21 12:30:00");
        JLabel endtimeL = new JLabel("End : "+ "2022-06-21 13:30:00");
        JLabel statusL = new JLabel("Status : "+ "Pending");
      
        panel.add(starttimeL);
        panel.add(endtimeL);
        panel.add(statusL);
       
        JLabel name = new JLabel("Organizer : "+"John Doe");
        JLabel organization = new JLabel("Organization : "+"TedX");
        JLabel phone = new JLabel("Contact Number : "+"1234567890");
        
        panel.add(name);
        panel.add(organization);
        panel.add(phone);
        
        JButton accept = new JButton("Accept");
        JButton reject = new JButton("Reject");

        panel.add(accept);
        panel.add(reject);

        JLabel description = new JLabel("Booking Description : "+"Would need a projector and a sound system");
        panel.add(description);

        JLabel feedback = new JLabel("Feedback");
        JTextField feedbackText = new JTextField();
        
        panel.add(feedback);
        panel.add(feedbackText);

        JSeparator line = new JSeparator();
        line.setBounds(50, 300, 500, 30);
        panel.add(line);

        JLabel heading2 = new JLabel("TEDx Talks");
        heading2.setFont(new Font("Serif", Font.BOLD, 15));
        heading2.setHorizontalAlignment(JLabel.CENTER);
        panel.add(heading2);
        
        JLabel starttimeL2 = new JLabel("Start : "+"2022-06-21 12:30:00");
        JLabel endtimeL2 = new JLabel("End : "+ "2022-06-21 13:30:00");
        JLabel statusL2 = new JLabel("Status : "+ "Pending");

        panel.add(starttimeL2);
        panel.add(endtimeL2);
        panel.add(statusL2);

        JLabel name2 = new JLabel("Organizer : "+"John Doe");
        JLabel organization2 = new JLabel("Organization : "+"TEDx");
        JLabel phone2 = new JLabel("Contact Number : "+"1234567890");
        
        panel.add(name2);
        panel.add(organization2);
        panel.add(phone2);

        JButton accept2 = new JButton("Accept");
        JButton reject2 = new JButton("Reject");

        panel.add(accept2);
        panel.add(reject2);

        JLabel description2 = new JLabel("Booking Description : "+"Would need a projector and a sound system");
        panel.add(description2);

        JLabel feedback2 = new JLabel("Feedback");
        JTextField feedbackText2 = new JTextField();
        
        panel.add(feedback2);
        panel.add(feedbackText2);

        JScrollPane scroll = new JScrollPane(panel);
        frame.add(scroll);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
   
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.sql.*;
import java.util.*;




public class ViewRequests {
    public static void main(String[] args) {
        new ViewRequests();
    }

    public ViewRequests(){
        
        JFrame frame = new JFrame("View Requests");
        frame.setSize(600, 700);
        
        TitledBorder border = new TitledBorder("Booking Requests ");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.BLACK);
        border.setTitleFont(new Font("Arial", Font.BOLD, 20));
      
        frame.getRootPane().setBorder(border);

        JLabel heading = new JLabel("TedX Talks");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 15));
        heading.setHorizontalAlignment(JLabel.CENTER);
        frame.add(heading);
      
        JLabel starttimeL = new JLabel("Start:");
        JLabel startTime = new JLabel("2022-06-21 12:30:00");
        JLabel endtimeL = new JLabel("End:");
        JLabel endTime = new JLabel("2022-06-21 13:30:00");
        JLabel statusL = new JLabel("Pending");
        
        starttimeL.setBounds(30, 50, 50, 50);
        startTime.setBounds(80, 50, 150, 50);
        endtimeL.setBounds(230, 50, 50, 50);
        endTime.setBounds(280, 50, 150, 50);
        statusL.setBounds(430, 50, 80, 50);
      
        frame.add(starttimeL);
        frame.add(startTime);
        frame.add(endtimeL);
        frame.add(endTime);
        frame.add(statusL);
       
        JLabel name = new JLabel("John Doe");
        JLabel organization = new JLabel("TedX");
        JLabel phone = new JLabel("1234567890");
    
        name.setBounds(30, 100, 150, 50);
        organization.setBounds(230, 100, 150, 50);
        phone.setBounds(430, 100, 150, 50);
        
        frame.add(name);
        frame.add(organization);
        frame.add(phone);
        
        JButton accept = new JButton("Accept");
        JButton reject = new JButton("Reject");
      
        accept.setBounds(200, 150, 100, 30);
        reject.setBounds(300, 150, 100, 30);

        frame.add(accept);
        frame.add(reject);


        JLabel description = new JLabel("Would need a projector and a sound system");
        description.setBounds(150, 200, 300, 30);
        frame.add(description);

        JLabel feedback = new JLabel("Feedback");
        JTextField feedbackText = new JTextField();
        feedback.setBounds(30, 250, 100, 30);
        feedbackText.setBounds(150, 250, 300, 30);
        frame.add(feedback);
        frame.add(feedbackText);
        
        JSeparator line = new JSeparator();
        line.setBounds(50, 300, 500, 30);
        frame.add(line);

        JLabel heading2 = new JLabel("Book Fest");
        heading2.setBounds(50, 310, 400, 50);
        heading2.setFont(new Font("Serif", Font.BOLD, 15));
        heading2.setHorizontalAlignment(JLabel.CENTER);
        frame.add(heading2);
       
        JLabel starttimeL2 = new JLabel("Start:");
        JLabel startTime2 = new JLabel("2022-06-21 12:30:00");
        JLabel endtimeL2 = new JLabel("End:");
        JLabel endTime2 = new JLabel("2022-06-21 13:30:00");
        JLabel statusL2 = new JLabel("Pending");

        starttimeL2.setBounds(30, 350, 50, 50);
        startTime2.setBounds(80, 350, 150, 50);
        endtimeL2.setBounds(230, 350, 50, 50);
        endTime2.setBounds(280, 350, 150, 50);
        statusL2.setBounds(430, 350, 80, 50);
        
        frame.add(starttimeL2);
        frame.add(startTime2);
        frame.add(endtimeL2);
        frame.add(endTime2);
        frame.add(statusL2);
        
        JLabel name2 = new JLabel("Peter Griffin");
        JLabel organization2 = new JLabel("Book Club");
        JLabel phone2 = new JLabel("1234567890");
        
        name2.setBounds(30, 400, 150, 50);
        organization2.setBounds(230, 400, 150, 50);
        phone2.setBounds(430, 400, 150, 50);
     
        frame.add(name2);
        frame.add(organization2);
        frame.add(phone2);

        JButton accept2 = new JButton("Accept");
        JButton reject2 = new JButton("Reject");
       
        accept2.setBounds(200, 450, 100, 30);
        reject2.setBounds(300, 450, 100, 30);
      
        frame.add(accept2);
        frame.add(reject2);

        JLabel description2 = new JLabel("Furniture will be needed");
        description2.setBounds(150, 500, 300, 30);
        frame.add(description2);

        JLabel feedback2 = new JLabel("Feedback");
        JTextField feedbackText2 = new JTextField();
        feedback2.setBounds(30, 550, 100, 30);
        feedbackText2.setBounds(150, 550, 300, 30);
        frame.add(feedback2);
        frame.add(feedbackText2);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    
    
}

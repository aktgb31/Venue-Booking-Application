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
        JFrame f = new JFrame("View Requests");
        f.setSize(600, 600);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        //event name , start time, end time and status
        String[] columnNames = {"Event Name", "Start Time", "End Time", "Status"};
        //get data from database
        String[][] data = {{"Diwali", "10:00", "12:00", "Accepted"}, {"Onam", "11:00", "13:00", "Pending"}, {"Birthday", "12:00", "14:00", "Rejected"},
        {"BTP Project", "13:00", "15:00", "Accepted"}, {"Christmas", "14:00", "16:00", "Accepted"},
        {"New Year", "15:00", "17:00", "Pending"},
        {"Linux Workshop", "18:00", "20:00", "Accepted"}, {"Windows Workshop", "19:00", "21:00", "Pending"}, {"Mac Workshop", "20:00", "22:00", "Rejected"}};
        
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 500, 100);
        f.add(scrollPane);

        //create buttons
        JButton b1 = new JButton("Accept");
        JButton b2 = new JButton("Reject");
        b1.setBounds(100, 300, 100, 30);
        b2.setBounds(300, 300, 100, 30);
        f.add(b1);
        f.add(b2);

        //create Description text area
        JTextArea description = new JTextArea();
        description.setBounds(50, 175, 500, 100);
        description.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Description", TitledBorder.LEFT, TitledBorder.TOP));
        f.add(description);

        //create text area
        JTextArea feedback = new JTextArea();
        feedback.setBounds(50, 350, 500, 100);
        feedback.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Feedback", TitledBorder.LEFT, TitledBorder.TOP));
        f.add(feedback);
    }   
}

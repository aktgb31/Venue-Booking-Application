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
         //JFrame
        JFrame f = new JFrame("Create Booking");
         //Heading View Booking Requests
        JLabel heading = new JLabel("View Booking Requests");
        heading.setBounds(50, 10, 400, 50);
         //change fontsize
        heading.setFont(new Font("Serif", Font.BOLD, 20));
         //center heading
        heading.setHorizontalAlignment(JLabel.CENTER);

        final DefaultListModel model = new DefaultListModel();
        //button accept and reject
        JButton b1 = new JButton("Accept");
        JButton b2 = new JButton("Reject");
        //set bounds
        //add buttons to model
        model.addElement(b2);
        model.addElement(b1);
        
        final JList list = new JList(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setBounds(50, 100, 400, 200);
        f.add(listScroller);

        f.add(heading);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         
            
            
            
    }

    
    
}

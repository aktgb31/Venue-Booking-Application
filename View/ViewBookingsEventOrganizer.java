import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.sql.*;
import java.util.*;

public class ViewBookingsEventOrganizer{
    
    public static void main(String[] args) {
        new ViewBookingsEventOrganizer();
    }
    
    public ViewBookingsEventOrganizer(){
        JFrame f = new JFrame("View Bookings");
        f.setSize(800, 800);
        
        String[] columnNames = {"Event Name", "Start Time", "End Time", "Status", "Contact Number","Venue","feedback"};
        String[][] data = {
            {"Robo Wars", "2022-06-21 12:30:00", "2022-06-21 13:30:00", "Rejected", "9238567890","Main Hall","Occupied during afternoon"},
            {"Robo Wars", "2022-06-21 12:30:00", "2022-06-21 13:30:00", "Accepted", "9234567890","Aryabhatta","Success"},
        };
   
        JTable table = new JTable(data, columnNames);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(160);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        f.add(scrollPane);

        f.setVisible(true);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

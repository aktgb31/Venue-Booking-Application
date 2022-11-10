import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.sql.*;
import java.util.*;

public class ViewBookingsVenueManager {

    public static void main(String[] args) {
        new ViewBookingsVenueManager();
    }
    
    public ViewBookingsVenueManager(){
        JFrame f = new JFrame("View Bookings");
        f.setSize(800, 600);

        String[] columnNames = {"Event Name", "Start Time", "End Time", "Status", "Contact Number","Organizer"};
        String[][] data = {
            {"Robo Wars", "2022-06-21 12:30:00", "2022-06-21 13:30:00", "Rejected", "1238567890","John"},
            {"TEDx Talks", "2022-06-21 12:30:00", "2022-06-21 13:30:00", "Accepted", "1234567890","Lenoah"},
            {"Book Fest", "2022-06-20 12:30:00", "2022-06-21 13:30:00", "Accepted", "1233567890","Naveen"},
            {"Guest Lecture", "2022-06-19 12:30:00", "2022-06-21 13:30:00", "Cancelled", "1239567890","Vinod"},
        };
    
        JTable table = new JTable(data, columnNames);
    
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        f.add(scrollPane);

        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

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
        f.setSize(1200, 800);
        
        String[] columnNames = {"Event Name", "Start Time", "End Time", "Status", "Contact Number","Venue","Hall Capacity","feedback","Hall Description"};
        String[][] data = {
            {"Robo Wars", "2022-06-21 12:30:00", "2022-06-21 13:30:00", "Rejected", "9238567890","Main Hall","1000","Occupied during afternoon","Air conditioned and stage"},
            {"Robo Wars", "2022-06-21 12:30:00", "2022-06-21 13:30:00", "Accepted", "9234567890","Aryabhatta","2000","Success","Air conditioned,chairs,tables available"},
        };
   
        JTable table = new JTable(data, columnNames);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        table.getColumnModel().getColumn(1).setPreferredWidth(140);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(250);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        f.add(scrollPane);

        f.setVisible(true);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;



public class Profile_EO {
   
    public static void main(String[] args) {
        new Profile_EO();
    }
    public Profile_EO(){
        JFrame f = new JFrame("Profile");
        f.setSize(600, 600);
      
        JLabel heading = new JLabel("Event Organizer Profile");
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
        t1.setText("Kunal Kushwaha");
        
        JTextField t2 = new JTextField();
        t2.setText("kunal656@gmail.com");
        t2.setEditable(false);

        JTextField t3 = new JTextField();
        t3.setText("kunal656");

        JTextField t4 = new JTextField();
        t4.setText("1234567890");

        JTextField t5 = new JTextField();
        t5.setText("Coding Blocks");

        JTextField t6 = new JTextField();
        t6.setText("Noida");
        
        JButton b1 = new JButton("Update");
        JButton b2 = new JButton("Dashboard");
        //set bounds
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
        //add to frame
        f.add(heading);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(b1);
        f.add(b2);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;



public class VenueManagerSignup {
    public static void main(String[] args) {
        new VenueManagerSignup();
    }
    public VenueManagerSignup(){
        JFrame frame = new JFrame("Register");
        frame.setSize(800, 800);
        
        JLabel heading = new JLabel("Venue Manager Registration");
        heading.setBounds(50, 10, 400, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setHorizontalAlignment(JLabel.CENTER);
    
        JLabel l1 = new JLabel("Name");
        JLabel l2 = new JLabel("Email ID");
        JLabel l3 = new JLabel("Password");
        JLabel l4 = new JLabel("Contact Number");
        JLabel l5 = new JLabel("Hall Name");
        JLabel l6 = new JLabel("Hall Address");
        JLabel l7 = new JLabel("Hall Capacity");
        JLabel l8 = new JLabel("Hall Description");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JPasswordField t3 = new JPasswordField();
        JTextField t4 = new JTextField();
        JTextField t5 = new JTextField();
        JTextField t6 = new JTextField();
        JTextField t7 = new JTextField();
        t7.setText("Example: 1000");
        JTextField t8 = new JTextField();
        t8.setText("Example: AC/Non AC, Projector,Cost, Wifi, etc.");
        t7.setForeground(Color.GRAY);
        t8.setForeground(Color.GRAY);

        JButton b1 = new JButton("Register");
        JButton b2 = new JButton("Login");

        l1.setBounds(50, 100, 200, 30);
        l2.setBounds(50, 150, 200, 30);
        l3.setBounds(50, 200, 200, 30);
        l4.setBounds(50, 250, 200, 30);
        l5.setBounds(50, 300, 200, 30);
        l6.setBounds(50, 350, 200, 30);
        l7.setBounds(50, 400, 200, 30);
        l8.setBounds(50, 450, 200, 30);
        t1.setBounds(250, 100, 300, 30);
        t2.setBounds(250, 150, 300, 30);
        t3.setBounds(250, 200, 300, 30);
        t4.setBounds(250, 250, 300, 30);
        t5.setBounds(250, 300, 300, 30);
        t6.setBounds(250, 350, 300, 30);
        t7.setBounds(250, 400, 300, 30);
        t8.setBounds(250, 450, 300, 30);
        b1.setBounds(75, 500, 100, 30);
        b2.setBounds(200, 500, 100, 30);

        t7.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                t7.setText("");
                t7.setForeground(Color.BLACK);

            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t7.getText().isEmpty()) {
                    t7.setText("Example: 1000");
                    t7.setForeground(Color.GRAY);
                }
            }
        });
        t8.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                t8.setText("");
                t8.setForeground(Color.BLACK);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t8.getText().isEmpty()) {
                    t8.setForeground(Color.GRAY);
                    t8.setText("Example: AC/Non AC, Projector,Cost, Wifi, etc.");
                }
            }
        });
        
        frame.add(heading);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        frame.add(t6);
        frame.add(t7);
        frame.add(t8);
        frame.add(b1);
        frame.add(b2);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }  
}

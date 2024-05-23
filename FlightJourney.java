package AirlinesManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class FlightJourney extends JFrame implements ActionListener {
    private JFrame f;
    private JLabel l1, l2, l3;
    private JButton b, b2;
    private Choice ch1, ch2;

    public FlightJourney() {
        // Set up the JFrame
        f = new JFrame("Select Source & Destination");
        f.setBackground(Color.green);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Background Label
        l1 = new JLabel();
        l1.setBounds(0, 0, 500, 270);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/3.jpg"));
        Image img1 = img.getImage().getScaledInstance(700, 370, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img1);
        l1.setIcon(ic1);
        f.add(l1);

        // Source Label
        l2 = new JLabel("Source");
        l2.setVisible(true);
        l2.setBounds(40, 60, 150, 30);
        l2.setForeground(Color.white);
        Font F1 = new Font("Arial", Font.BOLD, 21);
        l2.setFont(F1);
        l1.add(l2);

        // Destination Label
        l3 = new JLabel("Destination");
        l3.setVisible(true);
        l3.setBounds(40, 120, 150, 30);
        l3.setForeground(Color.white);
        l3.setFont(F1);
        l1.add(l3);

        // Source Choice
        ch1 = new Choice();
        ch1.setBounds(240, 60, 190, 25);
        populateChoices(ch1, "select distinct source from bookedflight");
        ch1.setFont(F1);
        l1.add(ch1);

        // Destination Choice
        ch2 = new Choice();
        ch2.setBounds(240, 120, 190, 25);
        populateChoices(ch2, "select distinct destination from bookedflight");
        ch2.setFont(F1);
        l1.add(ch2);

        // Search Button
        b = new JButton("Search");
        b.setBounds(140, 185, 100, 30);
        b.addActionListener(this);
        l1.add(b);

        // Close Button
        b2 = new JButton("Close");
        b2.setBounds(260, 185, 100, 30);
        b2.addActionListener(this);
        b2.setBackground(Color.red);
        b2.setForeground(Color.WHITE);
        l1.add(b2);

        // Frame settings
        f.setSize(500, 270);
        f.setLocation(450, 250);
        f.setVisible(true);
    }

    private void populateChoices(Choice choice, String query) {
        try {
            ConnectionClass obj = new ConnectionClass();
            ResultSet rest = obj.stm.executeQuery(query);
            while (rest.next()) {
                choice.add(rest.getString(1));
            }
            rest.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            f.setVisible(false);
            new HomePage();
        }
        if (ae.getSource() == b) {
            f.setVisible(false);
            new FlightJourneyDetails(ch1.getSelectedItem(), ch2.getSelectedItem()).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new FlightJourney();
    }
}

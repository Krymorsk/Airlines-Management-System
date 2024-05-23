package AirlinesManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CargoManagement implements ActionListener {
    JFrame frame;
    JLabel l1, l2, l3, l4, l5, imageLabel;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3;

    CargoManagement() {
        frame = new JFrame("Cargo Management");
        frame.setLayout(null);
        frame.setSize(700, 500); // Increased width to accommodate the image
        frame.setLocation(400, 200);

        l1 = new JLabel("Cargo ID");
        l1.setBounds(50, 50, 100, 30);
        frame.add(l1);

        t1 = new JTextField();
        t1.setBounds(150, 50, 150, 30);
        frame.add(t1);

        l2 = new JLabel("Description");
        l2.setBounds(50, 100, 100, 30);
        frame.add(l2);

        t2 = new JTextField();
        t2.setBounds(150, 100, 150, 30);
        frame.add(t2);

        l3 = new JLabel("Weight (in KG)");
        l3.setBounds(50, 150, 100, 30);
        frame.add(l3);

        t3 = new JTextField();
        t3.setBounds(150, 150, 150, 30);
        frame.add(t3);

        l4 = new JLabel("Sender");
        l4.setBounds(50, 200, 100, 30);
        frame.add(l4);

        t4 = new JTextField();
        t4.setBounds(150, 200, 150, 30);
        frame.add(t4);

        l5 = new JLabel("Receiver");
        l5.setBounds(50, 250, 100, 30);
        frame.add(l5);

        t5 = new JTextField();
        t5.setBounds(150, 250, 150, 30);
        frame.add(t5);

        b1 = new JButton("Add Cargo");
        b1.setBounds(50, 300, 100, 30);
        b1.addActionListener(this);
        frame.add(b1);

        b2 = new JButton("View Cargo");
        b2.setBounds(170, 300, 100, 30);
        b2.addActionListener(this);
        frame.add(b2);

        b3 = new JButton("Delete Cargo");
        b3.setBounds(290, 300, 120, 30);
        b3.addActionListener(this);
        frame.add(b3);

        // Adding an image on the right side
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/S4.jpg"));
        Image i1=img.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
            imageLabel = new JLabel(img1);
            imageLabel.setBounds(0, 00, 700, 500); // Adjust the size and position as needed
            frame.add(imageLabel);
        

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String description = t2.getText();
            String weightStr = t3.getText();
            String sender = t4.getText();
            String receiver = t5.getText();

            try {
                // Validate that the weight field contains a valid double
                double weight = Double.parseDouble(weightStr);

                ConnectionClass obj = new ConnectionClass();
                String q = "INSERT INTO cargo (description, weight, sender, receiver) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = obj.con.prepareStatement(q);
                pst.setString(1, description);
                pst.setDouble(2, weight);
                pst.setString(3, sender);
                pst.setString(4, receiver);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Cargo Added Successfully");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for weight.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            new ViewCargo();
        } else if (ae.getSource() == b3) {
            String cargoId = t1.getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "DELETE FROM cargo WHERE cargoId = ?";
                PreparedStatement pst = obj.con.prepareStatement(q);
                pst.setInt(1, Integer.parseInt(cargoId));
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Cargo Deleted Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CargoManagement();
    }
}

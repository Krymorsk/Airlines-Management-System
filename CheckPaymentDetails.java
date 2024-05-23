package AirlinesManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class CheckPaymentDetails extends JFrame {
    private JTextField textField;
    private JTable table;
    private JLabel titleLabel;

    public static void main(String[] args) {
        new CheckPaymentDetails();
    }

    public CheckPaymentDetails() {
        initialize();
    }

    private void initialize() {
        setTitle("Payment Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(960, 590);
        setLayout(null);

        titleLabel = new JLabel("Check Payment Details");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 33));
        titleLabel.setBounds(300, 30, 400, 40);
        add(titleLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        usernameLabel.setBounds(190, 160, 100, 26);
        add(usernameLabel);

        textField = new JTextField();
        textField.setBounds(300, 160, 150, 26);
        textField.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField);

        JButton showButton = new JButton("Show");
        showButton.setFont(new Font("Arial", Font.BOLD, 14));
        showButton.setBackground(Color.BLACK);
        showButton.setForeground(Color.WHITE);
        showButton.setBounds(500, 160, 100, 26);
        add(showButton);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(90, 250, 780, 150);
        add(scrollPane);

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String username = textField.getText();
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a username", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    ConnectionClass obj = new ConnectionClass();
                    String query = "SELECT tid, price, journey_date, journey_time, username, status FROM bookedFlight WHERE username = ? AND status = 'Success'";
                    PreparedStatement pst = obj.conn.prepareStatement(query);
                    pst.setString(1, username);
                    ResultSet rs = pst.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    if (!rs.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null, "No records found", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel backgroundLabel = new JLabel();
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/home2.jpg"));
        Image img = ic.getImage().getScaledInstance(960, 590, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img);
        backgroundLabel.setIcon(ic1);
        backgroundLabel.setBounds(0, 0, 960, 590);
        add(backgroundLabel);

        setVisible(true);
    }
}


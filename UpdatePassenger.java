package AirlinesManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class UpdatePassenger extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    GradientButton bt1, bt2;
    JPanel p1, p2, p3;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf9;
    JComboBox<String> nationalityComboBox, genderComboBox;
    Font f, f1;
    Choice ch;

    UpdatePassenger() {
        super("Update Passenger");
        setLocation(450, 10);
        setSize(740, 600);
  
        // Load custom Pacifico font
        try {
            URL fontUrl = ClassLoader.getSystemResource("AirlinesManagementSystem/fonts/Pacifico-Regular.ttf");
            if (fontUrl != null) {
                Font pacifico = Font.createFont(Font.TRUETYPE_FONT, new File(fontUrl.toURI()));
                f = pacifico.deriveFont(Font.PLAIN, 24);
            } else {
                throw new IOException("Font file not found.");
            }
            f1 = new Font("Arial", Font.PLAIN, 18);
        } catch (FontFormatException | IOException | URISyntaxException e) {
            e.printStackTrace();
            f = new Font("Arial", Font.PLAIN, 24); // Fallback font
            f1 = new Font("Arial", Font.PLAIN, 18);
        }

        ch = new Choice();
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select username from passenger";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch.add(rest.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        l1 = new JLabel("Update Passenger Details");
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Age");
        l5 = new JLabel("Date of birth");
        l6 = new JLabel("Address");
        l7 = new JLabel("Phone");
        l8 = new JLabel("Email");
        l9 = new JLabel("Nationality");
        l10 = new JLabel("Gender");
        l11 = new JLabel("Passport");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf9 = new JTextField();

        // Nationality JComboBox
        String[] nationalities = {"American", "British", "Canadian", "Chinese", "French", "German", "Indian", "Japanese", "Russian", "Other"};
        nationalityComboBox = new JComboBox<>(nationalities);
        nationalityComboBox.setFont(f1);

        // Gender JComboBox
        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setFont(f1);

        bt1 = createGradientButton("Update Passenger");
        bt2 = createGradientButton("Back", Color.RED, Color.DARK_GRAY);

        l1.setHorizontalAlignment(JLabel.CENTER);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        ch.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf9.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.setOpaque(false); // Make panel background transparent
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(11, 2, 10, 10));
        p2.setOpaque(false); // Make panel background transparent

        p2.add(l2);
        p2.add(ch);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9);
        p2.add(nationalityComboBox);
        p2.add(l10);
        p2.add(genderComboBox);
        p2.add(l11);
        p2.add(tf9);
        p2.add(bt1);
        p2.add(bt2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));
        p3.setOpaque(false); // Make panel background transparent

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/update.png"));
        Image img1 = img.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l12 = new JLabel(ic1);

        p3.add(l12);

        // Set a custom gradient panel as the content pane
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(new BorderLayout(10, 10));
        gradientPanel.add(p1, BorderLayout.NORTH);
        gradientPanel.add(p2, BorderLayout.CENTER);
        gradientPanel.add(p3, BorderLayout.WEST);
        setContentPane(gradientPanel);

        // Set padding for the main frame
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj2 = new ConnectionClass();
                    String username = ch.getSelectedItem();
                    String q1 = "select * from passenger where username='" + username + "'";
                    ResultSet rest1 = obj2.stm.executeQuery(q1);
                    if (rest1.next()) {
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("age"));
                        tf3.setText(rest1.getString("dob"));
                        tf4.setText(rest1.getString("address"));
                        tf5.setText(rest1.getString("phone"));
                        tf6.setText(rest1.getString("email"));
                        nationalityComboBox.setSelectedItem(rest1.getString("nationality"));
                        genderComboBox.setSelectedItem(rest1.getString("gender"));
                        tf9.setText(rest1.getString("passport"));
                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        });
    }

    // Method to create a GradientButton
    private GradientButton createGradientButton(String text) {
        return createGradientButton(text, new Color(118, 75, 162), new Color(102, 126, 234));
    }

    // Method to create a GradientButton with custom colors
    private GradientButton createGradientButton(String text, Color startColor, Color endColor) {
        GradientButton button = new GradientButton(text);
        button.setGradient(startColor, endColor);
        button.setHoverGradient(endColor, startColor);
        button.setForeground(Color.WHITE); // Set text color to white
        button.setFont(f1);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            String username = ch.getSelectedItem();
            String name = tf1.getText();
            String age = tf2.getText();
            String dob = tf3.getText();
            String address = tf4.getText();
            String phone = tf5.getText();
            String email = tf6.getText();
            String nationality = (String) nationalityComboBox.getSelectedItem();
            String gender = (String) genderComboBox.getSelectedItem();
            String passport = tf9.getText();

            try {
                ConnectionClass obj3 = new ConnectionClass();
                String q1 = "update passenger set name='" + name + "', age='" + age + "', dob='" + dob + "', address='" + address + "', phone='" + phone + "', email='" + email + "', nationality='" + nationality + "', gender='" + gender + "', passport='" + passport + "' where username='" + username + "'";
                int aa = obj3.stm.executeUpdate(q1);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Your data Successfully updated");
                    this.setVisible(false);
                    new ViewPassenger().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please, fill all details carefully");
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == bt2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdatePassenger().setVisible(true);
    }
}

// Custom gradient panel
class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = new Color(118, 75, 162);
        Color color2 = new Color(102, 126, 234);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}

// Custom button with gradient background
class GradientButton extends JButton {
    private Color startColor;
    private Color endColor;
    private Color hoverStartColor;
    private Color hoverEndColor;

    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    public void setGradient(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    public void setHoverGradient(Color hoverStartColor, Color hoverEndColor) {
        this.hoverStartColor = hoverStartColor;
        this.hoverEndColor = hoverEndColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isRollover()) {
            setGradientColors(g, hoverStartColor, hoverEndColor);
        } else {
            setGradientColors(g, startColor, endColor);
        }
        super.paintComponent(g);
    }

    private void setGradientColors(Graphics g, Color startColor, Color endColor) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, startColor, 0, height, endColor);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}

class ConnectionClass {
    Connection con;
    Statement stm;

    ConnectionClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "root", "password");
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

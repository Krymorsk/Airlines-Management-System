package AirlinesManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.*;

public class AddFlights extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    GradientButton bt1, bt2;
    JPanel p1, p2, p3;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
    Font f, f1;

    AddFlights() {
        super("Add Airlines Flight");
        setLocation(450, 50);
        setSize(500, 450);

        // Load custom Pacifico font
    try {
        URL fontUrl = ClassLoader.getSystemResource("AirlinesManagementSystem/fonts/Pacifico-Regular.ttf");
        if (fontUrl != null) {
            Font pacifico = Font.createFont(Font.TRUETYPE_FONT, new File(fontUrl.toURI()));
            f = pacifico.deriveFont(Font.PLAIN, 24);
            f1 = new Font("Arial", Font.PLAIN, 14);
 
        } else {
            throw new IOException("Font file not found.");
        }
    } catch (FontFormatException | IOException | URISyntaxException e) {
        e.printStackTrace();
        // Fall back to Arial if Pacifico font is not available
        f = new Font("Arial", Font.BOLD, 24);
        f1 = new Font("Arial", Font.PLAIN, 14);
    }
        l1 = new JLabel("Add Airlines Flight");
        l2 = new JLabel("Flight Code");
        l3 = new JLabel("Flight Name");
        l4 = new JLabel("Source");
        l5 = new JLabel("Destination");
        l6 = new JLabel("Capacity");
        l7 = new JLabel("Class Name");
        l8 = new JLabel("Price");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();

        bt1 = createGradientButton("Add Flight");
        bt2 = createGradientButton("Back");

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

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(l1, BorderLayout.CENTER);
        p1.setOpaque(false);

        p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        p2.setOpaque(false); // Make panel background transparent
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Adjust the weightx to make text fields wider
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p2.add(l2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        p2.add(tf1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        p2.add(l3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        p2.add(tf2, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        p2.add(l4, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        p2.add(tf3, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        p2.add(l5, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        p2.add(tf4, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        p2.add(l6, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        p2.add(tf5, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        p2.add(l7, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        p2.add(tf6, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        p2.add(l8, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        p2.add(tf7, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        p2.add(bt1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        p2.add(bt2, gbc);

        // Set a custom gradient panel as the content pane
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(new BorderLayout(10, 10));
        gradientPanel.add(p1, BorderLayout.NORTH);
        gradientPanel.add(p2, BorderLayout.CENTER);
        setContentPane(gradientPanel);

        // Set padding for the main frame
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // Method to create a GradientButton
    private GradientButton createGradientButton(String text) {
        GradientButton button = new GradientButton(text);
        button.setGradient(new Color(120, 0, 255), new Color(0, 120, 255)); // Set gradient colors
        button.setHoverGradient(new Color(0, 120, 255), new Color(120, 0, 255)); // Set hover gradient colors
        button.setForeground(Color.WHITE); // Set text color to white
        button.setFont(f1);
        return button;
    }

    // Event handling for button clicks
    public void actionPerformed(ActionEvent e) {
        String fcode = tf1.getText();
        String fname = tf2.getText();
        String source = tf3.getText();
        String destination = tf4.getText();
        String capacity = tf5.getText();
        String classname = tf6.getText();
        String price = tf7.getText();

        if (e.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into flight(f_code,f_name,source,destination,capacity,class_name,price) values('" + fcode + "','" + fname + "','" + source + "','" + destination + "','" + capacity + "','" + classname + "','" + price + "')";
                int aa = obj.stm.executeUpdate(q);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Your data has been successfully inserted");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all details carefully");
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if (e.getSource() == bt2) {
            this.setVisible(false);
            new AdminHomePage().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AddFlights().setVisible(true);
    }
}

// Custom JPanel for gradient background
class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = new Color(100, 128, 255);
        Color color2 = new Color(255, 128, 192);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}

// GradientButton class with hover effect
class GradientButton extends JButton {
    private Color startColor;
    private Color endColor;
    private Color hoverStartColor;
    private Color hoverEndColor;
    private boolean isHovering;

    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovering = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovering = false;
                repaint();
            }
        });
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
        Graphics2D g2 = (Graphics2D) g.create();
        if (isHovering) {
            g2.setPaint(new GradientPaint(0, 0, hoverStartColor, getWidth(), 0, hoverEndColor));
        } else {
            g2.setPaint(new GradientPaint(0, 0, startColor, getWidth(), 0, endColor));
        }
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
        super.paintComponent(g);
    }
}

package AirlinesManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.*;

public class Index extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    GradientButton bt1, bt2;
    JPanel p1, p2, p3, p4;
    Font f, f1, f2;

    // Constructor
    Index() {
        super("Home Page");
        setLocation(450, 250);
        setSize(500, 300);

         // Load custom Pacifico font using ClassLoader
    try {
        URL fontUrl = ClassLoader.getSystemResource("AirlinesManagementSystem/fonts/Pacifico-Regular.ttf");
        if (fontUrl != null) {
            Font pacifico = Font.createFont(Font.TRUETYPE_FONT, new File(fontUrl.toURI()));
            f = pacifico.deriveFont(Font.PLAIN, 24);
            f1 = new Font("Arial", Font.PLAIN, 14);
            f2 = new Font("Arial", Font.PLAIN, 18);
        } else {
            throw new IOException("Font file not found.");
        }
    } catch (FontFormatException | IOException | URISyntaxException e) {
        e.printStackTrace();
        // Fall back to Arial if Pacifico font is not available
        f = new Font("Arial", Font.BOLD, 24);
        f1 = new Font("Arial", Font.PLAIN, 18);
    }

        // Initialize labels
        l1 = new JLabel("Admin Login");
        l2 = new JLabel("Employee Login");

        // Initialize gradient buttons
        bt1 = createGradientButton("Login");
        bt2 = createGradientButton("Login");

        // Add action listeners to buttons
        bt1.addActionListener(this);
        bt2.addActionListener(this);

        // Load and scale the image
        ImageIcon c = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/icons/login.png"));
        Image i = c.getImage().getScaledInstance(130, 120, Image.SCALE_SMOOTH);
        ImageIcon c1 = new ImageIcon(i);
        l3 = new JLabel(c1);

        // Main title label
        l4 = new JLabel("Airlines Management");
        l4.setHorizontalAlignment(JLabel.CENTER);
        l4.setFont(f);
        l4.setForeground(Color.BLACK);

        // Set fonts for labels
        l1.setFont(f2);
        l2.setFont(f2);
        l1.setForeground(Color.black);
        l2.setForeground(Color.black);

        // Create panels and set layouts
        p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.setOpaque(false); // Make panel background transparent
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        p1.add(l1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        p1.add(bt1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        p1.add(l2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        p1.add(bt2, gbc);

        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.setOpaque(false); // Make panel background transparent
        p2.add(l3, BorderLayout.CENTER);
        p2.add(l4, BorderLayout.SOUTH);

        p3 = new JPanel();
        p3.setLayout(new BorderLayout(10, 10));
        p3.setOpaque(false); // Make panel background transparent
        p3.add(p2, BorderLayout.CENTER);
        p3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p4 = new JPanel();
        p4.setLayout(new BorderLayout(10, 10));
        p4.setOpaque(false); // Make panel background transparent
        p4.add(p1, BorderLayout.NORTH);
        p4.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Set a custom gradient panel as the content pane
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(new BorderLayout(10, 10));
        gradientPanel.add(p3, BorderLayout.WEST);
        gradientPanel.add(p4, BorderLayout.CENTER);
        setContentPane(gradientPanel);

        // Set padding for the main frame
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // Method to create a GradientButton
    private GradientButton createGradientButton(String text) {
        GradientButton button = new GradientButton(text);
        button.setGradient(new Color(118,75,162), new Color(102,126,234)); // Set gradient colors
        button.setHoverGradient(new Color(102,126,234), new Color(118,75,162)); // Set hover gradient colors
        button.setForeground(Color.WHITE); // Set text color to white
        button.setFont(f1);
        return button;
    }

    // Event handling for button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            new AdminLoginPage().setVisible(true);
            this.setVisible(false);
        } else if (e.getSource() == bt2) {
            new Login().setVisible(true);
            this.setVisible(false);
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
            Color color1 = new Color(169,241,223);
            Color color2 = new Color(255,130,160);
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

    // Main method to launch the application
    public static void main(String[] args) {
        new Index().setVisible(true);
    }
}

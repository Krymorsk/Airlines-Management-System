package AirlinesManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class AdminHomePage extends JFrame implements ActionListener {
    JLabel l1, l2;
    GradientButton bt1, bt2, bt3, bt4;
    JPanel p1, p2;
    Font f, f1;

    AdminHomePage() {
        super("Admin Section");
        setLocation(450, 250);
        setSize(500, 300);

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

        l1 = new JLabel("Admin Section");
        l1.setForeground(Color.BLACK);

        // Initialize gradient buttons
        bt1 = createGradientButton("Add Flights");
        bt2 = createGradientButton("Update Flights");
        bt3 = createGradientButton("Add Airline Employee");
        bt4 = createGradientButton("SignUp");

        l1.setHorizontalAlignment(JLabel.CENTER);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/f4.png"));
        Image img2 = img.getImage().getScaledInstance(100, 180, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        l2 = new JLabel(img3);

        l1.setFont(f);
        l2.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 1, 10, 10));
        p1.setOpaque(false); // Make panel background transparent
        p1.add(l1);
        p1.add(bt1);
        p1.add(bt2);
        p1.add(bt3);
        p1.add(bt4);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.setOpaque(false); // Make panel background transparent
        p2.add(l2);

        // Set a custom gradient panel as the content pane
        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setLayout(new BorderLayout(10, 10));
        gradientPanel.add(p1, BorderLayout.CENTER);
        gradientPanel.add(p2, BorderLayout.EAST);
        setContentPane(gradientPanel);

        // Set padding for the main frame
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // Method to create a GradientButton
    private GradientButton createGradientButton(String text) {
        GradientButton button = new GradientButton(text);
        button.setGradient(new Color(118, 75, 162), new Color(102, 126, 234)); // Set gradient colors
        button.setHoverGradient(new Color(102, 126, 234), new Color(118, 75, 162)); // Set hover gradient colors
        button.setForeground(Color.WHITE); // Set text color to white
        button.setFont(f1);
        return button;
    }

    // Event handling for button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            new AddFlights().setVisible(true);
        } else if (e.getSource() == bt2) {
            new UpdateFlights().setVisible(true);
        } else if (e.getSource() == bt3) {
            new AddAirlineEmployee().setVisible(true);
        } else if (e.getSource() == bt4) {
            new Index().setVisible(true);
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
            Color color1 = new Color(169, 241, 223);
            Color color2 = new Color(255, 130, 160);
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

    public static void main(String[] args) {
        new AdminHomePage().setVisible(true);
    }
}

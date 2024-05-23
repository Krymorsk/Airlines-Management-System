package AirlinesManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GradientButton extends JButton {
    private Color startColor;
    private Color endColor;
    private Color hoverStartColor;
    private Color hoverEndColor;
    private boolean isHovered = false;

    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        // Add mouse listener to handle hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }
        });
    }

    public void setGradient(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        repaint();
    }

    public void setHoverGradient(Color hoverStartColor, Color hoverEndColor) {
        this.hoverStartColor = hoverStartColor;
        this.hoverEndColor = hoverEndColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        if (isHovered) {
            g2.setPaint(new GradientPaint(0, 0, hoverStartColor, getWidth(), 0, hoverEndColor));
        } else {
            g2.setPaint(new GradientPaint(0, 0, startColor, getWidth(), 0, endColor));
        }
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
        super.paintComponent(g);
    }
}

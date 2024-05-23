package AirlinesManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SlideshowPanel extends JPanel {
    private List<ImageIcon> images;
    private JLabel label;
    private int currentIndex = 0;
    private Timer timer;

    public SlideshowPanel(List<ImageIcon> icons, int interval) {
        setLayout(new BorderLayout());
        images = icons;

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        // Add a component listener to ensure the size is non-zero before scaling the image
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                if (getWidth() > 0 && getHeight() > 0) {
                    if (timer == null) {
                        timer = new Timer(interval, e -> updateImage());
                        timer.start();
                    }
                    updateImage();
                }
            }
        });
    }

    private void updateImage() {
        if (!images.isEmpty()) {
            currentIndex = (currentIndex + 1) % images.size();
            ImageIcon icon = images.get(currentIndex);
            Image img = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        }
    }

    public void stopSlideshow() {
        if (timer != null) {
            timer.stop();
        }
    }
}

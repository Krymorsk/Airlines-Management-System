package AirlinesManagementSystem;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends JFrame implements ActionListener {
    private static final Font MENU_FONT = new Font("Lucida Fax", Font.BOLD, 20);
    private static final Font MENU_ITEM_FONT = new Font("MS UI Gothic", Font.BOLD, 18);
    private SlideshowPanel slideshowPanel;
    private ChatBot chatBot;

    public HomePage() {
        super("Airlines Management System");
        setLocation(0, 0);
        setSize(1550, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        setLayout(new BorderLayout());

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/S1.jpg"));
        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/S2.jpg"));
        ImageIcon img3 = new ImageIcon(ClassLoader.getSystemResource("AirlinesManagementSystem/Icons/S3.jpg"));
        List<ImageIcon> imageIcons = new ArrayList<>();
        // Add your ImageIcon objects to this list
        imageIcons.add(img1);
        imageIcons.add(img2);
        imageIcons.add(img3);
        // Add more images as needed
        slideshowPanel = new SlideshowPanel(imageIcons, 5000); // Pass the list to the constructor// Change images every 5 seconds
        add(slideshowPanel, BorderLayout.CENTER);

        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        chatBot = new ChatBot(); // Initialize the chatbot
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(createMenu("Passenger Profile", "Add Passenger Profile", "View Passenger Profile"));
        menuBar.add(createMenu("Manage Passenger", "Update Passenger Details"));
        menuBar.add(createMenu("Your Flight", "Book Flight", "View Booked Flight"));
        menuBar.add(createMenu("Flight Details", "Journey Details", "Flight Zone"));
        menuBar.add(createMenu("Cancellation", "Cancel Ticket", "View Canceled Ticket"));
        menuBar.add(createMenu("Cargo Management", "Add Cargo", "View Cargo"));
        menuBar.add(createMenu("Bill", "Check Payment"));
        menuBar.add(createMenu("Logout", "Exit"));

        // Add AskMe button to the menu bar
        JMenu askMeMenu = new JMenu("AskMe");
        askMeMenu.setFont(MENU_FONT);
        JMenuItem askMeItem = createMenuItem("AskMe");
        askMeMenu.add(askMeItem);
        menuBar.add(askMeMenu);

        return menuBar;
    }

    private JMenu createMenu(String title, String... menuItems) {
        JMenu menu = new JMenu(title);
        menu.setFont(MENU_FONT);

        for (String item : menuItems) {
            JMenuItem menuItem = createMenuItem(item);
            menu.add(menuItem);
        }

        return menu;
    }

    private JMenuItem createMenuItem(String title) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.setFont(MENU_ITEM_FONT);
        menuItem.setToolTipText(title);
        menuItem.addActionListener(this);
        return menuItem;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Add Passenger Profile":
                new AddPassengerDetails();
                break;
            case "View Passenger Profile":
                new ViewPassenger().setVisible(true);
                break;
            case "Update Passenger Details":
                new UpdatePassenger().setVisible(true);
                break;
            case "Book Flight":
                new BookFlight().setVisible(true);
                break;
            case "View Booked Flight":
                new ViewBookedFlight().setVisible(true);
                break;
            case "Journey Details":
                new FlightJourney();
                break;
            case "Flight Zone":
                new FlightZone().setVisible(true);
                break;
            case "Cancel Ticket":
                new CancelFlight().setVisible(true);
                break;
            case "View Canceled Ticket":
                new ViewCanceledTicket().setVisible(true);
                break;
            case "Add Cargo":
                new CargoManagement().frame.setVisible(true);
                break;
            case "View Cargo":
                new ViewCargo().setVisible(true);
                break;
            case "Check Payment":
                new CheckPaymentDetails().setVisible(true);
                break;
            case "Exit":
                slideshowPanel.stopSlideshow();
                System.exit(0);
                break;
            case "AskMe":
                chatBot.startChat();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Unknown command: " + command);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePage homePage = new HomePage();
            homePage.setVisible(true);
        });
    }
}

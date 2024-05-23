package AirlinesManagementSystem;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ChatBot {
    private Map<String, Map<String, String>> responses;

    public ChatBot() {
        responses = new HashMap<>();

        // Level 1 queries
        Map<String, String> level1Queries = new HashMap<>();
        level1Queries.put("Book Flight", null);
        level1Queries.put("Cancel Flight", null);
        level1Queries.put("Check Payment", null);
        responses.put("Main Menu", level1Queries);

        // Level 2 queries for "Book Flight"
        Map<String, String> bookFlightQueries = new HashMap<>();
        bookFlightQueries.put("How to book a flight?", "To book a flight, please go to the 'Your Flight' menu and select 'Book Flight'.");
        bookFlightQueries.put("View Booked Flight", "You can view your booked flights by selecting 'View Booked Flight' under 'Your Flight' menu.");
        responses.put("Book Flight", bookFlightQueries);

        // Level 2 queries for "Cancel Flight"
        Map<String, String> cancelFlightQueries = new HashMap<>();
        cancelFlightQueries.put("How to cancel a flight?", "To cancel a flight, please go to the 'Cancellation' menu and select 'Cancel Ticket'.");
        cancelFlightQueries.put("View Canceled Ticket", "You can view your canceled tickets by selecting 'View Canceled Ticket' under 'Cancellation' menu.");
        responses.put("Cancel Flight", cancelFlightQueries);

        // Level 2 queries for "Check Payment"
        Map<String, String> checkPaymentQueries = new HashMap<>();
        checkPaymentQueries.put("How to check payment?", "To check your payment details, please go to the 'Bill' menu and select 'Check Payment'.");
        responses.put("Check Payment", checkPaymentQueries);
    }

    public void startChat() {
        String currentLevel = "Main Menu";

        while (true) {
            Map<String, String> currentQueries = responses.get(currentLevel);
            String[] options = currentQueries.keySet().toArray(new String[0]);
            String query = (String) JOptionPane.showInputDialog(null, "Choose a query:", "AskMe", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (query == null) {
                break; // User cancelled the dialog
            }

            String response = currentQueries.get(query);

            if (response == null) {
                currentLevel = query; // Navigate to the next level
            } else {
                JOptionPane.showMessageDialog(null, response);
                currentLevel = "Main Menu"; // Reset to main menu
            }
        }
    }
}

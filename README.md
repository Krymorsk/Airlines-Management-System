# Airlines Management System

## Project Overview

The Airlines Management System is a comprehensive application designed to manage various aspects of airline operations. It provides functionalities for managing passenger profiles, booking flights, managing cargo, viewing flight details, handling cancellations, and more. Additionally, it includes an integrated chatbot for user queries.

## Features

1. **Passenger Profile Management**
   - Add Passenger Profile
   - View Passenger Profile
   - Update Passenger Details

2. **Flight Management**
   - Book Flight
   - View Booked Flights
   - Journey Details
   - Flight Zone

3. **Ticket Management**
   - Cancel Ticket
   - View Canceled Tickets

4. **Cargo Management**
   - Add Cargo
   - View Cargo

5. **Billing**
   - Check Payment

6. **Utilities**
   - Exit Application
   - AskMe (ChatBot Integration)

## Technologies Used

- **Java**: Core language for application logic.
- **Swing**: GUI framework for building the user interface.
- **FlatLaf**: Look and feel library for modern UI design.
- **Java AWT**: Used for event handling and component layout.
- **ImageIcon**: For displaying images in the slideshow.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/airlines-management-system.git
   ```

2. Open the project in your preferred IDE.

3. Ensure the required libraries (`flatlaf-<version>.jar`) are included in the project classpath.

### Running the Application

1. Locate the `HomePage.java` file in the project structure.
2. Run the `HomePage` class:
   - In your IDE, right-click on `HomePage.java` and select `Run 'HomePage.main()'`.
   - Alternatively, use the command line to navigate to the project directory and run:
     ```
     javac AirlinesManagementSystem/HomePage.java
     java AirlinesManagementSystem.HomePage
     ```

## Code Structure

### Main Classes

- **HomePage**: The main class that initializes the GUI, including the menu bar, slideshow, and integrates the chatbot.
- **SlideshowPanel**: Manages the display of a slideshow with images changing at regular intervals.
- **ChatBot**: Represents the chatbot feature that assists users with their queries.

### Menu Actions

- **Passenger Profile Actions**: Classes like `AddPassengerDetails`, `ViewPassenger`, `UpdatePassenger` manage the operations related to passenger profiles.
- **Flight Actions**: Classes such as `BookFlight`, `ViewBookedFlight`, `FlightJourney`, `FlightZone` handle flight booking and details.
- **Cancellation Actions**: `CancelFlight`, `ViewCanceledTicket` manage ticket cancellation processes.
- **Cargo Actions**: `CargoManagement`, `ViewCargo` deal with cargo operations.
- **Billing Actions**: `CheckPaymentDetails` manages payment verification.

### Event Handling

The `actionPerformed` method in the `HomePage` class handles various menu actions by invoking the appropriate classes based on the command string.

## User Interface

### Menu Bar

The menu bar contains the following menus with their respective items:

- **Passenger Profile**
  - Add Passenger Profile
  - View Passenger Profile
- **Manage Passenger**
  - Update Passenger Details
- **Your Flight**
  - Book Flight
  - View Booked Flight
- **Flight Details**
  - Journey Details
  - Flight Zone
- **Cancellation**
  - Cancel Ticket
  - View Canceled Ticket
- **Cargo Management**
  - Add Cargo
  - View Cargo
- **Bill**
  - Check Payment
- **Logout**
  - Exit
- **AskMe**
  - AskMe (ChatBot)

### Slideshow Panel

Displays a series of images related to the airline industry, enhancing the visual appeal of the application.

## Contributing

If you would like to contribute to the project, please fork the repository and submit a pull request. Ensure that your code adheres to the coding standards and is well-documented.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

## Contact

For any inquiries or issues, please contact [your email].

---

Feel free to customize the sections as per your project specifics and provide more detailed instructions if necessary.

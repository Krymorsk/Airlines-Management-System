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
   git clone https://github.com/Krymorsk/airlines-management-system.git
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
   ```bash
   git clone https://github.com/yourusername/airlines-management-system.git
   ```

2. Open the project in your preferred IDE.

3. Ensure the required libraries (`flatlaf-<version>.jar`) are included in the project classpath.

### Running the Application

1. Locate the `HomePage.java` file in the project structure.
2. Run the `HomePage` class:
   - In your IDE, right-click on `HomePage.java` and select `Run 'HomePage.main()'`.
   - Alternatively, use the command line to navigate to the project directory and run:
     ```bash
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

## Database Schema

### Tables

1. **adminlogin**
   - `username`: varchar(50)
   - `password`: varchar(16)
   - `name`: varchar(50)
   - `phone`: varchar(10)

2. **bookedflight**
   - `tid`: varchar(50) (Primary Key)
   - `source`: varchar(50)
   - `destination`: varchar(50)
   - `class_name`: varchar(50)
   - `price`: varchar(50)
   - `fcode`: varchar(50)
   - `fname`: varchar(50)
   - `journey_date`: varchar(50)
   - `journey_time`: varchar(50)
   - `username`: varchar(50)
   - `name`: varchar(50)
   - `status`: varchar(50)

3. **cancelflight**
   - `tid`: varchar(50) (Primary Key)
   - `source`: varchar(50)
   - `destination`: varchar(50)
   - `class_name`: varchar(50)
   - `price`: varchar(50)
   - `fcode`: varchar(50)
   - `fname`: varchar(50)
   - `journey_date`: varchar(50)
   - `journey_time`: varchar(50)
   - `username`: varchar(50)
   - `name`: varchar(50)
   - `reason`: varchar(100)

4. **cargo**
   - `cargoId`: int (Primary Key, Auto Increment)
   - `description`: varchar(255)
   - `weight`: double
   - `sender`: varchar(255)
   - `receiver`: varchar(255)
   - `flight_code`: varchar(20)
   - Foreign Key (`flight_code`) references `flight` (`f_code`)

5. **flight**
   - `f_code`: varchar(20) (Primary Key, Unique)
   - `f_name`: varchar(50)
   - `source`: varchar(50)
   - `destination`: varchar(50)
   - `capacity`: int
   - `class_name`: varchar(50)
   - `price`: varchar(50)
   - `journey_date`: date
   - `journey_time`: time
   - `flight_name`: varchar(50)

6. **passenger**
   - `username`: varchar(16) (Primary Key)
   - `name`: varchar(30)
   - `age`: varchar(50)
   - `dob`: varchar(50)
   - `address`: varchar(50)
   - `phone`: varchar(10)
   - `email`: varchar(50)
   - `nationality`: varchar(50)
   - `gender`: varchar(50)
   - `passport`: varchar(16)

7. **signup**
   - `username`: varchar(16) (Primary Key)
   - `name`: varchar(50)
   - `password`: varchar(50)
   - `Phone`: varchar(10)


Sure! Here is the SQL script to create the database and its tables, including inserting the initial data. This script can be run in a MySQL environment to set up the database for your Airlines Management System.

```sql
-- Create the database
CREATE DATABASE IF NOT EXISTS airlines;

-- Use the newly created database
USE airlines;

-- Table structure for table `adminlogin`
DROP TABLE IF EXISTS `adminlogin`;
CREATE TABLE `adminlogin` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insert data into `adminlogin`
INSERT INTO `adminlogin` VALUES 
('admin','admin','arish','8989898989'),


-- Table structure for table `bookedflight`
DROP TABLE IF EXISTS `bookedflight`;
CREATE TABLE `bookedflight` (
  `tid` varchar(50) NOT NULL,
  `source` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `fcode` varchar(50) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `journey_date` varchar(50) DEFAULT NULL,
  `journey_time` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Table structure for table `cancelflight`
DROP TABLE IF EXISTS `cancelflight`;
CREATE TABLE `cancelflight` (
  `tid` varchar(50) NOT NULL,
  `source` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `fcode` varchar(50) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `journey_date` varchar(50) DEFAULT NULL,
  `journey_time` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Table structure for table `cargo`
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo` (
  `cargoId` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `flight_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cargoId`),
  KEY `fk_flight` (`flight_code`),
  CONSTRAINT `fk_flight` FOREIGN KEY (`flight_code`) REFERENCES `flight` (`f_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `flight`
DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `f_code` varchar(20) NOT NULL,
  `f_name` varchar(50) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `journey_date` date DEFAULT NULL,
  `journey_time` time DEFAULT NULL,
  `flight_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`f_code`),
  UNIQUE KEY `f_code` (`f_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insert data into `flight`
INSERT INTO `flight` VALUES 
('FX123','BIGAIR','delhi','lucknow',500,'airbus','69000',NULL,NULL,NULL),
('FX128','AirFrance','India','France',500,'Economy','500',NULL,NULL,NULL),
('FX423','aircruise','Dubai','Singapore',500,'Economy','4565',NULL,NULL,NULL);

-- Table structure for table `passenger`
DROP TABLE IF EXISTS `passenger`;
CREATE TABLE `passenger` (
  `username` varchar(16) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `passport` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `signup`
DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup` (
  `username` varchar(16) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



### Instructions to Create Database

1. Open your MySQL client (such as MySQL Workbench, phpMyAdmin, or the command line).
2. Copy and paste the above SQL script into the SQL editor.
3. Execute the script.

This script will create the required tables and insert the initial data as per your project's requirements.

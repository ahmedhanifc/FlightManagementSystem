# Flight Booking System

## Project Overview

The Flight Booking System is a console-based application designed to simulate the management of a small airline's flight booking operations. Developed using **Java** and **Object-Oriented Programming (OOP)** principles, the system allows customers to search for and book flights, manage their bookings, and enables airline staff to handle flights, passengers, and schedules.

---

## Key Features

1. **Book a Flight**  
   - Search for flights based on origin, destination, and date.
   - Book flights by providing personal details and seat preferences.
   - Ensure seat availability before confirming a booking.

2. **Cancel a Booking**  
   - Cancel existing bookings using the booking reference number.
   - Update flight seat availability after cancellation.

3. **Display Available Flights**  
   - View flights based on specified criteria.
   - See details such as flight number, timings, available seats, and crew.

4. **Check Flight Status**  
   - Access flight status details, including departure and arrival times.
   - Track delays or updates.

5. **Manage Flight Schedules**  
   - Create, update, and manage flight schedules.
   - Assign pilots and crew members to flights.

6. **View Customer Details**  
   - Airline staff can view customer booking histories and details.

---

## Core Components

### Classes and Functionalities

1. **Person.java**  
   - Abstract base class for `Customer`, `Pilot`, and `CrewMember`.
   - Attributes: `name`, `dob`, `passportNumber`, `nationality`.
   - Abstract method: `printRole()`.

2. **Customer.java**  
   - Inherits from `Person`.
   - Attributes: `mealPreference`, `flightsUndertaken`, `bookings`.
   - Methods: Manage customer-specific bookings.

3. **Pilot.java**  
   - Inherits from `CrewMember`.
   - Attributes: `licenseType`, `flightHours`.
   - Methods: Manage pilot-specific data and roles.

4. **Flight.java**  
   - Represents flight information.
   - Attributes: `flightNumber`, `origin`, `destination`, `departure/arrival times`, `crew`, and `bookings`.
   - Methods: Manage flight schedules, crew, and bookings.

5. **Booking.java**  
   - Represents customer bookings.
   - Attributes: `bookingNumber`, `customer`, `seat`, `flight`, `ticketType`.

6. **FlightManagement.java**  
   - Handles operations such as:
     - Adding/removing airplanes, flights, and crew.
     - Assigning resources to flights.
     - Managing flight bookings and schedules.

7. **Utility.java**  
   - Provides helper methods for managing collections and maps.
   - Examples: `addIfNotExistsCollection`, `searchCollection`.

8. **MainFlightManagementSystem.java**  
   - Entry point for the application.
   - Implements a menu-driven interface for interacting with the system.
   - Handles user input and calls the relevant operations.

---

## Development Details

### Tools and Technologies

- **Programming Language**: Java
- **OOP Concepts**: Inheritance, Polymorphism, Encapsulation, Abstraction
- **Data Structures**: HashMap, ArrayList, HashSet

### Input/Output

- **Input**: User interacts via console using the `Scanner` class.
- **Output**: Displays flight and booking details on the console.

---

## How to Run the Application

1. **Setup**
   - Ensure Java is installed on your system.
   - Clone the repository or download the source code.

2. **Compile and Run**
   ```bash
   javac program/*.java
   java program.MainFlightManagementSystem
   ```

3. **Interact with the System**
   - Use the console menu to navigate functionalities like booking flights, managing schedules, and viewing details.

---

## Sample Interactions

### Main Menu
1. Display Available Flights  
2. Book a Flight  
3. View Booked Flights  
4. Cancel Booked Flight  
5. Exit  

### Booking Process
- Input origin and destination cities.
- Select a flight and provide customer details.
- Confirm booking if seats are available.

### Manage Flights
- Assign pilots, co-pilots, and crew members.
- View flight details.
- Update schedules.

---

## Future Enhancements

1. Integrate with a database for persistent data storage.
2. Add a graphical user interface (GUI).
3. Include real-time flight updates and notifications.

---

## Acknowledgments

This project is part of an academic assignment to practice OOP concepts. Special thanks to the project guidelines for providing a structured framework for implementation.


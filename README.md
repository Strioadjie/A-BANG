# A-BANG

A desktop-based Java application designed to streamline train ticketing operations. The system provides dedicated interfaces for administrators, staff members, and passengers, ensuring a structured workflow for ticket management and procurement.

## Architecture and Modules

The project is built using the Java Swing framework and follows a modular package structure to separate concerns between different user roles:

*   **Admin Module:** Handles user management, ticket inventory (CRUD operations), and system dashboard oversight.
*   **Staff (Pegawai) Module:** Provides operational forms for managing day-to-day ticketing tasks and verifying passenger information.
*   **Passenger (Penumpang) Module:** Features an interactive interface for searching, booking tickets, and viewing booking history. Includes secure user registration and login.

## Technical Stack

*   **Language:** Java (JDK 8+)
*   **GUI Framework:** Java Swing
*   **Database:** MySQL / MariaDB
*   **Database Connectivity:** JDBC (MySQL Connector/J)
*   **Security:** SHA-256 Hashing for credential protection
*   **Build Tool:** Ant (NetBeans)

## Setup and Installation

1.  **Clone the Repository:**
    ```bash
    git clone <your-repository-url>
    ```

2.  **Database Configuration:**
    *   Import the `kai.sql` file located in the root directory into your MySQL server.
    *   Update the database connection credentials in `A-BANG/src/Admin/DatabaseConnection.java` to match your local database setup.

3.  **Build and Run:**
    *   Open the `A-BANG` folder as a project in NetBeans IDE.
    *   Ensure the MySQL Connector/J library is added to the project's libraries.
    *   Clean and Build the project.
    *   Execute `Login.java` in the `Admin` package to start the application.

## Deployment

The project includes an installer configuration. Setup files can be found in the `A-BANG-SetupFiles` directory to install the application as a native Windows executable (.msi).

## License

This project is licensed under the MIT License.

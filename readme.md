# Online Appointment Booking System

This project is a **Java Servlet-based web application** that allows users to book and manage appointments online. It demonstrates essential backend and frontend development skills, including Java servlets, database integration, and MVC architecture.

## Features

1. **User Authentication**:

   - Users can register and log in.
   - Admins have a separate role to manage appointments.

2. **Appointment Management**:

   - Users can view, book, and cancel appointments.
   - Admins can approve, reject, or complete appointments.

3. **Database Integration**:

   - Data is stored and retrieved from a MySQL database.

4. **Responsive Design**:
   - Bootstrap ensures the application is accessible on all devices.

## Technologies Used

- **Backend**: Java Servlets, JDBC
- **Frontend**: JSP, HTML, CSS (Bootstrap)
- **Database**: MySQL
- **Build Tool**: Maven

## Project Setup

### Prerequisites

1. **Java Development Kit (JDK)**: Version 8 or higher
2. **Apache Tomcat**: Version 9 or higher
3. **MySQL Database**
4. **Maven**: Ensure Maven is installed and configured

### Installation Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/mahingaRodin/Online-Appointment-Booking-System.git
   cd Online-Appointment-Booking-System
   ```

2. Import the project into your IDE (IntelliJ, Eclipse, etc.) as a Maven project.

3. Configure the MySQL database:

   - Create a database named `appointments_db`.
   - Execute the following SQL script to create the required tables:

     ```sql
     CREATE TABLE users (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(100),
         email VARCHAR(100) UNIQUE,
         password VARCHAR(100),
         role VARCHAR(20)
     );

     CREATE TABLE appointments (
         id INT AUTO_INCREMENT PRIMARY KEY,
         user_id INT,
         service VARCHAR(100),
         date DATE,
         time TIME,
         status VARCHAR(20),
         FOREIGN KEY (user_id) REFERENCES users(id)
     );
     ```

4. Update the database connection in `DatabaseUtils.java`:

   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/appointments_db";
   private static final String USER = "root";
   private static final String PASSWORD = "your_password";
   ```

5. Build the project:

   ```bash
   mvn clean install
   ```

6. Deploy the application to Tomcat:
   - Place the generated WAR file (`target/appointment-booking-system.war`) in the `webapps` directory of your Tomcat installation.
   - Start Tomcat and access the application at `http://localhost:8080/appointment-booking-system`.

## Project Structure

```plaintext
src
├── main
│   ├── java
│   │   └── com.example.appointments
│   │       ├── controllers       # Servlets for handling HTTP requests
│   │       ├── dao               # Data Access Objects (DB operations)
│   │       ├── models            # POJOs for Users and Appointments
│   │       └── utils             # Utility classes (e.g., DatabaseUtils)
│   ├── resources                 # Configuration files
│   └── webapp
│       ├── WEB-INF
│       │   └── web.xml           # Deployment descriptor
│       ├── css                   # Stylesheets
│       ├── js                    # JavaScript files
│       └── jsp                   # JSP pages (login.jsp, dashboard.jsp, etc.)
```

## Usage

1. Open the application in your browser.
2. Register as a new user or log in with an existing account.
3. Book, view, and manage appointments from the user dashboard.
4. Admins can manage all appointments from the admin panel.

## Screenshots

- **Login Page**: A simple login form with error handling.
- **Dashboard**: Displays user appointments with options to book or cancel.
- **Admin Panel**: Allows management of all appointments.

## Contributions

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add new feature"
   ```
4. Push to your branch:
   ```bash
   git push origin feature-name
   ```
5. Open a pull request.

## Contact

For questions or support, feel free to reach out via LinkedIn: [Mahinga Rodin](https://www.linkedin.com/in/mahinga-rodin-67924a2a2/).

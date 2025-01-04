package com.example.appointments;

import com.example.appointments.dao.AppointmentDAO;
import com.example.appointments.dao.UserDAO;
import com.example.appointments.models.Appointment;
import com.example.appointments.models.User;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            //testing userDAO
            UserDAO userDAO =  new UserDAO();

            //registering new user
            User newUser = new User();
            newUser.setName("Mahinga Rodin");
            newUser.setEmail("mahingarodin@gmail.com");
            newUser.setPassword("admin123");
            newUser.setRole("ADMIN");

            boolean isRegistered = userDAO.registerUser(newUser);
            System.out.println("User registration successful " + isRegistered);

            //fetching a user by email
            User fetchedUser = userDAO.getUserByEmail("mahingarodin@gmail.com");
            System.out.println("Fetched user: "+ fetchedUser.getName() + "Email: " + fetchedUser.getEmail());

            //testing appointmentDAO
            AppointmentDAO appointmentDAO = new AppointmentDAO();

            //creating a new appointment
            Appointment app = new Appointment();
            app.setUserId(fetchedUser.getId());
            app.setService("Eye Checkup");
            app.setDate(Date.valueOf("2025-01-20"));
            app.setTime(Time.valueOf("09:00:00"));
            app.setStatus("PENDING");
            boolean isAppointmentCreated = appointmentDAO.createAppointment(app);
            System.out.println("Appointment creation successful: " + isAppointmentCreated);
            List<Appointment> appointments = appointmentDAO.getAppointmentsByUserId(fetchedUser.getId());
            System.out.println("User Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println("- Service: " + appointment.getService() +
                        ", Date: " + appointment.getDate() +
                        ", Time: " + appointment.getTime() +
                        ", Status: " + appointment.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

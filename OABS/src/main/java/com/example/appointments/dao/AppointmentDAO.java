package com.example.appointments.dao;

import com.example.appointments.models.Appointment;
import com.example.appointments.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    public List<Appointment> getAppointmentsByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM appointments WHERE user_id = ?";
        List<Appointment> appointments = new ArrayList<>();

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setUserId(resultSet.getInt("user_id"));
                appointment.setService(resultSet.getString("service"));
                appointment.setDate(resultSet.getDate("date"));
                appointment.setTime(resultSet.getTime("time"));
                appointment.setStatus(resultSet.getString("status"));
                appointments.add(appointment);
            }
        }
        return appointments;
    }

    public boolean createAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appointments (user_id, service, date, time, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, appointment.getUserId());
            statement.setString(2, appointment.getService());
            statement.setDate(3, appointment.getDate());
            statement.setTime(4, appointment.getTime());
            statement.setString(5, appointment.getStatus());
            return statement.executeUpdate() > 0;
        }
    }
}

package com.example.appointments.dao;

import com.example.appointments.models.Appointment;
import com.example.appointments.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public boolean createAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appointments (user_id, date, time, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, appointment.getUserId());
            statement.setDate(2, java.sql.Date.valueOf(appointment.getDate()));
            statement.setTime(3, java.sql.Time.valueOf(appointment.getTime()));
            statement.setString(4, appointment.getStatus());
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Appointment> getAppointmentsByUserId(int userId) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments WHERE user_id = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                appointments.add(new Appointment(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getTime("time").toLocalTime(),
                        resultSet.getString("status")
                ));
            }
        }
        return appointments;
    }

    @Override
    public boolean updateAppointmentStatus(int appointmentId, String status) throws SQLException {
        String query = "UPDATE appointments SET status = ? WHERE id = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, status);
            statement.setInt(2, appointmentId);
            return statement.executeUpdate() > 0;
        }
    }
}

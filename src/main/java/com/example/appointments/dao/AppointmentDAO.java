package com.example.appointments.dao;

import com.example.appointments.models.Appointment;

import java.sql.SQLException;
import java.util.List;

public interface AppointmentDAO {
    boolean createAppointment(Appointment appointment) throws SQLException;
    List<Appointment> getAppointmentsByUserId(int userId) throws SQLException;
    boolean updateAppointmentStatus(int appointmentId, String status) throws SQLException;
}

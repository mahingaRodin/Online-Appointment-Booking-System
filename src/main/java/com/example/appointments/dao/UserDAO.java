package com.example.appointments.dao;

import com.example.appointments.models.User;

import java.sql.SQLException;

public interface UserDAO {
    User getUserByEmail(String email) throws SQLException;
    boolean registerUser(User user) throws SQLException;
}
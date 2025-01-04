package com.example.appointments.dao;

import com.example.appointments.models.User;
import com.example.appointments.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User getUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {
           statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                return  user;
            }
        }
        return null;
    }

    public boolean registerUser(User user) throws SQLException {
        String query = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
        try(Connection connection = DatabaseUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());
            return statement.executeUpdate() > 0;
        }

    }

}

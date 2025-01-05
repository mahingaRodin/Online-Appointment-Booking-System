package com.example.appointments.servlets;

import com.example.appointments.dao.UserDAO;
import com.example.appointments.dao.UserDAOImpl;
import com.example.appointments.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUserServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole("USER");

            boolean isRegistered = userDAO.registerUser(user);

            if (isRegistered) {
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.getWriter().write("User registered successfully!");
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("Failed to register user.");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("An error occurred: " + e.getMessage());
        }
        }
    }


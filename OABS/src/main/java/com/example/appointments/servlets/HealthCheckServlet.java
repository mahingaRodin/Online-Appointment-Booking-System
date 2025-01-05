package com.example.appointments.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/healthcheck")
public class HealthCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String healthStatus = "{\"status\": \"OK\", \"message\": \"Application is running smoothly.\"}";
        resp.getWriter().write(healthStatus);
        resp.setStatus(HttpServletResponse.SC_OK);

    }
}

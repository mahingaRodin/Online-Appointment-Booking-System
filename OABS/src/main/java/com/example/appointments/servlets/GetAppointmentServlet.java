package com.example.appointments.servlets;

import com.example.appointments.dao.AppointmentDAO;
import com.example.appointments.dao.AppointmentDAOImpl;
import com.example.appointments.models.Appointment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAppointmentServlet extends HttpServlet {
   private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            List<Appointment> appointments = appointmentDAO.getAppointmentsByUserId(userId);

            if(appointments != null && !appointments.isEmpty()) {
                response.setContentType("application/json");
                response.getWriter().write(appointments.toString());
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("An error occurred: " + e.getMessage());
        }
    }

}

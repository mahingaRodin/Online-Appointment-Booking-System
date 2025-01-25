package com.example.appointments;

import com.example.appointments.servlets.GetAppointmentServlet;
import com.example.appointments.servlets.HealthCheckServlet;
import com.example.appointments.servlets.RegisterUserServlet;
import jakarta.servlet.Servlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Create Tomcat instance
            Tomcat tomcat = new Tomcat();

            // Set the port number
            tomcat.setPort(8080);

            // Define the context path and base directory for the application
            String contextPath = "/oabs"; // Change this to your desired context path
            String baseDir = new File(".").getAbsolutePath();

            // Add the web application
            Context context = tomcat.addWebapp(contextPath, baseDir);

            // Add individual servlets without unnecessary casting
            tomcat.addServlet(context, "HealthCheckServlet", (Servlet) new HealthCheckServlet());
            tomcat.addServlet(context, "UserServlet", (Servlet) new RegisterUserServlet());
            tomcat.addServlet(context, "AppointmentServlet", (Servlet) new GetAppointmentServlet());

            // Map servlets to their respective URL patterns
            context.addServletMappingDecoded("/healthcheck", "HealthCheckServlet");
            context.addServletMappingDecoded("/user/*", "UserServlet");
            context.addServletMappingDecoded("/appointments/*", "AppointmentServlet");

            // Start Tomcat
            tomcat.start();
            System.out.println("Tomcat started on http://localhost:8080" + contextPath);
            tomcat.getServer().await();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

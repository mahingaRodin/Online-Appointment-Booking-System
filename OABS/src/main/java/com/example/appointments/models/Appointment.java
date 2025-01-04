package com.example.appointments.models;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
    private int id;
    private int userId;
    private String service;
    private Date date;
    private Time time;
    private String status; // "PENDING", "APPROVED", "COMPLETED"

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

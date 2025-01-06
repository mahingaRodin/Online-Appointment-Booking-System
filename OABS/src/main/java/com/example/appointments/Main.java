package com.example.appointments;

import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();

            tomcat.setPort(9090);

        }
    }
}
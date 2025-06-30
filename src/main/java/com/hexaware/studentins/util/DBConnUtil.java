package com.hexaware.studentins.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sisdb", "root", "Sivabaggiya19/");
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e.getMessage());
            return null;
        }
    }
}


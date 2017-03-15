package com.example.ingridstoen.alarme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by ingridstoen on 10.03.2017.
 */

public class DatabaseConnection {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public DatabaseConnection() {
        connect();
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:localhost:3306//id994524_alarme?user=id994524_alarme" +
                    "&password=12345678");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public void addUser(String username, String password) {
        try {
            String query = "INSERT INTO USERS (Username, Password) VALUES (" + username + "," + password + ")";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public String getCourses() {
        try {
            stmt = conn.createStatement();

            String query = "SELECT COURSECODE FROM EXAM";
            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}

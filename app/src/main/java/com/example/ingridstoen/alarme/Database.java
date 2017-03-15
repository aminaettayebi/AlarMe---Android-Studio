package com.example.ingridstoen.alarme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by ingridstoen on 10.03.2017.
 */

public class Database {
    public static void main(String[] args) throws Exception {

        String server = "sql8.freemysqlhosting.net";
        String database = "sql8163118";
        String username = "sql8163118";
        String password = "*********";
        String connectionString = "jdbc:mysql://" + server + "/" + database + "?user=" + username + "&password=" + password;

        Connection connection = DriverManager.getConnection(connectionString);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM test");

        while (result.next()) {
            System.out.println(result.getInt(1));
        }

    }
}

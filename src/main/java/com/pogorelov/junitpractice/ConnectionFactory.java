package com.pogorelov.junitpractice;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    private Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/junittest?serverTimezone=UTC";
    private final String username = "root";
    private final String password = "1234";

    Statement getStatement() {

        try {
//            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(URL, username, password);
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

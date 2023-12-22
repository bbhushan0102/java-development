package com.bharat.studyEasy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabseConfig {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String dbURL = "jdbc:mysql://localhost:3306/studyeasy?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "Veratuhina@13";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        return con;
    }
}

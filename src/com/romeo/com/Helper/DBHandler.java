package com.romeo.com.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Config {

//        Class.forName("com.mysql.jdbc.Driver");
//    Connection connection =
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "1234");
//        System.out.println("Connected to the database " + connection.getCatalog());
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/"
                + dbName;
        // Connect to mysql
        Class.forName("com.mysql.jdbc.Driver");
        // Create connection
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }
}
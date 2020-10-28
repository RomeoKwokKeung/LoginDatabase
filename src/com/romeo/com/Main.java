package com.romeo.com;

import com.romeo.com.Helper.DBHandler;

import java.sql.*;

public class Main {
    static private DBHandler dbHandler;
    static private Connection connection;
    static private PreparedStatement preparedStatement;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        dbHandler = new DBHandler();
        connection = dbHandler.getDbConnection();

        //writeToDB();
        //readFromDB();
        //updateDB("Carlos", "Santana", "sanatana", "8888 building", 77, 1);
        deleteDB(1);
    }

    private static void writeToDB() throws SQLException {
        String insert = "INSERT INTO users(firstname, lastname, username, address, age)" +
                "VALUES(?,?,?,?,?)";

        preparedStatement = connection.prepareStatement(insert);

        preparedStatement.setString(1, "Ricardo");
        preparedStatement.setString(2, "John");
        preparedStatement.setString(3, "rico");
        preparedStatement.setString(4, "1234 City");
        preparedStatement.setInt(5, 81);
        preparedStatement.executeUpdate();
    }

    private static void readFromDB() throws SQLException {
        String query = "SELECT * from users";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Name: " + resultSet.getString("firstname") +
                    " " + resultSet.getString("lastname") +
                    " " + resultSet.getInt("age") +
                    " " + resultSet.getString("address"));
        }
    }

    private static void updateDB(String firstName, String lastName, String username, String address, int age, int id) {
        String query = "UPDATE users set firstname = ?, lastname = ?, username = ?, address = ?, age = ? "
                + "where userid = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, age);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteDB(int id) {
        String query = "DELETE from users where userid = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

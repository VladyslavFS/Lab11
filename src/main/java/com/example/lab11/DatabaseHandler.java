package com.example.lab11;

import java.sql.*;

public final class DatabaseHandler {
    private static final String URL = "jdbc:postgresql://localhost:5432/Transport";
    private static final String USER = "postgres";
    private static final String PASSWORD = "11111111";
    private Connection connection;

    public DatabaseHandler() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addEnterprise(String name, String address, Date foundingDate, double fund, double value) throws SQLException {
        String query = "INSERT INTO Підприємства (назва, адреса, дата_заснування, статутний_фонд, балансова_вартість) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setDate(3, foundingDate);
            statement.setDouble(4, fund);
            statement.setDouble(5, value);
            statement.executeUpdate();
        }
    }

    public ResultSet searchEnterprise(String name) throws SQLException {
        String query = "SELECT * FROM Підприємства WHERE назва LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + name + "%");
        return statement.executeQuery();
    }

    public void updateEnterprise(int id, String address, double value) throws SQLException {
        String query = "UPDATE Підприємства SET адреса = ?, балансова_вартість = ? WHERE код_підприємства = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, address);
            statement.setDouble(2, value);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    public void deleteEnterprise(int id) throws SQLException {
        String query = "DELETE FROM Підприємства WHERE код_підприємства = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

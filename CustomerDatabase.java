package database;

import java.sql.*;

public class CustomerDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/gas1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS customer (" +
                                    "customerID INT AUTO_INCREMENT PRIMARY KEY, " +
                                    "firstname VARCHAR(50), " +
                                    "lastname VARCHAR(50), " +
                                    "dateofbirth DATE, " +
                                    "aadhar_number BIGINT, " +
                                    "mobile_number BIGINT, " +
                                    "connectionType VARCHAR(10))";
            statement.execute(createTableSQL);

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

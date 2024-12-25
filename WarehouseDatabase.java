package database;

import java.sql.*;

public class WarehouseDatabase {
    
    private static final String URL = "jdbc:mysql://localhost:3306/gas1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS warehouse (" +
                                    "14_2kg_filled INT, " +
                                    "14_2kg_empty INT, " +
                                    "19kg_filled INT, " +
                                    "19kg_empty INT, " +
                                    "5kg_filled INT, " +
                                    "5kg_empty INT)";
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

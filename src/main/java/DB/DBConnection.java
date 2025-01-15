package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/budget";
    private static String USERNAME;
    private static String PASSWORD;

    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            Properties props = new Properties();
            props.load(fis);
            USERNAME = props.getProperty("DB_USERNAME");
            PASSWORD = props.getProperty("DB_PASSWORD");
        } catch (IOException e) {
            System.err.println("Failed to load database configuration: " + e.getMessage());
        }
    }

    // Private constructor to prevent instantiation
    private DBConnection() {}

    // Establish connection (you could use a connection pool instead)
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


}

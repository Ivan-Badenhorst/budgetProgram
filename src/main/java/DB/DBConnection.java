package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * The {@code DBConnection} class provides a utility for managing database connections.
 */
public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/budget";
    private static String USERNAME;
    private static String PASSWORD;

    // Static block to initialize database credentials
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

    /**
     * Establishes a connection to the database using the loaded credentials.
     *
     * @return a {@link Connection} object representing the database connection
     * @throws SQLException if a database access error occurs or the connection URL is invalid
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyApp {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");
                // Perform your queries here
            } else {
                System.out.println("Failed to connect to the database.");
            }
        }
    }
}
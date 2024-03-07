import java.sql.*;

public class DatabaseConnection {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/jdbc_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Create a table (if not exists)
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Persons (PersonID INT, LastName VARCHAR(255), FirstName VARCHAR(255), Address VARCHAR(255), City VARCHAR(255))");
            // Insert some entries
           statement.executeUpdate("INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES (1, 'Doe', 'John', '123 Main St', 'New York')");
            statement.executeUpdate("INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES (2, 'Smith', 'Jane', '456 Elm St', 'Los Angeles')");
            statement.executeUpdate("INSERT INTO Persons (PersonID, LastName, FirstName, Address, City) VALUES (3, 'Johnson', 'Bob', '789 Oak St', 'Chicago')");

            // Retrieve data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");

            // Iterate over the result set
            System.out.println("Persons:");
            while (resultSet.next()) {
                int id = resultSet.getInt("PersonID");
                String lastName = resultSet.getString("LastName");
                String firstName = resultSet.getString("FirstName");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                System.out.println("PersonID: " + id + ", LastName: " + lastName + ", FirstName: " + firstName + ", Address: " + address + ", City: " + city);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
import java.sql.*;

public class index {
    public static void main(String[] args) {
        connect();
    }
    public static Connection connect() {
        String url = "jdbc:postgresql://localhost/Database_Assignment2";
        String user = "postgres";
        String password = "1234";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}

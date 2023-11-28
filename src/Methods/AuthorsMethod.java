package Methods;

import Entity.Authors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsMethod {
    public boolean addBooks(Authors authors) {
        try (Connection connection = connect();) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO authors (author_id,author_name) VALUES (?,?)");
            st.setInt(1, authors.getAuthor_id());
            st.setString(2, authors.getAuthor_name());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public List<Authors> getAllAuthors() {
        List<Authors> authors = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM authors");
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int author_id = res.getInt("author_id");
                String author_name = res.getString("author_name");
                authors.add(new Authors(author_id, author_name));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return authors;
    }

    public boolean updateBooks(Authors authors) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE authors SET author_name=? WHERE author_id=?");
            st.setString(1, authors.getAuthor_name());
            st.setInt(2, authors.getAuthor_id());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteAuthors(int author_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM authors WHERE author_id = " + author_id);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static Connection connect() {
        String url = "jdbc:postgresql://localhost/Database_Assignment2";
        String user = "postgres";
        String password = "1234";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database successfully.");
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
        }

        return con;
    }
}


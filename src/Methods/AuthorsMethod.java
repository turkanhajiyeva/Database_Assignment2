package Methods;

import Connectivity.Database_connection;
import Entity.Authors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorsMethod extends Database_connection {
    public static boolean addAuthors(Authors authors) {
        try (Connection connection = connect();) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO authors (author_id,author_name) VALUES (?,?)");
            st.setInt(1, authors.getAuthor_id());
            st.setString(2, authors.getAuthor_name());
            System.out.println("Inserting author");
            st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        System.out.println("Author inserted successfully");
        return true;
    }

    public static List<Authors> getAllAuthors() {
        List<Authors> authors = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM authors");
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int author_id = res.getInt("author_id");
                String author_name = res.getString("author_name");
                System.out.println("author_id = " + author_id + ", author_name = " + author_name);
                authors.add(new Authors(author_id, author_name));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return authors;
    }

    public static boolean updateAuthors(Authors authors) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE authors SET author_name=? WHERE author_id=?");
            st.setString(1, authors.getAuthor_name());
            st.setInt(2, authors.getAuthor_id());
            System.out.println("Updated successfully");
            st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean deleteAuthors(int author_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM authors WHERE author_id = " + author_id);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        System.out.println("Successfully Deleted author");
        return true;
    }

    public static Authors getAuthorById(int author_id) {
        Authors authors = null;
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM authors WHERE author_id = " + author_id);
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int id = res.getInt("author_id");
                String author_name = res.getString("author_name");
                System.out.println("author_id = " + author_id + ", author_name = " + author_name);
                authors = new Authors(id, author_name);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return authors;
    }
}

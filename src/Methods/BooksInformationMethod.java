package Methods;

import Entity.BooksInformation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksInformationMethod {
    public boolean addBooksInformation(BooksInformation BooksInformation) {
        try (Connection connection = connect();) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO booksinformation (book_id,author_id) VALUES (?,?)");
            st.setInt(1, BooksInformation.getBook_id());
            st.setInt(2, BooksInformation.getAuthor_id());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public List<BooksInformation> getAllBooksInformation() {
        List<BooksInformation> BooksInformation = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM booksinformation");
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int book_id = res.getInt("book_id");
                int author_id = res.getInt("author_id");
                BooksInformation.add(new BooksInformation(book_id,author_id));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return BooksInformation;
    }

    public boolean updateBooksInformation(BooksInformation BooksInformation) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE booksinformation SET author_id=? WHERE book_id=?");
            st.setInt(1, BooksInformation.getAuthor_id());
            st.setInt(2, BooksInformation.getBook_id());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteBooksInformation(int author_id, int book_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM booksinformation WHERE book_id = " + book_id + " AND author_id = " + author_id);
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


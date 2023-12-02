package Methods;

import Connectivity.Database_connection;
import Entity.BooksInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksInformationMethod extends Database_connection {
    public static boolean addBooksInformation(BooksInformation BooksInformation) {
        try (Connection connection = connect();) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO booksinformation (book_id,author_id) VALUES (?,?)");
            st.setInt(1, BooksInformation.getBook_id());
            st.setInt(2, BooksInformation.getAuthor_id());
            System.out.println("Inserting Book Information");
            st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        System.out.println("Book Information inserted successfully");
        return true;
    }

    public static List<BooksInformation> getAllBooksInformation() {
        List<BooksInformation> BooksInformation = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM booksinformation");
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int book_id = res.getInt("book_id");
                int author_id = res.getInt("author_id");
                System.out.println("book_id = " + book_id + ", author_id = " + author_id);
                BooksInformation.add(new BooksInformation(book_id, author_id));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return BooksInformation;
    }

    public static boolean updateBooksInformation(BooksInformation BooksInformation) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE booksinformation SET author_id=? WHERE book_id=?");
            st.setInt(1, BooksInformation.getAuthor_id());
            st.setInt(2, BooksInformation.getBook_id());
            System.out.println("Updated successfully");
            st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean deleteBooksInformation(int author_id, int book_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM booksinformation WHERE book_id = " + book_id + " AND author_id = " + author_id);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        System.out.println("Successfully Deleted Book Information");
        return true;
    }

    public static List<BooksInformation> getAllBooksInformationById(int book_id) {
        List<BooksInformation> booksInformation = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM booksinformation WHERE book_id = " + book_id);
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int id = res.getInt("book_id");
                int id2 = res.getInt("author_id");
                System.out.println("book_id = " + book_id + ", author_id = " + id2);
                booksInformation.add(new BooksInformation(id, id2));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return booksInformation;
    }
    public static BooksInformation getBooksInformationById(int book_id, int author_id) {
        BooksInformation booksInformation = null;
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM booksinformation WHERE book_id = " + book_id + " AND author_id = " + author_id);
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int id = res.getInt("book_id");
                int id2 = res.getInt("author_id");
                System.out.println("book_id = " + book_id + ", author_id = " + id2);
                booksInformation = new BooksInformation(id, id2);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return booksInformation;
    }
}
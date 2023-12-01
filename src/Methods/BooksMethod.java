package Methods;

import Connection.Database_connection;
import Entity.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksMethod extends Database_connection {
     public boolean addBooks(Books book) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO books (book_id,title,genre,price,stock) VALUES (?,?,?,?,?)");
            st.setInt(1, book.getBook_id());
            st.setString(2, book.getTitle());
            st.setString(3, book.getGenre());
            st.setInt(4, book.getPrice());
            st.setInt(5, book.getStock());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM books");
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int book_id = res.getInt("book_id");
                String title = res.getString("title");
                String genre = res.getString("genre");
                int price = res.getInt("price");
                int stock = res.getInt("stock");
                books.add(new Books(book_id, title, genre, price, stock));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return books;
    }

    public boolean updateBooks(Books book) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE books SET title=?, genre=?, price=?, stock=? WHERE book_id=?");
            st.setString(1, book.getTitle());
            st.setString(2, book.getGenre());
            st.setInt(3, book.getPrice());
            st.setInt(4, book.getStock());
            st.setInt(5, book.getBook_id());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteBooks(int book_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM books WHERE book_id = " + book_id);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static Books getBookById(int book_id) {
        Books book = null;
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM book WHERE book_id = " + book_id);
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int id = res.getInt("book_id");
                String title = res.getString("title");
                String genre = res.getString("genre");
                int price = res.getInt("price");
                int stock = res.getInt("stock");
                book = new Books(id, title, genre, price, stock);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return book;
    }
}

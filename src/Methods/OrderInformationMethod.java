package Methods;

import Entity.Books;
import Entity.OrderInformation;
import Connection.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderInformationMethod extends Database_connection {
    public boolean addOrderInformation(OrderInformation OrderInformation) {
        try (Connection connection = connect();
             PreparedStatement insertOrderStatement = connection.prepareStatement("INSERT INTO orderinformation (order_id, book_id,orderedbooks) VALUES (?, ?, ?)");
             PreparedStatement updateBookStatement = connection.prepareStatement("UPDATE books SET stock = ? WHERE book_id = ?")) {

            connection.setAutoCommit(false);

            int book_id = OrderInformation.getBook_id();
            int orderedbooks = OrderInformation.getOrderedbooks();
            Books book = BooksMethod.getBookById(book_id);

            if (book != null && book.getStock() >= orderedbooks) {
                insertOrderStatement.setInt(1, OrderInformation.getOrder_id());
                insertOrderStatement.setInt(2, OrderInformation.getBook_id());
                insertOrderStatement.setInt(3, OrderInformation.getOrderedbooks());
                insertOrderStatement.executeUpdate();

                int updatedStock = book.getStock() - orderedbooks;
                updateBookStatement.setInt(1, updatedStock);
                updateBookStatement.setInt(2, book_id);
                updateBookStatement.executeUpdate();

                connection.commit();
                return true;
            } else {
                connection.rollback();
                System.out.println("Not enough books in stock for this order.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public List<OrderInformation> getAllOrderInformation() {
        List<OrderInformation> OrderInformation = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM orderinformation");
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int order_id = res.getInt("order_id");
                int book_id = res.getInt("book_id");
                int orderedbooks = res.getInt("orderedbooks");
                OrderInformation.add(new OrderInformation(order_id, book_id, orderedbooks));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return OrderInformation;
    }

    public boolean updateOrderInformation(OrderInformation OrderInformation) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE orderinformation SET book_id=?, orderedbooks=? WHERE order_id=?");
            st.setInt(1, OrderInformation.getBook_id());
            st.setInt(2, OrderInformation.getOrder_id());
            st.setInt(3, OrderInformation.getOrderedbooks());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteOrderInformation(int book_id, int order_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM orderinformation WHERE book_id = " + book_id + " AND order_id = " + order_id);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

}


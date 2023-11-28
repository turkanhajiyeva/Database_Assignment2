package Methods;

import Entity.OrderInformation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderInformationMethod {
    public boolean addOrderInformation(OrderInformation OrderInformation) {
        try (Connection connection = connect();) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO orderinformation (order_id, book_id) VALUES (?,?)");
            st.setInt(1, OrderInformation.getOrder_id());
            st.setInt(2, OrderInformation.getBook_id());
            return st.execute();
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
                OrderInformation.add(new OrderInformation(order_id, book_id));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return OrderInformation;
    }

    public boolean updateOrderInformation(OrderInformation OrderInformation) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE orderinformation SET book_id=? WHERE order_id=?");
            st.setInt(1, OrderInformation.getBook_id());
            st.setInt(2, OrderInformation.getOrder_id());
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


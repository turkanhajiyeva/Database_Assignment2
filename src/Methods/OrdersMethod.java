package Methods;

import Entity.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersMethod extends Destination_connection {
    public boolean addOrders(Orders Orders) {
        try (Connection connection = connect();) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO orders (order_id, customer_id,order_date,total_cost) VALUES (?,?,?,?)");
            st.setInt(1, Orders.getOrder_id());
            st.setInt(2, Orders.getCustomer_id());
            st.setDate(3, Orders.getOrder_date());
            st.setInt(4, Orders.getTotal_cost());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public List<Orders> getAllOrders() {
        List<Orders> Orders = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM orders");
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int order_id = res.getInt("order_id");
                int customer_id = res.getInt("customer_id");
                Date order_date = res.getDate("order_date");
                int total_cost = res.getInt("total_cost");
                Orders.add(new Orders(order_id, customer_id, order_date, total_cost));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return Orders;
    }

    public boolean updateOrders(Orders Orders) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE orders SET customer_id=?, order_date=?, total_cost=? WHERE order_id=?");
            st.setInt(4, Orders.getCustomer_id());
            st.setDate(1, Orders.getOrder_date());
            st.setInt(2, Orders.getTotal_cost());
            st.setInt(4, Orders.getCustomer_id());
            return st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteOrders(int order_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM orders WHERE order_id = " + order_id);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }
}


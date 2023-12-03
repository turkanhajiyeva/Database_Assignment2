package Methods;

import Connectivity.Database_connection;
import Entity.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersMethod extends Database_connection {
    public static boolean addOrders(Orders Orders) {
        try (Connection connection = connect();) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO orders (order_id, customer_id,order_date,total_cost) VALUES (?,?,?,?)");
            st.setInt(1, Orders.getOrder_id());
            st.setInt(2, Orders.getCustomer_id());
            st.setDate(3, Orders.getOrder_date());
            st.setInt(4, Orders.getTotal_cost());
            System.out.println("Inserting order");
            st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static List<Orders> getAllOrders() {
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
                System.out.println("order_id = " + order_id + ", customer_id = " + customer_id +
                        ", order_date = " + order_date + ", total_cost = " + total_cost);
                Orders.add(new Orders(order_id, customer_id, order_date, total_cost));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return Orders;
    }

    public static boolean updateOrders(Orders Orders) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE orders SET customer_id=?, order_date=?, total_cost=? WHERE order_id=?");
            st.setInt(1, Orders.getCustomer_id());
            st.setDate(2, Orders.getOrder_date());
            st.setInt(3, Orders.getTotal_cost());
            st.setInt(4, Orders.getOrder_id());
            System.out.println("Updated successfully");
            st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean deleteOrders(int order_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM orders WHERE order_id = " + order_id);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        System.out.println("Successfully deleted order");
        return true;
    }

    public static Orders getOrderById(int order_id) {
        Orders order = null;
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM orders WHERE order_id = " + order_id);
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int id = res.getInt("order_id");
                int customer_id = res.getInt("customer_id");
                Date order_date = res.getDate("order_date");
                int total_cost = res.getInt("total_cost");
                System.out.println("order_id = " + id + ", customer_id = " + customer_id +
                        ", order_date = " + order_date + ", total_cost = " + total_cost);
                order = new Orders(id,customer_id,order_date,total_cost);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return order;
    }
}

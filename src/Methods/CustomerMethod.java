package Methods;

import Entity.Books;
import Entity.Customer;
import Connectivity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMethod extends Database_connection{
    public static boolean addCustomer(Customer Customer) {
        try (Connection connection = connect();) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO customer (customer_id,address,email,customer_name) VALUES (?,?,?,?)");
            st.setInt(1, Customer.getCustomer_id());
            st.setString(2, Customer.getAddress());
            st.setString(3, Customer.getEmail());
            st.setString(4, Customer.getCustomer_name());
            System.out.println("Inserting Customer");
            st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        System.out.println("Customer inserted successfully");
        return true;
    }

    public static List<Customer> getAllCustomer() {
        List<Customer> Customer = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM customer");
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int customer_id = res.getInt("customer_id");
                String address = res.getString("address");
                String email = res.getString("email");
                String customer_name = res.getString("customer_name");
                System.out.println("customer_id = " + customer_id + ", address = " + address + ", email = " + email
                        + ", customer_name = " + customer_name);
                Customer.add(new Customer(customer_id, address, email, customer_name));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return Customer;
    }

    public static boolean updateCustomer(Customer Customer) {
        try (Connection connection = connect()) {
            PreparedStatement st = connection.prepareStatement("UPDATE customer SET address=?, email=?, customer_name=? WHERE customer_id=?");
            st.setString(1, Customer.getAddress());
            st.setString(2, Customer.getEmail());
            st.setString(3, Customer.getCustomer_name());
            st.setInt(4, Customer.getCustomer_id());
            System.out.println("Updated successfully");
            st.execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean deleteCustomer(int customer_id) {
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM Customer WHERE customer_id = " + customer_id);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
        System.out.println("Successfully Deleted Customer");
        return true;
    }

    public static Customer getCustomerById(int customer_id) {
        Customer customer = null;
        try (Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("SELECT * FROM customer WHERE customer_id = " + customer_id);
            ResultSet res = st.getResultSet();
            while (res.next()) {
                int id = res.getInt("customer_id");
                String address = res.getString("address");
                String email = res.getString("email");
                String customer_name = res.getString("customer_name");
                System.out.println("customer_id = " + customer_id + ", address = " + address + ", email = " + email
                        + ", customer_name = " + customer_name);
                customer = new Customer(id, address, email, customer_name);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return customer;
    }
}

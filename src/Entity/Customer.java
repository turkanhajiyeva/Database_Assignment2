package Entity;

public class Customer {
    private int customer_id;
    private String email;
    private String address;
    private String customer_name;

    public Customer() {
    }

    public Customer(int customer_id, String email, String address, String customer_name) {
        this.customer_id = customer_id;
        this.email = email;
        this.address = address;
        this.customer_name = customer_name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}

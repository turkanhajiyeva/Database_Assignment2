package Entity;

import java.sql.Date;

public class Orders {
    private int order_id;
    private int customer_id;
    private Date order_date;
    private int total_cost;

    public Orders() {
    }

    public Orders(int order_id, int customer_id, Date order_date, int total_cost) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.total_cost = total_cost;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", order_date=" + order_date +
                ", total_cost=" + total_cost +
                '}';
    }
}
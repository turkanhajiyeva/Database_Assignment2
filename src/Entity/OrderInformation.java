package Entity;

public class OrderInformation {
    private int order_id;
    private int book_id;

    public OrderInformation() {
    }

    public OrderInformation(int order_id, int book_id) {
        this.order_id = order_id;
        this.book_id = book_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "OrderInformation{" +
                "order_id=" + order_id +
                ", book_id=" + book_id +
                '}';
    }
}

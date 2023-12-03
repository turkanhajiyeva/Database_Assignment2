package Entity;

public class OrderInformation {
    private int order_id;
    private int book_id;
    private int orderedbooks;

    public OrderInformation() {
    }

    public OrderInformation(int order_id, int book_id, int orderedbooks) {
        this.order_id = order_id;
        this.book_id = book_id;
        this.orderedbooks = orderedbooks;
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

    public int getOrderedbooks() {
        return orderedbooks;
    }

    public void setOrderedbooks(int orderedbooks) {
        this.orderedbooks = orderedbooks;
    }

    @Override
    public String toString() {
        return "OrderInformation{" +
                "order_id=" + order_id +
                ", book_id=" + book_id +
                ", orderedbooks=" + orderedbooks +
                '}';
    }
}

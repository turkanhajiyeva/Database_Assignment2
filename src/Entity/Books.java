package Entity;

public class Books {
    private int book_id;
    private String title;
    private String genre;

    private int price;
    private int stock;
    private Authors author;
    private Customer customer;
    private Orders order;

    public Books() {

    }

    public Books(int book_id, String title, String genre, int price, int stock, Authors author, Customer customer, Orders order) {
        this.book_id = book_id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.stock = stock;
        this.author = author;
        this.customer = customer;
        this.order = order;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Orders getOrders() {
        return order;
    }

    public void setOrders(Orders orders) {
        this.order = orders;
    }



    public Books(int book_id, String title, String genre, int price, int stock) {
        this.book_id = book_id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.stock = stock;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", author=" + author +
                ", customer=" + customer +
                ", orders=" + order +
                '}';
    }
}

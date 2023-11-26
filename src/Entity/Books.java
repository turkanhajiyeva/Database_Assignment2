package Entity;

public class Books {
    private int book_id;
    private String title;
    private String genre;
    private int stock;
    private int price;
    public Books() {

    }
    public Books(int book_id, String title, String genre, int stock, int price) {
        this.book_id = book_id;
        this.title = title;
        this.genre = genre;
        this.stock = stock;
        this.price = price;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}



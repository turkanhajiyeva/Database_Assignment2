package Entity;

public class Authors {
    private int author_id;
    private String author_name;

    public Authors() {
    }

    public Authors(int author_id, String author_name) {
        this.author_id = author_id;
        this.author_name = author_name;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                '}';
    }
}



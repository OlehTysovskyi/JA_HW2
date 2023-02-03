package source;

public class Book {

    private int idbooks;
    private String book_name;

    private String author;

    private int pub_date;

    public Book(int idbooks, String book_name, String author, int pub_date) {
        this.idbooks = idbooks;
        this.book_name = book_name;
        this.author = author;
        this.pub_date = pub_date;
    }

    public Book(String book_name, String author, int pub_date) {
        this.book_name = book_name;
        this.author = author;
        this.pub_date = pub_date;
    }

    public int getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(int idbooks) {
        this.idbooks = idbooks;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPub_date() {
        return pub_date;
    }

    public void setPub_date(int pub_date) {
        this.pub_date = pub_date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idbooks=" + idbooks +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", pub_date=" + pub_date +
                '}';
    }
}

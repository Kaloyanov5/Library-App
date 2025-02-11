package src.model;

public class Book {
    private String title;
    private String author;
    private Integer isbn;
    private Integer yearPublished;

    public Book() {
    }

    public Book(String title, String author, Integer isbn, Integer yearPublished) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "\nTitle: " + this.title +
                "\nAuthor: " + this.author +
                "\nISBN: " + this.isbn +
                "\nYear: " + this.yearPublished;
    }
}

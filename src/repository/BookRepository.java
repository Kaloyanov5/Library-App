package src.repository;

import src.model.Book;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    boolean removeBook(Integer isbn);
    List<Book> findBookByTitle(String title);
    List<Book> findBookByAuthor(String author);
}

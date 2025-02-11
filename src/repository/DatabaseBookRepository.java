package src.repository;

import src.model.Book;

import java.util.List;

public class DatabaseBookRepository implements BookRepository{

    @Override
    public void addBook(Book book) {

    }

    @Override
    public boolean removeBook(Integer isbn) {
        return false;
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return List.of();
    }
}

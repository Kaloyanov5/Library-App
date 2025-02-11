package src.repository;

import src.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InMemoryBookRepository implements BookRepository {
    List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        for (Book b : books) {
            if (Objects.equals(b.getIsbn(), book.getIsbn())) {
                throw new IllegalArgumentException("A book with this ISBN already exists!");
            }
        }

        books.add(book);
    }

    @Override
    public boolean removeBook(Integer isbn) {
        try {
            for (Book b : books) {
                if (Objects.equals(b.getIsbn(), isbn)) {
                    books.remove(b);
                    return true;
                }
            }
            throw new IllegalArgumentException("Book does not exists in the library!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();

        books.forEach(book -> {
            if (book.getTitle().equals(title)) {
                foundBooks.add(book);
            }
        });
        return foundBooks;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        books.forEach(book -> {
            if (book.getAuthor().equals(author)) {
                foundBooks.add(book);
            }
        });
        return foundBooks;
    }
}

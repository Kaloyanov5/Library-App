package src.repository;

import src.model.Book;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseBookRepository implements BookRepository{
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private String dbDriver;

    public DatabaseBookRepository() {
        loadDatabaseConfig();
    }

    private void loadDatabaseConfig() {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream("db_config.properties");
            if (input == null) {
                throw new RuntimeException("Database config file not found in resources!");
            }

            Properties properties = new Properties();
            properties.load(input);

            this.dbUrl = properties.getProperty("db.url");
            this.dbUser = properties.getProperty("db.user");
            this.dbPassword = properties.getProperty("db.password");
            this.dbDriver = properties.getProperty("db.driver");

            Class.forName(dbDriver);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, year_published) VALUES (?, ?, ?)";
        try {
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getYearPublished());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeBook(Integer isbn) {
        String sql = "DELETE FROM books WHERE isbn = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, Integer.valueOf(isbn));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ?";

        try {
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, "%"+title+"%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                foundBooks.add(new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("isbn"),
                        rs.getInt("year_published")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundBooks;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE author LIKE ?";

        try {
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, "%"+author+"%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                foundBooks.add(new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("isbn"),
                        rs.getInt("year_published")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundBooks;
    }
}

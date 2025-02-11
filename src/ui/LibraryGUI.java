package src.ui;

import src.model.Book;
import src.repository.BookRepository;
import src.repository.DatabaseBookRepository;
import src.repository.InMemoryBookRepository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LibraryGUI extends JFrame {
    private BookRepository repository;

    private JTextField titleField, authorField, isbnField, yearField, searchField;
    private JTextArea outputArea;

    public LibraryGUI(BookRepository repository) {
        this.repository = repository;

        setTitle("Library System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Year:"));
        yearField = new JTextField();
        inputPanel.add(yearField);

        if (repository instanceof DatabaseBookRepository) {
            inputPanel.add(new JLabel("ISBN (FOR REMOVING ONLY):"));
        } else {
            inputPanel.add(new JLabel("ISBN:"));
        }
        isbnField = new JTextField();
        inputPanel.add(isbnField);

        JButton addButton = new JButton("Add Book");
        inputPanel.add(addButton);

        JButton removeButton = new JButton("Remove Book");
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        searchField = new JTextField(25);
        searchPanel.add(searchField);

        JButton searchTitleButton = new JButton("Search by Title");
        JButton searchAuthorButton = new JButton("Search by Author");
        searchPanel.add(searchTitleButton);
        searchPanel.add(searchAuthorButton);

        add(searchPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(scrollPane, BorderLayout.SOUTH);

        add(outputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addBook());
        removeButton.addActionListener(e -> removeBook());
        searchTitleButton.addActionListener(e -> searchBookByTitle());
        searchAuthorButton.addActionListener(e -> searchBookByAuthor());

        setVisible(true);
    }

    private void addBook() {
        try {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            Integer isbn;
            if (repository instanceof InMemoryBookRepository) {
                isbn = Integer.parseInt(isbnField.getText().trim());
            } else {
                isbn = 0;
            }
            Integer year = Integer.parseInt(yearField.getText().trim());

            Book book = new Book(title, author, isbn, year);
            repository.addBook(book);

            outputArea.setText("Book added: " + title);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeBook() {
        try {
            Integer isbn = Integer.parseInt(isbnField.getText());
            if (repository.removeBook(isbn)) {
                outputArea.setText("Book removed!");
            } else {
                throw new Exception("Book does not exist in the library!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error removing book!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchBookByTitle() {
        String searchText = searchField.getText().trim();
        java.util.List<Book> results = repository.findBookByTitle(searchText);
        displayResults(results);
    }

    private void searchBookByAuthor() {
        String searchText = searchField.getText().trim();
        java.util.List<Book> results = repository.findBookByAuthor(searchText);
        displayResults(results);
    }

    private void displayResults(List<Book> results) {
        if (results.isEmpty()) {
            outputArea.setText("No books found.");
        } else {
            outputArea.setText("Search Results:\n");
            for (Book book : results) {
                outputArea.append(book + "\n");
            }
        }
    }
}

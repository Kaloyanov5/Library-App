package src;

import src.repository.BookRepository;
import src.repository.DatabaseBookRepository;
import src.repository.InMemoryBookRepository;
import src.ui.LibraryGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] options = {"In Memory", "Database"};
        int choice = JOptionPane.showOptionDialog(
                null, "Choose Repository Type:",
                "Library System",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        );

        BookRepository repository = (choice == 0) ? new InMemoryBookRepository() : new DatabaseBookRepository();
        SwingUtilities.invokeLater(() -> new LibraryGUI(repository));
    }
}

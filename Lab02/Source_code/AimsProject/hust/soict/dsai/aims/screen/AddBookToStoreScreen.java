package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors; // Nhập authors cách nhau bằng dấu phẩy

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book");
    }

    @Override
    protected void addSpecificFields(JPanel panel, GridBagConstraints gbc, int startRow) {
        gbc.gridx = 0; gbc.gridy = startRow;
        panel.add(new JLabel("Authors (comma separated):"), gbc);
        gbc.gridx = 1;
        tfAuthors = new JTextField(15);
        panel.add(tfAuthors, gbc);
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());
            String authorsStr = tfAuthors.getText().trim();
            List<String> authors = Arrays.asList(authorsStr.split(","));
            Book book = new Book(title, category, cost);
            book.setAuthors(authors);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        tfAuthors.setText("");
    }
}
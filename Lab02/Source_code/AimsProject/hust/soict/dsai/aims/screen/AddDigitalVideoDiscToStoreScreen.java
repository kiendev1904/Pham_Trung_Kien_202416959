package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD");
    }

    @Override
    protected void addSpecificFields(JPanel panel, GridBagConstraints gbc, int startRow) {
        // Director
        gbc.gridx = 0; gbc.gridy = startRow;
        panel.add(new JLabel("Director:"), gbc);
        gbc.gridx = 1;
        tfDirector = new JTextField(15);
        panel.add(tfDirector, gbc);

        // Length
        gbc.gridx = 0; gbc.gridy = startRow + 1;
        panel.add(new JLabel("Length (minutes):"), gbc);
        gbc.gridx = 1;
        tfLength = new JTextField(15);
        panel.add(tfLength, gbc);
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());
            String director = tfDirector.getText().trim();
            int length = Integer.parseInt(tfLength.getText().trim());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format for Cost or Length", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        tfDirector.setText("");
        tfLength.setText("");
    }
}
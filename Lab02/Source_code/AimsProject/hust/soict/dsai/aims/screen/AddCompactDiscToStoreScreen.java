package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;
    private JTextArea taTracks; // Nhập tracks mỗi dòng: "title;length"

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD");
        setSize(500, 500);
    }

    @Override
    protected void addSpecificFields(JPanel panel, GridBagConstraints gbc, int startRow) {
        gbc.gridx = 0; gbc.gridy = startRow;
        panel.add(new JLabel("Artist:"), gbc);
        gbc.gridx = 1;
        tfArtist = new JTextField(15);
        panel.add(tfArtist, gbc);

        gbc.gridx = 0; gbc.gridy = startRow + 1;
        panel.add(new JLabel("Tracks (title;length per line):"), gbc);
        gbc.gridx = 1;
        taTracks = new JTextArea(5, 15);
        JScrollPane scroll = new JScrollPane(taTracks);
        panel.add(scroll, gbc);
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            float cost = Float.parseFloat(tfCost.getText().trim());
            String artist = tfArtist.getText().trim();

            CompactDisc cd = new CompactDisc(title, category, cost, artist);
            // Thêm tracks
            String[] lines = taTracks.getText().trim().split("\\n");
            for (String line : lines) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String trackTitle = parts[0].trim();
                    int trackLength = Integer.parseInt(parts[1].trim());
                    cd.addTrack(new Track(trackTitle, trackLength));
                }
            }
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format for Cost or Track length", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        tfArtist.setText("");
        taTracks.setText("");
    }
}
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("Add to cart");
        addToCartBtn.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(this, "Added to cart: " + media.getTitle());
        });
        container.add(addToCartBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(e -> {
                // Hiển thị dialog chơi media (sẽ xử lý exception)
                JDialog playDialog = new JDialog();
                playDialog.setTitle("Playing " + media.getTitle());
                playDialog.setSize(300, 200);
                playDialog.setLocationRelativeTo(this);
                JTextArea ta = new JTextArea("Playing: " + media.getTitle() + "\n");
                try {
                    ((Playable) media).play(); // play() có thể ném PlayerException
                    ta.append("Playback successful.");
                } catch (Exception ex) {
                    ta.append("Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
                playDialog.add(new JScrollPane(ta));
                playDialog.setVisible(true);
            });
            container.add(playBtn);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
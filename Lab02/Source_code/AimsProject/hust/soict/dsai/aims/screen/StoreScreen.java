package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("AIMS Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        JMenuItem viewCart = new JMenuItem("View Cart");
        JMenuItem updateStore = new JMenuItem("Update Store");
        JMenu updateStoreMenu = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");

        addBookItem.addActionListener(e -> new AddBookToStoreScreen(store).setVisible(true));
        addCDItem.addActionListener(e -> new AddCompactDiscToStoreScreen(store).setVisible(true));
        addDVDItem.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store).setVisible(true));

        updateStoreMenu.add(addBookItem);
        updateStoreMenu.add(addCDItem);
        updateStoreMenu.add(addDVDItem);
        menuBar.add(updateStoreMenu);
        menu.add(viewStore);
        menu.add(viewCart);
        menu.add(updateStore);
        menuBar.add(menu);

        // Thêm action listeners (tạm thời để console, sau sẽ nâng cấp)
        viewStore.addActionListener(e -> JOptionPane.showMessageDialog(this, "You are already in Store"));
        viewCart.addActionListener(e -> {
            // Sau này sẽ chuyển sang CartScreen (JavaFX)
            JOptionPane.showMessageDialog(this, "View Cart - will be implemented with JavaFX");
        });
        updateStore.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Update Store - will be implemented later");
        });

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartBtn = new JButton("View Cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));
        cartBtn.addActionListener(e -> {

            JOptionPane.showMessageDialog(this, "Open Cart Screen (JavaFX) later");
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2)); // 3x3, có thể thay đổi theo số lượng media

        ArrayList<Media> itemsInStore = store.getItemsInStore(); // giả sử Store có phương thức này
        for (Media media : itemsInStore) {
            center.add(new MediaStore(media, cart)); // sẽ tạo MediaStore
        }
        return center;
    }



}
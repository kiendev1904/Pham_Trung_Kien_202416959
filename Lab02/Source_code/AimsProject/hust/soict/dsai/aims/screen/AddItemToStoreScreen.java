package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;
    protected JButton btnAdd;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item to Store");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo menu bar (giống StoreScreen)
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        // Tạo panel chính với BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createFormPanel(), BorderLayout.CENTER);
        add(mainPanel);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        JMenuItem viewCart = new JMenuItem("View Cart");
        JMenuItem updateStore = new JMenuItem("Update Store");

        viewStore.addActionListener(e -> {
            // Mở lại StoreScreen (đóng màn hình hiện tại)
            new StoreScreen(store, new Cart()).setVisible(true);
            dispose();
        });
        viewCart.addActionListener(e -> {
            // Mở CartScreen (JavaFX)
            Cart cart = new Cart(); // Lấy cart thực tế từ đâu đó? Tạm thế
            new CartScreen(cart).setVisible(true);
        });
        updateStore.addActionListener(e -> {
            // Đã ở trong Update Store, có thể refresh
            JOptionPane.showMessageDialog(this, "You are already in Update Store");
        });
        menu.add(viewStore);
        menu.add(viewCart);
        menu.add(updateStore);
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Dòng 0: Title
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Title:"), gbc);
        gbc.gridx = 1;
        tfTitle = new JTextField(15);
        panel.add(tfTitle, gbc);

        // Dòng 1: Category
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        tfCategory = new JTextField(15);
        panel.add(tfCategory, gbc);

        // Dòng 2: Cost
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Cost:"), gbc);
        gbc.gridx = 1;
        tfCost = new JTextField(15);
        panel.add(tfCost, gbc);

        // Các trường riêng sẽ được thêm bởi lớp con (gọi addSpecificFields)
        addSpecificFields(panel, gbc, 3);

        // Nút Add
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        btnAdd = new JButton("Add to Store");
        btnAdd.addActionListener(e -> addItemToStore());
        panel.add(btnAdd, gbc);

        return panel;
    }

    // Phương thức abstract để lớp con thêm các trường riêng (director, length, etc.)
    protected abstract void addSpecificFields(JPanel panel, GridBagConstraints gbc, int startRow);

    // Phương thức abstract để tạo đối tượng Media và thêm vào store
    protected abstract void addItemToStore();
}
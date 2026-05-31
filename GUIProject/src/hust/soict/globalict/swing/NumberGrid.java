package hust.soict.globalict.swing; // hoặc hust.soict.dsai.swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        // Tạo text field hiển thị
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setEditable(true); // có thể cho phép gõ tay, nhưng lab thường để đọc

        // Tạo panel chứa các nút, dùng GridLayout 4 hàng, 3 cột
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        // Lấy content pane và thiết lập BorderLayout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 250);
        setVisible(true);
    }

    // Thêm các nút vào panelButtons
    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        // Các nút từ 1 đến 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Nút DEL
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Nút 0
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Nút C (Reset)
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    // Inner class xử lý sự kiện cho các nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String currentText = tfDisplay.getText();

            if (command.matches("[0-9]")) { // Nếu là số
                // Nếu currentText là "0" hoặc rỗng thì thay thế, else nối thêm
                if (currentText.equals("0") || currentText.isEmpty()) {
                    tfDisplay.setText(command);
                } else {
                    tfDisplay.setText(currentText + command);
                }
            } else if (command.equals("DEL")) {
                // Xóa ký tự cuối
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
                if (tfDisplay.getText().isEmpty()) {
                    tfDisplay.setText("0");
                }
            } else if (command.equals("C")) {
                // Xóa toàn bộ, hiển thị 0
                tfDisplay.setText("0");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberGrid());
    }
}
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        String[] options = {"Đồng ý", "Để sau", "Không bao giờ"};

        int response = JOptionPane.showOptionDialog(null, 
            "Bạn có muốn lưu bài tập không?", 
            "Tùy chọn lưu",
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.PLAIN_MESSAGE,
            null, 
            options, 
            options[0] 
        );

        if (response == 0) {
            JOptionPane.showMessageDialog(null, "Bạn đã chọn Đồng ý");
        } else if (response == 1) {
            JOptionPane.showMessageDialog(null, "Bạn đã chọn Để sau");
        } else if (response == 2) {
            JOptionPane.showMessageDialog(null, "Bạn đã chọn Không bao giờ");
        }

        System.exit(0);
    }
}
import javax.swing.JOptionPane;

public class second_degree {
    public static void main(String[] args) {
        String strA = JOptionPane.showInputDialog(null, "Nhập hệ số a:", "Giải phương trình bậc 2", JOptionPane.QUESTION_MESSAGE);
        String strB = JOptionPane.showInputDialog(null, "Nhập hệ số b:", "Giải phương trình bậc 2", JOptionPane.QUESTION_MESSAGE);
        String strC = JOptionPane.showInputDialog(null, "Nhập hệ số c:", "Giải phương trình bậc 2", JOptionPane.QUESTION_MESSAGE);

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);

        String result = "";

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result = "Phương trình có vô số nghiệm.";
                } else {
                    result = "Phương trình vô nghiệm.";
                }
            } else {
                double x = -c / b;
                result = "Phương trình bậc nhất có nghiệm: x = " + x;
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                result = "Phương trình vô nghiệm.";
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Phương trình có nghiệm kép: x1 = x2 = " + x;
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "Phương trình có 2 nghiệm phân biệt:\n" + "x1 = " + x1 + "\nx2 = " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}

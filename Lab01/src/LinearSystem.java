import javax.swing.JOptionPane;

public class LinearSystem {
    public static void main(String[] args) {
        String strA11, strA12, strB1, strA21, strA22, strB2;
        String strNotification = "";

        strA11 = JOptionPane.showInputDialog(null, "a11:", "a11*x1 + a12*x2 = b1", JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(strA11);
        strA12 = JOptionPane.showInputDialog(null, "a12:", "a11*x1 + a12*x2 = b1", JOptionPane.INFORMATION_MESSAGE);
        double a12 = Double.parseDouble(strA12);
        strB1 = JOptionPane.showInputDialog(null, "b1:", "a11*x1 + a12*x2 = b1", JOptionPane.INFORMATION_MESSAGE);
        double b1 = Double.parseDouble(strB1);

        strA21 = JOptionPane.showInputDialog(null, "a21:", "a21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        double a21 = Double.parseDouble(strA21);
        strA22 = JOptionPane.showInputDialog(null, "a22:", "a21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        double a22 = Double.parseDouble(strA22);
        strB2 = JOptionPane.showInputDialog(null, "b2:", "a21*x1 + a22*x2 = b2", JOptionPane.INFORMATION_MESSAGE);
        double b2 = Double.parseDouble(strB2);

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            strNotification = "The system has a unique solution: x1 = " + x1 + " and x2 = " + x2;
        } else {
            if (D1 == 0 && D2 == 0) {
                strNotification = "The system has infinitely many solutions.";
            } else {
                strNotification = "The system has no solution.";
            }
        }

        JOptionPane.showMessageDialog(null, strNotification, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
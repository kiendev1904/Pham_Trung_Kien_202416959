import javax.swing.JOptionPane;

public class SecondDegreeEquation {
    public static void main(String[] args) {
        String strA, strB, strC;
        String strNotification = "";

        strA = JOptionPane.showInputDialog(null, "Input a:", "Equation: ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);
        strB = JOptionPane.showInputDialog(null, "Input b:", "Equation: ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strB);
        strC = JOptionPane.showInputDialog(null, "Input c:", "Equation: ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(strC);

        if (a == 0) {
            
            if (b == 0) {
                if (c == 0) {
                    strNotification = "Infinitely many solutions.";
                } else {
                    strNotification = "No solution.";
                }
            } else {
                strNotification = "Linear equation result: x = " + (-c / b);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                strNotification = "The equation has two distinct roots: x1 = " + x1 + " and x2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                strNotification = "The equation has a double root: x = " + x;
            } else {
                strNotification = "The equation has no real root.";
            }
        }

        JOptionPane.showMessageDialog(null, strNotification, "Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
import javax.swing.JOptionPane;

public class LinearEquation {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = ""; 

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the number for a: ", "Equation: ax + b = 0",
                JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the number for b: ", "Equation: ax + b = 0",
                JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strNum2);

     
        if (a == 0) {
            if (b == 0) {
                strNotification = "The equation has infinitely many solutions (Vô số nghiệm).";
            } else {
                strNotification = "The equation has no solution (Vô nghiệm).";
            }
        } else {
            double x = -b / a;
            strNotification = "The equation has one solution: x = " + x;
        }

        JOptionPane.showMessageDialog(null, strNotification, 
                "Result", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}
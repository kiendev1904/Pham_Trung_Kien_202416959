import javax.swing.JOptionPane;

public class DoubleNumber {
    public static void main(String[] args) {
        String strNum1, strNum2;
        
       
        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        
        
        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        
       
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        

        String strNotification = "Results:\n" +
                                 "Sum: " + sum + "\n" +
                                 "Difference: " + difference + "\n" +
                                 "Product: " + product + "\n";
        
        
        if (num2 != 0) {
            strNotification += "Quotient: " + (num1 / num2);
        } else {
            strNotification += "Quotient: Cannot divide by zero";
        }

        JOptionPane.showMessageDialog(null, strNotification, 
                "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}
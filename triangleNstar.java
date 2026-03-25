package week1;
import java.util.Scanner;
public class triangleNstar {
    public static void main(String[] args) {
        System.out.println("Input: ");
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();

        for( int i = 0; i < n; i++){
            for( int j = 1; j < n - i; j++){
                System.out.print(" ");
            }
            for( int k = 0; k < 2 * i + 1; k++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        keyboard.close();
    }
}


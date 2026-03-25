import java.util.Arrays;
import java.util.Scanner;

public class Sortarray {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter number of elements (n): ");
        int n = keyboard.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = keyboard.nextInt(); 
        }

        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        double average = (double) sum / n;
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);
        
        keyboard.close();
    }
}

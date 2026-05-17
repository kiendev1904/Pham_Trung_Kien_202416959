// ConcatenationInLoops.java
package hust.soict.dsai.garbage;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        // Using + operator
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 100000; i++) {
            str += "a";
        }
        long end = System.currentTimeMillis();
        System.out.println("Using + operator: " + (end - start) + " ms");

        // Using StringBuilder
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("Using StringBuilder: " + (end - start) + " ms");

        // Using StringBuffer (synchronized, slower but thread-safe)
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sbf.append("a");
        }
        end = System.currentTimeMillis();
        System.out.println("Using StringBuffer: " + (end - start) + " ms");
    }
}
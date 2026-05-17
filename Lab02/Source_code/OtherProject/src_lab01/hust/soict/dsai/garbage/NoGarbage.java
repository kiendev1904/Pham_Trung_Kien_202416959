// NoGarbage.java
package hust.soict.dsai.garbage;

import java.io.FileInputStream;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "largefile.dat";
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                // Dùng StringBuilder append thay vì +, không tạo đối tượng thừa
                sb.append(new String(buffer, 0, bytesRead));
            }
            System.out.println("Done without garbage issues. Length: " + sb.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
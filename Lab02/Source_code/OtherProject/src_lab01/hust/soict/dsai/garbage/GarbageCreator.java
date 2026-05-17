// GarbageCreator.java
package hust.soict.dsai.garbage;

import java.io.FileInputStream;
import java.io.IOException;

public class GarbageCreator {
    public static void main(String[] args) {
        // Thay đường dẫn bằng file lớn (VD: 100MB)
        String filename = "largefile.dat"; // bạn cần tạo file này hoặc chỉnh đường dẫn
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            String s = "";
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                // Chuyển byte thành String và nối bằng + => tạo nhiều đối tượng
                s += new String(buffer, 0, bytesRead);
                // Nếu file rất lớn, chương trình sẽ chậm dần và có thể treo do GC
            }
            System.out.println("Done (but may cause OutOfMemoryError or hang)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
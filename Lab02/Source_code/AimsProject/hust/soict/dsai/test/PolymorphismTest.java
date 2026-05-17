package hust.soict.dsai.test;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;

public class PolymorphismTest {
    public static void main(String[] args) {
        // Tạo một ArrayList kiểu Media (lưu được mọi đối tượng con của Media)
        ArrayList<Media> mediaList = new ArrayList<>();

        // 1. DigitalVideoDisc
        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Sci-Fi", "Nolan", 148, 22.95f);
        mediaList.add(dvd);

        // 2. Book
        Book book = new Book();
        book.setId(2);
        book.setTitle("Effective Java");
        book.setCategory("Programming");
        book.setCost(45.99f);
        book.addAuthor("Joshua Bloch");
        book.addAuthor("John Doe"); // test thêm tác giả
        mediaList.add(book);

        // 3. CompactDisc
        CompactDisc cd = new CompactDisc();
        cd.setId(3);
        cd.setTitle("Abbey Road");
        cd.setCategory("Rock");
        cd.setCost(18.99f);
        cd.setArtist("The Beatles");
        cd.setDirector("George Martin");
        // Thêm các track
        Track t1 = new Track("Come Together", 259);
        Track t2 = new Track("Something", 182);
        cd.addTrack(t1);
        cd.addTrack(t2);
        mediaList.add(cd);

        // 4. Một Disc thuần (nếu muốn minh họa, nhưng Disc là abstract nên không khởi tạo trực tiếp)
        // Thay vào đó, thêm một DVD khác
        DigitalVideoDisc anotherDVD = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 136, 19.99f);
        mediaList.add(anotherDVD);

        // In ra tất cả các media (tính đa hình thể hiện qua phương thức toString())
        System.out.println("=== Danh sách Media trong cửa hàng (Polymorphism) ===\n");
        for (Media m : mediaList) {
            // Mặc dù biến tham chiếu kiểu Media, nhưng toString() được gọi là phiên bản của lớp thực tế
            System.out.println(m.toString());
            System.out.println("---");
        }

        // Thử gọi phương thức play() nếu media implement Playable (dùng instanceof)
        System.out.println("\n=== Playable Media ===");
        for (Media m : mediaList) {
            if (m instanceof Playable) {
                System.out.println("Playing: " + m.getTitle());
                ((Playable) m).play(); // ép kiểu để gọi play()
                System.out.println();
            }
        }
    }
}
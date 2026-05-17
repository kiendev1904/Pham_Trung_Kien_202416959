package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo cửa hàng
        Store myStore = new Store();

        // Tạo một số DVD mẫu (giả sử lớp hust.soict.dsai.aims.media.DigitalVideoDisc có các constructor phù hợp)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Jungle Book", "Animation", "Wolfgang Reitherman", 78, 14.95f);

        // Thêm DVD vào store
        System.out.println("--- Adding DVDs ---");
        myStore.addMedia(dvd1);
        myStore.addMedia(dvd2);
        myStore.addMedia(dvd3);
        myStore.addMedia(dvd4);

        // In cửa hàng sau khi thêm
        myStore.printStore();

        // Xóa một DVD
        System.out.println("\n--- Removing 'Star Wars' ---");
        myStore.removeMedia(dvd2);

        // In lại cửa hàng sau khi xóa
        myStore.printStore();

        // Thử xóa một DVD không có trong store
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 22.95f);
        System.out.println("\n--- Trying to remove a DVD not in store ---");
        myStore.removeMedia(dvd5);

        // Thử thêm DVD khi store đầy (không cần test với MAX=100, nhưng có thể thêm vòng lặp để minh họa)
        // (nếu cần, có thể tạo thêm DVD và thêm đến khi đầy)
        System.out.println("\n--- hust.soict.dsai.aims.store.Store status at end ---");
        myStore.printStore();
    }
}
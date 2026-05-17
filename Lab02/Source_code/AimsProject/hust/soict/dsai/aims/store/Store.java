package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    // Sử dụng ArrayList<Media> thay cho mảng DigitalVideoDisc[]
    private ArrayList<Media> itemsInStore;
    // Không cần qtyStored và MAX_NUMBERS_STORED vì ArrayList tự quản lý kích thước

    // Constructor khởi tạo ArrayList
    public Store() {
        itemsInStore = new ArrayList<>();
    }

    // Phương thức thêm Media vào cửa hàng (thay cho addDVD)
    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add null media.");
            return;
        }
        itemsInStore.add(media);
        System.out.println("Media \"" + media.getTitle() + "\" has been added to the store.");
    }

    // Phương thức xóa Media khỏi cửa hàng (thay cho removeDVD)
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" not found in the store.");
        }
    }

    // In ra tất cả Media trong cửa hàng (cập nhật để dùng toString của Media)
    public void printStore() {
        System.out.println("*********************** STORE ***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media m = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + m.toString());
            }
        }
        System.out.println("******************************************************");
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

}
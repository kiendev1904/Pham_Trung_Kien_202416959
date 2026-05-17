package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    // Thuộc tính: mảng lưu các DVD trong cửa hàng
    private DigitalVideoDisc[] itemsInStore;
    private int qtyStored;           // số lượng DVD hiện có
    public static final int MAX_NUMBERS_STORED = 100; // sức chứa tối đa

    // Constructor khởi tạo mảng
    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_STORED];
        qtyStored = 0;
    }

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyStored < MAX_NUMBERS_STORED) {
            itemsInStore[qtyStored] = dvd;
            qtyStored++;
            System.out.println("DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Phương thức xóa DVD khỏi cửa hàng (dựa trên đối tượng)
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyStored; i++) {
            if (itemsInStore[i] == dvd) {
                // Dịch các phần tử phía sau lên trước
                for (int j = i; j < qtyStored - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyStored - 1] = null;
                qtyStored--;
                found = true;
                System.out.println("DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("DVD \"" + dvd.getTitle() + "\" not found in the store.");
        }
    }

    // Phương thức in ra tất cả DVD trong cửa hàng (dùng để test)
    public void printStore() {
        System.out.println("*********************** STORE ***********************");
        if (qtyStored == 0) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < qtyStored; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].getTitle());
            }
        }
        System.out.println("******************************************************");
    }
}
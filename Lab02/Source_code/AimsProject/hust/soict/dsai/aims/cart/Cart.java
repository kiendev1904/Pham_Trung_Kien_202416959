package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    // --- Thêm media (có thể thêm 1 hoặc nhiều) ---
    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) {
            if (media == null) {
                System.out.println("Cannot add null media.");
                continue;
            }
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        }
    }

    // --- Xoá media ---
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media not found.");
        }
    }

    // --- Tổng tiền ---
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // --- In giỏ hàng chi tiết (gọi toString() của từng media) ---
    public void print() {
        System.out.println("*********************** CART ***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media m = itemsOrdered.get(i);
            System.out.printf("%d. %s\n", i + 1, m.toString());
        }
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("****************************************************");
    }

    // --- Tìm kiếm theo id ---
    public Media searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found: " + m.toString());
                return m;
            }
        }
        System.out.println("No media found with id = " + id);
        return null;
    }

    // --- Tìm kiếm theo title (chính xác) ---
    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + m.toString());
                return m;
            }
        }
        System.out.println("No media found with title: " + title);
        return null;
    }

    // --- Sắp xếp theo title (tuỳ chọn) ---
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getTitle));
        System.out.println("Cart sorted by title.");
    }

    // --- Sắp xếp theo cost (tuỳ chọn) ---
    public void sortByCost() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getCost));
        System.out.println("Cart sorted by cost.");
    }

    // --- (Giữ lại phương thức printCart cũ nếu muốn) ---
    public void printCart() {
        print(); // gọi lại phương thức print mới
    }
    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title (then cost descending).");
    }

    // Sắp xếp theo cost rồi title
    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost descending (then title).");
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
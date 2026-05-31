package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor mặc định
    public Media() {
        super();
    }

    // Constructor có tham số (tuỳ chọn)
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative!");
        }
        this.cost = cost;
    }
    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            Comparator.comparing(Media::getTitle)
                    .thenComparing(Media::getCost, Comparator.reverseOrder());

    // Comparator: by cost descending, then title ascending
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            Comparator.comparing(Media::getCost, Comparator.reverseOrder())
                    .thenComparing(Media::getTitle);

}
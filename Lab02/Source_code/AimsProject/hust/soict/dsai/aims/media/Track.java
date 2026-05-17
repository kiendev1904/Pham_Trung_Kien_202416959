package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructors
    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    @Override
    public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Setters (tuỳ chọn)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Override equals để kiểm tra trùng track (dùng trong contains)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && title.equals(track.title);
    }
    @Override
    public String toString() {
        return "Track [title=" + title + ", length=" + length + " sec]";
    }
}
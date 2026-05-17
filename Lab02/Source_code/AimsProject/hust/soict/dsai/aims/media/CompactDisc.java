package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    // Constructor
    public CompactDisc() {
        super();
        tracks = new ArrayList<>();
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        tracks = new ArrayList<>();
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Number of tracks: " + tracks.size());
        for (Track track : tracks) {
            track.play();
        }
    }
    // Getter for artist (only)
    public String getArtist() {
        return artist;
    }

    // Setter for artist (có thể thêm nếu cần)
    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Methods addTrack and removeTrack
    public void addTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot add null track.");
            return;
        }
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD [id=").append(getId())
                .append(", title=").append(getTitle())
                .append(", category=").append(getCategory())
                .append(", cost=").append(getCost())
                .append(", artist=").append(artist)
                .append(", tracks=[");
        for (int i = 0; i < tracks.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(tracks.get(i).getTitle());
        }
        sb.append("]]");
        return sb.toString();
    }

    // Override getLength() to sum track lengths
    @Override
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }

    // Optional: display info
    public void displayInfo() {
        System.out.println("CD - " + getTitle() + " - " + getCategory() + " - Artist: " + artist);
        System.out.println("Tracks: ");
        for (Track track : tracks) {
            System.out.println("  - " + track.getTitle() + ": " + track.getLength() + " sec");
        }
        System.out.println("Total length: " + getLength() + " sec");
        System.out.println("Cost: " + getCost() + " $");
    }
}
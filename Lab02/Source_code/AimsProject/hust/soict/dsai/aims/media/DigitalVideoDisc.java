package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc() {
		super();
		setId(++nbDigitalVideoDiscs);
	}

	public DigitalVideoDisc(String title) {
		super();
		setId(++nbDigitalVideoDiscs);
		setTitle(title);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		setId(++nbDigitalVideoDiscs);
		setTitle(title);
		setCategory(category);
		setDirector(director);
		setCost(cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		setId(++nbDigitalVideoDiscs);
		setTitle(title);
		setCategory(category);
		setDirector(director);
		setLength(length);
		setCost(cost);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		setId(++nbDigitalVideoDiscs);
		setTitle(title);
		setCategory(category);
		setCost(cost);
	}
	@Override
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		System.out.println("Playing DVD: " + getTitle());
		System.out.println("DVD length: " + getLength());
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("Length cannot be negative!");
		}
		this.length = length;
	}

	@Override
	public String toString() {
		return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
	}

	public boolean isMatch(String keyword) {
		return getTitle().toLowerCase().contains(keyword.toLowerCase());
	}
}
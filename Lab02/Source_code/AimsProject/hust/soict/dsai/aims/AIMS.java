import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;

public class AIMS {
	public static void main(String[] args) {
		Cart cart = new Cart();

		DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 120, 19.99f);
		Book book = new Book(2, "Clean Code", "Programming", 45.99f);
		CompactDisc cd = new CompactDisc();
		cd.setTitle("Thriller");
		cd.setArtist("Michael Jackson");
		Track t1 = new Track("Billie Jean", 294);
		Track t2 = new Track("Beat It", 258);
		cd.addTrack(t1);
		cd.addTrack(t2);

		cart.addMedia(dvd);
		cart.addMedia(book);
		cart.addMedia(cd);

		cart.printCart();

		// Play tests
		dvd.play();
		cd.play();
		t1.play();
	}
}
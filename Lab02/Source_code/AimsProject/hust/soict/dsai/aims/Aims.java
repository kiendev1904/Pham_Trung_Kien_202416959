package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Tạo dữ liệu mẫu cho cửa hàng
		initStore();

		while (true) {
			showMenu();
			int choice = getIntInput(0, 3);
			switch (choice) {
				case 1:
					viewStore();
					break;
				case 2:
					updateStore();
					break;
				case 3:
					seeCurrentCart();
					break;
				case 0:
					System.out.println("Exiting AIMS. Goodbye!");
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void initStore() {
		// Thêm một số DVD, Book, CD vào store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Nolan", 148, 22.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 136, 19.99f);
		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("Effective Java");
		book1.setCategory("Programming");
		book1.setCost(45.99f);
		book1.addAuthor("Joshua Bloch");
		Book book2 = new Book();
		book2.setId(2);
		book2.setTitle("Clean Code");
		book2.setCategory("Programming");
		book2.setCost(39.99f);
		book2.addAuthor("Robert C. Martin");
		CompactDisc cd1 = new CompactDisc();
		cd1.setId(3);
		cd1.setTitle("Abbey Road");
		cd1.setCategory("Rock");
		cd1.setCost(18.99f);
		cd1.setArtist("The Beatles");
		cd1.setDirector("George Martin");
		Track t1 = new Track("Come Together", 259);
		Track t2 = new Track("Something", 182);
		cd1.addTrack(t1);
		cd1.addTrack(t2);

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(book1);
		store.addMedia(book2);
		store.addMedia(cd1);
	}

	// ---------- Menu chính ----------
	public static void showMenu() {
		System.out.println("\nAIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2-3: ");
	}

	// ---------- View store ----------
	private static void viewStore() {
		store.printStore(); // hiển thị danh sách media trong store
		while (true) {
			storeMenu();
			int choice = getIntInput(0, 4);
			switch (choice) {
				case 1:
					seeMediaDetails();
					break;
				case 2:
					addMediaToCartFromStore();
					break;
				case 3:
					playMediaFromStore();
					break;
				case 4:
					seeCurrentCart(); // hiển thị giỏ hàng và cart menu
					return; // sau khi xem giỏ, quay lại store menu? Theo logic, chọn 4 sẽ "See current cart" nhưng không có chỉ dẫn quay lại store ngay. Thực tế nên quay lại store menu sau khi xử lý cart. Ở đây ta sẽ quay lại store menu sau khi người dùng back từ cart.
				case 0:
					return; // back to main menu
				default:
					System.out.println("Invalid choice.");
			}
		}
	}

	public static void storeMenu() {
		System.out.println("\nOptions: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2-3-4: ");
	}

	private static void seeMediaDetails() {
		System.out.print("Enter the title of the media: ");
		String title = scanner.nextLine();
		Media media = findMediaInStore(title);
		if (media == null) {
			System.out.println("Media not found in store.");
			return;
		}
		System.out.println(media.toString());
		mediaDetailsMenu(media);
	}

	private static void mediaDetailsMenu(Media media) {
		while (true) {
			System.out.println("\nOptions: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1-2: ");
			int choice = getIntInput(0, 2);
			switch (choice) {
				case 1:
					cart.addMedia(media);
					System.out.println("Current cart has " + cart.getItemsOrdered().size() + " item(s).");
					return;
				case 2:
					if (media instanceof Playable) {
						((Playable) media).play();
					} else {
						System.out.println("This media cannot be played.");
					}
					return;
				case 0:
					return;
			}
		}
	}

	private static void addMediaToCartFromStore() {
		System.out.print("Enter the title of the media to add to cart: ");
		String title = scanner.nextLine();
		Media media = findMediaInStore(title);
		if (media == null) {
			System.out.println("Media not found.");
			return;
		}
		cart.addMedia(media);
		System.out.println("Current cart has " + cart.getItemsOrdered().size() + " item(s).");
	}

	private static void playMediaFromStore() {
		System.out.print("Enter the title of the media to play: ");
		String title = scanner.nextLine();
		Media media = findMediaInStore(title);
		if (media == null) {
			System.out.println("Media not found.");
			return;
		}
		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media cannot be played.");
		}
	}

	private static Media findMediaInStore(String title) {
		for (Media m : store.getItemsInStore()) {
			if (m.getTitle().equalsIgnoreCase(title)) {
				return m;
			}
		}
		return null;
	}

	// ---------- Update store ----------
	private static void updateStore() {
		System.out.println("\nUpdate Store:");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");
		System.out.print("Choose: ");
		int choice = getIntInput(0, 2);
		switch (choice) {
			case 1:
				addMediaToStore();
				break;
			case 2:
				removeMediaFromStore();
				break;
			case 0:
				return;
		}
	}

	private static void addMediaToStore() {
		System.out.println("Select type of media to add:");
		System.out.println("1. DigitalVideoDisc");
		System.out.println("2. Book");
		System.out.println("3. CompactDisc");
		System.out.print("Choice: ");
		int type = getIntInput(1, 3);
		try {
			switch (type) {
				case 1:
					System.out.print("Enter title: ");
					String title = scanner.nextLine();
					System.out.print("Enter category: ");
					String category = scanner.nextLine();
					System.out.print("Enter director: ");
					String director = scanner.nextLine();
					System.out.print("Enter length (min): ");
					int length = Integer.parseInt(scanner.nextLine());
					System.out.print("Enter cost: ");
					float cost = Float.parseFloat(scanner.nextLine());
					DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
					store.addMedia(dvd);
					break;
				case 2:
					System.out.print("Enter title: ");
					title = scanner.nextLine();
					System.out.print("Enter category: ");
					category = scanner.nextLine();
					System.out.print("Enter cost: ");
					cost = Float.parseFloat(scanner.nextLine());
					Book book = new Book();
					book.setTitle(title);
					book.setCategory(category);
					book.setCost(cost);
					// Có thể thêm tác giả nếu muốn
					System.out.print("Enter authors (comma separated): ");
					String authorsLine = scanner.nextLine();
					if (!authorsLine.trim().isEmpty()) {
						for (String name : authorsLine.split(",")) {
							book.addAuthor(name.trim());
						}
					}
					store.addMedia(book);
					break;
				case 3:
					System.out.print("Enter title: ");
					title = scanner.nextLine();
					System.out.print("Enter category: ");
					category = scanner.nextLine();
					System.out.print("Enter artist: ");
					String artist = scanner.nextLine();
					System.out.print("Enter director: ");
					director = scanner.nextLine();
					System.out.print("Enter cost: ");
					cost = Float.parseFloat(scanner.nextLine());
					CompactDisc cd = new CompactDisc();
					cd.setTitle(title);
					cd.setCategory(category);
					cd.setArtist(artist);
					cd.setDirector(director);
					cd.setCost(cost);
					// Thêm track (có thể bỏ qua để đơn giản)
					store.addMedia(cd);
					break;
			}
			System.out.println("Media added to store.");
		} catch (Exception e) {
			System.out.println("Invalid input. Media not added.");
		}
	}

	private static void removeMediaFromStore() {
		System.out.print("Enter title of media to remove: ");
		String title = scanner.nextLine();
		Media media = findMediaInStore(title);
		if (media != null) {
			store.removeMedia(media);
		} else {
			System.out.println("Media not found.");
		}
	}

	// ---------- Cart handling ----------
	private static void seeCurrentCart() {
		cart.printCart(); // hiển thị giỏ hàng
		while (true) {
			cartMenu();
			int choice = getIntInput(0, 5);
			switch (choice) {
				case 1:
					filterCart();
					break;
				case 2:
					sortCart();
					break;
				case 3:
					removeMediaFromCart();
					break;
				case 4:
					playMediaFromCart();
					break;
				case 5:
					placeOrder();
					return; // sau khi place order, quay lại main menu
				case 0:
					return; // back to previous menu
				default:
					System.out.println("Invalid choice.");
			}
		}
	}

	public static void cartMenu() {
		System.out.println("\nOptions: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2-3-4-5: ");
	}

	private static void filterCart() {
		System.out.println("Filter by:");
		System.out.println("1. ID");
		System.out.println("2. Title");
		System.out.print("Choice: ");
		int choice = getIntInput(1, 2);
		if (choice == 1) {
			System.out.print("Enter ID: ");
			int id = Integer.parseInt(scanner.nextLine());
			Media found = null;
			for (Media m : cart.getItemsOrdered()) {
				if (m.getId() == id) {
					found = m;
					break;
				}
			}
			if (found != null) {
				System.out.println("Found: " + found.toString());
			} else {
				System.out.println("No media with ID " + id + " in cart.");
			}
		} else {
			System.out.print("Enter title (or part): ");
			String title = scanner.nextLine().toLowerCase();
			ArrayList<Media> matches = new ArrayList<>();
			for (Media m : cart.getItemsOrdered()) {
				if (m.getTitle().toLowerCase().contains(title)) {
					matches.add(m);
				}
			}
			if (matches.isEmpty()) {
				System.out.println("No matching media.");
			} else {
				System.out.println("Matching media:");
				for (Media m : matches) {
					System.out.println(m.toString());
				}
			}
		}
	}

	private static void sortCart() {
		System.out.println("Sort by:");
		System.out.println("1. Title (then cost descending)");
		System.out.println("2. Cost descending (then title)");
		System.out.print("Choice: ");
		int choice = getIntInput(1, 2);
		if (choice == 1) {
			cart.sortByTitleThenCost();
		} else {
			cart.sortByCostThenTitle();
		}
		cart.printCart(); // hiển thị sau khi sort
	}

	private static void removeMediaFromCart() {
		System.out.print("Enter title of media to remove: ");
		String title = scanner.nextLine();
		Media toRemove = null;
		for (Media m : cart.getItemsOrdered()) {
			if (m.getTitle().equalsIgnoreCase(title)) {
				toRemove = m;
				break;
			}
		}
		if (toRemove != null) {
			cart.removeMedia(toRemove);
		} else {
			System.out.println("Media not found in cart.");
		}
	}

	private static void playMediaFromCart() {
		System.out.print("Enter title of media to play: ");
		String title = scanner.nextLine();
		Media media = null;
		for (Media m : cart.getItemsOrdered()) {
			if (m.getTitle().equalsIgnoreCase(title)) {
				media = m;
				break;
			}
		}
		if (media == null) {
			System.out.println("Media not found in cart.");
			return;
		}
		if (media instanceof Playable) {
			((Playable) media).play();
		} else {
			System.out.println("This media cannot be played.");
		}
	}

	private static void placeOrder() {
		System.out.println("Order created. Your cart will be emptied.");
		cart.getItemsOrdered().clear(); // xóa giỏ hàng
		System.out.println("Cart is now empty.");
	}

	// ---------- Helper ----------
	private static int getIntInput(int min, int max) {
		while (true) {
			try {
				int value = Integer.parseInt(scanner.nextLine());
				if (value >= min && value <= max) return value;
				else System.out.print("Please enter a number between " + min + " and " + max + ": ");
			} catch (NumberFormatException e) {
				System.out.print("Invalid input. Enter a number: ");
			}
		}
	}
}
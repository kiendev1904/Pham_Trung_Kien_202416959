public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2, dvd3);

        DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
        cart.addDigitalVideoDisc(dvdList);

        cart.removeDigitalVideoDisc(dvd2);
        System.out.println("Total cost after removing Star Wars: " + cart.totalCost());
        cart.printCart();
        cart.searchById(1);
        cart.searchByTitle("Aladdin");
        cart.searchByTitle("Star Wars");

    }
}

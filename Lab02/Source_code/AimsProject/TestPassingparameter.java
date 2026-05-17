public class TestPassingparameter {

    public static void main(String[] args) {
        DigitalVideoDisc[] dvds = new DigitalVideoDisc[2];
        dvds[0] = new DigitalVideoDisc("Jungle");
        dvds[1] = new DigitalVideoDisc("Cinderella");
        swap(dvds, 0, 1);
        System.out.println("After swapping: dvds[0] = " + dvds[0].getTitle() + ", dvds[1] = " + dvds[1].getTitle());


    }
    public static void swap(DigitalVideoDisc[] arr, int i, int j) {
        DigitalVideoDisc temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
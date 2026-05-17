public class TestPassingparameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");


        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Real swap in Java");
        DigitalVideoDisc[] dvds = new DigitalVideoDisc[2];
        dvds[0] = new DigitalVideoDisc("Jungle");
        dvds[1] = new DigitalVideoDisc("Cinderella");
        swap(dvds, 0, 1);
        System.out.println("jungle dvd title: " + dvds[0].getTitle());
        System.out.println("cinderella dvd title: " + dvds[1].getTitle());
    }


    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }


    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
    public static void swap(DigitalVideoDisc[] arr, int i, int j) {
        DigitalVideoDisc temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
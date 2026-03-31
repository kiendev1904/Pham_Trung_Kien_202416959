package model;

public class Bird extends Animal {

	public Bird() {
		super("Bird");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		System.out.println("Toi an sau");
	}

	@Override
	public void makeSound() {
		System.out.println("liu lo");
	}
	

}

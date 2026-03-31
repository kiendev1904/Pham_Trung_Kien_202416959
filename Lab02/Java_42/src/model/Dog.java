package model;

public class Dog extends Animal {
	public Dog() {
		super("Dog");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		System.out.println("Toi an xuong");
	}

	@Override
	public void makeSound() {
		System.out.println("Gau Gau");
	}
	
}

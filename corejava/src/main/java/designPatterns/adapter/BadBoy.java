package designPatterns.adapter;

public class BadBoy implements Person{

	private String name;
	
	public BadBoy(String name) {
		this.name = name;
	}

	public void act() {
		System.out.println("I'm acting as a bad boy.");
	}

	public String getName() {
		return name;
	}

}

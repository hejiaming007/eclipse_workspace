package designPatterns.adapter;

public class GoodBoy implements Person{

	private String name;
	
	public GoodBoy(String name) {
		this.name = name;
	}

	public void act() {
		System.out.println("I'm acting as a good boy.");
	}

	public String getName() {
		return name;
	}

}

package designPatterns.listener;

public class ListenerPatternHelloworld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Baby baby = new Baby();
		baby.addListener(new BabySisterListener());
		baby.addListener(new MotherListener());
		
		
		baby.cry();
		
		
	}

}

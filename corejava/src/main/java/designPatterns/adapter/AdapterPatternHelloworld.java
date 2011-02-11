package designPatterns.adapter;

public class AdapterPatternHelloworld {

	public static void main(String[] args) {

		Person boy = new GoodBoy("Jimmy");
		
		new BadClub(getBadBoyAdapter(boy));
		
		new GoodClub(getGoodBoyAdapter(boy));
		
		new BadClub(getBadBoyAdapter(boy));
	}
	
	public static GoodBoy getGoodBoyAdapter(Person boy){
		return new GoodBoy(boy.getName());
	}
	
	public static BadBoy getBadBoyAdapter(Person boy){
		return new BadBoy(boy.getName());
	}
	
	
}

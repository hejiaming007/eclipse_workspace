package interfaze.sample.interfaze;

public interface IEnhancedAnimal extends IAnimal {
	
	
	//Get food is a new added method for the IAnimal Interface.
	//For don't want to change all implement of the IAnimal, so add a new extend interface for this solution.
	public String getFood();
	
}

package interfaze.sample;

import interfaze.sample.impl.Cat;
import interfaze.sample.impl.Cow;
import interfaze.sample.interfaze.IAnimal;

public class AnimalManager {

	public static IAnimal getAnimal(){
		//If the implement is still under development, you can return null directly, and
		//Let the interface can take effect first.
		//return null;      !@#
		
		
		return new Cow();
	}
	
}

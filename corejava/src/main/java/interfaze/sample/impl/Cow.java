package interfaze.sample.impl;

import interfaze.sample.interfaze.IEnhancedAnimal;

public class Cow implements IEnhancedAnimal {

	public String getFood() {
		return "grass";
	}

	public String shout() {
		return "Muu Muu";
	}

}

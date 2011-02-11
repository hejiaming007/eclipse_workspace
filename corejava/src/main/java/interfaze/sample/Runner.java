package interfaze.sample;

import java.util.ArrayList;
import java.util.List;

import interfaze.sample.interfaze.IAnimal;
import interfaze.sample.interfaze.IEnhancedAnimal;




/**
 * @author hejiaming
 * This class use the interface to work. don't care about whether the implementation of the interface
 * is exist.
 */



public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Runner();
	}
	
	public Runner(){
		run();
	}
	
	public void run(){
	
		IAnimal animal = AnimalManager.getAnimal();
		
		//adjust whether the interface is enhanced interface.!@# 
		if( animal instanceof IEnhancedAnimal){
			String food = ((IEnhancedAnimal) animal).getFood();
			System.out.println(food);
			
		}
		
		System.out.println(animal.shout());
	}
	
}

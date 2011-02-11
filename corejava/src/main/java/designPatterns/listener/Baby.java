package designPatterns.listener;

import java.util.ArrayList;
import java.util.List;

public class Baby {
	
	List<BabyListener> listeners = new ArrayList<BabyListener>();
	
	
	public void addListener(BabyListener listener) {
		// TODO Auto-generated method stub
		listeners.add(listener);
//		this.listener = listener;
		
	}
	
	public void cry() {
		System.out.println("Baby is crying..\n");

		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).handleCry();
		}
		
	}
	
}

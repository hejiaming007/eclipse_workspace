package corejava.thread.synchronization.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadHelloworld {

	static List list = new ArrayList();
	static List list2 = Collections.synchronizedList(new ArrayList());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		list = 
		
		Thread t1 = new Thread(new MyThread("t1"));
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.add("1");
	}

}

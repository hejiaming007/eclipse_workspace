package corejava.thread.synchronization.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FailFastHelloworld {

	static List list = new ArrayList();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		list.add("1");
		list.add("2");
		Iterator itr = list.iterator();
		list.remove(0);
		itr.next();// will throw java.util.ConcurrentModificationException
		
//		
//		Thread t1 = new Thread(new MyThread("t1"));
//		Thread t2 = new Thread(new MyThread("t2"));
//		t1.start();
//		t2.start();
	}

}

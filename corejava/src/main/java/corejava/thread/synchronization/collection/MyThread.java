package corejava.thread.synchronization.collection;

import org.apache.commons.lang.math.RandomUtils;

public class MyThread implements Runnable {

	String threadName;
	
	public MyThread(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		int old_size = ThreadHelloworld.list.size();
		ThreadHelloworld.list.add("1");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ThreadHelloworld.list.size() != old_size + 1){
			System.out.println("List Synchronization Error.");
		}
		
	}

}

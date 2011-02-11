package corejava.thread;

public class ThreadDeathHelloworld{

	public static void main(String[] args) throws InterruptedException {
		try {
			System.out.println("Main thread start");
			Thread1 t1 = new Thread1();
			t1.start();
			Thread.sleep(2000);
			Thread2 t2 = new Thread2(t1);
			t2.start();
			t1.join(); //Main wait for thread1
			System.out.println("Main thread end");
		} catch (Throwable t) {
			System.err.println("Exception: " + t);
		}
	}

	
	static class Thread1 extends Thread {
		private String header = "		  ";
		public Thread1() {
			super("Thread1");
		};
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(header + threadName + " thread start.");
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println(header + threadName + " loop at " + (i+1));
					Thread.sleep(1000);
				}
				System.out.println(header + threadName + " thread end.");
			} catch (Throwable t) {
				System.err.println(header + "Error: " + t);
			}
		}
	}
	
	
	static class Thread2 extends Thread {
		private String header = "						";
		Thread t1 = null;
		public Thread2(Thread thread) {//pass t1 to t2 as constructor parameter
			super("Thread2");
			this.t1 = thread;
		};
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(header + threadName + " thread start.");
			try {
				t1.stop();
				for (int i = 0; i < 5; i++) {
					System.out.println(header + threadName + " loop at " + (i+1));
					Thread.sleep(1000);
					
				}
				System.out.println(header + threadName + " thread end.");
			} catch (Throwable t) {
				System.err.println(header + "Exception: " + t);
			}
		}
	}
	
}

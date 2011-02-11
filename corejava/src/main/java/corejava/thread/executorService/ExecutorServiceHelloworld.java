package corejava.thread.executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;



public class ExecutorServiceHelloworld {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(10);

		es.awaitTermination(1, TimeUnit.SECONDS);
		
		Future<?> feature = es.submit(new RunnableThread2(new RunnableThread1(), new Result()));
		
		System.out.println("After submit...");
//		feature1.cancel(true);
//		System.out.println("Thread1 result:" + feature1.get().getName());
		
		
	}
	
}


class RunnableThread1 implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end");
		
	}
}

class RunnableThread2 extends FutureTask<Result> {
	
	public RunnableThread2(Runnable runnable, Result result) {
		super(runnable, result);
		result.setName("jimmy");
		// TODO Auto-generated constructor stub
	}


	
}

class Result {
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

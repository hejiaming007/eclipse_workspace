package spring.ioc;

public class BeanB {

	static {
		System.out.println("initializating B.");
	}
	
	private static BeanB b = new BeanB();
	
	public static BeanB getInstance(){
		return b;
	}
	
	public void sayHelloB(){
		System.out.println("B saying Hello");
	}
	
	
	
}

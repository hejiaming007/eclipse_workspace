package designPatterns.singleton;

public class SingletonPatternHelloworld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FooManager mgr1, mgr2;
		
		mgr1 = FooManager1.getInstance();
		mgr2 = FooManager1.getInstance();
		System.out.println(mgr1 == mgr2);
		
		mgr1 = FooManager2.getInstance();
		mgr2 = FooManager2.getInstance();
		System.out.println(mgr1 == mgr2);
		
		
		
		
	}

}

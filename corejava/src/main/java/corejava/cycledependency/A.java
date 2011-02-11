package corejava.cycledependency;

public class A {

	B b = new B();

	public static void main(String[] args) {
		//Exception in thread "main" java.lang.StackOverflowError
		//Exception thrown when a stack overflow occurs because an application recurses too deeply.
		new A();
	}
}


class B {
	A a = new A();
}
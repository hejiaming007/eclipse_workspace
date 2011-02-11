/**
 * 
 */
package corejava.innerclass;

import java.lang.reflect.Method;

import javassist.Modifier;

/**
 * @author hejiaming
 * 
 */
public class MyClass {

	class SubClass {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// No enclosing instance of type MyClass is accessible. Must
		// qualify the allocation with an enclosing instance of type
		// MyClass (e.g. x.new A() where x is an instance of
		// MyClass).
		//SubClass c = new SubClass();
		
		//Following is the correct way to new inner class object
		MyClass a = new MyClass();
		MyClass.SubClass b1 = a.new SubClass();
		SubClass b2 = a.new SubClass();   //<---this way is also ok.
		
		
		//All methods defined in interface are implicitly modified by public and abstract
		Method[] methods = IMyClass.class.getMethods();
		for (Method method : methods) {
			System.out.println("method name:"+method.getName());
			int modifier = method.getModifiers();
			System.out.println("is public:"+Modifier.isPublic(modifier));//true
			System.out.println("is abstract:"+Modifier.isAbstract(modifier));//true
		}
		
	}

}

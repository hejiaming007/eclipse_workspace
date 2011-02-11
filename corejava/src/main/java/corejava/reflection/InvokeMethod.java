package corejava.reflection;

import java.lang.reflect.Method;

public class InvokeMethod {

	/**
	 * @param args
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws Exception {

		String str = new String("Jimmy");

		//call charAt() return char, actually return java.lang.Character
		Method method = null;
		method = str.getClass().getMethod("charAt", new Class[]{Integer.TYPE});
		System.out.println(method.invoke(str, new Object[]{new Integer(2)}).getClass());
		char c = (Character)method.invoke(str, new Object[]{new Integer(2)});
		System.out.println("char:"+c);
		
		
		//call length() return int, acutally return java.lang.Integer
		method = str.getClass().getMethod("length", new Class[]{}); //parameter types can be null
		int l = (Integer)method.invoke(str, new Object[]{}); //parameter types can be null
		System.out.println("length:"+l);
		
		
		InvokeMethod instance = new InvokeMethod();
		
		method = instance.getClass().getMethod("sayHello", new Class[]{String.class}); //parameter types can be null
		String message = null;
		try {
			message = (String)method.invoke(instance, new Object[]{"Jimmy"}); //parameter types can be null
		} catch (Exception e) {
			//Here, e is java.lang.reflect.InvocationTargetException. e has its stack trace.
			e.printStackTrace();
		}
		System.out.println(message);
		
		
	}
	
	
	public String sayHello(String person) throws Exception{
		System.out.println(person + " say hello!");
		if(true){
			throw new Exception("sayHello occur exception");
		}
		return person + " say hello!";
		
	}

}

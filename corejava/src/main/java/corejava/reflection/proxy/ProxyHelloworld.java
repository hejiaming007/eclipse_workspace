package corejava.reflection.proxy;

import java.beans.EventHandler;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHelloworld {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 InvocationHandler handler = EventHandler.create(InvocationHandler.class, "getName", "");
	    Class proxyClass = Proxy.getProxyClass(
	    		User.class.getClassLoader(), new Class[] { IUser.class });
	    
//	    Proxy.newProxyInstance(loader, interfaces, h);
	    System.out.println(Proxy.isProxyClass(proxyClass));
	    System.out.println(Proxy.isProxyClass(Integer.class));
	    
	    
	    Constructor constructor = proxyClass.getConstructor(new Class[] { InvocationHandler.class });
	    System.out.println("constructor:"+constructor);
	    
	    
	    Method[] methods = proxyClass.getMethods();
	    for (int i = 0; i < methods.length; i++) {
	    	System.out.println("metho:"+i+":"+methods[i]);
		}
	    Method  method = proxyClass.getMethod("getName", new Class[]{});
	    System.out.println("method:"+method);
	    
	    
	    //Register the handler to the proxyClass
	    constructor.newInstance(new Object[] { handler });
	    
	     
	    handler.invoke(proxyClass, method, new Object[]{});
	    
//	    System.out.println(proxyClass.getClass());
	    
//	    User user = new User("jimmy");

	    
//	    Integer f = (Integer) proxyClass.
//	         getConstructor(new Class[] { String.class }).
//	         newInstance(new Object[] { handler });
	 
	}
}



 class MyInvocationHandler implements InvocationHandler{

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		
		
		
		String methodName = method.getName();
        // Handle the Object public methods.
        if (methodName.equals("getName"))  {
            return new Integer(System.identityHashCode(proxy));   
        }
        
		System.out.println("invoking...proxy:"+proxy+" method:"+method+" args:"+args.length);
		//method.invoke(new Object[]{});
//		System.out.println(method.getName());
		
//		method.invoke(proxy, )
		
		// TODO Auto-generated method stub
		return null;
	}
	 
 }

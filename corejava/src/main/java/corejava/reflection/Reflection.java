package corejava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Reflection {

	/**
	 * @param args
	 * @throws NoSuchMethodException 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		String className = "java.lang.Integer";
		
		// TODO Auto-generated method stub
		Constructor constructor = Class.forName(className).getConstructor(new Class[]{String.class});
		Integer integer = (Integer)constructor.newInstance(new Object[]{"22"});
		System.out.println(integer);
		
		System.out.println(Modifier.isPublic(constructor.getModifiers()));
		
		
		Field field = Class.forName(className).getField("MAX_VALUE");
		System.out.println(field.getName());
		
		
	}

}

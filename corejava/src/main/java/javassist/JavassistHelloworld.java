package javassist;

public class JavassistHelloworld {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClassPool pool = ClassPool.getDefault();
		
		
		/*
		 * Prohibited package name: java.lang
		 * */
		//CtClass StringClass = pool.getCtClass("java.lang.Object");
		
		
		CtClass cc = pool.get("javassist.SampleClass");
		CtMethod[] methods = cc.getMethods();

		// javassist.CtBehavior.getSignature();
		// cc.toBytecode();
		for (CtMethod ctMethod : methods) {
			if(ctMethod.getName().equals("getName")){
				ctMethod.insertBefore("System.out.println(\"hejiaming\");");//AOP sample
				
			}
			if(ctMethod.getName().equals("getSex")){
				ctMethod.setBody(" return \"female\";  "); //Change method logic sample
			}
		}
		
		CtField field = cc.getField("name");
		// field.setName("name2");   //Change field sample
		
		cc.toClass();//save to the class.
		
		SampleClass sc = new SampleClass();
		System.out.println(sc.getName());
		System.out.println(sc.getSex());

		
		
	}

}

class SampleClass {

	private String name = "Jimmy";
	
	public String getName() {
		return name;
	}
	
	public String getSex(){
		return "male";
	}
	
	

}

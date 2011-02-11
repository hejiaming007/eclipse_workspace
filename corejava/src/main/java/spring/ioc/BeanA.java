package spring.ioc;


public class BeanA {
	
	String message;
	
	String strValue;
	
	BeanB subObject;
	
	
	static {
		System.out.println("initializating A.");
	}
	
	
	public BeanB getSubObject() {
		return subObject;
	}


	public void setSubObject(BeanB subObject) {
		this.subObject = subObject;
	}


	public String getStrValue() {
		return strValue;
	}


	public void setStrValue(String name) {
		this.strValue = name;
	}


	public BeanA(String message) {
		super();
		this.message = message;
		// TODO Auto-generated constructor stub
	}


	public void sayHello(){
		System.out.println(message + " " + getStrValue());
		subObject.sayHelloB();
	}
	
	
	
}




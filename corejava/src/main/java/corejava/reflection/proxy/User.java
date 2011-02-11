package corejava.reflection.proxy;

public class User implements IUser {

	private String name;
	
	public User(String name){
		this.name = name;
	}
	
	public String getName() {
		System.out.println("User: getName()");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

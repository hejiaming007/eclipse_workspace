package spring.jmx;

public class JmxBean {

	public JmxBean(){
		System.out.println("Init JmxBean.");
	}
	
	private String name;
	private int age;
	private boolean isSuperman;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int add(int x, int y) {
		return x + y;
	}

	public void dontExposeMe() {
		throw new RuntimeException();
	}
}

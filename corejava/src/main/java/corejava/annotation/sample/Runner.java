package corejava.annotation.sample;

import java.lang.annotation.Annotation;

public class Runner {

	@Test(id = 1, value = "abc")
	public void test() {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runner runner = new Runner();
		Annotation[] annotation;

		try {
			annotation = runner.getClass().getMethod("test").getAnnotations();

			System.out.println(annotation.length);
			for (Annotation tag : annotation) {
				System.out.println("Tag is:" + tag);
				System.out.println("tag.name()" + ((Test) tag).value());
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

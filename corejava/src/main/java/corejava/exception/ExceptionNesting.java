package corejava.exception;

public class ExceptionNesting {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		ExceptionNesting inst = new ExceptionNesting();
		try {
			inst.m1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void m1() throws Exception {
		try {
			m2();
		} catch (Exception e) {
			throw new Exception("Message wrap 4 times.",e);
		}
	}
	
	public void m2() throws Exception{
		try {
			m3();
		} catch (Exception e) {
			throw new Exception("Message wrap 3 times.",e);
		}
	}
	
	public void m3() throws Exception{
		try {
			m4();
		} catch (Exception e) {
			throw new Exception("Message wrap twice.",e);
		}
	}
	
	public void m4() throws Exception{
		try {
			m5();
		} catch (Exception e) {
			throw new Exception("Message wrap once.",e);
		}
	}
	
	public void m5() throws Exception{
		m6();
	}
	
	public void m6() throws Exception{
		m7();
	}
	
	public void m7() throws Exception{
		System.out.println(1/0);//throw java.lang.ArithmeticException: / by zero here.
		
	}
	
}

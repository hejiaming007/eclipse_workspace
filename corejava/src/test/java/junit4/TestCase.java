package junit4;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.JUnitCore;


public class TestCase {

	String str = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	//If there's multiple @Before method, call sequence is uncertain.
	@Before
	public void setUp2() throws Exception {
		str = new String("2");
		System.out.println("setUp2");
	}
	
	@Before
	public void setUp1() throws Exception {
		str = new String("1");
		System.out.println("setUp1");
	}
	

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}
	
	@Test
	public void aaa(){
		Assert.assertEquals(1, str);
	}
	
	@Test(expected = ArithmeticException.class)   
	public void divisionWithException() {   
	    int i = 1/0;
	}  
	
	public static void main(String[] args){
		JUnitCore.runClasses(TestCase.class);
	}
	

}

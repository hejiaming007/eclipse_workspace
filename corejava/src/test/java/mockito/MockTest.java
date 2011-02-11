/**
 * 
 */
package mockito;

import java.util.List;

import org.mockito.Mockito;

/**
 * @author hejiaming
 *
 */
public class MockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List mockList = Mockito.mock(List.class);
		
		Mockito.when(mockList.get(0)).thenReturn("one");
		/*
		mockList.add("one");
		mockList.clear();
		
		
		Mockito.verify(mockList).add("one");
		Mockito.verify(mockList).clear();
		*/
		
		System.out.println(mockList.get(0));
		System.out.println(mockList.get(1));
		
		System.out.println(Mockito.verify(mockList).get(0));
		System.out.println(Mockito.verify(mockList).get(1));
		
		
	}

}

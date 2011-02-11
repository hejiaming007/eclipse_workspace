package memory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class MemoryAllocate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		try {
			
			for(int i = 0;;i++){
				String s = "aaa";
				list.add(s);
//				Thread.sleep(5);
//				System.out.println(i);
			}
		} catch (Throwable t) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			t.printStackTrace(pw);

			System.out.println(sw.toString());
			
		}
		System.out.println(list.size());
		//25764983
		
		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
//		System.out.println("total memory:"+Runtime.getRuntime().totalMemory());
//		 System.out.println("free memory:"+Runtime.getRuntime().freeMemory());
//		 String s = "aaa";
//		 System.out.println("free memory:"+Runtime.getRuntime().freeMemory());
	}

}

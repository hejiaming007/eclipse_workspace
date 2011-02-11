package benchmark;

import org.apache.commons.lang.ArrayUtils;
import org.hsqldb.lib.ArrayUtil;

public class Loop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 100000000;
		
		long start, end;
		start = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			
		}
		end = System.currentTimeMillis();
		
		System.out.println("for takes "+ (end - start) + "(ms)");
		
		///////////////////////////////
		
		start = System.currentTimeMillis();
		int i = 0;
		while(i < count) {
			i++;
		}
		end = System.currentTimeMillis();
		
		System.out.println("while takes "+ (end - start) + "(ms)");
		
		
	}

}

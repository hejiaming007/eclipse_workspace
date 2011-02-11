package memory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Sizeof

{

	public static void main(String[] args) throws Exception

	{

		// Warm up all classes/methods we will use

		runGC();

		usedMemory();

		// Array to keep strong references to allocated objects

		final int count = 100000;

		Object[] objects = new Object[count];

		long heap1 = 0;

		// Allocate count+1 objects, discard the first one

		for (int i = -1; i < count; ++i)

		{

			Object object = null;

			// Instantiate your data here and assign it to object

			object = new Object();

			List list = new ArrayList();
			try {
				
				for(int j = 0; j < 1100;j++){
					String s = "aaaaaaaa11";
					list.add(s);
//					Thread.sleep(5);
//					System.out.println(i);
				}
			} catch (Throwable t) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				t.printStackTrace(pw);

				System.out.println(sw.toString());
				
			}
			object = list;
			
			
			
			
			if (i >= 0)

				objects[i] = object;

			else

			{

				object = null; // Discard the warm up object

				runGC();

				heap1 = usedMemory(); // Take a before heap snapshot

			}

		}

		runGC();

		long heap2 = usedMemory(); // Take an after heap snapshot:

		final int size = Math.round(((float) (heap2 - heap1)) / count);

		System.out.println("'before' heap: " + heap1 +

		", 'after' heap: " + heap2);

		System.out.println("heap delta: " + (heap2 - heap1) +

		", {" + objects[0].getClass() + "} size = " + size + " bytes");

		for (int i = 0; i < count; ++i)
			objects[i] = null;

		objects = null;

	}

	private static void runGC() throws Exception

	{

		// It helps to call Runtime.gc()

		// using several method calls:

		for (int r = 0; r < 4; ++r)
			_runGC();

	}

	private static void _runGC() throws Exception

	{

		long usedMem1 = usedMemory(), usedMem2 = Long.MAX_VALUE;

		for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++i)

		{

			s_runtime.runFinalization();

			s_runtime.gc();

			Thread.currentThread().yield();

			usedMem2 = usedMem1;

			usedMem1 = usedMemory();

		}

	}

	private static long usedMemory()

	{

		return s_runtime.totalMemory() - s_runtime.freeMemory();

	}

	private static final Runtime s_runtime = Runtime.getRuntime();

} // End of class

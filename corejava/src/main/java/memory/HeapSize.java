package memory;

public class HeapSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		
		long maxM = runtime.maxMemory();
		long totalM = runtime.totalMemory();
		long freeM = runtime.freeMemory();
		
		System.out.println("max memory:"+maxM);
		System.out.println("total memory:"+totalM);
		System.out.println("free memory:"+freeM);
		
		
		
		
	}

}

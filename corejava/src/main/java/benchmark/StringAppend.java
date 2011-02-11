package benchmark;

//import bb.util.Benchmark;

public class StringAppend {

	/**
	 * pay attention to several things that can change results of tests :
	 * JVM warmup : Due to several parameters, the code is first often slow and becomes faster and faster when the execution time grows until it goes to steady-state.
	 * Class loading : The first time you launch a benchmark, all the used classes must be loaded, increasing the execution time.
	 * Just In Time Compiler : When the JVM identify a hot part of the code
	 * Garbage Collector : A garbage collection can happen during the benchmark and with that the time can increase a lot.
	 * 
	 * please refer to: http://www.ellipticgroup.com/html/benchmarkingArticle.html
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Runnable runnableStringAdd = new Runnable(){

			public void run() {
				String str = "";
				int count = 1000;
				for (int i = 0; i < count; i++) {
					str = str + "a";
				}
			}
        };

		
		
        Runnable runnableStringAppend = new Runnable(){

			public void run() {
				StringBuffer str = new StringBuffer(1000);
				int count = 1000;
				for (int i = 0; i < count; i++) {
					str.append("a");
				}
			}
        };
		
		
//		System.out.println("String directly append takes "+ (end - start) + "(ms)");
		
		///////////////////////////////
		
        try {
//            Benchmark intBenchmark = new Benchmark(runnableStringAdd);
 
            System.out.println("Result with String add: ");
//            System.out.println(intBenchmark.toString());
 
//            Benchmark shortBenchmark = new Benchmark(runnableStringAppend);
 
            System.out.println("Result with String append ");
//            System.out.println(shortBenchmark.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        //Result with String add: 
        //first = 2.759 ms, mean = 1.091 ms (CI deltas: -7.827 us, +10.826 us), sd = 1.155 ms (CI deltas: -272.214 us, +548.741 us) WARNING: execution times have mild outliers, execution times may have serial correlation, SD VALUES MAY BE INACCURATE
        //Result with String append 
        //first = 199.352 us, mean = 17.963 us (CI deltas: -35.361 ns, +43.750 ns), sd = 39.633 us (CI deltas: -7.665 us, +10.919 us) WARNING: execution times have mild outliers, SD VALUES MAY BE INACCURATE

		
	}

}

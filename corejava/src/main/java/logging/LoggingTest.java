package logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingTest {
	
	//LogFactory is from org.apache.commons.logging
	private static Log log = LogFactory.getLog(LoggingTest.class);

	public void test() {
		
		System.out.println(log.getClass());
		
		log.debug(" 111 ");
		log.info(" 222 ");
		log.warn(" 333 ");
		log.error(" 444 ", new Exception("my Exception"));
		log.fatal(" 555 ");
	}

	public static void main(String[] args) {
		LoggingTest testLog = new LoggingTest();
		testLog.test();
	}
	
}
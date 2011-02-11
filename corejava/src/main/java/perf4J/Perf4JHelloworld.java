package perf4J;

import logging.LoggingTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

public class Perf4JHelloworld {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// note that the log4j framework will automatically load the log4j.xml
        // file if it is in a root directory on the classpath

		Log rootLogger = LogFactory.getLog(Perf4JHelloworld.class);
//        Logger rootLogger = Logger.getRootLogger();

        for (int i = 0; i < 50; i++) {
            // By default the Log4JStopWatch uses the Logger named org.perf4j.TimingLogger
            StopWatch stopWatch = new Log4JStopWatch();

            // for demo purposes just sleep
            Thread.sleep((long) (Math.random() * 100L));

            rootLogger.info("Normal logging messages only go to the console");

            // Calling lap() stops timing for the previous block, sends the
            // message to the log4j Logger, and starts timing the next block.
            stopWatch.lap("firstBlock");

            Thread.sleep((long) (Math.random() * 200L));

            stopWatch.stop("secondBlock");
        }



	}

}

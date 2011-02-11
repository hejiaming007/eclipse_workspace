/**
 * 
 */
package logging.slf4j;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hejiaming
 *
 */
public class Slf4jTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
		//use placeholders to replace parameter
		String name = "jimmy";
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("orange");
		list.add("banner");
		
		//This is not a effective way, because for the second one, if debug level is off, still need to construction the string first.
		//string append, list to string cost time.
		//and this kind of construction is useless and not the best way of logging.
		logger.debug("Hello " + name + ", you have:" + list.toString());
		
		//Even re-work to this, still not the best way, although no need pre-construct the string.
		//But need to check if debug level is enable twice.
		if(logger.isDebugEnabled()){
			logger.debug("Hello " + name + ", you have:" + list.toString());
		}
		
		//Best approach is like this:
		logger.debug("Hello {}, you have:{}", name, list);
		
		
		long startTime;
		
		//But for the best approach, it's helplessness if the value need long time to query.
		startTime = System.currentTimeMillis();
		logger.debug("Hello {}", getNameFromDB());
		System.out.println("Duration of logger.debug(\"Hello {}\", getNameFromDB());:"+ (System.currentTimeMillis()-startTime)/1000);
		
		
		//for this case, check if log level is available first.
		startTime = System.currentTimeMillis();
		if(logger.isDebugEnabled()){
			logger.debug("Hello {}", getNameFromDB());
		}
		System.out.println("Duration of logger.debug(\"Hello {}\", getNameFromDB());:"+ (System.currentTimeMillis()-startTime)/1000);
	}
	
	/**
	 * get name via long-time call, like read from Database.
	 * @return
	 */
	public static String getNameFromDB(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jimmy";
	}

}

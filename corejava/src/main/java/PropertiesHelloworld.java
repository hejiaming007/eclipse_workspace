import java.io.File;

import org.apache.commons.configuration.PropertiesConfiguration;


public class PropertiesHelloworld {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("F:/workspaces/eclipse_workspace/corejava/src/main/resources/testdb.properties");
		PropertiesConfiguration config = new PropertiesConfiguration(file);
		config.setAutoSave(true);
		System.out.println("before:"+config.getProperty("sql.enforce_strict_size"));
		config.setProperty("sql.enforce_strict_size", "true");
		System.out.println("after:"+config.getProperty("sql.enforce_strict_size"));
		
		
	}

}

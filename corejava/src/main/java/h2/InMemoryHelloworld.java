package h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InMemoryHelloworld {

	/**
	 * In memory mode wont' persist any data to file system, all in memory
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.h2.Driver");
		Statement stat = null;
		ResultSet result = null;
		Connection conn = null, conn2 = null;
		conn = DriverManager.getConnection("jdbc:h2:mem:;" +
				"INIT=" +
				"RUNSCRIPT FROM 'ddl/workflow-schema.ddl'" +
				"\\;RUNSCRIPT FROM 'ddl/signon-schema.ddl'" +
				"\\;RUNSCRIPT FROM 'ddl/security-service-db-schema.ddl'" +
				"\\;RUNSCRIPT FROM 'ddl/security-init-data.sql'" +
				"");
		
		stat = conn.createStatement();
		result = stat.executeQuery("select * from SEC_PRINCIPALS");
		while(result.next()){
			System.out.println(result.getString("full_path"));
		}
		
		
		conn2 = DriverManager.getConnection("jdbc:h2:mem:");//another db instance, not the above one
		stat = conn2.createStatement();
		try {
			result = stat.executeQuery("select * from SEC_PRINCIPALS");
		} catch (org.h2.jdbc.JdbcSQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //Exception here, because it's already another database and no record.
		}
		
		
		
		
	}

}

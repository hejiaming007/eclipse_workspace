package h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmbededHelloworld {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.h2.Driver");
		Statement stat = null;
		ResultSet result = null;
		Connection conn = null, conn2 = null;
//		Connection conn = DriverManager.getConnection("jdbc:h2:mem;" +
//				"INIT=" +
//				"RUNSCRIPT FROM 'ddl/workflow-schema.ddl'" +
//				"\\;RUNSCRIPT FROM 'ddl/signon-schema.ddl'" +
//				"\\;RUNSCRIPT FROM 'ddl/security-service-db-schema.ddl'" +
//				"\\;RUNSCRIPT FROM 'ddl/security-init-data.sql'" +
//				"");
//		
//		Statement stat = conn.createStatement();
//		ResultSet result = stat.executeQuery("select * from SEC_PRINCIPALS");
//		while(result.next()){
//			System.out.println(result.getString("full_path"));
//		}
		
		conn2 = DriverManager.getConnection("jdbc:h2:mem:");
		
		stat = conn2.createStatement();
		result = stat.executeQuery("select * from SEC_PRINCIPALS");
		while(result.next()){
			System.out.println(result.getString("full_path"));
		}
		
		System.out.println(conn.hashCode());
		System.out.println(conn2.hashCode());
		
//		for (int i = 0;; i++) {
//			System.out.println(i);
//			DriverManager.getConnection("jdbc:h2:mem");
//		}
		
		
	}

}

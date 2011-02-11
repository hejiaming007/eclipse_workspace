package hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqlHelloworld {

	/**
	 * HSQL : Hyper Sonic sql Database
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (Exception e) {
			System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}

		// Connection c =
		// DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "sa",
		// "");
		try {

			// The database home is under this project's root folder: xxx/testdb
			Connection conn = DriverManager.getConnection(
					"jdbc:hsqldb:file:hsqldb_script/testdb", "sa", "");
			conn.createStatement();
			Statement st = null;

			ResultSet rs = null;

			int result = 0;

			// String createTableSQL =
			// "CREATE TABLE sample_table ( id INTEGER IDENTITY, str_col VARCHAR(256), num_col INTEGER)";
			String insertRecordSQL = "INSERT INTO sample_table(str_col,num_col) VALUES('Ford', 100)";
			String queryRecordSQL = "SELECT * FROM sample_table";

			st = conn.createStatement(); // statements
			//			
			//			
			// result = st.executeUpdate(createTableSQL); // run the query
			// if (result == -1) {
			// System.out.println("db error : " + createTableSQL);
			// }
			//	        
			//	        
			result = st.executeUpdate(insertRecordSQL); // run the query
			if (result == -1) {
				System.out.println("db error : " + insertRecordSQL);
			}

			// st.close();

			st = conn.createStatement(); // statement objects can be reused with
			// repeated calls to execute but we
			// choose to make a new one each time
			rs = st.executeQuery(queryRecordSQL); // run the query

			ResultSetMetaData meta = rs.getMetaData();
			int colmax = meta.getColumnCount();
			int i;
			Object o = null;
			for (; rs.next();) {
				for (i = 0; i < colmax; ++i) {
					o = rs.getObject(i + 1); // Is SQL the first column is
												// indexed

					// with 1 not 0
					System.out.print(o.toString() + " ");
				}

				System.out.println(" ");
			}

			// do something with the result set.
			st.close(); // NOTE!! if you close a statement the associated
						// ResultSet is
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

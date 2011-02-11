package spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class DataSourceTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = applicationContext.getBean("simpleJdbcDao", UserDao.class);

		
		System.out.println("rowCount:"+dao.getUserCountByName("Jimmy"));

		List<User> users = dao.getAllUsers();
		System.out.println(users);
		
		dao.addUser(new User(3, "Parker"));
		
		//Check all record:
		users = dao.getAllUsers();
		System.out.println(users);
		
	}
	
	
	

}

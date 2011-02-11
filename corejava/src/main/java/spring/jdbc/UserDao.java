/**
 * 
 */
package spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

/**
 * UserDao Object
 * 
 * @author hejiaming
 *
 */
public class UserDao extends SimpleJdbcDaoSupport {
	
	public List<User> getAllUsers (){
		return getJdbcTemplate().query("select ID, NAME from sample_table", new UserMapper());
	}
	
	public int addUser(User user){
		return getJdbcTemplate().update("insert into sample_table (id, name) values (?,?)", user.getId(), user.getName());
	}
	
	public int getUserCountByName(String name){
		return getJdbcTemplate().queryForInt("SELECT count(1) FROM sample_table where name = ?", name);
	}
	
}


class UserMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("ID"));
		user.setName(rs.getString("NAME"));
		return user;
	}
	
}
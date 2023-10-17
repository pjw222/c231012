package c231017.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class TestUserDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public TestUserDAO (DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void drop() {
		jdbcTemplate.execute("drop table users");
	}
	public void create() {
		jdbcTemplate.execute("create table users (\r\n"
				+ " id number generated as identity primary key,\r\n"
				+ " name varchar2(20),\r\n"
				+ " user_id varchar2(50) not null,\r\n"
				+ " password varchar2(64) not null\r\n"
				+ ")"
				);
	}
//	public void add(UserInterface user) throws SQLException {
//		jdbcTemplate.update("insert into users (name, user_id, password) values (?,?,?)", user.getName(),
//				user.getUserId(), user.getPassword());
//
//	}
//	public void delete(int id) throws SQLException{
//		jdbcTemplate.update("delete from users where id=?", id);
//	}
//
//	public UserInterface get(String userId) throws SQLException {
//
//		return jdbcTemplate.queryForObject("select *from users where user_id=?", new Object[] { userId },
//				new RowMapper<UserBean>() {
//					@Override
//					public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
//						UserBean user = new UserBean();
//						user.setId(rs.getInt("id"));
//						user.setName(rs.getString("name"));
//						user.setUserId(rs.getString("user_id"));
//						user.setPassword(rs.getString("password"));
//						return user;
//					}
//				});
//
//	}
}

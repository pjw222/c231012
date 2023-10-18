package c231017.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserSpringUserDAO {

	private JdbcTemplate jdbcTemplate;

	public UserSpringUserDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void add(UserInterface user) throws DataAccessException {
		jdbcTemplate.update("insert into users (name, user_id, password) values (?,?,?)", user.getName(),
				user.getUserId(), user.getPassword());

	}
	public void delete(int id) throws DataAccessException{
		jdbcTemplate.update("delete from users where id=?", id);
	}

	public UserInterface get(String userId) throws DataAccessException {

		return jdbcTemplate.queryForObject("select *from users where user_id=?", new Object[] { userId },
				new RowMapper<UserBean>() {
					@Override
					public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserBean user = new UserBean();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setUserId(rs.getString("user_id"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				});

	}

}

package c231017.factory;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;



import c231017.user.TestUserDAO;

import c231017.user.UserSpringUserDAO;


public class DAOFactory {

	@Bean
	public UserSpringUserDAO userSpringUserDAO() {	
		return new UserSpringUserDAO(dataSource());

	}
	@Bean
	public TestUserDAO testUserDAO() {
		return new TestUserDAO(dataSource());
	}

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(oracle.jdbc.OracleDriver.class);
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		dataSource.setUsername("java");
		dataSource.setPassword("qwer");
		return dataSource;
	}
	
}

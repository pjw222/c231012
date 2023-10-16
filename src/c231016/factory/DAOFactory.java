package c231016.factory;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;


import c231016.user.JdbcContextUserDAO;
import c231016.user.UserDAO;
import c231016.user.UserSpringUserDAO;


public class DAOFactory {
//	private UserDAO USERDAOINSTANCE;
//	private ConnectionMaker CONNECTIONMAKERINSTANCE;
	@Bean
	public UserDAO userDAO() {	
		return new UserDAO(dataSource());
//		if(USERDAOINSTANCE == null) USERDAOINSTANCE = new UserDAO(connectionMaker());
//		return USERDAOINSTANCE;
	}
	@Bean
	public JdbcContextUserDAO jdbcContextUserDAO() {	
		return new JdbcContextUserDAO(dataSource());

	}
	@Bean
	public UserSpringUserDAO userSpringUserDAO() {	
		return new UserSpringUserDAO(dataSource());

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

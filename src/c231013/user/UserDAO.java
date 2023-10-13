package c231013.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import c231012.connection.ConnectionMaker;
import c231012.factory.DAOFactory;
import c231013.user.UserBean;

public class UserDAO {
	//DB와 통신해 유저를 관리한다
	private ConnectionMaker maker;
	private DataSource dataSource;
	
	public UserDAO(ConnectionMaker maker) {
		this.maker = maker;
//		new DAOFactory().userDAO();
//		ApplicationContext context = new ApplicationConfigApplicationContext(DAOFactory.class);
//		this.maker = context.getBean("connectionMaker", ConnectionMaker);
	}
	public UserDAO(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	public void add(UserBean user)throws Exception
	{
//		Connection con = maker.makeConnection();
		Connection con = dataSource.getConnection();
		String query = "insert into users (name, user_id, password) values (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getUserId());
		pstmt.setString(3, user.getPassword());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public UserInterface get(String userId)throws Exception {

//		Connection con = maker.makeConnection();
		Connection con = dataSource.getConnection();
		String query = "select *from users where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		UserInterface user = null;
		if(rs.next()) {
			user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setUserId(rs.getString("user_id"));
			user.setPassword(rs.getString("password"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
		
	}
}

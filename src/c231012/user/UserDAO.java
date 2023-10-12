package c231012.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import c231012.connection.ConnectionMaker;


public class UserDAO {
	//DB와 통신해 유저를 관리한다
	private ConnectionMaker maker;
	
	public UserDAO(ConnectionMaker maker) {
		this.maker = maker;
	}
	public void add(UserBean user)throws Exception
	{
		Connection con = maker.makeConnection(); 
		String query = "insert into users (name, user_id, password) values (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getUserId());
		pstmt.setString(3, user.getPassword());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public UserBean get(String userId)throws Exception {

		Connection con = maker.makeConnection();
		String query = "select *from users where user_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		UserBean user = null;
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

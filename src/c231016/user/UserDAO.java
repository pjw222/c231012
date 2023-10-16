package c231016.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import c231016.user.UserBean;
import c231016.user.UserInterface;

public class UserDAO {
	//DB와 통신해 유저를 관리한다
	private DataSource dataSource;
	// () ->{}

	public UserDAO(DataSource dataSource)
	{
		this.dataSource = dataSource;
		
	}
	public void add(UserBean user) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			
			String query = "insert into users (name, user_id, password) values (?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getPassword());
			pstmt.executeUpdate();
			
		
		}catch(SQLException e) {
			throw e;
		}finally {
			if(pstmt !=null) {
				try {
					pstmt.close();								
				}catch(SQLException e) {
				}
			}
			if(con !=null) {
				try {
					con.close();								
				}catch(SQLException e) {
				}
			}
		}
		
	}
	
	public void delete(int id) throws SQLException {
		Connection con = dataSource.getConnection();
		String query = "delete from users where id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, id);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public UserInterface get(String userId) throws SQLException {


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
	/*
	private PreparedStatement makepstmt(Connection con, UserInterface user) throws SQLException {
		String query = "insert into users (name, user_id, password) values (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getUserId());
		pstmt.setString(3, user.getPassword());
		
		return pstmt;
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
}
package c231016.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOadd {
	private PreparedStatement makepstmt(Connection con, UserInterface user) throws SQLException {
		String query = "insert into users (name, user_id, password) values (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getUserId());
		pstmt.setString(3, user.getPassword());
		
		return pstmt;
	}
}

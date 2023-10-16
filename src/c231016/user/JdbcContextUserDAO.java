package c231016.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

public class JdbcContextUserDAO {
	private DataSource dataSource;

	public JdbcContextUserDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void jdbcContextWithStatementStrategy(StatementStrategy stmtStrategy) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = stmtStrategy.makePstmt(con);
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
//	public void jdbcContextWithGetStatementStrategy(StatementStrategy stmtStrategy) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		UserInterface user = null;
//		try {
//			con = dataSource.getConnection();			
//			pstmt = stmtStrategy.makePstmt(con);
//			rs = pstmt.executeQuery();
//			
//		
//		}catch(SQLException e) {
//				throw e;
//			}finally {
//				if(pstmt !=null) {
//					try {
//						pstmt.close();								
//					}catch(SQLException e) {
//					}
//				}
//				if(con !=null) {
//					try {
//						con.close();								
//					}catch(SQLException e) {
//					}
//				}
//			}
//
//	}

	public void add(UserBean user) throws SQLException{
		jdbcContextWithStatementStrategy(new StatementStrategy(){
			@Override
			public PreparedStatement makePstmt(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("insert into users (name, user_id, password) values (?,?,?)");

				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getUserId());
				pstmt.setString(3, user.getPassword());

				return pstmt;
			}
		});
	}
	public void delete(int id) throws SQLException{
		jdbcContextWithStatementStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makePstmt(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("delete from users where id=?");

				pstmt.setInt(1, id);

				return pstmt;
			}
		});

	}

//public UserInterface get(String userId) throws SQLException{
//	jdbcContextWithGetStatementStrategy(new StatementStrategy() {
//		@Override
//		public PreparedStatement makePstmt(Connection con) throws SQLException {
//			PreparedStatement pstmt = con.prepareStatement("select *from users where user_id=?");
//			pstmt.setString(1, userId);
//			ResultSet rs = pstmt.executeQuery();
//			UserInterface user = null;
//			if(rs.next()) {
//				user = new UserBean();
//				user.setId(rs.getInt("id"));
//				user.setName(rs.getString("name"));
//				user.setUserId(rs.getString("user_id"));
//				user.setPassword(rs.getString("password"));
//			}
//
//
//			return pstmt;
//		} 
//	 });
//	return null;
//	
//}

}






package c231020.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BoardDAO {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<BoardBean> mapper = new RowMapper<BoardBean>() {
		@Override
		public BoardBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardBean board = new BoardBean();
			board.setId(rs.getInt("id"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setCreatedAt(rs.getDate("created_at"));
			board.setUserId(rs.getInt("user_id"));

			return board;
		}
	};

	public void add(BoardBean board) {
		jdbcTemplate.update("insert into boards (\"title\", \"user_id\", \"content\") values (?,?,?)", board.getTitle(),
				board.getUserId(), board.getContent());
	}
	
	public BoardBean get(int id) {
		return jdbcTemplate.queryForObject("select * from boards where \"id\"=?", new Object[] { id }, mapper);
	}
	
	public List<BoardBean> getAll(){
		return jdbcTemplate.query("select * from boards", mapper);
	}
	
	
	
	
}

package c231019.test.user;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserTestDAO {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void drop() {
		jdbcTemplate.execute("BEGIN\r\n" + "   EXECUTE IMMEDIATE 'DROP TABLE users';\r\n" + "EXCEPTION\r\n"
				+ "   WHEN OTHERS THEN\r\n" + "      IF SQLCODE != -942 THEN\r\n" + "         RAISE;\r\n"
				+ "      END IF;\r\n" + "END;");
	}

	public void create() throws Exception {
		int maxCount = 3;
		while (maxCount-- > 0) { // 예외 복구 << 만약 true 를 넣을경우는 성공할때까지 무한정 시도하 기때문에 서버가 꺼져있을경우 램폭파 조건을 넣어줘야함
			try {
				jdbcTemplate.execute("create table users (\r\n" + " id number generated as identity primary key,\r\n"
						+ " name varchar2(20),\r\n" + " user_id varchar2(50) not null unique,\r\n"
						+ " password varchar2(64) not null\r\n" + ")");
				return;
			} catch (Exception e) {
				System.out.println(maxCount + "번 남았다.");
//				e.printStackTrace();
			}
		}
		throw new Exception("table 생성 실패"); // 예외 전환
	}
}

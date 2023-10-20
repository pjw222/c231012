package c231020.test.board;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import c231019.user.UserBean;
import c231019.user.UserDAO;
import c231020.board.BoardBean;
import c231020.board.BoardDAO;
import c231020.board.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/c231020/dataSource.xml", "applicationContext.xml" })
public class BoardTest {
	@Autowired
	BoardDAO boardDAO;
	@Autowired
	BoardService boardService;
	@Autowired
	BoardTestDAO boardTestDAO;
	@Autowired
	UserDAO userDAO;

	@Before
	public void intialize() throws Exception {
		boardTestDAO.drop();
		boardTestDAO.create();
		BoardBean board = new BoardBean();
		board.setTitle("확인중1");
		board.setUserId(1);
		board.setContent("확인중인 내용");
		boardDAO.add(board);
		board.setTitle("확인중1");
		board.setUserId(1);
		board.setContent("확인중인 내용");
		boardDAO.add(board);
		board.setTitle("확인중1");
		board.setUserId(1);
		board.setContent("확인중인 내용");
		boardDAO.add(board);
		board.setTitle("확인중1");
		board.setUserId(1);
		board.setContent("확인중인 내용");
		boardDAO.add(board);
	}

	@Test
	public void add() {
		BoardBean board = new BoardBean();
		board.setTitle("확인중1");
		board.setUserId(1);
		board.setContent("확인중인 내용");
		System.out.println(board.getContent());
		System.out.println(board.getTitle());
		System.out.println(board.getUserId());
		boardDAO.add(board);
	}

	@Test
	public void get() {
		BoardBean board = boardDAO.get(1);
		assertThat(board.getId(), is(1));
		assertThat(board.getTitle(), is("확인중1"));
		assertThat(board.getUserId(), is(1));
		assertThat(board.getContent(), is("확인중인 내용"));
	}

	@Test
	public void getAll() {
		List<BoardBean> list = boardDAO.getAll();
		list.forEach((BoardBean board) -> {
			assertThat(board.getTitle(), is("확인중1"));
			assertThat(board.getUserId(), is(1));
			assertThat(board.getContent(), is("확인중인 내용"));
		});
	}
	
	@Test
	public void addInService() {
		UserBean user = userDAO.get(2);
		BoardBean board = new BoardBean();
		board.setTitle("서비스 확인");
		board.setContent("서비스 확인중");
		boardService.add(board, user);
	}
	@Test
	public void getInService() {
		UserBean user = userDAO.get(1);
		BoardBean board = boardService.get(1);
		assertThat(board.getTitle(), is("확인중1"));
		assertThat(board.getUserId(), is(1));
		assertThat(board.getContent(), is("확인중인 내용"));
		assertThat(board.getUser().getName(), is(user.getName()));
		assertThat(board.getUser().getPassword(), is(user.getPassword()));
		assertThat(board.getUser().getUserId(), is(user.getUserId()));
	}
}

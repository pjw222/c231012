package c231024.main.java.com.classJava.board.service;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import c231024.main.java.com.classJava.board.dao.BoardDAO;
import c231024.main.java.com.classJava.board.domain.Board;
import c231024.main.java.com.classJava.user.dao.UserDAO;
import c231024.main.java.com.classJava.user.domain.User;
import c231024.main.java.com.classJava.user.service.UserService;

public class BoardServiceImpl implements BoardService {
	private UserDAO userDAO;
	private BoardDAO boardDAO;
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}


	public void add(Board board, int userId) {
		if(userService.isLogIn(userId))boardDAO.add(board);
		else new RuntimeException("로그인 실패");
	}

	public Board get(int id) {
		Board board = boardDAO.get(id);
		User user = userDAO.get(board.getUserId());
		board.setUser(user);

		return board;
	}

	public List<Board> getAll() {
		List<Board> list = boardDAO.getAll();
		for (int i = 0; i < list.size(); ++i) {
			int userId = list.get(i).getUserId();
			User user = userDAO.get(userId);
			list.get(i).setUser(user);
		}
		return list;
	}


	public void updateBefore(Board board, User user) throws Exception {
		// 어떠한 유저(user)가 자신의 글(board)를 수정한다.
		if (board.getUserId() == user.getId()) {
			boardDAO.update(board);
		} else {
			throw new Exception("wrong user");
		}
	}



	public void updateInner(Board board, User user) {
		User writer = board.getUser();
		if(writer.getId() == user.getId()) {
			boardDAO.update(board);
		} else {  
			throw new RuntimeException("wrong user");
		}
	}
	
	public void updateAllInner(User user) {
		List<Board> list = getAll();
		for(int i = 0;i<list.size();i++) {
			if(i == 2)user = new User("김남균", "knk", "1234");
			Board board = list.get(i);
			board.setContent("삭제된 컨텐츠");
			User writer = board.getUser();
			if(writer.getId() == user.getId()) {
				boardDAO.update(board);
			} else {
				throw new RuntimeException("wrong user");
			}
		}
	}

	@Override
	public void update(Board board, User user) {
		// TODO Auto-generated method stub
		   
	}

	@Override
	public void updateAll(User user) {
		// TODO Auto-generated method stub
		
	}


}

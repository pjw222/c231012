package c231017.test.user;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import c231017.factory.DAOFactory;
import c231017.user.UserBean;
import c231017.user.UserInterface;
import c231017.user.UserSpringUserDAO;
import c231017.user.TestUserDAO;

public class UserDAOTest {
	private UserInterface user1 = new UserBean();
	private ApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);
	public static void main(String[] args) throws Exception {
		addAndGetTest();
	}

	private static void addAndGetTest() throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);
		UserSpringUserDAO dao = context.getBean("userSpringUserDAO", UserSpringUserDAO.class);

		UserBean user = new UserBean();
		user.setName("개미");
		user.setUserId("ant");
		user.setPassword("ss");
		dao.add(user);


		UserInterface createdUser = dao.get("ant");
		System.out.println(createdUser.getId());
		if (!createdUser.getName().equals(user.getName())) {
			System.out.println("이름 문제 발생");
		} else if (!createdUser.getUserId().equals(user.getUserId())) {
			System.out.println("아이디 문제 발생");
		} else if (!createdUser.getPassword().equals(user.getPassword())) {
			System.out.println("비밀번호 문제 발생");
		} else {
			System.out.println("테스트성공");
		}

	}

	@Before
	public void initialize() throws SQLException {

		TestUserDAO test = context.getBean("testUserDAO", TestUserDAO.class);
		UserSpringUserDAO dao = context.getBean("userSpringUserDAO", UserSpringUserDAO.class);

//		test.drop();

		test.create();
		
		user1.setName("개미123");
		user1.setUserId("an52");
		user1.setPassword("ss2");

		dao.add(user1);
		System.out.println("before");

	}
	
	@After
	public void dropTable() throws SQLException{
		TestUserDAO test = context.getBean("testUserDAO", TestUserDAO.class);

		test.drop();
		System.out.println("after");
	}
	
	@Test
	public void add() throws SQLException{
		UserSpringUserDAO dao = context.getBean("userSpringUserDAO", UserSpringUserDAO.class);
		
		UserBean user = new UserBean();
		
		user.setName("개미");
		user.setUserId("an53");
		user.setPassword("ss23");

		dao.add(user);
		System.out.println("add");
	}
	
	@Test
	public void get() throws SQLException{
		UserSpringUserDAO dao = context.getBean("userSpringUserDAO", UserSpringUserDAO.class);
		
		UserInterface createdUser = dao.get(user1.getUserId());
		assertThat(createdUser.getId(), is(1));
		assertThat(createdUser.getName(), is(user1.getName()));
		assertThat(createdUser.getUserId(), is(user1.getUserId()));
		assertThat(createdUser.getPassword(), is(user1.getPassword()));
		System.out.println("get");
		
	}
	
	@Test
	public void addAndGet() throws SQLException {
//		ApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);
		UserSpringUserDAO dao = context.getBean("userSpringUserDAO", UserSpringUserDAO.class);
//		TestUserDAO test = context.getBean("testUserDAO", TestUserDAO.class);
//		test.drop();
//		test.create();
		UserBean user = new UserBean();
		user.setName("개미1");
		user.setUserId("an534");
		user.setPassword("ss2");

		dao.add(user);

		UserInterface createdUser = dao.get(user.getUserId());
		assertThat(createdUser.getName(), is(user.getName()));
		assertThat(createdUser.getUserId(), is(user.getUserId()));
		assertThat(createdUser.getPassword(), is(user.getPassword()));
		System.out.println("addAndGet");

	}

}

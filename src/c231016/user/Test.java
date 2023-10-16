package c231016.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import c231016.factory.DAOFactory;

public class Test {
	
	public static void main(String[] args) throws Exception
	{			
//		UserDAO dao = new DAOFactory().userDAO();
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);
//		JdbcContextUserDAO dao = context.getBean("jdbcContextUserDAO", JdbcContextUserDAO.class);
		UserSpringUserDAO dao = context.getBean("userSpringUserDAO", UserSpringUserDAO.class);
//		UserDAO dao1 = context.getBean("userDAO", UserDAO.class);
//		
//		UserDAO dao2 = context.getBean("userDAO", UserDAO.class);
//		System.out.println(dao1);
//		System.out.println(dao2);
//		
//		UserDAO dao3 = context.getBean("userDAO", UserDAO.class);
//		UserDAO dao4 = context.getBean("userDAO", UserDAO.class);
//		System.out.println(dao3);
//		System.out.println(dao4);
		
		
		UserBean user = new UserBean();
//		user.setName("UserSpring");
//		user.setUserId("USId");
//		user.setPassword("USPw");
//		dao.add(user);
		
		System.out.println("추가성공");
		dao.delete(19);
		UserInterface createdUser = dao.get("knk");
		System.out.println(createdUser.getId());
		System.out.println(createdUser.getName());
		System.out.println(createdUser.getUserId());
		System.out.println(createdUser.getPassword());
	}
}

package c231013.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import c231013.factory.*;


// User의 DAO를 테스트
public class Test {
	
	public static void main(String[] args) throws Exception
	{			
//		UserDAO dao = new DAOFactory().userDAO();
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);
		UserDAO dao = context.getBean("userDAO", UserDAO.class);
		
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
		user.setName("스프링테스트");
		user.setUserId("SpringTestID");
		user.setPassword("SpringTestPW");
		dao.add(user);
		
		System.out.println("추가성공");
		
		UserInterface createdUser = dao.get("SpringTestID");
		System.out.println(createdUser.getId());
		System.out.println(createdUser.getName());
		System.out.println(createdUser.getUserId());
		System.out.println(createdUser.getPassword());
	}
}

package gz.ht.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gz.ht.dao.UserDao;
import gz.ht.pojo.User;


public class UserDaoImplTest {
	private AbstractXmlApplicationContext applicationContext;
	private UserDao userdao;
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	public void testFindUserById() throws Exception {
		userdao = (UserDao) applicationContext.getBean("userDao");
		User user = userdao.findUserById(27);
		System.out.println(user);
	}

	public void testInsert() {
		userdao = (UserDao) applicationContext.getBean("userDao");
	}
	@Test
	public void testDelete() throws Exception {
		userdao = (UserDao) applicationContext.getBean("userDao");
		userdao.delete(26);
	}
	
	
	public void testUpdate() throws Exception {
		userdao = (UserDao) applicationContext.getBean("userDao");
		User user = new User(27,"Áõ·è¿ñ","Å®",new Date(),"Ì¨Íå");
		userdao.update(user);
	}

}

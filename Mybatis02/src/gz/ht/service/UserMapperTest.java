package gz.ht.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gz.ht.dao.UserMapper;
import gz.ht.pojo.User;

public class UserMapperTest {
	private ApplicationContext applicationContext;
	private UserMapper userMapper;
	
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	public void test() throws Exception {
		userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user =  userMapper.findUserById(1);
		System.out.println(user);
	}
	
	public void inset() throws Exception {
		userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = new User("Ðì¼Ò±ó", "ÄÐ", new Date(), "ÐÅ·áÀ¬»ø³¡");
		userMapper.insert(user);
	}
	
	public void update() throws Exception{
		userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = new User(28,"Ðì¼Ò±ó", "ÄÐ", new Date(), "ÐÅ·áÀ¬»ø³¡»Æ½ðµØ¶Î");
		userMapper.update(user);
	}

	@Test
	public void delete() throws Exception{
		userMapper = (UserMapper) applicationContext.getBean("userMapper");
		userMapper.delete(28);
	}
}

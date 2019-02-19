package gz.ht.first;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import gz.ht.dao.UserDao;
import gz.ht.daoImpl.UserDaoImpl;
import gz.ht.pojo.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	private UserDao userDao;
	@Before
	public void setUp() throws Exception{
		//配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		userDao = new UserDaoImpl(sqlSessionFactory);
	}

	public void testFindUserById() throws Exception {
		User user = userDao.findUserById(9);
		System.out.println(user);
	}
	
	@Test
	public void testInsert() throws Exception{
		User user = new User();
		user.setUsername("弟弟");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("台湾");
		userDao.insert(user);
	}
	
	public void testDelete() throws Exception{
		userDao.delete(9);
	}

	public void testUpdate() throws Exception{
		User user = new User();
		user.setId(9);
		user.setUsername("弟弟");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("台湾");
		userDao.update(user);
	}
}

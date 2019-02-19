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
		//�����ļ�
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//�����Ự����
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
		user.setUsername("�ܵ�");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("̨��");
		userDao.insert(user);
	}
	
	public void testDelete() throws Exception{
		userDao.delete(9);
	}

	public void testUpdate() throws Exception{
		User user = new User();
		user.setId(9);
		user.setUsername("�ܵ�");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("̨��");
		userDao.update(user);
	}
}

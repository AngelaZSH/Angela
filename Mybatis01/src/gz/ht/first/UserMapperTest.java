package gz.ht.first;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import gz.ht.dao.UserMapper;
import gz.ht.daoImpl.UserDaoImpl;
import gz.ht.pojo.User;
import gz.ht.pojo.UserQuerVo;

/**
 * @author ���غ�
 * @date	2019��2��17������8:11:15
 * @version �汾��ʶ
 * ʹ��mapper������������Աֻ��Ҫдmapper�ӿ�
 */
public class UserMapperTest {
	
	//���ִ����ӡ����¡�ɾ����Ҫ����SqlSession.commit();
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp()throws Exception{
		//�����ļ�
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//�����Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
	}
	
	//��ѯ
	public void findUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user =  userMapper.findUserById(2);
		sqlSession.close();
		System.out.println(user);
	}
	
	//ʹ��resultMap��ʽ
	@Test
	public void findUserByIdMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user =  userMapper.findUserByIdMap(15);
		sqlSession.close();
		System.out.println(user);
	}
	
	//����
	public void insert() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUsername("�����123");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("��������");
		userMapper.insert(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//ɾ��
	public void delete() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.delete(2);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//��������ѯ
	@Test
	public void findUserList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQuerVo userQuerVo = new UserQuerVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(3);
		ids.add(17);
		
		User user = new User();
		user.setSex("Ů");
		user.setUsername("���غ�");
		
		userQuerVo.setUser(user);
		userQuerVo.setIds(ids);
		
		List<User> list = userMapper.findUserList(userQuerVo);
		sqlSession.close();
		System.out.println("��ѯ����+......"+list.size());
	}
	
	//��ѯ����
	public void count() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQuerVo userQuerVo = new UserQuerVo();
		User user = new User();
		user.setSex("��");
		user.setUsername("�ܵ�");
		userQuerVo.setUser(user);
		
		int i = userMapper.count(userQuerVo);
		
		System.out.println("��������ѯ����......"+i);
	}
}

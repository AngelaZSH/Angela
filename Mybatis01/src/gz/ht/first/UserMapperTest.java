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
 * @author 张韶涵
 * @date	2019年2月17日下午8:11:15
 * @version 版本标识
 * 使用mapper代理开发，程序员只需要写mapper接口
 */
public class UserMapperTest {
	
	//如果执行添加、更新、删除需要调用SqlSession.commit();
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp()throws Exception{
		//配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
	}
	
	//查询
	public void findUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user =  userMapper.findUserById(2);
		sqlSession.close();
		System.out.println(user);
	}
	
	//使用resultMap方式
	@Test
	public void findUserByIdMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user =  userMapper.findUserByIdMap(15);
		sqlSession.close();
		System.out.println(user);
	}
	
	//插入
	public void insert() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUsername("刘疯狂123");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("江西赣州");
		userMapper.insert(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//删除
	public void delete() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.delete(2);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//带条件查询
	@Test
	public void findUserList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQuerVo userQuerVo = new UserQuerVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(3);
		ids.add(17);
		
		User user = new User();
		user.setSex("女");
		user.setUsername("张韶涵");
		
		userQuerVo.setUser(user);
		userQuerVo.setIds(ids);
		
		List<User> list = userMapper.findUserList(userQuerVo);
		sqlSession.close();
		System.out.println("查询条数+......"+list.size());
	}
	
	//查询条数
	public void count() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQuerVo userQuerVo = new UserQuerVo();
		User user = new User();
		user.setSex("男");
		user.setUsername("弟弟");
		userQuerVo.setUser(user);
		
		int i = userMapper.count(userQuerVo);
		
		System.out.println("带条件查询条数......"+i);
	}
}

package gz.ht.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import gz.ht.pojo.User;
/**
 * @author 	张韶涵
 * @date	2019年2月15日下午4:23:46
 * @version 版本标识
 */

public class MybatisFirst {
	
	//查询
	public void find() throws IOException{
		//配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream); 
		//通过工厂得到session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过session操作数据库selectList返回多个对象，selectOne单个对象
		 List<User> list =  sqlSession.selectList("test.username","%韶涵%");
		System.out.println(list);
		sqlSession.close();
	} 
	
	//新增
	@Test
	public void add() throws IOException{
		//配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream); 
		//通过工厂得到session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("Anela张韶涵123");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setAddress("台湾");
		//通过session操作数据库
		sqlSession.insert("test.user",user);
		//提交事务
		sqlSession.commit();
		System.out.println("获取的id"+user.getId());
		sqlSession.close();
	} 
	
	//删除
	@Test
	public void delete() throws IOException{
		//配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream); 
		//通过工厂得到session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过session操作数据库
		sqlSession.delete("test.userid",1);
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	}
	
	//更新
	@Test
	public void update() throws IOException{
		//配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream); 
		//通过工厂得到session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(3);
		user.setUsername("韶涵天后");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setAddress("台湾");
		//通过session操作数据库
		sqlSession.update("test.update",user);
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	} 
}

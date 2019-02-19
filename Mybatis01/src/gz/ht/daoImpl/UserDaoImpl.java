package gz.ht.daoImpl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gz.ht.dao.UserDao;
import gz.ht.pojo.User;

/**
 * @author 张韶涵
 * @date	2019年2月15日下午7:28:41
 * @version 
 */

public class UserDaoImpl implements UserDao{
	//注入sqlSessionFtory
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.id",id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insert(Object obj) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.user",obj);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void delete(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.userid",id);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void update(Object obj) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("test.update",obj);
		sqlSession.commit();
		sqlSession.close();
	}
	
}

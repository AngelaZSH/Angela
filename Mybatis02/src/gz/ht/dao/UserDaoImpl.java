package gz.ht.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import gz.ht.dao.UserDao;
import gz.ht.pojo.User;


/**
 * @author 张韶涵
 * @date	2019年2月24日下午8:11:13
 * @version 版本标识
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	//继承SqlSessionDaoSupport，通过this.getSqlSession()得到sqlSession
	//注入sqlSessionFtory
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("test.findUserById",id);
		return user;
	}

	@Override
	public void insert(Object obj) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("test.user",obj);
	}

	@Override
	public void delete(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("test.delete",id);
	}

	@Override
	public void update(Object obj) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("test.update",obj);
	}
	
}

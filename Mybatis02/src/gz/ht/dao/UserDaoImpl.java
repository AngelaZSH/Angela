package gz.ht.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import gz.ht.dao.UserDao;
import gz.ht.pojo.User;


/**
 * @author ���غ�
 * @date	2019��2��24������8:11:13
 * @version �汾��ʶ
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	//�̳�SqlSessionDaoSupport��ͨ��this.getSqlSession()�õ�sqlSession
	//ע��sqlSessionFtory
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

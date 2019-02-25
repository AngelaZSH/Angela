package gz.ht.dao;

import gz.ht.pojo.User;



/**
 * @author 张韶涵
 * @date	2019年2月24日下午8:11:00
 * @version 版本标识
 */
public interface UserDao {
	public User findUserById (int id) throws Exception;
	public void insert(Object obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(Object obj) throws Exception;
}

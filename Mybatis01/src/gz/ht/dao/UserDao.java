package gz.ht.dao;

import gz.ht.pojo.User;

/**
 * @author 张韶涵
 * @date	2019年2月15日下午7:28:17
 * @version 
 */

public interface UserDao {
	public User findUserById (int id) throws Exception;
	public void insert(Object obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(Object obj) throws Exception;
}

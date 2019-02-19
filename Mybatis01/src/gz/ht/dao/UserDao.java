package gz.ht.dao;

import gz.ht.pojo.User;

/**
 * @author ���غ�
 * @date	2019��2��15������7:28:17
 * @version 
 */

public interface UserDao {
	public User findUserById (int id) throws Exception;
	public void insert(Object obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(Object obj) throws Exception;
}

package gz.ht.dao;

import gz.ht.pojo.User;



/**
 * @author ���غ�
 * @date	2019��2��24������8:11:00
 * @version �汾��ʶ
 */
public interface UserDao {
	public User findUserById (int id) throws Exception;
	public void insert(Object obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(Object obj) throws Exception;
}

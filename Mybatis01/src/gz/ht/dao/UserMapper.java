package gz.ht.dao;

import java.util.List;

import gz.ht.pojo.User;
import gz.ht.pojo.UserQuerVo;

/**
 * @author ���غ�
 * @date	2019��2��17������7:24:03
 * @version �汾��ʶ
 */

public interface UserMapper {
	//ʹ��mapper����ķ�ʽ
	/*
	  1.mapper.xml��namespace����mapper�ӿڵ�ַ
	  
	  2.mapper.java�ӿ��еķ�������mapper.xml��statement��idһ��

	  3.mapper.java�ӿ��еķ�������������ͺ�mapper.xml��statement��parameterTypeָ��������һ�¡�
		
	  4.mapper.java�ӿ��еķ�������ֵ���ͺ�mapper.xml��statement��resultTypeָ��������һ�¡�
	  */
	
	//     4    2            3
	public User findUserById(int id) throws Exception;
	public void insert(User user) throws Exception;
	public void delete(int id) throws Exception;
	public void update(User user)throws Exception;
	public List<User> findUserList(UserQuerVo userQuerVo) throws Exception;
	public int count(UserQuerVo userQuerVo) throws Exception;
	public User findUserByIdMap(int id) throws Exception;
}

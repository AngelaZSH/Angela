package gz.ht.dao;

import java.util.List;

import gz.ht.pojo.User;
import gz.ht.pojo.UserQuerVo;

/**
 * @author 张韶涵
 * @date	2019年2月17日下午7:24:03
 * @version 版本标识
 */

public interface UserMapper {
	//使用mapper代理的方式
	/*
	  1.mapper.xml中namespace等于mapper接口地址
	  
	  2.mapper.java接口中的方法名和mapper.xml中statement的id一致

	  3.mapper.java接口中的方法输入参数类型和mapper.xml中statement的parameterType指定的类型一致。
		
	  4.mapper.java接口中的方法返回值类型和mapper.xml中statement的resultType指定的类型一致。
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

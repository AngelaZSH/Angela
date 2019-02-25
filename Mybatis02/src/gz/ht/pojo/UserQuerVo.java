package gz.ht.pojo;

import java.util.List;

/**
 * @author 张韶涵
 * @date	2019年2月18日下午2:27:37
 * @version 版本标识
 */
public class UserQuerVo {
	private User user;
	private List<Integer> ids;
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Integer> getIds() {
		return ids;
	}


	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}

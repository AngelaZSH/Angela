package gz.ht.pojo;

/**
 * @author 张韶涵
 * @date	2019年2月20日下午7:25:41
 * @version 版本标识
 */
public class OrdersCustom extends Orders {

	private String username;
	private String address;
	private String sex;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

}

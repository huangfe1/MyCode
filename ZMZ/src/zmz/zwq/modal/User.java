package zmz.zwq.modal;

/**
 * 用户类 管理员和代理的父类
 * @author zwq
 * 
 *
 */
public class User {
	/**
	 * 用户的id（自增长的）
	 */
	private int userId;
	/**
	 * 用户的名字
	 */
	private String userName;
	/**
	 * 用户的密码
	 */
	private String userPassword;
	/**
	 * 用户的状态
	 */
	private int userStatus;
	/**
	 * 登陆时间(不用插入到数据库)
	 */
	private long loginTime;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}
	
}

package zmz.hf.common;

import java.util.HashMap;

import zmz.zwq.modal.User;
	/**
	 * 
	 * @author huangfei
	 *
	 */
public class Static {
	/**
	 * 在线用户
	 */
public static HashMap<String, User> LOGIN_USERS=new HashMap<String, User>();
	/**
	 * 游客人数
	 */
public static int VISITOR_USERS_SUM;
	/**
	 * 获取在线登陆人数
	 * @return
	 */
public static int getOnlineCounts(){
	return LOGIN_USERS.size();
}
/**
 * 获取游客人数
 * @return
 */
public static int getVisitorCounts(){
	return VISITOR_USERS_SUM;
}
}

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
	 * �����û�
	 */
public static HashMap<String, User> LOGIN_USERS=new HashMap<String, User>();
	/**
	 * �ο�����
	 */
public static int VISITOR_USERS_SUM;
	/**
	 * ��ȡ���ߵ�½����
	 * @return
	 */
public static int getOnlineCounts(){
	return LOGIN_USERS.size();
}
/**
 * ��ȡ�ο�����
 * @return
 */
public static int getVisitorCounts(){
	return VISITOR_USERS_SUM;
}
}

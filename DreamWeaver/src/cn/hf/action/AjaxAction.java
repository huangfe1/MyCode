package cn.hf.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport{
	public int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

	public Map<String,String> userInfo;
	public String getUser(){
		System.out.println("����ִ��"+uid);
		userInfo=new HashMap<String, String>();
		userInfo.put("1", "һ----");
		userInfo.put("2", "��2222");
		userInfo.put("3", "��1111222");
		return SUCCESS;
	}
	public Map<String, String> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Map<String, String> userInfo) {
		this.userInfo = userInfo;
	}
}

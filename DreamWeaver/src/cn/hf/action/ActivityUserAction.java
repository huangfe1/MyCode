package cn.hf.action;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ActivityUserAction implements Action{
	private int uid;
	private int status;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null&&user.getType()==0){//����ǹ�˾�û�
			UserDao.changeStatus(uid,status);//�޸��û�״̬
			return SUCCESS;
		}
		return null;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}

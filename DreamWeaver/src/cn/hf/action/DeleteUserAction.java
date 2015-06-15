package cn.hf.action;

import java.util.Map;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DeleteUserAction implements Action{
	private int uid;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		Map session=ac.getSession();
		User user=(User) session.get("user");
		if(user!=null){//����û�����
			User u=UserDao.getUser(uid);
			if(u.getFid()==user.getUid()||user.getType()==0){//���ҵ��û��������ǹ�˾�û�
				//UserDao.delectUser(uid);
				return SUCCESS;
			}
		}
		return "toLogin";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}

}

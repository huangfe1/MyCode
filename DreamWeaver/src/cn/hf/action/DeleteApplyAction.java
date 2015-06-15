package cn.hf.action;

import java.util.Map;

import cn.hf.bean.User;
import cn.hf.dao.ApplyDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DeleteApplyAction implements Action{
	private int aid;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		Map ses=ac.getSession();
		User user=(User) ses.get("user");
		if(user==null){
			return "toLogin";
		}
		ApplyDao.deleteApply(aid,user.getUid());
		return SUCCESS;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
}

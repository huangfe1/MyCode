package cn.hf.action;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ChangePawAction implements Action{
	private String oldpaw;
	private String newpaw;
	private String compaw;
	private String msg;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User u=(User) ac.getSession().get("user");
		if(u!=null){
			if(u.getPassword().equals(oldpaw)){
				if(newpaw.equals(compaw)){
					UserDao.changePaw(u.getUid(), newpaw);
					return SUCCESS;
				}else{
					msg="¡Ω¥Œ√‹¬Î≤ª∆•≈‰£°";
					return ERROR;
				}
			}else{
				msg="√‹¬Î¥ÌŒÛ£°";
				return ERROR;
			}
		}
		return "toLogin";
	}
	public String getOldpaw() {
		return oldpaw;
	}
	public void setOldpaw(String oldpaw) {
		this.oldpaw = oldpaw;
	}
	public String getNewpaw() {
		return newpaw;
	}
	public void setNewpaw(String newpaw) {
		this.newpaw = newpaw;
	}
	public String getCompaw() {
		return compaw;
	}
	public void setCompaw(String compaw) {
		this.compaw = compaw;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

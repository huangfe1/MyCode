package cn.hf.action;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ChangeUserAction implements Action{
	public User user;
	private int fuid;
	private String msg;
	private String dlname;//填写的代理名
	private int uid;//用户uid
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User u=(User) ac.getSession().get("user");
		uid=user.getUid();//当前用户的id,加入valuestack,跳转时候需要
		if(user.getInfo()==null||user.getInfo().equals("")){
			msg="请填写汇款备注!";
			return "error";
		}
		if(u!=null){
		user.setLevel(user.getLevel());
		if(u.getType()==0){//公司用户
		if(!dlname.equals("")&&dlname!=null){//有代理编号
			//User us=UserDao.getUserByName(dlname);
			User us=UserDao.getUser(dlname);//通过编号获取
			if(us!=null){//如果有用户
				//代理只能给自己的代理添加下级代理
				if(u.getType()==1&&us.getFid()!=u.getUid()){//代理用户,填写的不是自己
					msg="您填写的用户不是您的下级";
					return "error";
				}
				fuid=us.getUid();//设置fid
			}else{//没有用户
				msg="抱歉您填写的用户编号不存在";
				return "error";
			}
		}
		}
		user.setFid(fuid);
		try {
			UserDao.changeUser(user);
			/*ImageUtil.writeImage(user,0);//修改原始图,修改缩略图
			ImageUtil.writeImage(user,1);*/
			return SUCCESS;
		} catch (Exception e) {
			msg="请确保,手机,微信,身份证账号没有被使用";
			return "error";
		}
		}
		return "toLogin";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFuid() {
		return fuid;
	}
	public void setFuid(int fuid) {
		this.fuid = fuid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDlname() {
		return dlname;
	}
	public void setDlname(String dlname) {
		this.dlname = dlname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}

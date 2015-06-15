package cn.hf.action;

import java.util.ArrayList;
import java.util.Map;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;
import cn.hf.util.Myconf;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class checkUserAction implements Action{
	private int nowpage;
	private int count;
	public ArrayList<User> users;
	private String name;
	private String code;
	private String lvmsg;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null){
			//查询等级数量
			lvmsg=UserDao.selectLevelCount(user.getUid());
			if(code!=null||name!=null){
				setUsers(UserDao.getUserByFidCodeName(user.getUid(), code, name));
				nowpage++;//页码+1
				setNowpage(nowpage);//设置当前页码+1
				setCount(getUsers().size());//0,或者1
			}else{
			//从数据库获取用户,如果是按页数分页的话,limit nowpage*15,15
			setUsers(UserDao.getUserByFid(user.getUid(),nowpage,Myconf.limitCount));//获取Users
			nowpage++;//页码+1
			setNowpage(nowpage);//设置当前页码+1
			if(count==0){//第一次加载
			//获取总数,页面中获取存储
			setCount(UserDao.getCountByFid(user.getUid()));
			}
			}
			return SUCCESS;
		}
		return "toLogin";
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLvmsg() {
		return lvmsg;
	}
	public void setLvmsg(String lvmsg) {
		this.lvmsg = lvmsg;
	}
	
}

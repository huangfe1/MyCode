package cn.hf.action;

import java.util.ArrayList;
import java.util.Map;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;
import cn.hf.util.Myconf;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class checkAllUserAction implements Action{
	public int nowpage;
	private int count;
	public ArrayList<User> users;
	private String name;
	public String code;
	public String test;
	public String lvmsg;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null){
			lvmsg=UserDao.selectLevelCount(0);//查询所有等级信息
			if(code!=null&&!code.equals("")||name!=null&&!name.equals("")){
				setUsers(UserDao.getUserByCodeName(code, name));
				nowpage++;//页码+1
				setNowpage(nowpage);//设置当前页码+1
				setCount(getUsers().size());//0,或者1
			}else{
			//从数据库获取用户,如果是按页数分页的话,limit nowpage*15,15
			setUsers(UserDao.getUser(nowpage,Myconf.limitCount));//获取Users
			nowpage++;//页码+1
			setNowpage(nowpage);//设置当前页码+1
			if(count==0){//第一次加载
			//获取总数,页面中获取存储
			setCount(UserDao.getCount());
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
	private int getNowpage() {
		return nowpage;
	}
	private void setNowpage(int nowpage) {
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
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getLvmsg() {
		return lvmsg;
	}
	public void setLvmsg(String lvmsg) {
		this.lvmsg = lvmsg;
	}
	
}

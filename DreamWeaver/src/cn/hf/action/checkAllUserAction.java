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
			lvmsg=UserDao.selectLevelCount(0);//��ѯ���еȼ���Ϣ
			if(code!=null&&!code.equals("")||name!=null&&!name.equals("")){
				setUsers(UserDao.getUserByCodeName(code, name));
				nowpage++;//ҳ��+1
				setNowpage(nowpage);//���õ�ǰҳ��+1
				setCount(getUsers().size());//0,����1
			}else{
			//�����ݿ��ȡ�û�,����ǰ�ҳ����ҳ�Ļ�,limit nowpage*15,15
			setUsers(UserDao.getUser(nowpage,Myconf.limitCount));//��ȡUsers
			nowpage++;//ҳ��+1
			setNowpage(nowpage);//���õ�ǰҳ��+1
			if(count==0){//��һ�μ���
			//��ȡ����,ҳ���л�ȡ�洢
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

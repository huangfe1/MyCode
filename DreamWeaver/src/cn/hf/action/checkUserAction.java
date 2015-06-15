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
			//��ѯ�ȼ�����
			lvmsg=UserDao.selectLevelCount(user.getUid());
			if(code!=null||name!=null){
				setUsers(UserDao.getUserByFidCodeName(user.getUid(), code, name));
				nowpage++;//ҳ��+1
				setNowpage(nowpage);//���õ�ǰҳ��+1
				setCount(getUsers().size());//0,����1
			}else{
			//�����ݿ��ȡ�û�,����ǰ�ҳ����ҳ�Ļ�,limit nowpage*15,15
			setUsers(UserDao.getUserByFid(user.getUid(),nowpage,Myconf.limitCount));//��ȡUsers
			nowpage++;//ҳ��+1
			setNowpage(nowpage);//���õ�ǰҳ��+1
			if(count==0){//��һ�μ���
			//��ȡ����,ҳ���л�ȡ�洢
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

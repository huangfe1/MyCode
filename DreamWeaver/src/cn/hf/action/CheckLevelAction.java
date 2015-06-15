package cn.hf.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CheckLevelAction implements Action{
	private int uid;
	private HashMap<String, ArrayList<User>> hm;
	private int uc;
	private String name;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		Map session=ac.getSession();
		User user=(User) session.get("user");
		if(name==null||name.equals("")){
			name=user.getUsername();
		}
		if(user==null){
			return "toLogin";
		}
			if(uid==0){//如果uid不存在
				uid=user.getUid();
			}
			//查询
			ArrayList<User> users=UserDao.getUserByFid(uid);
			hm=new HashMap<String, ArrayList<User>>();
			for(User u : users){//生成存储的容器
				ArrayList<User> us=new ArrayList<User>();
				if(!u.getLevel().equals("0")){
				hm.put(u.getLevel(), us);//不添加公司用户
				}
			}
			for(User u : users){//分容器存储
				ArrayList<User> us=hm.get(u.getLevel());
				if(!u.getLevel().equals("0")){//不添加公司用户
					us.add(u);
				    hm.put(u.getLevel(), us);
					}
			}
			Iterator<String> it=hm.keySet().iterator();
				while(it.hasNext()){
					int c=hm.get(it.next()).size();
					if(uc<c){
						uc=c;
					}
				}
				if(uc==0){
					uc=1;
				}
		return SUCCESS;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public HashMap<String, ArrayList<User>> getHm() {
		return hm;
	}
	public void setHm(HashMap<String, ArrayList<User>> hm) {
		this.hm = hm;
	}
	public int getUc() {
		return uc;
	}
	public void setUc(int uc) {
		this.uc = uc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

package cn.hf.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cn.hf.bean.GoodsName;
import cn.hf.bean.User;
import cn.hf.dao.NameDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ConNameAction implements Action{
	private ArrayList<GoodsName> names;
	private String name;
	private String msg;
	private String newname;
	@Override
	public String execute(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(new Date());//获取时间
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null){
			try{
			NameDao.insertName(name, time);
			}catch(Exception e){
				msg="产品类型已经存在！";
				return "add";
			}
			return SUCCESS;
		}
		return "toLogin";
	}
	public String delete() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null){
			NameDao.delectName(name);
			return SUCCESS;
		}
		return "toLogin";
	}
	public String check() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null){
			names=NameDao.selectName();
			return "check";
		}
		return "toLogin";
	}
	public String change() {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null){
			try{
			NameDao.updateName(name,newname);
			}catch(Exception e){
				msg="产品类型已经存在！";
			return "change";
			}
			return SUCCESS;
		}
		return "toLogin";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<GoodsName> getNames() {
		return names;
	}
	public void setNames(ArrayList<GoodsName> names) {
		this.names = names;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getNewname() {
		return newname;
	}
	public void setNewname(String newname) {
		this.newname = newname;
	}
	
}

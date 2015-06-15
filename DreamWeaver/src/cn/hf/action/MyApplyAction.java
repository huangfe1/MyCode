package cn.hf.action;

import java.util.ArrayList;

import cn.hf.bean.Apply;
import cn.hf.bean.Goods;
import cn.hf.bean.User;
import cn.hf.dao.ApplyDao;
import cn.hf.dao.GoodsDao;
import cn.hf.util.Myconf;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class MyApplyAction implements Action{
	private String msg;
	private int type;//0为我的申请,1为下级申请
	private int nowpage;
	private int count;
	private String st;
	private String sn;
	public ArrayList<Apply> applys; 
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null){//用户存在
			if(user.getType()==0){//公司用户
				type=1;//下级所有申请
			}else{
				type=0;//我的申请
			}
			applys=ApplyDao.selectApplys(user.getUid(), type, st, sn, nowpage, Myconf.limitCount);
			nowpage++;//页码+1
			setNowpage(nowpage);//设置当前页码+1
			if(count==0){//第一次加载
			//获取总数,页面中获取存储
			setCount(ApplyDao.selectGcounts(user.getUid(), type, st, sn));
			}
			return SUCCESS;
		}
		return "toLogin";
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public ArrayList<Apply> getApplys() {
		return applys;
	}
	public void setApplys(ArrayList<Apply> applys) {
		this.applys = applys;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

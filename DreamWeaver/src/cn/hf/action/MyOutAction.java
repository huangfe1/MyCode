package cn.hf.action;

import java.util.ArrayList;

import cn.hf.bean.GoodsName;
import cn.hf.bean.Out;
import cn.hf.bean.User;
import cn.hf.dao.GoodsDao;
import cn.hf.dao.NameDao;
import cn.hf.dao.OutDao;
import cn.hf.util.Myconf;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class MyOutAction implements Action{
	private int nowpage;
	private int count;
	private String st;
	private String number;
	private ArrayList<Out> Outs;
	private int incount;
	private int outcount;
	private String gn;
	private ArrayList<GoodsName> names;
	@Override
	public String execute() throws Exception {
		if(gn==null||gn.equals("全部类型")){
			gn="";
		}
		//做库存记录逻辑
		ActionContext ac=ActionContext.getContext();
		User user=(User)ac.getSession().get("user");
		if(user!=null){//用户存在
			//搜寻货物种类
		names=NameDao.selectName();
		Outs=OutDao.selectOut(user.getUid(), st,gn,nowpage, Myconf.limitCount);
		nowpage++;//页码+1
		setNowpage(nowpage);//设置当前页码+1
		if(count==0){//第一次加载
		//获取总数,页面中获取存储
		setCount(OutDao.selectCounts(user.getUid(), st,gn));
		}
		//这里计算总数
		for(Out out : Outs){
			if(out.getUid()==user.getUid()){//收到货
				incount+=out.getCount();//统计收货
			}else if(out.getFid()==user.getUid()){//发出货
				outcount+=out.getCount();//统计发货
			}
		}
		}else{
			return "toLogin";
		}
		return SUCCESS;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public ArrayList<Out> getOuts() {
		return Outs;
	}
	public void setOuts(ArrayList<Out> outs) {
		Outs = outs;
	}
	public int getIncount() {
		return incount;
	}
	public void setIncount(int incount) {
		this.incount = incount;
	}
	public int getOutcount() {
		return outcount;
	}
	public void setOutcount(int outcount) {
		this.outcount = outcount;
	}
	
	public String getGn() {
		return gn;
	}
	public void setGn(String gn) {
		this.gn = gn;
	}
	public ArrayList<GoodsName> getNames() {
		return names;
	}
	public void setNames(ArrayList<GoodsName> names) {
		this.names = names;
	}
	
}

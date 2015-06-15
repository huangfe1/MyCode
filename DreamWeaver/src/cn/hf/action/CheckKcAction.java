package cn.hf.action;

import java.util.ArrayList;

import cn.hf.bean.GoodsName;
import cn.hf.bean.KuCun;
import cn.hf.bean.Out;
import cn.hf.bean.User;
import cn.hf.dao.GoodsDao;
import cn.hf.dao.KuDao;
import cn.hf.dao.NameDao;
import cn.hf.dao.OutDao;
import cn.hf.util.Myconf;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CheckKcAction implements Action{
	private int nowpage;
	private int count;
	private String number;
	private ArrayList<KuCun> kcs;
	private String name;
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
		kcs=KuDao.selectByFid(user.getUid(), name, gn,nowpage,Myconf.limitCount);
		nowpage++;//页码+1
		setNowpage(nowpage);//设置当前页码+1
		if(count==0){//第一次加载
		//获取总数,页面中获取存储
		setCount(KuDao.selectCountByFid(user.getUid(), name, gn));
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
	public ArrayList<KuCun> getKcs() {
		return kcs;
	}
	public void setKcs(ArrayList<KuCun> kcs) {
		this.kcs = kcs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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

package cn.hf.action;

import java.util.ArrayList;

import cn.hf.bean.Goods;
import cn.hf.bean.User;
import cn.hf.dao.GoodsDao;
import cn.hf.dao.UserDao;
import cn.hf.util.Myconf;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class MyGoodsAction implements Action{
	private int type;//0为库存,1为记录
	private int nowpage;
	private int count;
	private String st;
	private String sn;
	private String number;
	public ArrayList<Goods> goodses;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		if(user!=null){//用户存在
			if(number==null){//没有传来单个编号,st为时间,sn为代理商姓名
			setGoodses(GoodsDao.selectGoods(user.getUid(), type,st,sn,nowpage,Myconf.limitCount ));
			nowpage++;//页码+1
			setNowpage(nowpage);//设置当前页码+1
			if(count==0){//第一次加载
			//获取总数,页面中获取存储
			setCount(GoodsDao.selectGcounts(user.getUid(), type, st, sn));
			}
			}else{
				setGoodses(GoodsDao.selectGoods(user.getUid(), type, number));
				nowpage++;//页码+1
				setNowpage(nowpage);//设置当前页码+1
				setCount(getGoodses().size());//没有就是0，有就是1
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public ArrayList<Goods> getGoodses() {
		return goodses;
	}
	public void setGoodses(ArrayList<Goods> goodses) {
		this.goodses = goodses;
	}

		
}

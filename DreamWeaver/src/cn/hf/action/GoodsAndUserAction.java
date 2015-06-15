package cn.hf.action;

import java.util.ArrayList;

import cn.hf.bean.Goods;
import cn.hf.bean.User;
import cn.hf.dao.GoodsDao;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;

public class GoodsAndUserAction implements Action{
	private String code;
	private String number;
	private User user;
	private ArrayList<Goods> goodses;
	private String msg;
	private int pt;
	private int p;
	@Override
	public String execute() throws Exception {
		if(code!=null){
			user=UserDao.getUser(code);//查询已经
			if(user==null){
				user=UserDao.getUserByWeixin(code);
			}
			if(user==null){
				user=UserDao.getUserByPhone(code);
				}
			if(user==null){
				user=UserDao.getUserByName(code);
			}
		}
		if(user!=null){
			if(user.getStatus()==0){//状态为没有激活
				user=null;//设为空
			}
		}
		if(number!=null){
		     for(int i=0;i<number.length();i++){//去0操作
		    	 int index=number.length();
		    	 char s=number.charAt(0);
		    	 if(s=='0'){
		    		 number=number.substring(1,index);
		    	 }else{
		    		 break;
		    	 }
		     }
		     goodses=GoodsDao.selectGoods(number);
		}
		if(goodses==null&&user==null){
			msg="抱歉没有查询到相关信息,请确认后查询。";
		}
		/*if(user!=null){
			System.out.println("执行了");
			ImageUtil.writeImage(user, 1);//生成隐藏图
		}*/
		if(p==1){//是手机页面
			return "phone";
		}
		return SUCCESS;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Goods> getGoodses() {
		return goodses;
	}
	public void setGoodses(ArrayList<Goods> goodses) {
		this.goodses = goodses;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getPt() {
		return pt;
	}
	public void setPt(int pt) {
		this.pt = pt;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	
}

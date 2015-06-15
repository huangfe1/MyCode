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
	private int type;//0Ϊ���,1Ϊ��¼
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
		if(user!=null){//�û�����
			if(number==null){//û�д����������,stΪʱ��,snΪ����������
			setGoodses(GoodsDao.selectGoods(user.getUid(), type,st,sn,nowpage,Myconf.limitCount ));
			nowpage++;//ҳ��+1
			setNowpage(nowpage);//���õ�ǰҳ��+1
			if(count==0){//��һ�μ���
			//��ȡ����,ҳ���л�ȡ�洢
			setCount(GoodsDao.selectGcounts(user.getUid(), type, st, sn));
			}
			}else{
				setGoodses(GoodsDao.selectGoods(user.getUid(), type, number));
				nowpage++;//ҳ��+1
				setNowpage(nowpage);//���õ�ǰҳ��+1
				setCount(getGoodses().size());//û�о���0���о���1
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

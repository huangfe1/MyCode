package cn.hf.action;

import java.util.ArrayList;

import cn.hf.bean.Goods;
import cn.hf.bean.User;
import cn.hf.dao.GoodsDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LookGoodsAction implements Action{
	private int gid;
	private ArrayList<Goods> goodses;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		goodses=GoodsDao.selectHisByGid(gid, user.getUid());
		return SUCCESS;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public ArrayList<Goods> getGoodses() {
		return goodses;
	}
	public void setGoodses(ArrayList<Goods> goodses) {
		this.goodses = goodses;
	}

}

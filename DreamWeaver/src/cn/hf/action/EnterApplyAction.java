  package cn.hf.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hf.bean.Apply;
import cn.hf.bean.Goods;
import cn.hf.bean.KuCun;
import cn.hf.bean.Out;
import cn.hf.bean.User;
import cn.hf.dao.ApplyDao;
import cn.hf.dao.GoodsDao;
import cn.hf.dao.KuDao;
import cn.hf.dao.OutDao;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class EnterApplyAction implements Action{
	private String wid;
	private int aid;
	private String msg;
	public int type;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User)ac.getSession().get("user");
		if(user!=null){
			//首先获取详单
			Apply apply=ApplyDao.getApply(aid);
			ApplyDao.changeApply(aid,0,wid);//修改当前表单,录入完成
			KuDao.update(apply.getFid(), apply.getGname(), -apply.getGcount());//申请人库存减去实际录入的
			//录入成功插入一条Out记录
			Out out=new Out();
			out.setType(1);//这是发货
			KuCun kc=KuDao.select(apply.getFid());//获取发货人的库存
			out.setFid(apply.getFid());//设置发货人id
			out.setUid(apply.getUid());//设置收货人的id
			//获取当前时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());
			out.setTime(time);
			String mygname=apply.getGname();
			out.setFkucun(kc.getGnames().get(mygname));//设置发货人的库存
			kc=KuDao.select(apply.getUid());//获取收货人的库存
			if(kc!=null&&kc.getGnames().containsKey(mygname)){//此人可能还没有次货物的余存
				out.setSkucun(kc.getGnames().get(mygname));//设置收货人的库存
			}else{
				out.setSkucun(0);
			}
			out.setCount(apply.getGcount());//发货数量
			out.setGname(mygname);//发货数量
			OutDao.insert(out);
			msg="录入成功,点击继续";
			return "countinfo";
		}
			return "toLogin";
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}

package cn.hf.action;

import java.util.Map;

import cn.hf.bean.KuCun;
import cn.hf.bean.Out;
import cn.hf.bean.User;
import cn.hf.dao.KuDao;
import cn.hf.dao.OutDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DeleteOutAction implements Action{
	private int oid;
	private String msg;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		Map session=ac.getSession();
		User user=(User)session.get("user");
		if(user==null||user.getType()!=0){//公司用户
			return "toLogin";
		}
		Out out=OutDao.selectOut(oid);
		if(out.getFid()==user.getUid()){//只能删除自己的记录
			KuCun kc=KuDao.select(out.getUid());//找出收货人的库存
			if(kc.getGnames().get(out.getGname())>=out.getCount()){//还有这么多货物
				if(out.getUid()!=1){//收货人不是zmz,才给发货人添加
				KuDao.update(out.getFid(), out.getGname(), out.getCount());
				}
				KuDao.update(out.getUid(), out.getGname(), -out.getCount());
				OutDao.delete(oid);//删除代理
			}else{
				msg="删除失败,下级代理已将货物转出";
			}
		}
		
		return SUCCESS;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}

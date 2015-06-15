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
			//���Ȼ�ȡ�굥
			Apply apply=ApplyDao.getApply(aid);
			ApplyDao.changeApply(aid,0,wid);//�޸ĵ�ǰ��,¼�����
			KuDao.update(apply.getFid(), apply.getGname(), -apply.getGcount());//�����˿���ȥʵ��¼���
			//¼��ɹ�����һ��Out��¼
			Out out=new Out();
			out.setType(1);//���Ƿ���
			KuCun kc=KuDao.select(apply.getFid());//��ȡ�����˵Ŀ��
			out.setFid(apply.getFid());//���÷�����id
			out.setUid(apply.getUid());//�����ջ��˵�id
			//��ȡ��ǰʱ��
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());
			out.setTime(time);
			String mygname=apply.getGname();
			out.setFkucun(kc.getGnames().get(mygname));//���÷����˵Ŀ��
			kc=KuDao.select(apply.getUid());//��ȡ�ջ��˵Ŀ��
			if(kc!=null&&kc.getGnames().containsKey(mygname)){//���˿��ܻ�û�дλ�������
				out.setSkucun(kc.getGnames().get(mygname));//�����ջ��˵Ŀ��
			}else{
				out.setSkucun(0);
			}
			out.setCount(apply.getGcount());//��������
			out.setGname(mygname);//��������
			OutDao.insert(out);
			msg="¼��ɹ�,�������";
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

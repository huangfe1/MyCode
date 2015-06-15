package cn.hf.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cn.hf.bean.Goods;
import cn.hf.bean.User;
import cn.hf.dao.GoodsDao;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class BackGoodsAction implements Action{
	private int gid;
	private int[] checkbox1;
	private ArrayList<Goods> wgses;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		wgses=new ArrayList<>();
		if(user!=null){//�û�����
		if(gid!=0){//����ɾ��
			Goods goods=GoodsDao.selectByGid(gid);
			if(user.getUid()==goods.getFid()){//�������ҷ���
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String time=df.format(new Date());//��ȡʱ��
				GoodsDao.backGoods(gid, user.getUid(), time);
			}else{
				wgses.add(goods);
			}
		}
		if(checkbox1!=null){//Ⱥ��ɾ��
			for(int i=0; i<checkbox1.length;i++){
				int gid=checkbox1[0];
				Goods goods=GoodsDao.selectByGid(gid);
				if(user.getUid()==goods.getFid()){//�������ҷ���
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String time=df.format(new Date());//��ȡʱ��
					if(user.getType()==0){//��˾�û�����ֱ��ɾ��
						GoodsDao.deleteGoods(gid);
					}else{
						GoodsDao.backGoods(gid, user.getUid(), time);//���ص��ҵĲֿ�
						//ɾ����¼
						GoodsDao.deleteHistory(user.getUid(), gid);
					}
				}else{
					wgses.add(goods);
				}
			}
		}
		if(wgses.size()!=0){//����0
			return ERROR;
		}else{//����
			return SUCCESS;
		}
		}
		return "toLogin";
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int[] getCheckbox1() {
		return checkbox1;
	}
	public void setCheckbox1(int[] checkbox1) {
		this.checkbox1 = checkbox1;
	}
	public ArrayList<Goods> getWgses() {
		return wgses;
	}
	public void setWgses(ArrayList<Goods> wgses) {
		this.wgses = wgses;
	}
	
}

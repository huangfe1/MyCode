  package cn.hf.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hf.bean.Apply;
import cn.hf.bean.Goods;
import cn.hf.bean.KuCun;
import cn.hf.bean.User;
import cn.hf.dao.ApplyDao;
import cn.hf.dao.GoodsDao;
import cn.hf.dao.KuDao;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CopyOfEnterApplyAction implements Action{
	private String wid;
	private int aid;
	private int type;
	private List<Integer> list;
	private ArrayList<Goods> wgses;
	private ArrayList<Goods> ngses;
	private String msg;
	private int gcount;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User)ac.getSession().get("user");
		wgses=new ArrayList<>();
		ngses=new ArrayList<>();
		if(user!=null){
			//���Ȼ�ȡ�굥
			Apply apply=ApplyDao.getApply(aid);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());//��ȡʱ��
			Goods goods=new Goods();
			goods.setUid(apply.getUid());//�ջ���
			goods.setName(apply.getGname());//��Ʒ����
			goods.setTime(time);//ʱ��
				if(type==0){//����¼��
					int count=list.size()/2;
					for(int i=0;i<count;i++){
						//�ж�һ���Ƿ񳬹���
						if(gcount>=apply.getGcount()){
							break;
						}
						int f=list.get(i);
						int e=list.get(i+count);
						if(f<=e){//ѭ��¼������
							for(int j=f;j<=e;j++){
								//�ж�һ���Ƿ񳬹���
								if(gcount>=apply.getGcount()){
									break;
								}
								goods.setNumber(j+"");//���ñ���
								//ͨ��id��ѯ�Ƿ��д˻���
								String n=j+"";
								Goods gs=GoodsDao.selectByNumber(n);
								if(gs==null){//�����ڴ˻���
									if(user.getType()==0){//��˾�û�
									//����˻���
									GoodsDao.insertGoods(goods);
									//����
									gcount++;
									}else{//�����û�
										gs=new Goods();
										gs.setNumber(n);
										//�����ڴ˻���
										ngses.add(gs);
									}
								}else{		 //���ڻ�ȡ
									if(gs.getUid()==user.getUid()&&gs.getName().equals(apply.getGname())){//���ҵĻ��ﲢ���Ǵ˲�Ʒ��
										GoodsDao.changeGoods(goods);
										gcount++;//����
									}else{//δ��Ȩ
										wgses.add(gs);
									}
								}
							}
							
						}
					}
				}
				if(gcount!=0){
				int c=apply.getGcount()-gcount;//�����-ʵ��¼���
				ApplyDao.changeApply(aid,c,wid);//�޸ĵ�ǰ��
				KuDao.update(apply.getFid(), apply.getGname(), -gcount);//�����˿���ȥʵ��¼���
				if(gcount<apply.getGcount()){//¼�벻ȫ
					//����һ���Ѿ������˵�apply
					Apply a=new Apply();
					a=apply;
					a.setGcount(gcount);//��������Ϊʵ��¼������
					a.setStatus(1);//�Ѿ�����
					a.setWid(wid);
					ApplyDao.insert(a);//����һ���Ѿ�¼��ļ�¼
					msg="����ֻ¼����"+gcount+"��,����"+c;
				}
				}
				if(ngses.size()!=0||wgses.size()!=0){
						return ERROR;
				}else{//����¼���¼
					return SUCCESS;
				}
		}
			return "toLogin";
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	public ArrayList<Goods> getWgses() {
		return wgses;
	}
	public void setWgses(ArrayList<Goods> wgses) {
		this.wgses = wgses;
	}
	public ArrayList<Goods> getNgses() {
		return ngses;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setNgses(ArrayList<Goods> ngses) {
		this.ngses = ngses;
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
	
}

package cn.hf.action;

import java.util.ArrayList;
import java.util.HashMap;

import cn.hf.bean.KuCun;
import cn.hf.bean.User;
import cn.hf.dao.KuDao;
import cn.hf.dao.OutDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class MyKcAction implements Action{
	private KuCun kc;
	private ArrayList<KuCun> kcs;
	private ArrayList<KcInfo> kfs;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User user=(User) ac.getSession().get("user");
		kfs=new ArrayList<MyKcAction.KcInfo>();
		if(user!=null){//�û�����
			if(user.getType()==1){//�����û�
			kc=KuDao.select(user.getUid());
			}else{
				kcs=KuDao.selectAll();//�ҳ�gsCount,nowCount
				HashMap<String, Integer> rm=OutDao.selectAllCount();//��ȡ���
				
				for(int i=0;i<kcs.size();i++){
					KcInfo kf=new KcInfo();
					String gname=kcs.get(i).getGname();
					kf.setGname(gname);//��������
					if(rm.containsKey(gname)){
						kf.setAllcount(rm.get(gname));//�������
					}else{
						kf.setAllcount(0);//�������
					}
					kf.setGscount(kcs.get(i).getCount());//��˾���
					kf.setNowcount(kcs.get(i).getAllcount());//�ⷿ����
					kf.setDlcount(kf.getNowcount()-kf.getGscount());//�г����
					kf.setFscount(kf.getAllcount()-kf.getNowcount());//��������
					kfs.add(kf);
				}
			}
			return SUCCESS;
		}
		return "toLogin";
	}
	public ArrayList<KcInfo> getKfs() {
		return kfs;
	}
	public void setKfs(ArrayList<KcInfo> kfs) {
		this.kfs = kfs;
	}
	public KuCun getKc() {
		return kc;
	}
	public void setKc(KuCun kc) {
		this.kc = kc;
	}
	public ArrayList<KuCun> getKcs() {
		return kcs;
	}
	public void setKcs(ArrayList<KuCun> kcs) {
		this.kcs = kcs;
	}
	public class KcInfo{
		public int allcount;//�������
		public int gscount;//��˾���
		public int dlcount;//�������
		public int fscount;//��������
		public String gname;//��Ʒ����
		public int nowcount;//�ⷿ���(gs+dl)
		public String getGname() {
			return gname;
		}
		public int getAllcount() {
			return allcount;
		}
		public void setAllcount(int allcount) {
			this.allcount = allcount;
		}
		public int getGscount() {
			return gscount;
		}
		public void setGscount(int gscount) {
			this.gscount = gscount;
		}
		public int getDlcount() {
			return dlcount;
		}
		public void setDlcount(int dlcount) {
			this.dlcount = dlcount;
		}
		public int getFscount() {
			return fscount;
		}
		public void setFscount(int fscount) {
			this.fscount = fscount;
		}
		public int getNowcount() {
			return nowcount;
		}
		public void setNowcount(int nowcount) {
			this.nowcount = nowcount;
		}
		public void setGname(String gname) {
			this.gname = gname;
		}
	}
}

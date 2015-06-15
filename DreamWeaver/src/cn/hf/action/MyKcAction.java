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
		if(user!=null){//用户存在
			if(user.getType()==1){//代理用户
			kc=KuDao.select(user.getUid());
			}else{
				kcs=KuDao.selectAll();//找出gsCount,nowCount
				HashMap<String, Integer> rm=OutDao.selectAllCount();//获取入库
				
				for(int i=0;i<kcs.size();i++){
					KcInfo kf=new KcInfo();
					String gname=kcs.get(i).getGname();
					kf.setGname(gname);//设置名字
					if(rm.containsKey(gname)){
						kf.setAllcount(rm.get(gname));//入库总量
					}else{
						kf.setAllcount(0);//入库总量
					}
					kf.setGscount(kcs.get(i).getCount());//公司余存
					kf.setNowcount(kcs.get(i).getAllcount());//库房总数
					kf.setDlcount(kf.getNowcount()-kf.getGscount());//市场余存
					kf.setFscount(kf.getAllcount()-kf.getNowcount());//发货数量
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
		public int allcount;//入库总量
		public int gscount;//公司余存
		public int dlcount;//代理余存
		public int fscount;//发货总数
		public String gname;//产品类型
		public int nowcount;//库房余存(gs+dl)
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

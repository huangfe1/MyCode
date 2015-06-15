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
			//首先获取详单
			Apply apply=ApplyDao.getApply(aid);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());//获取时间
			Goods goods=new Goods();
			goods.setUid(apply.getUid());//收货人
			goods.setName(apply.getGname());//产品名字
			goods.setTime(time);//时间
				if(type==0){//串号录入
					int count=list.size()/2;
					for(int i=0;i<count;i++){
						//判断一下是否超过了
						if(gcount>=apply.getGcount()){
							break;
						}
						int f=list.get(i);
						int e=list.get(i+count);
						if(f<=e){//循环录入数组
							for(int j=f;j<=e;j++){
								//判断一下是否超过了
								if(gcount>=apply.getGcount()){
									break;
								}
								goods.setNumber(j+"");//设置编码
								//通过id查询是否有此货物
								String n=j+"";
								Goods gs=GoodsDao.selectByNumber(n);
								if(gs==null){//不存在此货物
									if(user.getType()==0){//公司用户
									//插入此货物
									GoodsDao.insertGoods(goods);
									//计数
									gcount++;
									}else{//代理用户
										gs=new Goods();
										gs.setNumber(n);
										//不存在此货物
										ngses.add(gs);
									}
								}else{		 //存在获取
									if(gs.getUid()==user.getUid()&&gs.getName().equals(apply.getGname())){//是我的货物并且是此产品名
										GoodsDao.changeGoods(goods);
										gcount++;//计数
									}else{//未授权
										wgses.add(gs);
									}
								}
							}
							
						}
					}
				}
				if(gcount!=0){
				int c=apply.getGcount()-gcount;//申请的-实际录入的
				ApplyDao.changeApply(aid,c,wid);//修改当前表单
				KuDao.update(apply.getFid(), apply.getGname(), -gcount);//申请人库存减去实际录入的
				if(gcount<apply.getGcount()){//录入不全
					//生成一条已经处理了的apply
					Apply a=new Apply();
					a=apply;
					a.setGcount(gcount);//设置数量为实际录入数量
					a.setStatus(1);//已经处理
					a.setWid(wid);
					ApplyDao.insert(a);//插入一条已经录入的记录
					msg="本次只录入了"+gcount+"件,还差"+c;
				}
				}
				if(ngses.size()!=0||wgses.size()!=0){
						return ERROR;
				}else{//返回录入记录
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

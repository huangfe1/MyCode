package cn.hf.action;

import java.util.ArrayList;
import java.util.Map;

import cn.hf.bean.Apply;
import cn.hf.bean.GoodsName;
import cn.hf.bean.KuCun;
import cn.hf.bean.User;
import cn.hf.dao.ApplyDao;
import cn.hf.dao.KuDao;
import cn.hf.dao.NameDao;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
public class ResultAction implements Action{
	private int type;//录入形式0为串号录入,1为单号录入
	private ArrayList<User> users;
	private ArrayList<GoodsName> names;
	private User user;
	private int uid;
	private String name;
	private String levels;
	private int aid;//申请表单
	private String gname;//货物类型
	private String msg;
	//private int gcount;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		Map session=ac.getSession();
		User us=(User)session.get("user");
		if(us!=null){//如果用户存在
			String jspName=ac.getName();
			if(jspName.equals("enterGoodsjsp")||jspName.equals("addUserjsp")||jspName.equals("applyGoodsjsp")||jspName.equals("changeUserjsp")||jspName.equals("addGoodsjsp")||jspName.equals("outGoodsjsp")){//主页面,添加用户,修改用户查询指定代理
				//这里要查询用户的下级代理
				ArrayList<User>	users=new ArrayList<>();
				users=UserDao.getUserByFid(us.getUid());//选出其所有用户,通过等级排序
				if(!jspName.equals("outGoodsjsp")&&!jspName.equals("enterGoodsjsp")){//转货不能填写自己
					User uss=(User) us.clone();
					uss.setUsername("我自己");
					users.add(0, uss);//把自己添加到第一位
				}
				setUsers(users);//加入valueStack对象中
				if(jspName.equals("enterGoodsjsp")||jspName.equals("applyGoodsjsp")||jspName.equals("addGoodsjsp")||jspName.equals("outGoodsjsp")){
				//这里查询商品名字
				ArrayList<GoodsName> names=new ArrayList<>();
				names=NameDao.selectName();
				setNames(names);
				}
				if(jspName.equals("changeUserjsp")){//修改用户界面,获取修改用户的信息
					//获取parameter中uid的值
					user=UserDao.getUser(uid);
				}
			}
			if(jspName.equals("enterApplyjsp")){//处理申请,查看库存
				//获取当前用户的库存
				Apply apply=ApplyDao.getApply(aid);//获取当前apply
				if(apply==null){//如果不存在
					msg="您选择的申请已被删除";
					return "myapply";
				}
				KuCun kc=KuDao.select(apply.getFid());//获取申请人的库存详情
				if(kc.getGnames().get(apply.getGname())<apply.getGcount()){//库存小于申请的数目
					msg="库存不足:"+apply.getFname()+"  申请发货  "+apply.getGname()+apply.getGcount()+"件,当前库存为"+kc.getGnames().get(apply.getGname())+"件";
					return "myapply";
				}
			}
			return SUCCESS;
		}else{
			String msg="亲,请先登录^_^";
			ActionContext.getContext().put("msg", msg);
			return "toLogin";
		}
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ArrayList<GoodsName> getNames() {
		return names;
	}
	public void setNames(ArrayList<GoodsName> names) {
		this.names = names;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

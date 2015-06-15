package cn.hf.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cn.hf.bean.Apply;
import cn.hf.bean.KuCun;
import cn.hf.bean.User;
import cn.hf.dao.ApplyDao;
import cn.hf.dao.KuDao;
import cn.hf.dao.UserDao;
import cn.hf.util.Myconf;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
public class ApplyGoodsAction implements Action{
	private Apply apply;//
	private String dlname;
	private String cname;
	private String msg;
	private int uid;
	@Override
	public String execute() throws Exception {
		Map ac=ActionContext.getContext().getSession();
		User us=(User)ac.get("user");
		if(us!=null){
			if(dlname!=null&&!dlname.equals("")){//如果存在dlname
				//找出收货人的id
				User user=UserDao.getUser(dlname);//换成了code
				if(user!=null){//如果用户不为空
					uid=user.getUid();//uid设置为当前代理的uid
				}else{
					msg="请确认您填写的是本公司的代理";
					return ERROR;
				}
			}else if(cname!=null&&!cname.equals("")){//普通用户
				//普通用户人
				uid=0;
				apply.setCname(cname);//设置普通用户名字
			}
			//看数量
			KuCun kc=KuDao.select(us.getUid());//搜寻此人的库存
			if(kc!=null&&kc.getGnames().containsKey(apply.getGname())){//如果包含此货物
				int count=kc.getGnames().get(apply.getGname());//获取数量
				if(count<apply.getGcount()){//库存不足
					msg="库存不足,您当前只拥有"+count+"件"+apply.getGname()+"产品";
					return ERROR;
				}
			}else{
				msg="库存不足,您当前只拥有"+0+"件"+apply.getGname()+"产品";
				return ERROR;
			}
			//获取当前时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());
			//apply.setFid(us.getUid());//设置发货人id
			apply.setFid(us.getUid());
			apply.setTime(time);//设置时间
			apply.setUid(uid);//普通用户的id为0
			apply.setStatus(0);//设置状态
			ApplyDao.insert(apply);//插入记录
		}else{
			return "toLogin";
		}
		return SUCCESS;
	}
	public Apply getApply() {
		return apply;
	}
	public void setApply(Apply apply) {
		this.apply = apply;
	}
	public String getDlname() {
		return dlname;
	}
	public void setDlname(String dlname) {
		this.dlname = dlname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}

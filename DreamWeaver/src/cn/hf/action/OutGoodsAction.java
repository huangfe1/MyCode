package cn.hf.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cn.hf.bean.KuCun;
import cn.hf.bean.Out;
import cn.hf.bean.User;
import cn.hf.dao.KuDao;
import cn.hf.dao.OutDao;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class OutGoodsAction implements Action{
	private String dlname;
	private int uid;
	private String msg;
	private Out out;
	@Override
	public String execute() throws Exception {
		Map ac=ActionContext.getContext().getSession();
		User us=(User)ac.get("user");
		if(us==null){//如果用户存在就可以转账
			return "toLogin";
		}
		if(dlname!=null&&!dlname.equals("")){
			User u=UserDao.getUserByName(dlname);//查出代理名字
			if(u!=null){
				uid=u.getUid();
			}else{
				msg="请确认+"+dlname+"这是本公司的代理";
				return "wrong";
			}
		}
		//看数量
		KuCun kc=KuDao.select(us.getUid());//搜寻发货人的库存
		if(kc!=null&&kc.getGnames().containsKey(out.getGname())){//如果包含此货物
			int count=kc.getGnames().get(out.getGname());//获取数量
			if(count<out.getCount()){//库存不足
				msg="库存不足,您当前只拥有"+count+"件"+out.getGname()+"产品";
				return "wrong";
			}
		}else{
			msg="库存不足,您当前只拥有"+0+"件"+out.getGname()+"产品";
			return "wrong";
		}
		//先刷新库存转出操作
		KuDao.update(us.getUid(), out.getGname(),-1*out.getCount());//发货人减去货物
		KuDao.update(uid, out.getGname(),out.getCount());//收货人增加货物
		//生成记录
		out.setFid(us.getUid());
		out.setUid(uid);
		//获取当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(new Date());
		out.setTime(time);
		//库存中插入发货人的库存,初始库存减去发货库存
		out.setFkucun(kc.getGnames().get(out.getGname())-out.getCount());
				//首先查询出收货人的库存
		kc=KuDao.select(out.getUid());
		//库存中插入收货人的当前余存
		out.setSkucun(kc.getGnames().get(out.getGname()));
		OutDao.insert(out);//插入一条记录
		//msg="您本次转出了"+out.getCount()+"件"+out.getGname()+"产品";
		return SUCCESS;
	}
	public String getDlname() {
		return dlname;
	}
	public void setDlname(String dlname) {
		this.dlname = dlname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Out getOut() {
		return out;
	}
	public void setOut(Out out) {
		this.out = out;
	}
	
}

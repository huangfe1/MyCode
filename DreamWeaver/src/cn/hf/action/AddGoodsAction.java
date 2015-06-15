package cn.hf.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import cn.hf.bean.KuCun;
import cn.hf.bean.Out;
import cn.hf.bean.User;
import cn.hf.dao.KuDao;
import cn.hf.dao.OutDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class AddGoodsAction implements Action{
	private Out out;
	private String msg;
	@Override
	public String execute() throws Exception {
		Map ac=ActionContext.getContext().getSession();
		User user=(User)ac.get("user");
		if(user!=null&&user.getType()==0){//公司用户存在
			if(out.getCount()<=0){
				msg="请规范填写";
				return "wrong";
			}
			//获取当前时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());
			//zmz转给zmz
			out.setTime(time);
			out.setFid(user.getUid());
			out.setUid(user.getUid());
			KuDao.update(out.getUid(),out.getGname(),out.getCount());
			//更新之后再获取
			KuCun kc=KuDao.select(user.getUid());//获取公司的库存
			out.setFkucun(kc.getGnames().get(out.getGname()));
			out.setSkucun(kc.getGnames().get(out.getGname()));
			OutDao.insert(out);
			//msg="本次添加了"+out.getGname()+"产品"+out.getCount()+"件";
			return SUCCESS;
		}
			return "toLogin";
	}
	public Out getOut() {
		return out;
	}
	public void setOut(Out out) {
		this.out = out;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

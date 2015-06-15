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
		if(user!=null&&user.getType()==0){//��˾�û�����
			if(out.getCount()<=0){
				msg="��淶��д";
				return "wrong";
			}
			//��ȡ��ǰʱ��
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());
			//zmzת��zmz
			out.setTime(time);
			out.setFid(user.getUid());
			out.setUid(user.getUid());
			KuDao.update(out.getUid(),out.getGname(),out.getCount());
			//����֮���ٻ�ȡ
			KuCun kc=KuDao.select(user.getUid());//��ȡ��˾�Ŀ��
			out.setFkucun(kc.getGnames().get(out.getGname()));
			out.setSkucun(kc.getGnames().get(out.getGname()));
			OutDao.insert(out);
			//msg="���������"+out.getGname()+"��Ʒ"+out.getCount()+"��";
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

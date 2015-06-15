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
		if(us==null){//����û����ھͿ���ת��
			return "toLogin";
		}
		if(dlname!=null&&!dlname.equals("")){
			User u=UserDao.getUserByName(dlname);//�����������
			if(u!=null){
				uid=u.getUid();
			}else{
				msg="��ȷ��+"+dlname+"���Ǳ���˾�Ĵ���";
				return "wrong";
			}
		}
		//������
		KuCun kc=KuDao.select(us.getUid());//��Ѱ�����˵Ŀ��
		if(kc!=null&&kc.getGnames().containsKey(out.getGname())){//��������˻���
			int count=kc.getGnames().get(out.getGname());//��ȡ����
			if(count<out.getCount()){//��治��
				msg="��治��,����ǰֻӵ��"+count+"��"+out.getGname()+"��Ʒ";
				return "wrong";
			}
		}else{
			msg="��治��,����ǰֻӵ��"+0+"��"+out.getGname()+"��Ʒ";
			return "wrong";
		}
		//��ˢ�¿��ת������
		KuDao.update(us.getUid(), out.getGname(),-1*out.getCount());//�����˼�ȥ����
		KuDao.update(uid, out.getGname(),out.getCount());//�ջ������ӻ���
		//���ɼ�¼
		out.setFid(us.getUid());
		out.setUid(uid);
		//��ȡ��ǰʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(new Date());
		out.setTime(time);
		//����в��뷢���˵Ŀ��,��ʼ����ȥ�������
		out.setFkucun(kc.getGnames().get(out.getGname())-out.getCount());
				//���Ȳ�ѯ���ջ��˵Ŀ��
		kc=KuDao.select(out.getUid());
		//����в����ջ��˵ĵ�ǰ���
		out.setSkucun(kc.getGnames().get(out.getGname()));
		OutDao.insert(out);//����һ����¼
		//msg="������ת����"+out.getCount()+"��"+out.getGname()+"��Ʒ";
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

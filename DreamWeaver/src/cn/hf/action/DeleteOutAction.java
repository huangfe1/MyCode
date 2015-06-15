package cn.hf.action;

import java.util.Map;

import cn.hf.bean.KuCun;
import cn.hf.bean.Out;
import cn.hf.bean.User;
import cn.hf.dao.KuDao;
import cn.hf.dao.OutDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DeleteOutAction implements Action{
	private int oid;
	private String msg;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		Map session=ac.getSession();
		User user=(User)session.get("user");
		if(user==null||user.getType()!=0){//��˾�û�
			return "toLogin";
		}
		Out out=OutDao.selectOut(oid);
		if(out.getFid()==user.getUid()){//ֻ��ɾ���Լ��ļ�¼
			KuCun kc=KuDao.select(out.getUid());//�ҳ��ջ��˵Ŀ��
			if(kc.getGnames().get(out.getGname())>=out.getCount()){//������ô�����
				if(out.getUid()!=1){//�ջ��˲���zmz,�Ÿ����������
				KuDao.update(out.getFid(), out.getGname(), out.getCount());
				}
				KuDao.update(out.getUid(), out.getGname(), -out.getCount());
				OutDao.delete(oid);//ɾ������
			}else{
				msg="ɾ��ʧ��,�¼������ѽ�����ת��";
			}
		}
		
		return SUCCESS;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}

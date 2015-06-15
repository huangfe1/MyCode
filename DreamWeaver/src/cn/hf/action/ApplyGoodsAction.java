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
			if(dlname!=null&&!dlname.equals("")){//�������dlname
				//�ҳ��ջ��˵�id
				User user=UserDao.getUser(dlname);//������code
				if(user!=null){//����û���Ϊ��
					uid=user.getUid();//uid����Ϊ��ǰ�����uid
				}else{
					msg="��ȷ������д���Ǳ���˾�Ĵ���";
					return ERROR;
				}
			}else if(cname!=null&&!cname.equals("")){//��ͨ�û�
				//��ͨ�û���
				uid=0;
				apply.setCname(cname);//������ͨ�û�����
			}
			//������
			KuCun kc=KuDao.select(us.getUid());//��Ѱ���˵Ŀ��
			if(kc!=null&&kc.getGnames().containsKey(apply.getGname())){//��������˻���
				int count=kc.getGnames().get(apply.getGname());//��ȡ����
				if(count<apply.getGcount()){//��治��
					msg="��治��,����ǰֻӵ��"+count+"��"+apply.getGname()+"��Ʒ";
					return ERROR;
				}
			}else{
				msg="��治��,����ǰֻӵ��"+0+"��"+apply.getGname()+"��Ʒ";
				return ERROR;
			}
			//��ȡ��ǰʱ��
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());
			//apply.setFid(us.getUid());//���÷�����id
			apply.setFid(us.getUid());
			apply.setTime(time);//����ʱ��
			apply.setUid(uid);//��ͨ�û���idΪ0
			apply.setStatus(0);//����״̬
			ApplyDao.insert(apply);//�����¼
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

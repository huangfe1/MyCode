package cn.hf.action;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ChangeUserAction implements Action{
	public User user;
	private int fuid;
	private String msg;
	private String dlname;//��д�Ĵ�����
	private int uid;//�û�uid
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User u=(User) ac.getSession().get("user");
		uid=user.getUid();//��ǰ�û���id,����valuestack,��תʱ����Ҫ
		if(user.getInfo()==null||user.getInfo().equals("")){
			msg="����д��ע!";
			return "error";
		}
		if(u!=null){
		user.setLevel(user.getLevel());
		if(u.getType()==0){//��˾�û�
		if(!dlname.equals("")&&dlname!=null){//�д�����
			//User us=UserDao.getUserByName(dlname);
			User us=UserDao.getUser(dlname);//ͨ����Ż�ȡ
			if(us!=null){//������û�
				//����ֻ�ܸ��Լ��Ĵ�������¼�����
				if(u.getType()==1&&us.getFid()!=u.getUid()){//�����û�,��д�Ĳ����Լ�
					msg="����д���û����������¼�";
					return "error";
				}
				fuid=us.getUid();//����fid
			}else{//û���û�
				msg="��Ǹ����д���û���Ų�����";
				return "error";
			}
		}
		}
		user.setFid(fuid);
		try {
			UserDao.changeUser(user);
			/*ImageUtil.writeImage(user,0);//�޸�ԭʼͼ,�޸�����ͼ
			ImageUtil.writeImage(user,1);*/
			return SUCCESS;
		} catch (Exception e) {
			msg="��ȷ��,�ֻ�,΢��,���֤�˺�û�б�ʹ��";
			return "error";
		}
		}
		return "toLogin";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFuid() {
		return fuid;
	}
	public void setFuid(int fuid) {
		this.fuid = fuid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
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
	
}

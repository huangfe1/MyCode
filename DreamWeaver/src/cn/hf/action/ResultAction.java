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
	private int type;//¼����ʽ0Ϊ����¼��,1Ϊ����¼��
	private ArrayList<User> users;
	private ArrayList<GoodsName> names;
	private User user;
	private int uid;
	private String name;
	private String levels;
	private int aid;//�����
	private String gname;//��������
	private String msg;
	//private int gcount;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		Map session=ac.getSession();
		User us=(User)session.get("user");
		if(us!=null){//����û�����
			String jspName=ac.getName();
			if(jspName.equals("enterGoodsjsp")||jspName.equals("addUserjsp")||jspName.equals("applyGoodsjsp")||jspName.equals("changeUserjsp")||jspName.equals("addGoodsjsp")||jspName.equals("outGoodsjsp")){//��ҳ��,����û�,�޸��û���ѯָ������
				//����Ҫ��ѯ�û����¼�����
				ArrayList<User>	users=new ArrayList<>();
				users=UserDao.getUserByFid(us.getUid());//ѡ���������û�,ͨ���ȼ�����
				if(!jspName.equals("outGoodsjsp")&&!jspName.equals("enterGoodsjsp")){//ת��������д�Լ�
					User uss=(User) us.clone();
					uss.setUsername("���Լ�");
					users.add(0, uss);//���Լ���ӵ���һλ
				}
				setUsers(users);//����valueStack������
				if(jspName.equals("enterGoodsjsp")||jspName.equals("applyGoodsjsp")||jspName.equals("addGoodsjsp")||jspName.equals("outGoodsjsp")){
				//�����ѯ��Ʒ����
				ArrayList<GoodsName> names=new ArrayList<>();
				names=NameDao.selectName();
				setNames(names);
				}
				if(jspName.equals("changeUserjsp")){//�޸��û�����,��ȡ�޸��û�����Ϣ
					//��ȡparameter��uid��ֵ
					user=UserDao.getUser(uid);
				}
			}
			if(jspName.equals("enterApplyjsp")){//��������,�鿴���
				//��ȡ��ǰ�û��Ŀ��
				Apply apply=ApplyDao.getApply(aid);//��ȡ��ǰapply
				if(apply==null){//���������
					msg="��ѡ��������ѱ�ɾ��";
					return "myapply";
				}
				KuCun kc=KuDao.select(apply.getFid());//��ȡ�����˵Ŀ������
				if(kc.getGnames().get(apply.getGname())<apply.getGcount()){//���С���������Ŀ
					msg="��治��:"+apply.getFname()+"  ���뷢��  "+apply.getGname()+apply.getGcount()+"��,��ǰ���Ϊ"+kc.getGnames().get(apply.getGname())+"��";
					return "myapply";
				}
			}
			return SUCCESS;
		}else{
			String msg="��,���ȵ�¼^_^";
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

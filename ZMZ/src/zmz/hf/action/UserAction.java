package zmz.hf.action;


import java.util.HashMap;
import java.util.Map;

import zmz.hf.common.BaseAction;
import zmz.hf.util.ConfigUtil;
import zmz.hf.util.TimeUtil;
import zmz.zwq.modal.Admin;
import zmz.zwq.modal.Agent;
import zmz.zwq.modal.Function;
import zmz.zwq.modal.Level;
import zmz.zwq.modal.Role;
import zmz.zwq.modal.User;

public class UserAction extends BaseAction{
	private int pageType;//ҳ������
	private String msg;//���ص���Ϣ
	//��½
	private String code;//�˺�
	private String paw;//����
	//�����û�
	private Agent agent;
	private String agentCode;//�¼�����ı��
	//�޸�����
	private String oldpaw;
	/**
	 * ��½
	 * @return
	 */
	public String login(){
		switch (pageType) {//0Ϊ�����̵�½1Ϊ��˾��½
		case 0:
			Agent ag= getAgent(code);
			if(ag!=null&&ag.getUserStatus()==1&&ag.getUserPassword().equals(paw)){//����
				session.put("sagent", ag);
			}else{
				msg="�˺��������,����û�м���";
			}
			break;
		case 1:
			Admin myadmin= getAdmin(code);
			if(myadmin!=null&&myadmin.getUserStatus()==1&&myadmin.getUserPassword().equals(paw)){//����
				session.put("sadmin", myadmin);
			}else{//�����ڻ���û�м���
				msg="�˺��������,����û�м���";
			}
			break;
		}
		
		if(msg==null||msg.equals("")){//û�д�����Ϣ,�ɹ�
			next=MIANJSP;//��ת����ҳ
		}else{
			next=LOGINJSP;//��ת����½ҳ��
			return CHAIN;
		}
		return REDIRECTACTION;
	}
	/**
	 * ���Ӵ���
	 */
	public String add(){
		//�����ж���Ϣ�Ƿ�ʹ�ù�
		if(isExist(agent)){
			msg="����΢��,�ֻ���,���֤�Ƿ�ʹ�ù�";
		}
		if(agent.getAgentPhone().length()<11){//�绰�������
			msg="����ȷ��д�ֻ���";
		}
		if(agentCode!=null&&!agentCode.equals("")){//ֱ����д�Ĵ����ŵ�
				Agent ag=getAgent(code);
				if(ag==null){//�����ڻ���û�м���
					msg="�������ڻ���û�м���";
				}else{
					agent.setAgentUpId(ag.getUserId());//������Ӵ�����ϼ�
				}
		}	
	if(msg==null||msg.equals("")){//Ϊ��
		//����������Ϣ
		agent.setAgentCode(getAgentCode(agent));//���ñ���
		agent.setAgentTime(TimeUtil.getTime());//���õ�ǰʱ��
		if(sadmin!=null){//���ü���״̬
			agent.setUserStatus(1);
		}else{
			if(ConfigUtil.getActivityLevel().contains(agent.getAgentLevel().getLevelId())){
				agent.setUserStatus(1);
			}
		}
		addAgent(agent);//�����ݿ��в������
		next=ZSIMAGE;//��ʾ֤��
		return VIEW;
	}
	next=USERADDJSP;//��Ӵ������
	return CHAIN;
	}
	/**
	 * �޸�����
	 * @return
	 */
	public String changePaw(){
		User u;int type;
		if(sadmin!=null){//����Ա
			u=sadmin;type=1;
		}else{
			u=sagent;type=0;
		}
		//������ͬ
		if(u.getUserPassword().equals(oldpaw)){
			changePaw(type,u.getUserId(),paw);//�޸�����
			msg="�����޸ĳɹ�";
			return INFO;
		}else{
			 msg="�����벻��ȷ";
			 next=CHANGEPAWJSP;
			 return CHAIN;
		}
		
	}

	/**
	 * �����û�
	 */
	private String activity(){
	
		return CHAIN;
	}
	/**
	 * �˳�ϵͳ
	 */
	public String out(){
		if(session.containsKey("sagent")){
			session.remove("sagent");//�Ƴ�agent
		}
		if(session.containsKey("sadmin")){
			session.remove("sadmin");//�Ƴ�agent
		}
		next=INDEX;
		return REDIRECTACTION;
	}
	
	/*****************************************�������Զ��巽��******************************************/
	
	/**
	 * ��ò���4�������
	 * @param n
	 * @return
	 */
	private String getRandom(int n){
		String str="";
		for(int i=0;i<n;i++){
			String s=(int)(Math.random()*10)+"";
			 while(s.contains("4")){//֪����������
				 s=(int)(Math.random()*10)+"";
			 }
			 str+=s;
		}
		return str;
	}
	/**
	 * �滻���ַ��е�4
	 * @param str
	 * @return
	 */
	private String removeFour(String str){
		while(str.contains("4")){//����4
			String s="";
			for(int i=0;i<str.length();i++){
				if(str.substring(i,i+1).equals("4")){//������ַ�4�滻��
					s+=getRandom(1);
				}else{//�����滻
					s+=str.substring(i,i+1);
				}
			}
			str=s;
			System.out.println("="+str);
		}
		return str;
	}
	/**
	 * ���ɴ�����
	 * @param agent
	 * @return
	 */
	private String getAgentCode(Agent agent){
		String phone=agent.getAgentPhone();
		//��ȡ���绰���������λ��
		String code=agent.getAgentPhone().substring(phone.length()-4,phone.length());
		code=removeFour(code);//ȥ���ַ�4
		//����˳��
		String c0=code.charAt(0)+"";
		String c1=code.charAt(1)+"";
		String c2=code.charAt(2)+"";
		String c3=code.charAt(3)+"";
		String c4=getRandom(1);//�����
		String c5=getRandom(1);//�����
		code="zmz"+c5+c3+c1+c4+c2+c0;
		while(codeExist(code)){//��code������������
			c4=getRandom(1);//�����
			c5=getRandom(1);//�����
			code="zmz"+c5+c3+c1+c4+c2+c0;
		}
		return code;
	}
	/************************************ǿ�����������ݿ����****************************************/
	/**
	 * 
	 * @param type 0Ϊ�޸Ĵ��� 1Ϊ�޸Ĺ���Ա
	 * @param uid   �û���id
	 * @param paw  �������޸ĳ�paw
	 */
	private void changePaw(int type,int uid,String paw){
		
	}
	/**ǿ��
	 * �����ݿ����
	 * @param agent
	 */
	private void addAgent(Agent agent){
		
	}
	/*
	 * 	�����ݿ����΢��,�ֻ�,���֤�Ƿ�ʹ�ù�
	 */
	private boolean isExist(Agent agent){
	
		return false;
	}
	/**
	 * �ж�code�Ƿ����
	 * @param code
	 * @return
	 */
	private boolean codeExist(String code){
		return false;
	}
	/**ǿ��
	 * ��ȡ����Ĺ���Ա
	 * @return null �� Admin
	 */
	private Admin getAdmin(String code){
		Admin admin=new Admin();
		admin.setUserPassword("1");
		Role role=new Role();
		role.setRoleName("���");
		admin.setAdminRole(role);
		admin.setUserName("�Ʒɹ���Ա");
		admin.setUserStatus(1);
		Map<String, Function> map=new HashMap<String, Function>();
		map.put("user_list_alljsp", new Function());
		map.put("user_addjsp", new Function());
		map.put("user_add", new Function());
		map.put("user_list_alljsp",new Function());
		role.setRoleFun(map);
		return admin;
	}
	/**ǿ��
	 * ͨ����Ż�ȡ����Ĵ���
	 * @return null �� User
	 */
	private Agent getAgent(String code){
		Agent agent=new Agent();
		agent.setUserPassword("1");
		agent.setAgentCode("zmz123456");
		agent.setAgentLevelName("һ��");
		agent.setUserId(1);
		agent.setUserName("�Ʒ�");
		agent.setUserStatus(1);
		Level l=new Level();
		l.setLevelId(1);
		l.setLevelName("�ȼ�"+1);
		agent.setAgentLevel(l);
		return agent;
	}
	public int getPageType() {
		return pageType;
	}
	public void setPageType(int pageType) {
		this.pageType = pageType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPaw() {
		return paw;
	}
	public void setPaw(String paw) {
		this.paw = paw;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getOldpaw() {
		return oldpaw;
	}
	public void setOldpaw(String oldpaw) {
		this.oldpaw = oldpaw;
	}
	
}

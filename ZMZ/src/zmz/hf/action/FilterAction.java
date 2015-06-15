package zmz.hf.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import sun.management.resources.agent;

import com.opensymphony.xwork2.ActionContext;

import demo.Pinyin4jAppletDemo;
import zmz.hf.common.BaseAction;
import zmz.hf.util.ConfigUtil;
import zmz.hf.util.PinyinComparator;
import zmz.zwq.modal.Admin;
import zmz.zwq.modal.Agent;
import zmz.zwq.modal.Level;

public class FilterAction extends BaseAction{
	private ArrayList<Agent> agents;//�¼�����
	private ConfigUtil config;//������
	private int fid;//�û���id
	private ArrayList<Level> levels;//���еĵȼ�
	//��ҳ����
	private String lvMsg="";//�ȼ���Ϣ
	private int currentPage;//��ǰҳ��
	private int sum;//��ѯ������
	private int slevelId=-1;//����ȼ�
	private String stime="";//����ʱ��
	private String param="";//��������
	/**
	 * ҳ�����
	 */
	public String execute(){
		if(sadmin!=null){//����Աʹ��ͳһ��id
			sagent=getZmz();//��ȡ����Ĺ�˾�û�
		}
		fid=sagent.getUserId();
		config=new ConfigUtil();
		String jspName=ActionContext.getContext().getName();//������
		switch (jspName) {
		case LOGINJSP ://ֱ�������½����,��ת��indexȥ�ж�
			next=INDEX;
			return CHAIN;
		case USERADDJSP://���Ӵ������
			//���ҳ��¼�����
			agents=getAgents(fid);
			Collections.sort(agents,new PinyinComparator());//ͨ����������
			agents.add(0,sagent);//���Լ���ӽ�ȥ
			//������еȼ�
			levels=getLevel();
			break;
		case USERLISTALLJSP://��ѯ�����û�
			currentPage++;//ҳ��+1
			//������еȼ�
			levels=getLevel();
			if(lvMsg==null||lvMsg.equals("")){//��һ�β�ѯ
				lvMsg=getAllLvMsg();
				sum=getAllSum();
			}
			agents=getAllAgents(currentPage,param,slevelId,stime);
			break;
	    case USERLISTMYJSP://��ѯ�Լ����û�
	    	currentPage++;//ҳ��+1
	    	//������еȼ�
			levels=getLevel();
			if(lvMsg==null||lvMsg.equals("")){//��һ�β�ѯ
				lvMsg=getLvMsg(sagent.getUserId());
				sum=getSum(sagent.getUserId());
			}
			agents=getAgents(sagent.getUserId(),currentPage,param,slevelId,stime);
			break;
		}
		return SUCCESS;
	}
	public ConfigUtil getConfig() {
		return config;
	}
	public void setConfig(ConfigUtil config) {
		this.config = config;
	}
	/*********************************************ǿ�����ݿ����***************************************************/
		
	/**
		 * ��ȡfid��������д��������
		 * @param fid
		 * @return
		 */
	private int getSum( int fid){
		return 30;
	}
	/**
	 * ��ȡ���д��������
	 * @return
	 */
	private int getAllSum(){
		
		return 100;
	}
	/**
		 * ��ȡfid����ĸ��ȼ����������
		 * @param fid
		 * @return
		 */
	private String getLvMsg(int fid){
		String s="һ��:30,����:40,����:50,�ļ�:90";
		return s;
	}
	/**
	 * ��ȡ���еĸ���������
	 * @return
	 */
	private  String getAllLvMsg(){
		String s="һ��:30,����:40,����:50,�ļ�:90";
		return s;
	}
	/**
	 * 
	 * @param currentPage ��ǰҳ
	 * @param param ���,����,΢�ź�,�ֻ�,���֤
	 * @param slevelId  ����ȼ�id
	 * @param stime ʱ��
	 * @return
	 */
	private ArrayList<Agent> getAllAgents(int currentPage,String param,int slevelId,String stime){
		//ֻ��ʱ��,ֻ�д���ȼ�,������һ��,��û��
		if(slevelId!=-1){//ɸѡ�ȼ�
			
		}
		if(!stime.equals("")){//��Ҫ����ʱ��ɸѡ
			
		}
		//
		if(!param.equals("")){
		
		}
		//��������
		 return getAgents(1);
	}
	/**
	 * ��ҳ��ȡ����
	 * @param fid �ϼ���id
	 * @return 
	 */
	private ArrayList<Agent> getAgents(int fid,int currentPage,String param,int slevelId,String stime){
		//��������
		 return getAgents(1);
	}
	/**
	 * ����fid��ȡ�¼������б�
	 * @param fid
	 * @return 
	 */
	private ArrayList<Agent> getAgents(int fid){
		 ArrayList<Agent> as=new ArrayList<Agent>();
		 for(int i=0;i<20;i++){
			Agent a=new Agent();
			a.setAgentCode("zmz12122"+i);
			a.setAgentUpName("zmz");
			a.setUserPassword("8888");
			a.setAgentTime("8888");
			a.setUserId(i);
			a.setUserName("����"+i);
			if(i==0){
				a.setUserName("�ƴ���"+i);a.setUserStatus(1);
			}
			if(i==1){
				a.setUserStatus(1);
				a.setUserName("�״���"+i);
			}
			if(i==2){
				a.setUserName("������"+i);a.setUserStatus(1);
			}
			a.setAgentIdcard("43052311950120761X");
			a.setAgentInfo("����");
			a.setAgentPhone("15673188984");
			a.setAgentWechat("505860922");
			a.setAgentLevelName("�ȼ�"+i);
			Level l=new Level();
			l.setLevelId(i);l.setLevelName("�ȼ�"+i);
			a.setAgentLevel(l);
			as.add(a);
		 }
		 return as;
 	}
	/**
	 * ��ȡ���е����еȼ�
	 * @return
	 */
	private ArrayList<Level> getLevel(){
		ArrayList<Level> levels=new ArrayList<Level>();
		for(int i=0;i<3;i++){
			Level l=new Level();
			l.setLevelId(i);
			l.setLevelName(i+"������");
			levels.add(l);
		}
		return levels;
	}
	/**
	 * ��ȡ�����zmz�˺�
	 * @return
	 */
	private Agent getZmz(){
			Agent a=new Agent();
			a.setAgentCode("zmz");
			a.setAgentUpId(1);
			a.setUserId(1);
			Level level=new Level();
			level.setLevelId(0);
			level.setLevelName("����Ա");
			a.setAgentLevel(level);
			a.setUserName("zmz");
			return a;
	}
	public ArrayList<Agent> getAgents() {
		return agents;
	}
	public void setAgents(ArrayList<Agent> agents) {
		this.agents = agents;
	}
	public void setLevels(ArrayList<Level> levels) {
		this.levels = levels;
	}
	public ArrayList<Level> getLevels() {
		return levels;
	}
	public String getLvMsg() {
		return lvMsg;
	}
	public void setLvMsg(String lvMsg) {
		this.lvMsg = lvMsg;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public int getSlevelId() {
		return slevelId;
	}
	public void setSlevelId(int slevelId) {
		this.slevelId = slevelId;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}




}

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
	private ArrayList<Agent> agents;//下级代理
	private ConfigUtil config;//配置类
	private int fid;//用户的id
	private ArrayList<Level> levels;//所有的等级
	//翻页操作
	private String lvMsg="";//等级信息
	private int currentPage;//当前页数
	private int sum;//查询的总数
	private int slevelId=-1;//代理等级
	private String stime="";//代理时间
	private String param="";//其他参数
	/**
	 * 页面过滤
	 */
	public String execute(){
		if(sadmin!=null){//管理员使用统一的id
			sagent=getZmz();//获取虚拟的公司用户
		}
		fid=sagent.getUserId();
		config=new ConfigUtil();
		String jspName=ActionContext.getContext().getName();//请求名
		switch (jspName) {
		case LOGINJSP ://直接请求登陆界面,跳转到index去判断
			next=INDEX;
			return CHAIN;
		case USERADDJSP://增加代理界面
			//查找出下级代理
			agents=getAgents(fid);
			Collections.sort(agents,new PinyinComparator());//通过姓名排序
			agents.add(0,sagent);//将自己添加进去
			//查出所有等级
			levels=getLevel();
			break;
		case USERLISTALLJSP://查询所有用户
			currentPage++;//页码+1
			//查出所有等级
			levels=getLevel();
			if(lvMsg==null||lvMsg.equals("")){//第一次查询
				lvMsg=getAllLvMsg();
				sum=getAllSum();
			}
			agents=getAllAgents(currentPage,param,slevelId,stime);
			break;
	    case USERLISTMYJSP://查询自己的用户
	    	currentPage++;//页码+1
	    	//查出所有等级
			levels=getLevel();
			if(lvMsg==null||lvMsg.equals("")){//第一次查询
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
	/*********************************************强哥数据库操作***************************************************/
		
	/**
		 * 获取fid下面的所有代理的总数
		 * @param fid
		 * @return
		 */
	private int getSum( int fid){
		return 30;
	}
	/**
	 * 获取所有代理的总数
	 * @return
	 */
	private int getAllSum(){
		
		return 100;
	}
	/**
		 * 获取fid下面的各等级代理的总数
		 * @param fid
		 * @return
		 */
	private String getLvMsg(int fid){
		String s="一级:30,二级:40,三级:50,四级:90";
		return s;
	}
	/**
	 * 获取所有的个代理总数
	 * @return
	 */
	private  String getAllLvMsg(){
		String s="一级:30,二级:40,三级:50,四级:90";
		return s;
	}
	/**
	 * 
	 * @param currentPage 当前页
	 * @param param 编号,姓名,微信号,手机,身份证
	 * @param slevelId  代理等级id
	 * @param stime 时间
	 * @return
	 */
	private ArrayList<Agent> getAllAgents(int currentPage,String param,int slevelId,String stime){
		//只有时间,只有代理等级,有其中一个,都没有
		if(slevelId!=-1){//筛选等级
			
		}
		if(!stime.equals("")){//需要根据时间筛选
			
		}
		//
		if(!param.equals("")){
		
		}
		//测试数据
		 return getAgents(1);
	}
	/**
	 * 分页获取代理
	 * @param fid 上级的id
	 * @return 
	 */
	private ArrayList<Agent> getAgents(int fid,int currentPage,String param,int slevelId,String stime){
		//测试数据
		 return getAgents(1);
	}
	/**
	 * 根据fid获取下级代理列表
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
			a.setUserName("代理"+i);
			if(i==0){
				a.setUserName("黄代理"+i);a.setUserStatus(1);
			}
			if(i==1){
				a.setUserStatus(1);
				a.setUserName("白代理"+i);
			}
			if(i==2){
				a.setUserName("啊代理"+i);a.setUserStatus(1);
			}
			a.setAgentIdcard("43052311950120761X");
			a.setAgentInfo("付款");
			a.setAgentPhone("15673188984");
			a.setAgentWechat("505860922");
			a.setAgentLevelName("等级"+i);
			Level l=new Level();
			l.setLevelId(i);l.setLevelName("等级"+i);
			a.setAgentLevel(l);
			as.add(a);
		 }
		 return as;
 	}
	/**
	 * 获取现有的所有等级
	 * @return
	 */
	private ArrayList<Level> getLevel(){
		ArrayList<Level> levels=new ArrayList<Level>();
		for(int i=0;i<3;i++){
			Level l=new Level();
			l.setLevelId(i);
			l.setLevelName(i+"级代理");
			levels.add(l);
		}
		return levels;
	}
	/**
	 * 获取虚拟的zmz账号
	 * @return
	 */
	private Agent getZmz(){
			Agent a=new Agent();
			a.setAgentCode("zmz");
			a.setAgentUpId(1);
			a.setUserId(1);
			Level level=new Level();
			level.setLevelId(0);
			level.setLevelName("管理员");
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

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
	private int pageType;//页面类型
	private String msg;//返回的信息
	//登陆
	private String code;//账号
	private String paw;//密码
	//增加用户
	private Agent agent;
	private String agentCode;//下级代理的编号
	//修改密码
	private String oldpaw;
	/**
	 * 登陆
	 * @return
	 */
	public String login(){
		switch (pageType) {//0为代理商登陆1为公司登陆
		case 0:
			Agent ag= getAgent(code);
			if(ag!=null&&ag.getUserStatus()==1&&ag.getUserPassword().equals(paw)){//存在
				session.put("sagent", ag);
			}else{
				msg="账号密码错误,或者没有激活";
			}
			break;
		case 1:
			Admin myadmin= getAdmin(code);
			if(myadmin!=null&&myadmin.getUserStatus()==1&&myadmin.getUserPassword().equals(paw)){//存在
				session.put("sadmin", myadmin);
			}else{//不存在或者没有激活
				msg="账号密码错误,或者没有激活";
			}
			break;
		}
		
		if(msg==null||msg.equals("")){//没有错误信息,成功
			next=MIANJSP;//跳转到主页
		}else{
			next=LOGINJSP;//跳转到登陆页面
			return CHAIN;
		}
		return REDIRECTACTION;
	}
	/**
	 * 增加代理
	 */
	public String add(){
		//首先判断信息是否被使用过
		if(isExist(agent)){
			msg="请检查微信,手机号,身份证是否被使用过";
		}
		if(agent.getAgentPhone().length()<11){//电话号码错误
			msg="请正确填写手机号";
		}
		if(agentCode!=null&&!agentCode.equals("")){//直接填写的代理编号的
				Agent ag=getAgent(code);
				if(ag==null){//不存在或者没有激活
					msg="代理不存在或者没有激活";
				}else{
					agent.setAgentUpId(ag.getUserId());//设置添加代理的上级
				}
		}	
	if(msg==null||msg.equals("")){//为空
		//设置其他信息
		agent.setAgentCode(getAgentCode(agent));//设置编码
		agent.setAgentTime(TimeUtil.getTime());//设置当前时间
		if(sadmin!=null){//设置激活状态
			agent.setUserStatus(1);
		}else{
			if(ConfigUtil.getActivityLevel().contains(agent.getAgentLevel().getLevelId())){
				agent.setUserStatus(1);
			}
		}
		addAgent(agent);//往数据库中插入代理
		next=ZSIMAGE;//显示证书
		return VIEW;
	}
	next=USERADDJSP;//添加代理界面
	return CHAIN;
	}
	/**
	 * 修改密码
	 * @return
	 */
	public String changePaw(){
		User u;int type;
		if(sadmin!=null){//管理员
			u=sadmin;type=1;
		}else{
			u=sagent;type=0;
		}
		//密码相同
		if(u.getUserPassword().equals(oldpaw)){
			changePaw(type,u.getUserId(),paw);//修改密码
			msg="密码修改成功";
			return INFO;
		}else{
			 msg="旧密码不正确";
			 next=CHANGEPAWJSP;
			 return CHAIN;
		}
		
	}

	/**
	 * 激活用户
	 */
	private String activity(){
	
		return CHAIN;
	}
	/**
	 * 退出系统
	 */
	public String out(){
		if(session.containsKey("sagent")){
			session.remove("sagent");//移除agent
		}
		if(session.containsKey("sadmin")){
			session.remove("sadmin");//移除agent
		}
		next=INDEX;
		return REDIRECTACTION;
	}
	
	/*****************************************这里是自定义方法******************************************/
	
	/**
	 * 获得不带4的随机数
	 * @param n
	 * @return
	 */
	private String getRandom(int n){
		String str="";
		for(int i=0;i<n;i++){
			String s=(int)(Math.random()*10)+"";
			 while(s.contains("4")){//知道不包含四
				 s=(int)(Math.random()*10)+"";
			 }
			 str+=s;
		}
		return str;
	}
	/**
	 * 替换掉字符中的4
	 * @param str
	 * @return
	 */
	private String removeFour(String str){
		while(str.contains("4")){//包含4
			String s="";
			for(int i=0;i<str.length();i++){
				if(str.substring(i,i+1).equals("4")){//如果是字符4替换掉
					s+=getRandom(1);
				}else{//否则不替换
					s+=str.substring(i,i+1);
				}
			}
			str=s;
			System.out.println("="+str);
		}
		return str;
	}
	/**
	 * 生成代理编号
	 * @param agent
	 * @return
	 */
	private String getAgentCode(Agent agent){
		String phone=agent.getAgentPhone();
		//获取到电话号码后面四位数
		String code=agent.getAgentPhone().substring(phone.length()-4,phone.length());
		code=removeFour(code);//去掉字符4
		//打乱顺序
		String c0=code.charAt(0)+"";
		String c1=code.charAt(1)+"";
		String c2=code.charAt(2)+"";
		String c3=code.charAt(3)+"";
		String c4=getRandom(1);//随机数
		String c5=getRandom(1);//随机数
		code="zmz"+c5+c3+c1+c4+c2+c0;
		while(codeExist(code)){//当code存在重新生成
			c4=getRandom(1);//随机数
			c5=getRandom(1);//随机数
			code="zmz"+c5+c3+c1+c4+c2+c0;
		}
		return code;
	}
	/************************************强哥这里是数据库操作****************************************/
	/**
	 * 
	 * @param type 0为修改代理 1为修改管理员
	 * @param uid   用户的id
	 * @param paw  把密码修改成paw
	 */
	private void changePaw(int type,int uid,String paw){
		
	}
	/**强哥
	 * 往数据库插入
	 * @param agent
	 */
	private void addAgent(Agent agent){
		
	}
	/*
	 * 	从数据库查找微信,手机,身份证是否被使用过
	 */
	private boolean isExist(Agent agent){
	
		return false;
	}
	/**
	 * 判断code是否存在
	 * @param code
	 * @return
	 */
	private boolean codeExist(String code){
		return false;
	}
	/**强哥
	 * 获取激活的管理员
	 * @return null 或 Admin
	 */
	private Admin getAdmin(String code){
		Admin admin=new Admin();
		admin.setUserPassword("1");
		Role role=new Role();
		role.setRoleName("库管");
		admin.setAdminRole(role);
		admin.setUserName("黄飞管理员");
		admin.setUserStatus(1);
		Map<String, Function> map=new HashMap<String, Function>();
		map.put("user_list_alljsp", new Function());
		map.put("user_addjsp", new Function());
		map.put("user_add", new Function());
		map.put("user_list_alljsp",new Function());
		role.setRoleFun(map);
		return admin;
	}
	/**强哥
	 * 通过编号获取激活的代理
	 * @return null 或 User
	 */
	private Agent getAgent(String code){
		Agent agent=new Agent();
		agent.setUserPassword("1");
		agent.setAgentCode("zmz123456");
		agent.setAgentLevelName("一级");
		agent.setUserId(1);
		agent.setUserName("黄飞");
		agent.setUserStatus(1);
		Level l=new Level();
		l.setLevelId(1);
		l.setLevelName("等级"+1);
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

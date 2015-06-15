package zmz.hf.action;

import zmz.hf.common.BaseAction;
import zmz.hf.common.Static;
import zmz.hf.util.ConfigUtil;
import zmz.zwq.modal.Agent;

public class IndexAction extends BaseAction{
	public ConfigUtil config;//网站的配置
	public  String execute(){
		config=new ConfigUtil();
		//session还存在
		if(sadmin==null||!hasAgent(sagent)){//都不存在
			return LOGIN;//登陆界面
		}
		return SUCCESS;//主页
	}
	/**
	 * 
	 * @param 判断是否有存在agent
	 * @return
	 */
	private boolean hasAgent(Agent sagent){
		if(sagent!=null){
			Agent magent=(Agent) Static.LOGIN_USERS.get(sagent.getAgentCode());//获取Agent
			if(magent.getLoginTime()==sagent.getLoginTime()){//登陆时间一样
				return true;
			}	
		}
		return false;
	}
	public ConfigUtil getConfig() {
		return config;
	}
	public void setConfig(ConfigUtil config) {
		this.config = new ConfigUtil();
	}

}

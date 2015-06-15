package zmz.hf.action;

import zmz.hf.common.BaseAction;
import zmz.hf.common.Static;
import zmz.hf.util.ConfigUtil;
import zmz.zwq.modal.Agent;

public class IndexAction extends BaseAction{
	public ConfigUtil config;//��վ������
	public  String execute(){
		config=new ConfigUtil();
		//session������
		if(sadmin==null||!hasAgent(sagent)){//��������
			return LOGIN;//��½����
		}
		return SUCCESS;//��ҳ
	}
	/**
	 * 
	 * @param �ж��Ƿ��д���agent
	 * @return
	 */
	private boolean hasAgent(Agent sagent){
		if(sagent!=null){
			Agent magent=(Agent) Static.LOGIN_USERS.get(sagent.getAgentCode());//��ȡAgent
			if(magent.getLoginTime()==sagent.getLoginTime()){//��½ʱ��һ��
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

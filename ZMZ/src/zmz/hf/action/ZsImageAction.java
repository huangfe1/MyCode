package zmz.hf.action;

import java.io.IOException;
import java.io.InputStream;

import zmz.hf.common.BaseAction;
import zmz.hf.util.ImageUtil;
import zmz.zwq.modal.Admin;
import zmz.zwq.modal.Agent;

public class ZsImageAction extends BaseAction{
	public int usertype;
	public String code;
	public InputStream getInputStream() throws IOException{
		if(sadmin!=null){
			usertype=1;
		}else{
			usertype=0;
		}
		InputStream ips=ImageUtil.getImageStream(getAgent(code), usertype);
		return ips;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * �����ݿ��ȡ������
	 * @param code �û����
	 * @return null��agent
	 */
	public Agent getAgent(String code){
		Agent agent=new Agent();
		agent.setAgentCode("zmz123456");
		agent.setAgentLevelName("һ������");
		agent.setUserId(1);
		agent.setUserName("�Ʒ�");
		agent.setAgentPhone("156734188984");
		agent.setAgentWechat("huangfeiwexin");
		agent.setAgentIdcard("43052319950120761X");
		agent.setAgentTime("2015/5/6");
		agent.setUserStatus(1);
		return agent;
	}
}

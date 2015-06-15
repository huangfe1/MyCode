package zmz.hf.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import zmz.hf.util.ConfigUtil;
import zmz.hf.util.SysOut;
import zmz.zwq.modal.Admin;
import zmz.zwq.modal.Agent;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyIntercept extends AbstractInterceptor{
		private String msg;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//ȥ��String���Ͳ������ַ�
		transfer(invocation.getInvocationContext().getParameters());
		//��ȡsession
		Map session= ActionContext.getContext().getSession();
		//��ȡrequest
		HttpServletRequest request=ServletActionContext.getRequest();
		Admin admin=(Admin) session.get("sadmin");//����Ա
		Agent agent=(Agent) session.get("sagent");//������
		//��ȡ����Action��
		String actionName=getName();
		String result = null;
			SysOut.log("�����"+actionName);
			//�����˶��ܷ��ʵ�ҳ��
			if(!ConfigUtil.getAllUserAction().contains(actionName)){//����û�о��ܷ��ʵ�ҳ��
				//��ҪȨ�޲��ܷ���
				if(admin==null&&!hasAgent(agent)){//û�е�½
					msg="���ȵ�½";
					request.setAttribute("msg", msg);                                
					result="ban";//������Ȩ����
				}
				else{//��½��
					//���ǵ�½���ܷ��ʵ�ҳ��
						if(!ConfigUtil.getLoginUserAction().contains(actionName)){
								//����Ա�������û��Ȩ��
								if(!adminCan(admin,actionName)||!agentCan(agent,actionName)){
									msg="Ȩ�޲���";
									request.setAttribute("msg", msg);                                
									result="ban";//������Ȩ����
								}
						}
				}
			}
		
			//��Ȩ�޷���
			if(result==null){
					result=invocation.invoke();
			}
		return result;
	}
	/**
	 * 
	 * @param params
	 * @return
	 */
	private void transfer(Map map){  
		 Set keys = map.keySet();  
		 Iterator it=keys.iterator();
		 while(it.hasNext()){
			 String key=it.next().toString();
			 Object value = map.get(key);
			 if(value instanceof String){//�����String���͵Ļ�
				 map.put(key, ((String)value).trim());//ȥ���ո�
			 }
		 }
    }  
	/**
	 * ��ȡ���ʵ�ActionName
	 * @return
	 */
private String getName( ){
	return ActionContext.getContext().getActionInvocation().getProxy().getActionName() ;
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
/**
 * ����Ա�Ƿ���Ȩ��
 * @return
 */
private boolean adminCan(Admin admin,String actionName){
	if(admin!=null){//�жϹ���Ա�Ƿ���Ȩ��
		if(!admin.getAdminRole().getRoleFun().containsKey(actionName)){
			return false;
		}
	}
	return true;
}
/**
 * �������Ƿ���Ȩ��
 * @return
 */
private boolean agentCan(Agent agent,String actionName){
	if(hasAgent(agent)){//�жϴ����Ƿ���Ȩ��
		if(!ConfigUtil.getAgentAction().contains(actionName)){
			return false;
		}
	}
	return true;
}
}

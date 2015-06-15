package zmz.hf.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.management.resources.agent;
import zmz.hf.util.ConfigUtil;
import zmz.hf.util.SysOut;
import zmz.zwq.modal.Admin;
import zmz.zwq.modal.Agent;
import zmz.zwq.modal.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CopyOfMyIntercept extends AbstractInterceptor{
		private String msg;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//��ȡsession
		Map session= ActionContext.getContext().getSession();
		//��ȡrequest
		HttpServletRequest request=ServletActionContext.getRequest();
		Admin admin=(Admin) session.get("admin");//����Ա
		Agent agent=(Agent) session.get("agent");//������
		//��ȡ����Action��
		String actionName=getName();
		String result = null;
			SysOut.log("�����"+actionName);
		//����Ҫ��½��Ȩ�޷��ʵ�ҳ��,��ҳ,��½,�˳�,֤��
		if(ConfigUtil.getAllUserAction().contains(actionName)){
			result=invocation.invoke();
		}
		else{//��Ҫ��½���ܷ��ʵ�
			if(admin==null&&!hasAgent(agent)){//û�е�½
				msg="��½��ʱ";
				request.setAttribute("msg", msg);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
				result="ban";//������ҳ
			}else{//��½��
				if(ConfigUtil.getLoginUserAction().contains(actionName)){//����ǵ�½�Ϳ��Է��ʵ�ҳ��
					result=invocation.invoke();
				}else{//��Ȩ�޵Ĺ���Ա���ܷ���
				//û��Ȩ��
				if(admin!=null&&!admin.getAdminRole().getRoleFun().containsKey(actionName)){//��������û��Ȩ�޵Ĺ���Ա
					msg="Ȩ�޲���";
					request.setAttribute("msg", msg);                                
					result="ban";//������Ȩ����
				}else if(hasAgent(agent)&&!ConfigUtil.getAgentAction().contains(actionName)){//�����̲��ܷ��ʵ�ҳ��
					msg="Ȩ�޲���";
					request.setAttribute("msg", msg);                                
					result="ban";//������Ȩ����
				}else{//��Ȩ��
						result=invocation.invoke();
				}
				}
			}
		}
		return result;
	}
	/**
	 * ��ȡ���ʵ�ActionName
	 * @return
	 */
private String getName( ){
	return ActionContext.getContext().getActionInvocation().getProxy().getActionName() ;
}
	/**
	 * �ж��Ƿ��д���agent
	 * 
	 */
private boolean hasAgent(Agent sagent){
	if(sagent==null){
		return false;
	}
	Agent magent=(Agent) Static.LOGIN_USERS.get(sagent.getAgentCode());//��ȡAgent
	if(magent.getLoginTime()==sagent.getLoginTime()){//��½ʱ��һ��
		return true;
	}	
	return false;
}

}

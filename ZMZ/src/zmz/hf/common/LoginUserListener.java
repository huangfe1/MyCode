package zmz.hf.common;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;







import zmz.hf.util.SysOut;
import zmz.zwq.modal.Agent;
import zmz.zwq.modal.User;

public class LoginUserListener implements HttpSessionAttributeListener,HttpSessionListener{
	/**
	 * session��������
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		//�߳�����
		synchronized (this) {
			//������+1
			Static.VISITOR_USERS_SUM++;
		}
	}
	/**
	 * sessionȡ������
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		Static.VISITOR_USERS_SUM--;//��������һ
		HttpSession session=event.getSession();
		Agent sagent=(Agent) session.getAttribute("sagent");//value
		if(sagent!=null){//ֻͳ�ƴ����̵���������
			Agent magent=(Agent) Static.LOGIN_USERS.get(sagent.getAgentCode());//��ȡmap�д洢��agent
			if(sagent.getLoginTime()==magent.getLoginTime()){//ʱ��һ��
				Static.LOGIN_USERS.remove(magent.getAgentCode());//�Ƴ���
			}
		}
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session=event.getSession();
		String attributeName=event.getName();
		if(attributeName.equals("sagent")){//ֻͳ�ƴ����̵���������
			Agent agent=(Agent) session.getAttribute("sagent");//value
			agent.setLoginTime(session.getCreationTime());//���õ�½ʱ��
			Agent agentt=(Agent) session.getAttribute("sagent");//value
			Static.LOGIN_USERS.put(agent.getAgentCode(), agent);//�������
		}
		
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String attributeName=event.getName();
		if(attributeName.equals("sagent")){//ֻͳ�ƴ����̵���������
			Agent sagent=(Agent) event.getValue();//��ȡ�Ƴ��Ķ���
			Agent magent=(Agent) Static.LOGIN_USERS.get(sagent.getAgentCode());//��ȡmap�д洢��agent
			if(magent!=null){
			if(sagent.getLoginTime()==magent.getLoginTime()){//ʱ��һ��
				Static.LOGIN_USERS.remove(magent.getAgentCode());//�Ƴ���
			}
			}
		}
		
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		HttpSession session=event.getSession();
		String attributeName=event.getName();
		if(attributeName.equals("sagent")){//ֻͳ�ƴ����̵���������
			Agent agent=(Agent) session.getAttribute("sagent");//value
			agent.setLoginTime(session.getCreationTime());//���õ�½ʱ��
			Static.LOGIN_USERS.put(agent.getAgentCode(), agent);//�������
		}
		
	}

}

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
	 * session创建监听
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		//线程锁定
		synchronized (this) {
			//访问量+1
			Static.VISITOR_USERS_SUM++;
		}
	}
	/**
	 * session取消监听
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		Static.VISITOR_USERS_SUM--;//访问量减一
		HttpSession session=event.getSession();
		Agent sagent=(Agent) session.getAttribute("sagent");//value
		if(sagent!=null){//只统计代理商的在线数量
			Agent magent=(Agent) Static.LOGIN_USERS.get(sagent.getAgentCode());//获取map中存储的agent
			if(sagent.getLoginTime()==magent.getLoginTime()){//时间一样
				Static.LOGIN_USERS.remove(magent.getAgentCode());//移除掉
			}
		}
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session=event.getSession();
		String attributeName=event.getName();
		if(attributeName.equals("sagent")){//只统计代理商的在线数量
			Agent agent=(Agent) session.getAttribute("sagent");//value
			agent.setLoginTime(session.getCreationTime());//设置登陆时间
			Agent agentt=(Agent) session.getAttribute("sagent");//value
			Static.LOGIN_USERS.put(agent.getAgentCode(), agent);//加入队列
		}
		
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String attributeName=event.getName();
		if(attributeName.equals("sagent")){//只统计代理商的在线数量
			Agent sagent=(Agent) event.getValue();//获取移除的对象
			Agent magent=(Agent) Static.LOGIN_USERS.get(sagent.getAgentCode());//获取map中存储的agent
			if(magent!=null){
			if(sagent.getLoginTime()==magent.getLoginTime()){//时间一样
				Static.LOGIN_USERS.remove(magent.getAgentCode());//移除掉
			}
			}
		}
		
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		HttpSession session=event.getSession();
		String attributeName=event.getName();
		if(attributeName.equals("sagent")){//只统计代理商的在线数量
			Agent agent=(Agent) session.getAttribute("sagent");//value
			agent.setLoginTime(session.getCreationTime());//设置登陆时间
			Static.LOGIN_USERS.put(agent.getAgentCode(), agent);//加入队列
		}
		
	}

}

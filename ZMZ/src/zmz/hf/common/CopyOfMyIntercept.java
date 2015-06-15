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
		//获取session
		Map session= ActionContext.getContext().getSession();
		//获取request
		HttpServletRequest request=ServletActionContext.getRequest();
		Admin admin=(Admin) session.get("admin");//管理员
		Agent agent=(Agent) session.get("agent");//代理商
		//获取请求Action名
		String actionName=getName();
		String result = null;
			SysOut.log("输出的"+actionName);
		//不需要登陆有权限访问的页面,首页,登陆,退出,证书
		if(ConfigUtil.getAllUserAction().contains(actionName)){
			result=invocation.invoke();
		}
		else{//需要登陆才能访问的
			if(admin==null&&!hasAgent(agent)){//没有登陆
				msg="登陆超时";
				request.setAttribute("msg", msg);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
				result="ban";//返回首页
			}else{//登陆了
				if(ConfigUtil.getLoginUserAction().contains(actionName)){//如果是登陆就可以访问的页面
					result=invocation.invoke();
				}else{//有权限的管理员才能访问
				//没有权限
				if(admin!=null&&!admin.getAdminRole().getRoleFun().containsKey(actionName)){//代理商与没有权限的管理员
					msg="权限不够";
					request.setAttribute("msg", msg);                                
					result="ban";//返回无权界面
				}else if(hasAgent(agent)&&!ConfigUtil.getAgentAction().contains(actionName)){//代理商不能访问的页面
					msg="权限不够";
					request.setAttribute("msg", msg);                                
					result="ban";//返回无权界面
				}else{//有权限
						result=invocation.invoke();
				}
				}
			}
		}
		return result;
	}
	/**
	 * 获取访问的ActionName
	 * @return
	 */
private String getName( ){
	return ActionContext.getContext().getActionInvocation().getProxy().getActionName() ;
}
	/**
	 * 判断是否有存在agent
	 * 
	 */
private boolean hasAgent(Agent sagent){
	if(sagent==null){
		return false;
	}
	Agent magent=(Agent) Static.LOGIN_USERS.get(sagent.getAgentCode());//获取Agent
	if(magent.getLoginTime()==sagent.getLoginTime()){//登陆时间一样
		return true;
	}	
	return false;
}

}

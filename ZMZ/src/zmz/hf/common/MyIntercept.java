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
		//去除String类型参数的字符
		transfer(invocation.getInvocationContext().getParameters());
		//获取session
		Map session= ActionContext.getContext().getSession();
		//获取request
		HttpServletRequest request=ServletActionContext.getRequest();
		Admin admin=(Admin) session.get("sadmin");//管理员
		Agent agent=(Agent) session.get("sagent");//代理商
		//获取请求Action名
		String actionName=getName();
		String result = null;
			SysOut.log("输出的"+actionName);
			//所有人都能访问的页面
			if(!ConfigUtil.getAllUserAction().contains(actionName)){//不是没有就能访问的页面
				//需要权限才能访问
				if(admin==null&&!hasAgent(agent)){//没有登陆
					msg="请先登陆";
					request.setAttribute("msg", msg);                                
					result="ban";//返回无权界面
				}
				else{//登陆了
					//不是登陆就能访问的页面
						if(!ConfigUtil.getLoginUserAction().contains(actionName)){
								//管理员与代理商没有权限
								if(!adminCan(admin,actionName)||!agentCan(agent,actionName)){
									msg="权限不够";
									request.setAttribute("msg", msg);                                
									result="ban";//返回无权界面
								}
						}
				}
			}
		
			//有权限放行
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
			 if(value instanceof String){//如果是String类型的话
				 map.put(key, ((String)value).trim());//去除空格
			 }
		 }
    }  
	/**
	 * 获取访问的ActionName
	 * @return
	 */
private String getName( ){
	return ActionContext.getContext().getActionInvocation().getProxy().getActionName() ;
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
/**
 * 管理员是否有权限
 * @return
 */
private boolean adminCan(Admin admin,String actionName){
	if(admin!=null){//判断管理员是否有权限
		if(!admin.getAdminRole().getRoleFun().containsKey(actionName)){
			return false;
		}
	}
	return true;
}
/**
 * 代理商是否有权限
 * @return
 */
private boolean agentCan(Agent agent,String actionName){
	if(hasAgent(agent)){//判断代理是否有权限
		if(!ConfigUtil.getAgentAction().contains(actionName)){
			return false;
		}
	}
	return true;
}
}

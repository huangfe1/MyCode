package cn.hf.action;

import java.util.Map;

import cn.hf.bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LogOutAction implements Action{
	@Override
	public String execute() throws Exception {
		Map<String, ?> ses=ActionContext.getContext().getSession();
		ses.put("user", null);
		if(ses.containsKey("user")){//如果有session
		ses.remove("user");//移除当前用户
		}
		return SUCCESS;
	}

}

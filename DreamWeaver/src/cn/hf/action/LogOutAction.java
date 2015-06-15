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
		if(ses.containsKey("user")){//�����session
		ses.remove("user");//�Ƴ���ǰ�û�
		}
		return SUCCESS;
	}

}

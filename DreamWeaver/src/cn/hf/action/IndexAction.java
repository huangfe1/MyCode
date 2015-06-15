package cn.hf.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class IndexAction implements Action{
	@Override
	public String execute() throws Exception {
		  Map session=ActionContext.getContext().getSession();
			if(session.get("user")!=null){//直接跳转到主页面
				return SUCCESS;
			}else{
				return ERROR;//跳转到登陆页面
			}
	}

}

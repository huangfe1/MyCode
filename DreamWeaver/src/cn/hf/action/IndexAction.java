package cn.hf.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class IndexAction implements Action{
	@Override
	public String execute() throws Exception {
		  Map session=ActionContext.getContext().getSession();
			if(session.get("user")!=null){//ֱ����ת����ҳ��
				return SUCCESS;
			}else{
				return ERROR;//��ת����½ҳ��
			}
	}

}

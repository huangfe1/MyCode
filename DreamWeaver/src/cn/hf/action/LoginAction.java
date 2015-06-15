package cn.hf.action;

import java.util.Map;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;
import cn.hf.util.IdentifyingCode;

import com.mchange.v2.codegen.IndentedWriter;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
//model处理
public class LoginAction implements Action,ModelDriven<User>{
   private User user=new User();
   private String msg="";
   private String yzm="";
	@Override
	public String execute() throws Exception {
		Map session=ActionContext.getContext().getSession();
		ActionContext ac=ActionContext.getContext();
		if(session.get("user")!=null){
			return SUCCESS;
		}else{
			yzm=yzm.toUpperCase();
			String syzm=(String) session.get(IdentifyingCode.RANDOMCODEKEY);
			System.out.println(yzm+"--"+syzm);
			if(!syzm.equals(yzm)){//如果验证码错误
				msg="验证码错误";
				ac.put("msg", msg);
				return ERROR;
			}
		String code=getModel().getCode();
		String paw=getModel().getPassword();
	
		//如果账号或者密码为空
		if(code.equals("")||paw.equals("")){
			msg="编号或者密码不能为空";
			ac.put("msg", msg);
			return ERROR;
		}
		//从数据库获取用户数据
		try{
		user=UserDao.getUser(code);
		}catch(Exception e){
			msg=e.getMessage();
			ac.put("msg", msg);
			return ERROR;
		}
		if(user==null||user.getStatus()==0){//不存在此用户，或者没有激活
			msg="此编号不存在,或者没有激活,请确认后再登录";
			ac.put("msg", msg);
			return ERROR;
		}else{
			//密码验证
			if(user.getPassword().equals(paw)){
				ac.getSession().put("user", user);//在session中传入user
				User u=(User) ac.getSession().get("user");
				if(u.getType()==2){//2的话
					u.setUid(1);//设置为公司用户uid
				}	
				return SUCCESS;
			}else{
				msg="密码错误,请确认后登录";
				ac.put("msg", msg);
				return ERROR;
			}
		}
		}
	}
	@Override
	public User getModel() {
		return user;
	}
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

}

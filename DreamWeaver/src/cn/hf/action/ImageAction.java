package cn.hf.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;
import cn.hf.util.ImageUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport{
	private	String code;
	//Ĭ�ϻ��ȡ����
 public InputStream getInputStream() throws Exception{
	  String path=ServletActionContext.getServletContext().getRealPath("WEB-INF")+File.separator+"zs"+File.separator;
	 ActionContext ac=ActionContext.getContext();
	User u=(User) ac.getSession().get("user");
	//�������γ��ļ���
	InputStream fi=null;
	// fi=new FileInputStream(path+code+".jpg");
	User user=UserDao.getUser(code);	 //���Ȼ�ȡUser
		if(u!=null&&u.getType()==0){//����ǹ�˾�û�����
			 if(user!=null){
				 fi=ImageUtil.getImageStream(user,0);
			 }
		}else{
				 if(user!=null){
					 fi=ImageUtil.getImageStream(user,1);
				 }
		}
		
		return fi;
 }
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
}

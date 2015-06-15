package cn.hf.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import cn.hf.bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class pdImageAction extends ActionSupport{
	private	String code;
	//默认会读取此流
 public InputStream getInputStream(){
	 String path=ServletActionContext.getServletContext().getRealPath("")+File.separator+"zs"+File.separator;
	 FileInputStream fi=null;
	 try{
	 fi=new FileInputStream(path+code+".jpg");
	 return fi;
	 }catch(Exception e){
		 e.printStackTrace();
	 }
		return null;
 }
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
 
}

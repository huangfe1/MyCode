package cn.hf.action;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import cn.hf.util.IdentifyingCode;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class YzmAction implements Action{
	@Override
	public String execute() throws Exception {
	  HttpServletResponse response =ServletActionContext.getResponse();
	  HttpServletRequest request =ServletActionContext.getRequest();
	  //设置不缓存图片  
      response.setHeader("Pragma", "No-cache");  
      response.setHeader("Cache-Control", "No-cache");  
      response.setDateHeader("Expires", 0) ;  
      //指定生成的相应图片  
      response.setContentType("image/jpeg") ;  
      IdentifyingCode idCode = new IdentifyingCode();  
      idCode.getRandcode(request, response);// 输出图片方法  
 		return null;
	}

}

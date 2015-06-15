package cn.hf.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

import org.apache.struts2.ServletActionContext;

import cn.hf.bean.User;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
public class ImageUtil {
	//public static String path=ServletActionContext.getServletContext().getRealPath("")+File.separator;
	//public static String imagePath="zs"+File.separator;
	public static InputStream getImageStream(User user,int type) throws Exception{//获取文件流
		if(type==1){//缩略图
			//隐藏电话号码
			String p=user.getPhone();
			p=p.replace(p.substring(7, 9), "**");
			user.setPhone(p);
			//隐藏身份证
			String cd=user.getIdcard();
			cd=cd.replace(cd.substring(cd.length()-4,cd.length()),"****");
			user.setIdcard(cd);
			//隐藏微信号码
		 	String weixin=user.getWeixin();
			weixin=weixin.replace(weixin.substring(weixin.length()-2,weixin.length()),"**");
			user.setWeixin(weixin);
		}
		//获取背景图对象
			ImageIcon ic=new ImageIcon(ServletActionContext.getServletContext().getRealPath("")+File.separator+"images"+File.separator+"zs.jpg");
			//创建缓冲图
			BufferedImage bf=new BufferedImage(566, 800, BufferedImage.TYPE_INT_RGB);
			//获取缓冲图画布
			Graphics g=bf.getGraphics();
			/********筑美*********/
			 	g.drawImage(ic.getImage(), 0, 0, null);
			    g.setColor(Color.black);
			    g.setFont(new Font("宋体", 1, 18));
			    g.drawString(user.getUsername(), 240, 443);
			    g.drawString(user.getWeixin(), 240, 468);
			    g.drawString(user.getPhone(), 240, 495);
			    g.drawString(user.getIdcard(), 240, 522);
			    g.drawString(user.getCode(), 240, 547);
			    g.drawString(user.getTime(), 245, 681);
			    g.setFont(new Font("宋体", 1, 20));
			    if (user.getLevel().equals("CEO"))
			      g.drawString(user.getLevel(), 245, 625);
			    else if (user.getLevel().equals("官方")){
			        g.drawString(user.getLevel() + "合作伙伴", 215, 625);
			    }
			    else if (user.getLevel().equals("天使")) {
			        g.drawString("筑美" + user.getLevel(), 240, 625);
			    }
			    else{
			      g.drawString(user.getLevel() + "代理", 240, 625);
			    }
			//将缓冲刘压缩,写入文件
			ByteArrayOutputStream baous = new ByteArrayOutputStream();  
			ImageOutputStream imOut=ImageIO.createImageOutputStream(baous);
			ImageIO.write(bf, "jpg", imOut);
			//JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baous);  
		   try{
		   // encoder.encode(bf);
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		 /*  File n =new File(path+imagePath+user.getCode()+".jpg");
		   n.createNewFile();
		   FileOutputStream ou=new FileOutputStream(n);
		   ou.write(baous.toByteArray());*/
		   InputStream in=new ByteArrayInputStream(baous.toByteArray());
		return in;
	}
}
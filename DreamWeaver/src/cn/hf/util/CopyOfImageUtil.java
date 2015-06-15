package cn.hf.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import javax.swing.ImageIcon;
import org.apache.struts2.ServletActionContext;
import cn.hf.bean.User;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
public class CopyOfImageUtil {
	public static String path=ServletActionContext.getServletContext().getRealPath("")+File.separator;
	public static String imagePath="zs"+File.separator;
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
		}
		//获取背景图对象
			ImageIcon ic=new ImageIcon(ServletActionContext.getServletContext().getRealPath("")+File.separator+"images"+File.separator+"zs.jpg");
			//创建缓冲图
			BufferedImage bf=new BufferedImage(566, 800, BufferedImage.TYPE_INT_RGB);
			//获取缓冲图画布
			Graphics g=bf.getGraphics();
//			//把背景图画上去
			/*********丝白秀儿***********/
//			g.drawImage(ic.getImage(), 0,0, null);
//			g.setColor(Color.black);
//			g.setFont(new Font("宋体", Font.BOLD, 15));
//			//把文字画上去,姓名,编号,手机微信,时间
//			g.drawString(user.getUsername(), 200, 300);//姓名
//			g.drawString(user.getWeixin(), 363, 300);//微信
//			g.drawString(user.getPhone(), 135, 350);//手机
//			g.drawString(user.getIdcard(),332,350);//身份证号
//			g.drawString(user.getCode(), 190, 395);//编号
//			g.drawString(user.getWeixin(), 150, 437);//微信
//			g.drawString(user.getTime(), 219, 608);//时间
//			g.setFont(new Font("微软雅黑", Font.BOLD, 20));
//			if(user.getLevel().equals("CEO")){
//			g.drawString(user.getLevel(), 270, 583);//代理等级
//			}else if(user.getLevel().equals("官方")){
//				g.drawString(user.getLevel()+"合作伙伴", 250, 583);//代理等级
//			}else if(user.getLevel().equals("天使")){
//				g.drawString("筑美"+user.getLevel(), 270, 583);//代理等级
//			}
//			else{
//			g.drawString(user.getLevel()+"代理", 270, 583);//代理等级
//			}
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
			    g.setFont(new Font("微软雅黑", 1, 20));
			    String lv;
			    if (user.getLevel().equals("CEO"))
			      g.drawString(user.getLevel(), 245, 625);
			    else if (user.getLevel().equals("官方")){
			    	lv=user.getLevel() + "合作伙伴";
			    	System.out.println("lv=="+lv);
			        lv=new String(lv.getBytes("iso8859-1"),"gb2312");
			        System.out.println("lv--"+lv);
			        g.drawString(lv, 215, 625);
			    }
			    else if (user.getLevel().equals("天使")) {
			    	lv="筑美" + user.getLevel();
			        lv=new String(lv.getBytes("iso8859-1"),"gb2312");
			        g.drawString(lv, 240, 625);
			    }
			    else{
			      lv=user.getLevel() + "代理";
			      lv=new String(lv.getBytes("iso8859-1"),"gb2312");
			      g.drawString(lv, 240, 625);
			    }
			//将缓冲刘压缩,写入文件
			ByteArrayOutputStream baous = new ByteArrayOutputStream();  
		    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baous);  
		   try{
		    encoder.encode(bf);
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		 /*  File n =new File(path+imagePath+user.getCode()+".jpg");
		   n.createNewFile();
		   FileOutputStream ou=new FileOutputStream(n);
		   System.out.println(n.getAbsolutePath());
		   ou.write(baous.toByteArray());*/
		   InputStream in=new ByteArrayInputStream(baous.toByteArray());
		return in;
	}
}
/*public static void writeImage(User user,int type){//0为完整图,1为隐藏图
//保存文件
File n;
if(type==0){//完整图
path=ServletActionContext.getServletContext().getRealPath("WEB-INF")+File.separator;
n=new File(path+imagePath+user.getCode()+".jpg");
}else{//隐藏图
	path=ServletActionContext.getServletContext().getRealPath("")+File.separator;
	n=new File(path+imagePath+user.getCode()+".jpg");	
	//隐藏电话号码
	String p=user.getPhone();
	p=p.replace(p.substring(7, 9), "**");
	user.setPhone(p);
	//隐藏身份证
	String cd=user.getIdcard();
	cd=cd.replace(cd.substring(cd.length()-4,cd.length()),"****");
	user.setIdcard(cd);
}
//获取背景图对象
ImageIcon ic=new ImageIcon(ServletActionContext.getServletContext().getRealPath("")+File.separator+"images"+File.separator+"zs.jpg");
//创建缓冲图
BufferedImage bf=new BufferedImage(566, 800, BufferedImage.TYPE_INT_RGB);
//获取缓冲图画布
Graphics g=bf.getGraphics();
//把背景图画上去
g.drawImage(ic.getImage(), 0,0, null);
g.setColor(Color.black);
g.setFont(new Font("宋体", Font.BOLD, 15));
//把文字画上去,姓名,编号,手机微信,时间
g.drawString(user.getUsername(), 200, 300);//姓名
g.drawString(user.getWeixin(), 363, 300);//微信
g.drawString(user.getPhone(), 135, 350);//手机
g.drawString(user.getIdcard(),332,350);//身份证号
g.drawString(user.getCode(), 190, 395);//编号
g.drawString(user.getWeixin(), 150, 437);//微信
g.drawString(user.getTime(), 219, 608);//时间
g.setFont(new Font("微软雅黑", Font.BOLD, 20));
if(user.getLevel().equals("CEO")){
g.drawString(user.getLevel(), 270, 583);//代理等级
}else if(user.getLevel().equals("官方")){
	g.drawString(user.getLevel()+"合作伙伴", 250, 583);//代理等级
}else if(user.getLevel().equals("天使")){
	g.drawString("筑美"+user.getLevel(), 270, 583);//代理等级
}
else{
g.drawString(user.getLevel()+"代理", 270, 583);//代理等级
}
try{
	if(!n.exists()){
		n.createNewFile();
	}
FileOutputStream i=new FileOutputStream(n);
//将缓冲如压缩,写入文件
ByteArrayOutputStream baous = new ByteArrayOutputStream();  
JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baous);  
encoder.encode(bf); 
//保存到文件
i.write(baous.toByteArray());
//再次生成隐藏版
}catch(Exception e){
e.printStackTrace();
}
}*/
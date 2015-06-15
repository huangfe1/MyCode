package zmz.hf.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

import org.apache.struts2.ServletActionContext;

import zmz.zwq.modal.Agent;

public class ImageUtil {
public static InputStream getImageStream(Agent agent,int type) throws IOException{//0为缩略图,1为完整图
	InputStream inputStream=null;
	//目录地址
	String path=ServletActionContext.getServletContext().getRealPath("")+File.separator;
	//获取背景图
	ImageIcon icon=new ImageIcon(path+new ConfigUtil().ZS_URL);
	//创建缩略图
	BufferedImage bf=new BufferedImage(566, 800, BufferedImage.TYPE_INT_BGR);
	//获取缓冲画布
	Graphics g=bf.getGraphics();
	g.drawImage(icon.getImage(),0,0,null);//背景
	g.setColor(Color.black);//设置黑色
    g.setFont(new Font("宋体", 1, 18));//设置字体
    String phone="";String wechat="";String idcard="";
	if(agent!=null){//为空
		 //完整图
		 phone=agent.getAgentPhone();
		 wechat=agent.getAgentWechat();
		 idcard=agent.getAgentIdcard();
		//缩略图
		 if(type==0){
		 phone=getHiddenString(phone,4);
		 wechat=getHiddenString(wechat, 2);
		 idcard=getHiddenString(idcard, 4);
		 }
		 g.drawString(agent.getUserName(), 240, 443);//名字
		 g.drawString(wechat, 240, 468);//微信
		 g.drawString(phone, 240, 495);//电话
		 g.drawString(idcard, 240, 522);//身份证
		 g.drawString(agent.getAgentCode(), 240, 547);//编号
		 g.drawString(agent.getAgentTime(), 245, 681);//时间
		 g.setFont(new Font("宋体", 1, 20));
	     g.drawString(agent.getAgentLevelName(), 245, 625);//代理等级
	}
	//将缓冲刘压缩,写入文件
	ByteArrayOutputStream baous = new ByteArrayOutputStream();  
	ImageOutputStream imOut=ImageIO.createImageOutputStream(baous);
	ImageIO.write(bf, "jpg", imOut);
	inputStream=new ByteArrayInputStream(baous.toByteArray());
	return inputStream;
}
/**
 * 隐藏字符
 * @param str 字符
 * @param len 隐藏后几位
 * @return
 */
private static String getHiddenString(String str,int len ){
	if(str.length()>=len){//长度够了
		str=str.substring(0,str.length()-len);
		for(int i=0;i<len;i++){
			str+="*";//用*号填充
		}
	}
	return str;
}
}

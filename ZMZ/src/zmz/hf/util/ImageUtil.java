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
public static InputStream getImageStream(Agent agent,int type) throws IOException{//0Ϊ����ͼ,1Ϊ����ͼ
	InputStream inputStream=null;
	//Ŀ¼��ַ
	String path=ServletActionContext.getServletContext().getRealPath("")+File.separator;
	//��ȡ����ͼ
	ImageIcon icon=new ImageIcon(path+new ConfigUtil().ZS_URL);
	//��������ͼ
	BufferedImage bf=new BufferedImage(566, 800, BufferedImage.TYPE_INT_BGR);
	//��ȡ���廭��
	Graphics g=bf.getGraphics();
	g.drawImage(icon.getImage(),0,0,null);//����
	g.setColor(Color.black);//���ú�ɫ
    g.setFont(new Font("����", 1, 18));//��������
    String phone="";String wechat="";String idcard="";
	if(agent!=null){//Ϊ��
		 //����ͼ
		 phone=agent.getAgentPhone();
		 wechat=agent.getAgentWechat();
		 idcard=agent.getAgentIdcard();
		//����ͼ
		 if(type==0){
		 phone=getHiddenString(phone,4);
		 wechat=getHiddenString(wechat, 2);
		 idcard=getHiddenString(idcard, 4);
		 }
		 g.drawString(agent.getUserName(), 240, 443);//����
		 g.drawString(wechat, 240, 468);//΢��
		 g.drawString(phone, 240, 495);//�绰
		 g.drawString(idcard, 240, 522);//���֤
		 g.drawString(agent.getAgentCode(), 240, 547);//���
		 g.drawString(agent.getAgentTime(), 245, 681);//ʱ��
		 g.setFont(new Font("����", 1, 20));
	     g.drawString(agent.getAgentLevelName(), 245, 625);//����ȼ�
	}
	//��������ѹ��,д���ļ�
	ByteArrayOutputStream baous = new ByteArrayOutputStream();  
	ImageOutputStream imOut=ImageIO.createImageOutputStream(baous);
	ImageIO.write(bf, "jpg", imOut);
	inputStream=new ByteArrayInputStream(baous.toByteArray());
	return inputStream;
}
/**
 * �����ַ�
 * @param str �ַ�
 * @param len ���غ�λ
 * @return
 */
private static String getHiddenString(String str,int len ){
	if(str.length()>=len){//���ȹ���
		str=str.substring(0,str.length()-len);
		for(int i=0;i<len;i++){
			str+="*";//��*�����
		}
	}
	return str;
}
}

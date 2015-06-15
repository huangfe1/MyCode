package cn.hf.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.struts2.ServletActionContext;

import cn.hf.bean.User;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.org.apache.regexp.internal.recompile;

public class AddUserAction implements Action{
	private int fuid;//ָ���ĸ����û�id
	private User user;
	private String path;
	private String msg;
	private String dlname;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User u=(User) ac.getSession().get("user");
		if(user.getInfo()==null||user.getInfo().equals("")){
			msg="����д��ע!";
			return ERROR;
		}
		if( u!= null){//������û���¼
		//	if(u.getType()==0){//��˾�û�
				if(!dlname.equals("")&&dlname!=null){//�д�������
				//	User us=UserDao.getUserByName(dlname);
					User us=UserDao.getUser(dlname);
					if(us!=null){//������û�
			//����ֻ�ܸ��Լ��Ĵ�������¼�����
						if(u.getType()==1&&us.getFid()!=u.getUid()){//�����û�,��д�Ĳ����Լ�
							msg="����д���û����������¼�";
							return "error";
						}
						fuid=us.getUid();//����fid
					}else{//û���û�
						msg="����д���û���Ų�����";
						return "error";
					}
				}
			//	}
			//��ȡʱ��
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());
			user.setTime(time);//����ʱ��
			//ȥ���û����Ŀո�
			String username=user.getUsername();//�û���
			username=username.replace(" ","");//ȥ���ո�
			user.setUsername(username);//��������
			//ȥ���绰�Ŀո�
			String phone=user.getPhone();
			if(phone.length()<11||user.getIdcard().length()<18){
				msg="����ȷ��д�ֻ�����������֤";
				return ERROR;
			}
			phone=phone.replace(" ","");//ȥ���ո�
			user.setPhone(phone);
			//ȥ��΢�ŵĿո�
			String weixin=user.getWeixin();
			weixin=weixin.replace(" ","");//ȥ���ո�
			user.setWeixin(weixin);
			//���ɱ��,�����*�ţ������������
			String c1=phone.substring(phone.length()-4,phone.length()-3);
			if(c1.equals("*")){
				c1=(int)(Math.random()*10)+"";
			}
			String c2=phone.substring(phone.length()-3,phone.length()-2);
			if(c2.equals("*")){
				c2=(int)(Math.random()*10)+"";
			}
			String c3=phone.substring(phone.length()-2,phone.length()-1);
			if(c3.equals("*")){
				c3=(int)(Math.random()*10)+"";
			}
			String c4=phone.substring(phone.length()-1,phone.length());
			if(c4.equals("*")){
				c4=(int)(Math.random()*10)+"";
			}
			Calendar cal = Calendar.getInstance();
			String c5=cal.get(Calendar.DAY_OF_MONTH)+"";
			String code=c3+c5+c1+c4+c2;
			//���������
			int ss=1+(int)(Math.random()*10);//����һ�������
			code= code.replaceAll("4",""+ss);//���ַ��Ļ��ɰ�
			if(code.length()<6){//����6λ
				int sj=1+(int)(Math.random()*10);//����һ�������
				code=c3+c5+c1+c4+sj+c2;
			}
			code="zmz"+code;//���Ϊzmz0
			boolean b=true;
			while(b){
				User mu=UserDao.getUser(code);
				if(mu==null){
					b=false;
				}else{
					int sj=1+(int)(Math.random()*10);//����һ�������
					code=code.replace(code.charAt(5)+"",sj+"");
				}
			}
			user.setCode(code);//���ñ��
			user.setLevel(user.getLevel());//�����û��ȼ�
			if(fuid==0){//������fuid
			user.setFid(u.getUid());//����fid
			}else{
			user.setFid(fuid);//����ָ����fid
			}
			 //�����û�
			//if(u.getType()==0||user.getLevel().equals("��Լ")||user.getLevel().equals("��ʹ")){//��˾�û�ֱ�Ӽ����������Լ,��ʹ
			if(u.getType()==0){//��˾�û�ֱ�Ӽ���
			user.setStatus(1);
			}else{//�����û���Ҫ��Ȩ
				user.setStatus(0);
			}
			try{//ִ�гɹ�
			UserDao.insertUser(user);
		/*	//������Ȩ֤��
			ImageUtil.writeImage(user,0);
			//��������֤��
			ImageUtil.writeImage(user,1);*/
			return SUCCESS;
			}catch(Exception e){//����ʧ��
				e.printStackTrace();
				msg="��Ǹ,�������֤,�绰,΢���Ƿ�ʹ�ù�,������ϵ�ͷ�";
			return ERROR;//ʧ��
			}
		}else{
		return "toLogin";
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getFuid() {
		return fuid;
	}
	public void setFuid(int fuid) {
		this.fuid = fuid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDlname() {
		return dlname;
	}
	public void setDlname(String dlname) {
		this.dlname = dlname;
	}
	
}

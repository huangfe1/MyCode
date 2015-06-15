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
	private int fuid;//指定的父级用户id
	private User user;
	private String path;
	private String msg;
	private String dlname;
	@Override
	public String execute() throws Exception {
		ActionContext ac=ActionContext.getContext();
		User u=(User) ac.getSession().get("user");
		if(user.getInfo()==null||user.getInfo().equals("")){
			msg="请填写汇款备注!";
			return ERROR;
		}
		if( u!= null){//如果有用户登录
		//	if(u.getType()==0){//公司用户
				if(!dlname.equals("")&&dlname!=null){//有代理名字
				//	User us=UserDao.getUserByName(dlname);
					User us=UserDao.getUser(dlname);
					if(us!=null){//如果有用户
			//代理只能给自己的代理添加下级代理
						if(u.getType()==1&&us.getFid()!=u.getUid()){//代理用户,填写的不是自己
							msg="您填写的用户不是您的下级";
							return "error";
						}
						fuid=us.getUid();//设置fid
					}else{//没有用户
						msg="您填写的用户编号不存在";
						return "error";
					}
				}
			//	}
			//获取时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time=df.format(new Date());
			user.setTime(time);//设置时间
			//去除用户名的空格
			String username=user.getUsername();//用户名
			username=username.replace(" ","");//去除空格
			user.setUsername(username);//设置姓名
			//去除电话的空格
			String phone=user.getPhone();
			if(phone.length()<11||user.getIdcard().length()<18){
				msg="请正确填写手机号码或者身份证";
				return ERROR;
			}
			phone=phone.replace(" ","");//去除空格
			user.setPhone(phone);
			//去除微信的空格
			String weixin=user.getWeixin();
			weixin=weixin.replace(" ","");//去除空格
			user.setWeixin(weixin);
			//生成编号,如过有*号，用随机数代替
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
			//产生随机数
			int ss=1+(int)(Math.random()*10);//产生一个随机数
			code= code.replaceAll("4",""+ss);//将字符四换成八
			if(code.length()<6){//不足6位
				int sj=1+(int)(Math.random()*10);//产生一个随机数
				code=c3+c5+c1+c4+sj+c2;
			}
			code="zmz"+code;//秀儿为zmz0
			boolean b=true;
			while(b){
				User mu=UserDao.getUser(code);
				if(mu==null){
					b=false;
				}else{
					int sj=1+(int)(Math.random()*10);//产生一个随机数
					code=code.replace(code.charAt(5)+"",sj+"");
				}
			}
			user.setCode(code);//设置编号
			user.setLevel(user.getLevel());//设置用户等级
			if(fuid==0){//不存在fuid
			user.setFid(u.getUid());//设置fid
			}else{
			user.setFid(fuid);//设置指定的fid
			}
			 //插入用户
			//if(u.getType()==0||user.getLevel().equals("特约")||user.getLevel().equals("天使")){//公司用户直接激活，或者是特约,天使
			if(u.getType()==0){//公司用户直接激活
			user.setStatus(1);
			}else{//其他用户需要授权
				user.setStatus(0);
			}
			try{//执行成功
			UserDao.insertUser(user);
		/*	//生成授权证书
			ImageUtil.writeImage(user,0);
			//生成隐藏证书
			ImageUtil.writeImage(user,1);*/
			return SUCCESS;
			}catch(Exception e){//插入失败
				e.printStackTrace();
				msg="抱歉,请检查身份证,电话,微信是否使用过,或者联系客服";
			return ERROR;//失败
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

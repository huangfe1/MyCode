package cn.hf.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements Cloneable{

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	private String time;//申请时间
	private int status;//状态0代表为激活,1代表已经激活
	private String fname;//推荐人名字
	private String level;//等级
	private int fid;//父级id
	private String code;
	private String username;
	private String password;
	private int type;//0代表公司用户,1代表代理商
	private int uid;
	private String weixin;//微信号
	private String phone;//手机号码
	private String idcard;//身份证号
	private String fcode;//推荐人的code
	private String info;//汇款信息
	public User(){
		
	}
	public User(ResultSet res) throws SQLException{
		this.level=res.getString("level");
		this.fid=res.getInt("fid");
		this.code=res.getString("code");
		this.username=res.getString("username");
		this.password=res.getString("password");
		this.type=res.getInt("type");
		this.uid=res.getInt("uid");
		this.weixin=res.getString("weixin");
		this.phone=res.getString("phone");
		this.idcard=res.getString("idcard");
		this.fname=res.getString("fname");
		this.status=res.getInt("status");//用户状态
		this.time=res.getString("time");//申请时间
		this.fcode=res.getString("fcode");//推荐人code
		this.info=res.getString("info");//备注
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFcode() {
		return fcode;
	}
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}

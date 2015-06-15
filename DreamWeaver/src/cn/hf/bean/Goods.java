package cn.hf.bean;

import java.sql.ResultSet;

public class Goods {
	private String code;
	private int fid;
	private String username;
	private int gid;
	private String number;
	private String company;
	private String parlour;
	private int uid;
	private String name;
	private String time;
	private String cname;
	public Goods(){
		
	}
	public Goods(int uid,String number,String company,String parlour,String goodsname,String time){
		setUid(uid);
		setNumber(number);//设置编码
		setCompany(company);//公司
		setParlour(parlour);//美容院
		setName(goodsname);//产品名字
		setTime(time);//时间
	}
	public Goods(ResultSet res){
		try{
		setNumber(res.getString("number"));
		setParlour(res.getString("parlour"));
		setUid(res.getInt("uid"));//用户id
		setUsername(res.getString("username"));//用户名
		setTime(res.getString("time"));
		setCompany(res.getString("company"));
		setName(res.getString("name"));
		setFid(res.getInt("fid"));
		setCode(res.getString("code"));
		setCname(res.getString("cname"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getParlour() {
		return parlour;
	}
	public void setParlour(String parlour) {
		this.parlour = parlour;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}

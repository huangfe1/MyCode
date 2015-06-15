package cn.hf.bean;

import java.sql.ResultSet;


public class Apply{
	private String wid;
	private int aid;
	private String fname;
	private String sname;
	private int fid;
	private int uid;
	private String cname;
	private String place;
	private String gname;
	private int gcount;
	private String time;
	private String phone;
	private int status=0;
	private String fcode;
	private String scode;
	private int ffid;
	public Apply(){
		
	}
	public Apply(ResultSet rs){
		try{
		this.fid=rs.getInt("fid");
		this.uid=rs.getInt("uid");
		this.cname=rs.getString("cname");
		this.place=rs.getString("place");
		this.gname=rs.getString("gname");
		this.gcount=rs.getInt("gcount");
		this.time=rs.getString("time");
		this.phone=rs.getString("phone");
		this.status=rs.getInt("status");
		this.fcode=rs.getString("fcode");
		this.scode=rs.getString("scode");
		this.fname=rs.getString("fname");
		this.sname=rs.getString("sname");
		this.aid=rs.getInt("aid");
		this.ffid=rs.getInt("ffid");
		this.wid=rs.getString("wid");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGcount() {
		return gcount;
	}
	public void setGcount(int gcount) {
		this.gcount = gcount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getFcode() {
		return fcode;
	}
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getFfid() {
		return ffid;
	}
	public void setFfid(int ffid) {
		this.ffid = ffid;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	
}

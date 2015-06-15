package cn.hf.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Out {
	private String fname;
	private String sname;
	private int fid;
	private int uid;
	private String gname;
	private String time;
	private int count ;
	private int oid;
	private int fkucun;//当前发货人的余存
	private int skucun;//当前收货人的余存
	private int type;//0为转货,1为发货
	public Out(){
		
	}
	public Out(ResultSet rs){
		try{
		this.fname=rs.getString("fname");
		this.sname=rs.getString("sname");
		this.fid=rs.getInt("fid");
		this.uid=rs.getInt("uid");
		this.time=rs.getString("time");
		this.count=rs.getInt("count");
		this.gname=rs.getString("gname");
		this.oid=rs.getInt("oid");
		this.fkucun=rs.getInt("fkucun");
		this.skucun=rs.getInt("skucun");
		this.type=rs.getInt("type");
		}catch(SQLException e){
			e.printStackTrace();
		}
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getFkucun() {
		return fkucun;
	}
	public void setFkucun(int fkucun) {
		this.fkucun = fkucun;
	}
	public int getSkucun() {
		return skucun;
	}
	public void setSkucun(int skucun) {
		this.skucun = skucun;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}

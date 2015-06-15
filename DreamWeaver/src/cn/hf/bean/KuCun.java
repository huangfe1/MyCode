package cn.hf.bean;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class KuCun{
	private int count;//公司余存
	private int allcount;//库房总数
	private String gname;
	private int uid;
	private String username;
	private Map<String, Integer> gnames;//货物种类
	public KuCun(){
		gnames=new HashMap<>();
	}
	public KuCun(ResultSet rs){
		try{
		this.uid=rs.getInt("uid");
		//this.count=rs.getInt("count");
		this.username=rs.getString("username");
		//this.gname=rs.getString("gname");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Map<String, Integer> getGnames() {
		return gnames;
	}
	public void setGnames(Map<String, Integer> gnames) {
		this.gnames = gnames;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getAllcount() {
		return allcount;
	}
	public void setAllcount(int allcount) {
		this.allcount = allcount;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	
}

package cn.hf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cn.hf.bean.GoodsName;
import cn.hf.db.MyDbPool;

public  class NameDao{
	/**
	 * 添加商品名
	 * @param name
	 * @param time
	 */
	public static void insertName(String name,String time)throws Exception{
			String sql="insert into goodsname(name,time) value(?,?)";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, time);
			pre.execute();
			pre.close();con.close();
	}
	/**
	 * 修改名字
	 */
	public static void updateName(String oldname,String newname) throws Exception{
			String sql="update goodsname set name=? where name=?";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, newname);
			pre.setString(2, oldname);
			pre.execute();
			pre.close();con.close();
	}
	/**
	 * 查询商品名
	 * @return
	 */
	public static ArrayList<GoodsName> selectName(){
		ArrayList<GoodsName> names=new ArrayList<>();
		try{
			GoodsName name=null;
			String sql="select * from goodsname";
			Connection con=MyDbPool.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()){
				name=new GoodsName();
				name.setName(rs.getString("name"));
				name.setTime(rs.getString("time"));
				names.add(name);
			}
			statement.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return names;
	}
	/**
	 * 删除商品名
	 * @param name
	 */
	public static void delectName(String name){
		try{
			String sql="delete  from goodsname where name=?";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, name);
			pre.execute();
			pre.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

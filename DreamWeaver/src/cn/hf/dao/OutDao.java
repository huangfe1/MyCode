package cn.hf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.hf.bean.Out;
import cn.hf.db.MyDbPool;
/**
 * 通过oid查找out记录
 * @author Administrator
 *
 */
public class OutDao {
	public static HashMap<String, Integer> selectAllCount(){
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		//公司发给公司就是入库
		String sql="select sum(count) as count ,gname from myout  where fid=1 and uid=1 group by gname";
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				//加入map中
				hm.put(rs.getString("gname"), rs.getInt("count"));
			}
			pre.close();rs.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hm;
	}
	public static Out selectOut(int oid){
		Out out=null;
		String sql="select * from myout_view where oid=?";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, oid);
		ResultSet rs=pre.executeQuery();
		if(rs.next()){
			out=new Out(rs);
		}
		pre.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return out;
	}
	/**
	 * 查出某人某天的库存操作记录
	 * @param uid
	 * @param time
	 * @return
	 */
	public static ArrayList<Out> selectOut(int uid,String time,String gname,int index,int limit){
		ArrayList<Out> Outs=new ArrayList<>();
		Out out=null;
		String sql="";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=null;
		if((time==null||time.equals(""))&&(gname==null||gname.equals(""))){//没有时间,没有货物名
		sql="select * from myout_view where uid=? or fid=? order by time desc,oid desc limit ?,? ";
		pre=con.prepareStatement(sql);
		pre.setInt(1, uid);
		pre.setInt(2, uid);
		pre.setInt(3, index*limit);
		pre.setInt(4, limit);
			}
		else if((time==null||time.equals(""))&&(gname!=null&&!gname.equals(""))){//时间为空但是商品名字不为空
			sql="select * from myout_view where uid=? and gname=?  or fid=? and gname=?  order by time desc,oid desc limit ?,? ";
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, gname);
			pre.setInt(3, uid);
			pre.setString(4, gname);
			pre.setInt(5, index*limit);
			pre.setInt(6, limit);
		}
		else if((time!=null&&!time.equals(""))&&(gname!=null&&!gname.equals(""))){//都不为空
			sql="select * from myout_view where uid=? and gname=? and time=? or fid=? and gname=? and time=?  order by time desc,oid desc limit ?,? ";
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, gname);
			pre.setString(3, time);
			pre.setInt(4, uid);
			pre.setString(5, gname);
			pre.setString(6, time);
			pre.setInt(7, index*limit);
			pre.setInt(8, limit);
		}
			else{//商品名字为空但是时间不为空
		//时间不需要限制
		sql="select * from myout_view where uid=? and time=?  or fid=? and time=?  ";
		pre=con.prepareStatement(sql);
		pre.setInt(1, uid);
		pre.setString(2, time);
		pre.setInt(3, uid);
		pre.setString(4, time);
			}
		ResultSet rs=pre.executeQuery();
		while(rs.next()){
			out=new Out(rs);
			Outs.add(out);
		}
		pre.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return Outs;
	}
	/**
	 * 查询总数
	 */
	public static int selectCounts(int uid,String time,String gname){
		int count=0;
		String sql;
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=null;
		if((time==null||time.equals(""))&&(gname==null||gname.equals(""))){//无条件
				sql="select count(uid) from myout_view  where uid=? or fid=? ";
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setInt(2, uid);
		}
		else if((time==null||time.equals(""))&&(gname!=null&&!gname.equals(""))){//只有gname
			sql="select count(uid) from myout_view  where uid=? and gname=? or fid=? and gname=? ";
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, gname);
			pre.setInt(3, uid);
			pre.setString(4, gname);
		}
		else if((time==null||time.equals(""))&&(gname!=null&&!gname.equals(""))){//有gname有时间
			sql="select count(uid) from myout_view  where uid=? and gname=? and time=? or fid=? and gname=? and time=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, gname);
			pre.setString(3, time);
			pre.setInt(4, uid);
			pre.setString(5, gname);
			pre.setString(6, time);
		}
		else{//只有时间
			System.out.println("搜寻只有时间的");
			sql="select count(uid) from myout_view  where uid=? and time=? or fid=? and time=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, time);
			pre.setInt(3, uid);
			pre.setString(4, time);
		}
		ResultSet res=pre.executeQuery();
		if(res.next()){
			count=res.getInt(1);
		}
		//关闭连接
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){ 
			e.printStackTrace();
			}
		return count;//0为库存,1为记录
	}
	public static void delete(int oid){
		String sql="delete from myout where oid=?";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, oid);
		pre.execute();
		pre.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/*
	 * 插入一条入库记录
	 */
	public static void insert(Out out){
		String sql="insert into myout(fid,uid,count,time,gname,skucun,fkucun,type) value(?,?,?,?,?,?,?,?)";
		try{	    
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1,out.getFid());
		pre.setInt(2,out.getUid());
		pre.setInt(3, out.getCount());
		pre.setString(4, out.getTime());
		pre.setString(5,out.getGname());
		pre.setInt(6,out.getSkucun());
		pre.setInt(7,out.getFkucun());
		pre.setInt(8,out.getType());
		pre.execute();
		pre.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

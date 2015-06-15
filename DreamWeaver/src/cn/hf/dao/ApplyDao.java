package cn.hf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import cn.hf.bean.Apply;
import cn.hf.db.MyDbPool;

public class ApplyDao {
/*	public static HashMap<String, Integer> getFsCount(){
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		String sql="select * from apply where fid=1";//公司处理的申请
		return hm;
	}*/
	public static void insert(Apply apply){
		String sql="insert into apply(fid,uid,cname,time,place,gname,gcount,phone,status,wid) value(?,?,?,?,?,?,?,?,?,?)";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, apply.getFid());
		pre.setInt(2,apply.getUid() );
		pre.setString(3, apply.getCname());
		pre.setString(4, apply.getTime());
		pre.setString(5, apply.getPlace());
		pre.setString(6, apply.getGname());
		pre.setInt(7, apply.getGcount());
		pre.setString(8, apply.getPhone());
		pre.setInt(9, apply.getStatus());
		pre.setString(10, apply.getWid());
		pre.execute();
		pre.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 通过aid获取申请
	 * @param aid
	 * @return
	 */
	public static Apply getApply(int aid){
		String sql="select * from apply_view where aid=?";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, aid);
		ResultSet rs=pre.executeQuery();
		if(rs.next()){
			Apply apply=new Apply(rs);
			return apply;
		}
		pre.close();
		rs.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除申请
	 */
	public static void deleteApply(int aid,int fid){
		String sql="delete from apply where aid=? and status=0 and fid=?";//删除未处理的申请
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, aid);
		pre.setInt(2,fid);
		pre.execute();
		pre.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 修改申请
	 */
	public static void changeApply(int aid,int count,String wid){
		String sql="";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=null;
		if(count==0){//录入完了
			sql="update apply set status=? ,wid=? where aid=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, 1);//状态
			pre.setString(2, wid);
			pre.setInt(3, aid);
		}else{
			sql="update apply set gcount =? where aid=?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, count);
			pre.setInt(2, aid);
		}
		pre.execute();
		pre.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 用户id,我的申请或者记录,代理商,时间
	 */
	public static ArrayList<Apply> selectApplys(int uid,int type,String time,String username,int index,int limit){//0为我的申请,1为记录
		ArrayList<Apply> applys=new ArrayList<>();
		try{
			String sql = "";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=null;
			if((time==null||time.equals(""))&&(username==null||username.equals(""))){//无条件
				if(type==0){//我的申请
					sql="select * from apply_view  where fid=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}else{//下级申请
				/*	sql="select * from apply_view  where ffid=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);*/
					sql="select * from apply_view   order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, index*limit);
					pre.setInt(2, limit);
				}
			}
			if((time==null||time.equals(""))&&(username!=null&&!username.equals(""))){//名字
				if(type==0){//我的申请
					sql="select * from apply_view  where fid=? and fname=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, username);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
				/*	sql="select * from apply_view  where ffid=? and fname=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, username);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);*/
					sql="select * from apply_view where fname=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setString(1, username);
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}
			}
			if((time!=null&&!time.equals(""))&&(username==null||username.equals(""))){//时间
				if(type==0){//我的申请
					sql="select * from apply_view  where fid=? and time=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
					/*sql="select * from apply_view  where ffid=? and time=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);*/
					sql="select * from apply_view  where  time=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setString(1, time);
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}
			}
			if((username!=null&&time!=null)&&(!username.equals("")&&!time.equals(""))){//时间跟代理商
				if(type==0){//我的申请
					sql="select * from apply_view  where fid=? and time=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
					/*sql="select * from apply_view  where ffid=? and time=? and fname=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, time);
					pre.setString(3, username);
					pre.setInt(4, index*limit);
					pre.setInt(5, limit);*/
					sql="select * from apply_view  where  time=? and fname=? order by status ,aid desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setString(1, time);
					pre.setString(2, username);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}
			}
		ResultSet res=pre.executeQuery();
		while(res.next()){
			Apply apply=new Apply(res);
			applys.add(apply);
			}
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return applys;
	}
	/**
	 * 查询总数
	 */
	public static int selectGcounts(int uid,int type,String time,String username){
		int count=0;
		String sql;
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=null;
		if((time==null||time.equals(""))&&(username==null||username.equals(""))){//无条件
			if(type==0){//我的申请
			sql="select count(aid) from apply_view  where fid=? ";
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			}else{
			sql="select count(aid) from apply_view";	
			pre=con.prepareStatement(sql);
			}
		}
		if((time==null||time.equals(""))&&(username!=null&&!username.equals(""))){//名字
			if(type==0){//我的申请
				sql="select count(aid) from apply_view  where fid=? and fname=?";
				pre=con.prepareStatement(sql);
				pre.setInt(1, uid);
				pre.setString(2, username);
			}else{
				sql="select count(aid) from apply_view  where fname=?";
				pre=con.prepareStatement(sql);
				pre.setString(1, username);
			}
		}
		if((time!=null&&!time.equals(""))&&(username==null||username.equals(""))){//时间
			if(type==0){//我的申请
				sql="select count(aid) from apply_view  where fid=? and time=?";
				pre=con.prepareStatement(sql);
				pre.setInt(1, uid);
				pre.setString(2, time);
			}else{
				sql="select count(aid) from apply_view  where time=?";
				pre=con.prepareStatement(sql);
				pre.setString(1, time);
			}	
		}
		if((username!=null&&time!=null)&&(!username.equals("")&&!time.equals(""))){//时间跟代理商
			if(type==0){
				sql="select count(gid) from apply_view  where fid=? and time=? and fname=?";
				pre=con.prepareStatement(sql);
				pre.setInt(1, uid);
				pre.setString(2, time);
				pre.setString(3, username);
			}else{
				sql="select count(aid) from apply_view  where time=? and fname=?";
				pre=con.prepareStatement(sql);
				pre.setString(1, time);
				pre.setString(2, username);
			}
			
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
		return count;//0为我的申请,1为记录
	}
}

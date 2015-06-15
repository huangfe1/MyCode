package cn.hf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.hf.bean.KuCun;
import cn.hf.db.MyDbPool;

public class KuDao {
	/**
	 * 查出此人的所有货物信息
	 * @param uid
	 * @return
	 */
	public static KuCun select(int uid){
		KuCun kc=null;
		try{
		String sql="select * from kucun_view where uid=?";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, uid);
		ResultSet rs=pre.executeQuery();
		int i=0;
		while(rs.next()){
			if(i==0){
				kc=new KuCun();//实例化一次
				i++;
			}
			String gname=rs.getString("gname");//获取产品名字
			int count=rs.getInt("count");//获取产品数量
			kc.getGnames().put(gname, count);//存数库存数量
			kc.setUid(rs.getInt("uid"));//设置用户id
			kc.setUsername(rs.getString("username"));//用户名
		}
		pre.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return kc;
	}
	/**
	 * 通过fid查询下级代理的库存
	 * @param uid
	 * @return
	 */
	public static ArrayList<KuCun> selectByFid(int fid,String name,String gname,int index,int limit){
		String sql;	PreparedStatement pre;
		ArrayList<KuCun>kcs=new ArrayList<KuCun>();
		try{
			Connection con=MyDbPool.getConnection();
			if((name!=null&&!name.equals(""))&&(gname==null||gname.equals(""))){//只有名字
				if(fid==1){//公司用户
					sql="select *  from kucun_view where  username=? limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setString(1, name);
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}else{
				sql="select *  from kucun_view where fid=? and username=? limit ?,?";
				pre=con.prepareStatement(sql);
				pre.setInt(1, fid);
				pre.setString(2, name);
				pre.setInt(3, index*limit);
				pre.setInt(4, limit);
				}
			}else 	if((gname!=null&&!gname.equals(""))&&(name==null||name.equals(""))){//只有种类
				if(fid==1){//公司用户
					sql="select * from kucun_view where  gname=? limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setString(1, gname);
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}else{
				sql="select * from kucun_view where fid=? and gname=? limit ?,?";
				pre=con.prepareStatement(sql);
				pre.setInt(1, fid);
				pre.setString(2, gname);
				pre.setInt(3, index*limit);
				pre.setInt(4, limit);
				}
			}
			else if((gname!=null&&!gname.equals(""))&&(name!=null&&!name.equals(""))){//都有
				if(fid==1){//公司用户
					sql="select *  from kucun_view where  gname=? and username=? limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setString(1, gname);
					pre.setString(2, name);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
				sql="select *  from kucun_view where fid=? and gname=? and username=? limit ?,?";
				pre=con.prepareStatement(sql);
				pre.setInt(1, fid);
				pre.setString(2, gname);
				pre.setString(3, name);
				pre.setInt(4, index*limit);
				pre.setInt(5, limit);
				}
			}
				else{
					if(fid==1){//公司用户
						sql="select *  from kucun_view   limit ?,?";
						pre=con.prepareStatement(sql);
						pre.setInt(1, index*limit);
						pre.setInt(2, limit);
					}else{
						sql="select *  from kucun_view where fid=?  limit ?,?";
						pre=con.prepareStatement(sql);
						pre.setInt(1, fid);
						pre.setInt(2, index*limit);
						pre.setInt(3, limit);
					}
		
			}
		ResultSet rs=pre.executeQuery();
		KuCun	kc=null;
		while(rs.next()){
			kc=new KuCun();//实例化一次
			kc.setGname(rs.getString("gname"));
			kc.setCount(rs.getInt("count"));
			kc.setUid(rs.getInt("uid"));//设置用户id
			kc.setUsername(rs.getString("username"));//用户名
			kcs.add(kc);
		}
		pre.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return kcs;
	}
	/**
	 * 通过fid查询下级代理的库存
	 * @param uid
	 * @return
	 */
	public static int selectCountByFid(int fid,String name,String gname){
		int count = 0;
		String sql;	PreparedStatement pre = null;
		try{
			Connection con=MyDbPool.getConnection();
			if((name!=null&&!name.equals(""))&&(gname==null||gname.equals(""))){//只有名字
				if(fid==1){//公司用户
					sql="select  count(*) as count from kucun_view where  username=? ";
					pre=con.prepareStatement(sql);
					pre.setString(1, name);
				}else{
				sql="select count(*) as count   from kucun_view where fid=? and username=? ";
				pre=con.prepareStatement(sql);
				pre.setInt(1, fid);
				pre.setString(2, name);
				}
			}else 	if((gname!=null&&!gname.equals(""))&&(name==null||name.equals(""))){//只有种类
				if(fid==1){//公司用户
					sql="select  count(*) as count from kucun_view where  gname=? ";
					pre=con.prepareStatement(sql);
					pre.setString(1, gname);
				}else{
				sql="select  count(*) as count from kucun_view where fid=? and gname=? ";
				pre=con.prepareStatement(sql);
				pre.setInt(1, fid);
				pre.setString(2, gname);
				}
			}
			else if((gname!=null&&!gname.equals(""))&&(name!=null&&!name.equals(""))){//都有
				if(fid==1){//公司用户
					sql="select  count(*) as count  from kucun_view where  gname=? and username=?";
					pre=con.prepareStatement(sql);
					pre.setString(1, gname);
					pre.setString(2, name);
				}else{
				sql="select count(*) as count  from kucun_view where fid=? and gname=? and username=? ";
				pre=con.prepareStatement(sql);
				pre.setInt(1, fid);
				pre.setString(2, gname);
				pre.setString(3, name);
				}
			}
				else{
					if(fid==1){//公司用户
						sql="select  count(*) as count  from kucun_view  ";
						pre=con.prepareStatement(sql);
					}else{
						sql="select  count(*) as count  from kucun_view where fid=? ";
						pre=con.prepareStatement(sql);
						pre.setInt(1, fid);
					}
			}
		ResultSet rs=pre.executeQuery();
		if(rs.next()){
		count=rs.getInt("count");
		}
		pre.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 查出所有信息
	 */
	public static ArrayList<KuCun> selectAll(){
		ArrayList<KuCun> kcs=new ArrayList<>();
		KuCun kc=null;
		try{
		String sql="select count,sum(count) as allcount,gname from kucun_view group by gname;";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		ResultSet rs=pre.executeQuery();
		while(rs.next()){
				kc=new KuCun();//实例化一次
				kc.setCount(rs.getInt("count"));
				kc.setGname(rs.getString("gname"));
				kc.setAllcount(rs.getInt("allcount"));
				kcs.add(kc);
			}
		pre.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return kcs;
	}
	/**
	 * 修改库存信息
	 * @param uid
	 * @param gname
	 * @param count 正负之分
	 */
	public static void update(int uid,String gname,int count){//没有就插入,有就修改
		try{
		String sql="insert into kucun(uid,gname,count) value(?,?,?) on duplicate key update count=count+?";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, uid);//数量
		pre.setString(2,gname );//用户id
		pre.setInt(3, count);//产品名
		pre.setInt(4, count);//数量
		pre.execute();
		pre.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

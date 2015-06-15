package cn.hf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.hf.bean.KuCun;
import cn.hf.db.MyDbPool;

public class KuDao {
	/**
	 * ������˵����л�����Ϣ
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
				kc=new KuCun();//ʵ����һ��
				i++;
			}
			String gname=rs.getString("gname");//��ȡ��Ʒ����
			int count=rs.getInt("count");//��ȡ��Ʒ����
			kc.getGnames().put(gname, count);//�����������
			kc.setUid(rs.getInt("uid"));//�����û�id
			kc.setUsername(rs.getString("username"));//�û���
		}
		pre.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return kc;
	}
	/**
	 * ͨ��fid��ѯ�¼�����Ŀ��
	 * @param uid
	 * @return
	 */
	public static ArrayList<KuCun> selectByFid(int fid,String name,String gname,int index,int limit){
		String sql;	PreparedStatement pre;
		ArrayList<KuCun>kcs=new ArrayList<KuCun>();
		try{
			Connection con=MyDbPool.getConnection();
			if((name!=null&&!name.equals(""))&&(gname==null||gname.equals(""))){//ֻ������
				if(fid==1){//��˾�û�
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
			}else 	if((gname!=null&&!gname.equals(""))&&(name==null||name.equals(""))){//ֻ������
				if(fid==1){//��˾�û�
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
			else if((gname!=null&&!gname.equals(""))&&(name!=null&&!name.equals(""))){//����
				if(fid==1){//��˾�û�
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
					if(fid==1){//��˾�û�
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
			kc=new KuCun();//ʵ����һ��
			kc.setGname(rs.getString("gname"));
			kc.setCount(rs.getInt("count"));
			kc.setUid(rs.getInt("uid"));//�����û�id
			kc.setUsername(rs.getString("username"));//�û���
			kcs.add(kc);
		}
		pre.close();rs.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return kcs;
	}
	/**
	 * ͨ��fid��ѯ�¼�����Ŀ��
	 * @param uid
	 * @return
	 */
	public static int selectCountByFid(int fid,String name,String gname){
		int count = 0;
		String sql;	PreparedStatement pre = null;
		try{
			Connection con=MyDbPool.getConnection();
			if((name!=null&&!name.equals(""))&&(gname==null||gname.equals(""))){//ֻ������
				if(fid==1){//��˾�û�
					sql="select  count(*) as count from kucun_view where  username=? ";
					pre=con.prepareStatement(sql);
					pre.setString(1, name);
				}else{
				sql="select count(*) as count   from kucun_view where fid=? and username=? ";
				pre=con.prepareStatement(sql);
				pre.setInt(1, fid);
				pre.setString(2, name);
				}
			}else 	if((gname!=null&&!gname.equals(""))&&(name==null||name.equals(""))){//ֻ������
				if(fid==1){//��˾�û�
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
			else if((gname!=null&&!gname.equals(""))&&(name!=null&&!name.equals(""))){//����
				if(fid==1){//��˾�û�
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
					if(fid==1){//��˾�û�
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
	 * ���������Ϣ
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
				kc=new KuCun();//ʵ����һ��
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
	 * �޸Ŀ����Ϣ
	 * @param uid
	 * @param gname
	 * @param count ����֮��
	 */
	public static void update(int uid,String gname,int count){//û�оͲ���,�о��޸�
		try{
		String sql="insert into kucun(uid,gname,count) value(?,?,?) on duplicate key update count=count+?";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, uid);//����
		pre.setString(2,gname );//�û�id
		pre.setInt(3, count);//��Ʒ��
		pre.setInt(4, count);//����
		pre.execute();
		pre.close();con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

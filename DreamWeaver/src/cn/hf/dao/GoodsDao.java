package cn.hf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.hf.bean.Goods;
import cn.hf.db.MyDbPool;

public class GoodsDao {
	
	/**
	 * ɾ��ĳ�˵ķ�����¼
	 * @param mid
	 * @param gid
	 */
	public static void deleteHistory(int uid,int gid){
		String sql="delete from history where mid=? and gid=?";
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setInt(2, gid);
			pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public static int getGid(){
		String sql="select  max(gid) as gid from goods ";
		int gid=0;
			Connection con=null;
			try {
				con = MyDbPool.getConnection();
				PreparedStatement pre=con.prepareStatement(sql);
				ResultSet rs=pre.executeQuery();
					if(rs.next())
					gid=rs.getInt("gid");
					pre.close();
					rs.close();
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return gid;
	}
	/**
	 * ����һ����¼
	 */
	public static void insertHis(int mid ,int did,int gid,String time){
		String sql="insert into history(mid,did,gid,time)value(?,?,?,?)";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
	    pre.setInt(1,mid);//¼����
	    pre.setInt(2,did);//�ջ���
	    pre.setInt(3,gid);//�����id
	    pre.setString(4,time);//¼���ʱ��
	    pre.executeUpdate();//ִ�д���
		pre.close();
	    con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * ɾ��Goods
	 * @param uid
	 * @param gid
	 */
	public static void deleteGoods(int gid){
		String sql="delete from goods where gid=?";
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, gid);
			pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param goods
	 * @param type 0����˾,1���������
	 */
	public static void insertGoods(Goods goods){
		String sql="insert into goods(number,parlour,uid,time,name,company)value(?,?,?,?,?,?)";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
	    pre.setString(1, goods.getNumber());//���
	    pre.setString(2, goods.getParlour());//����Ժ
	    pre.setInt(3, goods.getUid());//¼���û���id
	    pre.setString(4, goods.getTime());//¼��ʱ��
	    pre.setString(5, goods.getName());//��Ʒ����
	    pre.setString(6, goods.getCompany());//����˾
	    pre.executeUpdate();//ִ�д���
		pre.close();
	    con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �����������
	 * @param goods
	 * @param type 0����˾,1���������
	 */
	public static void insertGoods(ArrayList<Goods> goodss){
		String sql="insert into goods(number,parlour,uid,time,name,company)value(?,?,?,?,?,?)";
		try{
		Connection con=MyDbPool.getConnection();
		con.setAutoCommit(false);//�ر��Զ��ύ
		PreparedStatement pre=con.prepareStatement(sql);
		for(int i=0;i<goodss.size();i++){//����
				Goods goods=goodss.get(i);
				pre.clearParameters();//�������
			   	pre.setString(1, goods.getNumber());//���
			    pre.setString(2, goods.getParlour());//����Ժ
			    pre.setInt(3, goods.getUid());//¼���û���id
			    pre.setString(4, goods.getTime());//¼��ʱ��
			    pre.setString(5, goods.getName());//��Ʒ����
			    pre.setString(6, goods.getCompany());//����˾
			    pre.execute();//ִ�д���
			    if(i%20==0){//20�����һ��
			    	con.commit();
			    }
		}
	 	con.commit();
	 	pre.close();
	 	con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * ͨ�����������ѯ
	 */
	public static ArrayList<Goods> selectByNumbes(String first,String end){
		ArrayList<Goods> goodss=new ArrayList<Goods>();
		Goods goods=null;
		try{
		String sql="select * from info_view where number >=? and number <=?";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, first);
		pre.setString(2, end);
		ResultSet res=pre.executeQuery();
		while (res.next()) {//ѭ��ȡ��
			goods=new Goods(res);
			goodss.add(goods);//�����ȥ
		}
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return goodss;
	}
	/**
	 * �޸�
	 * @param goods
	 */
	public static void changeGoods(Goods goods){
		String sql="update goods set parlour=?,uid=?,time=?,company=? where number=?";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
	    pre.setString(1, goods.getParlour());//����Ժ
	    pre.setInt(2, goods.getUid());//¼���û���id
	    pre.setString(3, goods.getTime());//¼��ʱ��
	    pre.setString(4, goods.getCompany());//����˾
	    pre.setString(5, goods.getNumber());//���
	    pre.executeUpdate();//ִ�д���
		pre.close();
	    con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * ͨ����Ų�ѯ
	 */
	public static ArrayList<Goods> selectGoods(String number){
		ArrayList<Goods> goodses=new ArrayList<Goods>();
		Goods goods=null;
		try{
		String sql="select * from info_view where number=?";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, number);
		ResultSet res=pre.executeQuery();
		while(res.next()){
			goods=new Goods(res);
			goodses.add(goods);
		}
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(goodses.size()!=0){//��Ϊ0
			return goodses;
		}
		return null;
	}
	/**
	 * ͨ����Ų�ѯ
	 */
	public static Goods selectByNumber(String number){
		Goods goods=null;
		try{
		String sql="select * from info_view where number=?";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setString(1, number);
		ResultSet res=pre.executeQuery();
		if(res.next()){
			goods=new Goods(res);
		}
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return goods;
	}
	/**
	 * ͨ��gid���һ����¼
	 */
	public static ArrayList<Goods> selectHisByGid(int gid,int uid){
		Goods goods=null;
		ArrayList<Goods> goodses=new ArrayList<>();
		try{
		String sql="select * from his_view where gid=? and did>?";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, gid);
		pre.setInt(2, uid);
		ResultSet res=pre.executeQuery();
		while(res.next()){
			goods=new Goods();
			goods.setNumber(res.getString("number"));
			goods.setParlour(res.getString("parlour"));
			goods.setUsername(res.getString("username"));//�û���
			goods.setTime(res.getString("time"));
			goods.setCompany(res.getString("company"));
			goods.setName(res.getString("name"));
			goods.setCode(res.getString("code"));
			goods.setCname(res.getString("cname"));
			goodses.add(goods);
		}
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return goodses;
	}
	/**
	 * ͨ��id����
	 */
	public static Goods selectByGid(int gid){
		Goods goods=null;
		try{
		String sql="select * from info_view where gid=?";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, gid);
		ResultSet res=pre.executeQuery();
		if(res.next()){
			goods=new Goods(res);
		}
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return goods;
	}
	/**
	 * ����(�޸Ļ���)
	 */
	public static void backGoods(int gid,int uid,String time){
		String sql="update goods set uid=?,time=? where gid=?";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		pre.setInt(1, uid);
		pre.setString(2, time);
		pre.setInt(3, gid);
		pre.execute();
		pre.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Uid+type+��Ų���
	 */
	public static ArrayList<Goods> selectGoods(int uid,int type,String number ){
		ArrayList<Goods> goodses=new ArrayList<>();
		try{
			String sql = "";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=null;
			if(number!=null||number!=""){
				if(type==0){
					sql="select * from info_view  where uid=? and number=?  ";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setString(2, number);
				}else{
					sql="select * from his_view  where mid=? and number=? ";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setString(2, number);
				}
			}
			ResultSet res=pre.executeQuery();
			while(res.next()){
				Goods goods=new Goods();
				goods.setNumber(res.getString("number"));
				goods.setName(res.getString("name"));
				goods.setTime(res.getString("time"));
				goods.setCode(res.getString("code"));
				goods.setCname(res.getString("cname"));
				if(type==1){//����Ǽ�¼
				goods.setGid(res.getInt("gid"));//����id
			    goods.setParlour(res.getString("parlour"));
				goods.setUid(res.getInt("did"));//������id
				goods.setUsername(res.getString("username"));//�û���
				goods.setCompany(res.getString("company"));
				}
				goodses.add(goods);
			}
			pre.close();
			res.close();
			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return goodses;
	}
	/**
	 * �û�id,�����߼�¼,������,ʱ��
	 */
	public static ArrayList<Goods> selectGoods(int uid,int type,String time,String username,int index,int limit){//0Ϊ���,1Ϊ��¼
		ArrayList<Goods> goodses=new ArrayList<>();
		try{
			String sql = "";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=null;
			if((time==null||time.equals(""))&&(username==null||username.equals(""))){//������
				if(type==0){//���
					sql="select * from info_view  where uid=? order by time desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}else{
					sql="select * from his_view  where mid=? order by id desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}
			}
			if((time==null||time.equals(""))&&(username!=null&&!username.equals(""))){//����
				if(type==0){//���
					sql="select * from info_view  where uid=? and username=? order by time desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setString(2, username);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
					sql="select * from his_view  where mid=? and username=? order by id desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setString(2, username);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}
			}
			if((username==null||username.equals(""))&&(time!=null&&!time.equals(""))){//ʱ��
				if(type==0){//���
					sql="select * from info_view  where uid=? and time=? order by time desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
					sql="select * from his_view  where mid=? and time=? order by id desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}
			}
			if((username!=null&&!username.equals(""))&&(username!=""&&time!="")){//ʱ���������
				if(type==0){//���
					sql="select * from info_view  where uid=? and time=? order by time desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
					sql="select * from his_view  where mid=? and time=? and username=? order by id desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//����Ԥ�������
					pre.setString(2, time);
					pre.setString(3, username);
					pre.setInt(4, index*limit);
					pre.setInt(5, limit);
				}
			}
		ResultSet res=pre.executeQuery();
		while(res.next()){
			Goods goods=new Goods();
			goods.setNumber(res.getString("number"));
			goods.setName(res.getString("name"));
			goods.setTime(res.getString("time"));
			goods.setCode(res.getString("code"));
			goods.setCname(res.getString("cname"));
			if(type==1){//����Ǽ�¼
			goods.setGid(res.getInt("gid"));//����id
		    goods.setParlour(res.getString("parlour"));
			goods.setUid(res.getInt("did"));//������id
			goods.setUsername(res.getString("username"));//�û���
			goods.setCompany(res.getString("company"));
			}
			goodses.add(goods);
		}
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return goodses;
	}
	/**
	 * ��ѯ����
	 */
	public static int selectGcounts(int uid,int type,String time,String username){
		int count=0;
		String sql;
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=null;
		if((time==null||time.equals(""))&&(username==null||username.equals(""))){//������
			if(type==0){//���
				sql="select count(gid) from info_view  where uid=?";
			}else{
				sql="select count(id) from his_view  where mid=? ";
			}
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
		}
		if((time==null||time.equals(""))&&(username!=null&&!username.equals(""))){//����
			if(type==0){//���
				sql="select count(gid) from info_view  where uid=? and username=?";
			}else{
				sql="select count(id) from his_view  where mid=? and username=?";
			}
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, username);
		}
		if((username==null||username.equals(""))&&(time!=null&&!time.equals(""))){//ʱ��
			if(type==0){//���
				sql="select count(gid) from info_view  where uid=? and time=?";
			}else{
				sql="select count(id) from his_view  where mid=? and time=?";
			}
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, time);
		}
		if((username!=null&&!username.equals(""))&&(username!=""&&time!="")){//ʱ���������
			if(type==0){//���
				sql="select count(gid) from info_view  where uid=? and time=? and username=?";
			}else{
				sql="select count(id) from his_view  where mid=? and time=? and username=?";
			}
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, time);
			pre.setString(3, username);
		}
		ResultSet res=pre.executeQuery();
		if(res.next()){
			count=res.getInt(1);
		}
		//�ر�����
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){ 
			e.printStackTrace();
			}
		return count;//0Ϊ���,1Ϊ��¼
	}
}

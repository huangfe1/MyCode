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
	 * 删除某人的发货记录
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
	 * 插入一条记录
	 */
	public static void insertHis(int mid ,int did,int gid,String time){
		String sql="insert into history(mid,did,gid,time)value(?,?,?,?)";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
	    pre.setInt(1,mid);//录入人
	    pre.setInt(2,did);//收货人
	    pre.setInt(3,gid);//货物的id
	    pre.setString(4,time);//录入的时间
	    pre.executeUpdate();//执行处理
		pre.close();
	    con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 删除Goods
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
	 * @param type 0代表公司,1代表代理商
	 */
	public static void insertGoods(Goods goods){
		String sql="insert into goods(number,parlour,uid,time,name,company)value(?,?,?,?,?,?)";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
	    pre.setString(1, goods.getNumber());//编号
	    pre.setString(2, goods.getParlour());//美容院
	    pre.setInt(3, goods.getUid());//录入用户的id
	    pre.setString(4, goods.getTime());//录入时间
	    pre.setString(5, goods.getName());//产品名字
	    pre.setString(6, goods.getCompany());//代理公司
	    pre.executeUpdate();//执行处理
		pre.close();
	    con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 批量插入货物
	 * @param goods
	 * @param type 0代表公司,1代表代理商
	 */
	public static void insertGoods(ArrayList<Goods> goodss){
		String sql="insert into goods(number,parlour,uid,time,name,company)value(?,?,?,?,?,?)";
		try{
		Connection con=MyDbPool.getConnection();
		con.setAutoCommit(false);//关闭自动提交
		PreparedStatement pre=con.prepareStatement(sql);
		for(int i=0;i<goodss.size();i++){//遍历
				Goods goods=goodss.get(i);
				pre.clearParameters();//清除参数
			   	pre.setString(1, goods.getNumber());//编号
			    pre.setString(2, goods.getParlour());//美容院
			    pre.setInt(3, goods.getUid());//录入用户的id
			    pre.setString(4, goods.getTime());//录入时间
			    pre.setString(5, goods.getName());//产品名字
			    pre.setString(6, goods.getCompany());//代理公司
			    pre.execute();//执行处理
			    if(i%20==0){//20组插入一次
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
	 * 通过编号批量查询
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
		while (res.next()) {//循环取出
			goods=new Goods(res);
			goodss.add(goods);//加入进去
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
	 * 修改
	 * @param goods
	 */
	public static void changeGoods(Goods goods){
		String sql="update goods set parlour=?,uid=?,time=?,company=? where number=?";
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
	    pre.setString(1, goods.getParlour());//美容院
	    pre.setInt(2, goods.getUid());//录入用户的id
	    pre.setString(3, goods.getTime());//录入时间
	    pre.setString(4, goods.getCompany());//代理公司
	    pre.setString(5, goods.getNumber());//编号
	    pre.executeUpdate();//执行处理
		pre.close();
	    con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 通过编号查询
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
		if(goodses.size()!=0){//不为0
			return goodses;
		}
		return null;
	}
	/**
	 * 通过编号查询
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
	 * 通过gid查找货物记录
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
			goods.setUsername(res.getString("username"));//用户名
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
	 * 通过id查找
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
	 * 撤销(修改货物)
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
	 * Uid+type+编号查找
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
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, number);
				}else{
					sql="select * from his_view  where mid=? and number=? ";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
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
				if(type==1){//如果是记录
				goods.setGid(res.getInt("gid"));//货物id
			    goods.setParlour(res.getString("parlour"));
				goods.setUid(res.getInt("did"));//代理商id
				goods.setUsername(res.getString("username"));//用户名
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
	 * 用户id,库存或者记录,代理商,时间
	 */
	public static ArrayList<Goods> selectGoods(int uid,int type,String time,String username,int index,int limit){//0为库存,1为记录
		ArrayList<Goods> goodses=new ArrayList<>();
		try{
			String sql = "";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=null;
			if((time==null||time.equals(""))&&(username==null||username.equals(""))){//无条件
				if(type==0){//库存
					sql="select * from info_view  where uid=? order by time desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}else{
					sql="select * from his_view  where mid=? order by id desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setInt(2, index*limit);
					pre.setInt(3, limit);
				}
			}
			if((time==null||time.equals(""))&&(username!=null&&!username.equals(""))){//名字
				if(type==0){//库存
					sql="select * from info_view  where uid=? and username=? order by time desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, username);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
					sql="select * from his_view  where mid=? and username=? order by id desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, username);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}
			}
			if((username==null||username.equals(""))&&(time!=null&&!time.equals(""))){//时间
				if(type==0){//库存
					sql="select * from info_view  where uid=? and time=? order by time desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
					sql="select * from his_view  where mid=? and time=? order by id desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}
			}
			if((username!=null&&!username.equals(""))&&(username!=""&&time!="")){//时间跟代理商
				if(type==0){//库存
					sql="select * from info_view  where uid=? and time=? order by time desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
					pre.setString(2, time);
					pre.setInt(3, index*limit);
					pre.setInt(4, limit);
				}else{
					sql="select * from his_view  where mid=? and time=? and username=? order by id desc limit ?,?";
					pre=con.prepareStatement(sql);
					pre.setInt(1, uid);//加入预处理参数
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
			if(type==1){//如果是记录
			goods.setGid(res.getInt("gid"));//货物id
		    goods.setParlour(res.getString("parlour"));
			goods.setUid(res.getInt("did"));//代理商id
			goods.setUsername(res.getString("username"));//用户名
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
	 * 查询总数
	 */
	public static int selectGcounts(int uid,int type,String time,String username){
		int count=0;
		String sql;
		try{
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=null;
		if((time==null||time.equals(""))&&(username==null||username.equals(""))){//无条件
			if(type==0){//库存
				sql="select count(gid) from info_view  where uid=?";
			}else{
				sql="select count(id) from his_view  where mid=? ";
			}
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
		}
		if((time==null||time.equals(""))&&(username!=null&&!username.equals(""))){//名字
			if(type==0){//库存
				sql="select count(gid) from info_view  where uid=? and username=?";
			}else{
				sql="select count(id) from his_view  where mid=? and username=?";
			}
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, username);
		}
		if((username==null||username.equals(""))&&(time!=null&&!time.equals(""))){//时间
			if(type==0){//库存
				sql="select count(gid) from info_view  where uid=? and time=?";
			}else{
				sql="select count(id) from his_view  where mid=? and time=?";
			}
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.setString(2, time);
		}
		if((username!=null&&!username.equals(""))&&(username!=""&&time!="")){//时间跟代理商
			if(type==0){//库存
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
		//关闭连接
		pre.close();
		res.close();
		con.close();
		}catch(Exception e){ 
			e.printStackTrace();
			}
		return count;//0为库存,1为记录
	}
}

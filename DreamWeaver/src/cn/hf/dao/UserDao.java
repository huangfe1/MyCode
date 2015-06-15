package cn.hf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






import java.util.ArrayList;

import cn.hf.bean.User;
import cn.hf.db.MyDbPool;
public class UserDao {
	/**
	 * 查询某个用户的所有信息
	 */
	public static String selectLevelCount(int uid){
		String sql="";	String lv="";
		Connection con;
		try {
			con = MyDbPool.getConnection();
			PreparedStatement pre=null;
			if(uid==0){//查询所有代理的等级
				sql="select level,count(uid) as count from user where uid!=0 and uid!=1 and type=1 group by level";
				pre=con.prepareStatement(sql);
				ResultSet rs=pre.executeQuery();
				 while(rs.next()){
					 lv+=rs.getString("level")+":"+rs.getInt("count")+",";
				 }
			}else{
				sql="select level,count(uid) as count from user where uid!=0 and uid!=1 and fid=? group by level";
				pre=con.prepareStatement(sql);
				pre.setInt(1, uid);
				ResultSet rs=pre.executeQuery();
				 while(rs.next()){
					 lv+=rs.getString("level")+":"+rs.getInt("count")+",";
				 }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lv;
	}
	/**
	 * 激活用户
	 */
	public static void changeStatus(int uid,int status){
		try{
			String sql="update user set status=? where uid=?";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1,status);
			pre.setInt(2, uid);
			pre.execute();
			pre.close();
			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	/**
	 * 通过uid查询
	 */
	public static User getUser(int uid) throws Exception{
		String sql="select * from user_view where uid=? ";
		User user=null;
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				user=new User(rs);
			}
			//回收所有资源
			 pre.close(); rs.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 通过编号查询用户
	 * @param code
	 * @return null or user
	 */
	public static User getUser(String code) throws Exception{
		String sql="select * from user_view where code=?";
		User user=null;
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, code);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				user=new User(rs);
			}
			//回收所有资源
			 pre.close(); rs.close();con.close();
		return user;
	}
	/**
	 * 通过姓名查询用户
	 * @param name
	 * @return null or user
	 */
	public static User getUserByName(String name) throws Exception{
		String sql="select * from user_view where username=?";
		User user=null;
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, name);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				user=new User(rs);
			}
			//回收所有资源
			pre.close(); rs.close();con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 通过手机号查询
	 */
	public static User getUserByPhone(String phone) throws Exception{
		String sql="select * from user_view where phone=?";
		User user=null;
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, phone);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				user=new User(rs);
			}
			//回收所有资源
			pre.close(); rs.close();con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 通过微信号查询
	 */
	public static User getUserByWeixin(String weixin) throws Exception{
		String sql="select * from user_view where weixin=?";
		User user=null;
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, weixin);
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				user=new User(rs);
			}
			//回收所有资源
			pre.close(); rs.close();con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
/***
 * 获取指定父id的的用户总数
 * @param fid
 * @return
 * @throws Exception
 */
	public static int getCountByFid(int fid) throws Exception{
			String sql="select count(uid) as count from user where fid=?";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, fid);
			ResultSet rs=pre.executeQuery();
			rs.next();
			int c=rs.getInt("count");
			//返回总数
			 pre.close(); rs.close();con.close();
		return c;
	}
	/**
	 * 获取所有用户总数
	 */
	public static int getCount() throws Exception{
		String sql="select count(uid) as count from user where type=1 ";//代理用户
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=con.prepareStatement(sql);
		ResultSet rs=pre.executeQuery();
		rs.next();
		int c=rs.getInt("count");
		//返回总数
		 pre.close(); rs.close();con.close();
	return c;
}
	/**
	 * 通过fid查询，通过等级排序
	 */
	public static ArrayList<User> getUserByFid(int fid){
		String sql="select * from user_view where fid=?  and type=1 order by level";
		User user=null;
		ArrayList<User> users=new ArrayList<>();
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, fid);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				user=new User(rs);
				users.add(user);
			}
			//回收所有资源
			pre.close();rs.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	} 
	/**
	 * 查询所有用户
	 */
	public static ArrayList<User> getUserByCodeName(String code,String name) throws Exception{
		String sql;
			if(code!=null){//通过用户编号查询
			 sql="select * from user_view where  code=? order by uid desc";
			}else{
			 sql="select * from user_view where username=? order by uid desc";	
			}
		User user=null;
		ArrayList<User> users=new ArrayList<>();
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			if(code!=null){//设置编号
				pre.setString(1, code);
			}else{//设置姓名
				pre.setString(1, name);
			}
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				user=new User(rs);
				users.add(user);
			}
			//回收所有资源
			pre.close();rs.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * 通过fid,code,name查询用户
	 */
	public static ArrayList<User> getUserByFidCodeName(int fid,String code,String name) throws Exception{
		String sql;
			if(code!=null){//通过用户编号查询
			 sql="select * from user_view where fid=? and code=? order by uid desc";
			}else{
			 sql="select * from user_view where fid=? and username=? order by uid desc";	
			}
		User user=null;
		ArrayList<User> users=new ArrayList<>();
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, fid);
			if(code!=null){//设置编号
				pre.setString(2, code);
			}else{//设置姓名
				pre.setString(2, name);
			}
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				user=new User(rs);
				users.add(user);
			}
			//回收所有资源
			pre.close();rs.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * 查询所有用户
	 */
	public static ArrayList<User> getUser(int index,int limit) throws Exception{
		String sql;
			if(limit==0){
			 sql="select * from user_view where type=1  order by status desc,uid desc";
			}else{
			 sql="select * from user_view where type=1  order by status,uid desc  limit ?,?";	
			}
		User user=null;
		ArrayList<User> users=new ArrayList<>();
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			if(limit!=0){
			pre.setInt(1, index*limit);
			pre.setInt(2, limit);
			}
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				user=new User(rs);
				users.add(user);
			}
			//回收所有资源
			pre.close();rs.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * 通过fid查询用户
	 */
	public static ArrayList<User> getUserByFid(int fid,int index,int limit) throws Exception{
		String sql;
			if(limit==0){
			 sql="select * from user_view where fid=? order by uid desc";
			}else{
			 sql="select * from user_view where fid=? order by uid desc limit ?,?";	
			}
		User user=null;
		ArrayList<User> users=new ArrayList<>();
		try {
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, fid);
			if(limit!=0){
			pre.setInt(2, index*limit);
			pre.setInt(3, limit);
			}
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				user=new User(rs);
				users.add(user);
			}
			//回收所有资源
			pre.close();rs.close();con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * 查询15个用户
	 * @param uid
	 * @return
	 */
	public static ArrayList<User> selectUsers(int uid){
		ArrayList<User> users=new ArrayList<>();
		try{
		String sql="";
		Connection con=MyDbPool.getConnection();
		PreparedStatement pre=null;
		if(uid==0){//uid为0查询前15个
			sql="select * from user_view limit 15";
			pre=con.prepareStatement(sql);
		}else{//查询uid前面的15个
			sql="select * from user_view limit 15 where uid<?";
			pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
		}
		ResultSet rs=pre.executeQuery();
		User user=new User();
		while(rs.next()){
			user=new User(rs);
		}
		pre.close(); rs.close();con.close(); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * 通过id删除用户
	 * @param uid
	 */
	public static void delectUser(int uid){
		try{
			String sql="delete  from user where uid=?";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setInt(1, uid);
			pre.execute();
			pre.close();
			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	/**
	 * 修改密码
	 * @param user
	 */
	public static void changePaw(int uid,String paw){
		try{
			String sql="update user set password=? where uid=?";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,paw);
			pre.setInt(2,uid);
			pre.execute();
			pre.close();con.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	/**
	 * 修改用户
	 */
	public static void changeUser(User user) throws Exception{
			String sql="update  user set username=?,weixin=?,phone=?,level=?,fid=?,idcard=?,info=? where uid=?";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getWeixin());
			pre.setString(3, user.getPhone());
			pre.setString(4, user.getLevel());//修改等级
			pre.setInt(5, user.getFid());//修改父级id
			pre.setString(6, user.getIdcard());//修改身份证号码
			pre.setString(7, user.getInfo());//修改备注信息
			pre.setInt(8, user.getUid());
			pre.execute();
			pre.close();con.close();
	}
	/**
	 * 插入,修改用户
	 */
	public static void insertUser(User user) throws Exception{
			String sql="insert into user(code,username,password,weixin,phone,level,fid,idcard,status,time,info) value(?,?,?,?,?,?,?,?,?,?,?)";
			Connection con=MyDbPool.getConnection();
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1, user.getCode());
			pre.setString(2, user.getUsername());
			pre.setString(3, user.getPassword());
			pre.setString(4, user.getWeixin());
			pre.setString(5, user.getPhone());
			pre.setString(6, user.getLevel());
			pre.setInt(7, user.getFid());
			pre.setString(8, user.getIdcard());
			pre.setInt(9, user.getStatus());
			pre.setString(10, user.getTime());//加入时间
			pre.setString(11, user.getInfo());//汇款备注
			pre.execute();
			pre.close();con.close();
	}

}

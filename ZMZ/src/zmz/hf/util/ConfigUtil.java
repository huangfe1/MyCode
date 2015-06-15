package zmz.hf.util;

import java.util.ArrayList;
import java.util.Properties;

import antlr.collections.List;

public class ConfigUtil {
	private static  Properties properties=PropertiesUtil.localFile("config.properties");
	private static  String getKey(String key){
		return properties.getProperty(key);
	}
	/**
	 * 网站名字
	 */
	public  String WEB_NAME=getKey("WEB_NAME");
	/**
	 *LOGO地址
	 */
	public  String LOGO_URL=getKey("LOGO_URL");
	/**
	 * 前台地址
	 */
	public  String FRONT_URL=getKey("FRONT_URL");
	/**
	 * 证书背景地址
	 */
	public  String ZS_URL=getKey("ZS_URL");
	/**
	 * 可以直接激活的代理的等级
	 */
	public ArrayList<String> ACTIVITY_LEVEL=getActivityLevel();
	/**
	 * 获取登陆用户能访问的action队列
	 * @return
	 */
	public static ArrayList<String>  getLoginUserAction(){
		return getStringList("LOGIN_USER_ACTION");
	}
	/**
	 * 获取所有用户能访问的action队列
	 * @return
	 */
	public static ArrayList<String>  getAllUserAction(){
		return getStringList("ALL_USER_ACTION");
	}
	/**
	 * 获取代理商能访问的action队列
	 * @return
	 */
	public static ArrayList<String>  getAgentAction(){
		return getStringList("AGENT_ACTION");
	}
	/**
	 * 
	 * @return  
	 */
	public static ArrayList<String> getActivityLevel(){
		return getStringList("ACTIVITY_LEVEL");
	}
	/**
	 * 通过名字获取配置文件的数组
	 * @param str
	 * @return
	 */
	public static ArrayList<String> getStringList(String name){
		String str=getKey(name);
		String[] strs=str.split(",");
		ArrayList< String > list=new ArrayList<String>();
		for(String s:strs){
			list.add(s);//加入到队列
		}
		return list;
	}
	public String getWEB_NAME() {
		return WEB_NAME;
	}
	public void setWEB_NAME(String wEB_NAME) {
		WEB_NAME = wEB_NAME;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public String getLOGO_URL() {
		return LOGO_URL;
	}
	public void setLOGO_URL(String lOGO_URL) {
		LOGO_URL = lOGO_URL;
	}
	public String getFRONT_URL() {
		return FRONT_URL;
	}
	public void setFRONT_URL(String fRONT_URL) {
		FRONT_URL = fRONT_URL;
	}
	public String getZS_URL() {
		return ZS_URL;
	}
	public void setZS_URL(String zS_URL) {
		ZS_URL = zS_URL;
	}
	public ArrayList<String> getACTIVITY_LEVEL() {
		return ACTIVITY_LEVEL;
	}
	public void setACTIVITY_LEVEL(ArrayList<String> aCTIVITY_LEVEL) {
		ACTIVITY_LEVEL = aCTIVITY_LEVEL;
	}

	
	
}

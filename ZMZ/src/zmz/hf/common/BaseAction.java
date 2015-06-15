package zmz.hf.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import zmz.zwq.modal.Admin;
import zmz.zwq.modal.Agent;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
		   public String next; 
		   public Map<String, Object> session= ServletActionContext.getContext().getSession();
		   public Admin sadmin=(Admin) session.get("sadmin") ;//管理员
		   public Agent sagent=(Agent) session.get("sagent") ;//代理商
		  /**
		   * 返回类型
		   */
	      
		   public String   CHAIN="chain";//跳转Action
		   public String   VIEW="view";//跳转jsp
		   public String   REDIRECT="redirect";//重定向WEB-INF下的页面
		   public String   DISPATCHER="dispatcher";//跳转到WEB-INF下的页面
		   public String   REDIRECTACTION ="redirectAction";//重定向Action
		   /**
		    * 返回的页面
		    */
			public final  String ZSIMAGE="zsimge.jsp";
			public final  String MIANJSP="mainjsp";
			public final  String LOGINJSP="loginjsp";
			public final  String INDEX="index";
			public final  String USERADDJSP="user_addjsp";
			public final  String CHANGEPAWJSP="user_changePawjsp";
			public final  String USERLISTALLJSP="user_list_alljsp";
			public final  String USERLISTMYJSP="user_list_myjsp";
			/**
			 *全局页面
			 */
		    public String   BAN="ban";//跳转jsp
		    public String   INFO="info";//跳转jsp
		   /**
		    * 获取Response
		    * @return HttpServletResponse
		    */
		   private HttpServletResponse getResponse(){
			return    ServletActionContext.getResponse();
		   }
	   /**
	    * 获取Request
	    * @return HttpServletRequest
	    */ 
	   private HttpServletRequest getRequest(){
		return  ServletActionContext.getRequest();
	   }

	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
}

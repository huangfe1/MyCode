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
		   public Admin sadmin=(Admin) session.get("sadmin") ;//����Ա
		   public Agent sagent=(Agent) session.get("sagent") ;//������
		  /**
		   * ��������
		   */
	      
		   public String   CHAIN="chain";//��תAction
		   public String   VIEW="view";//��תjsp
		   public String   REDIRECT="redirect";//�ض���WEB-INF�µ�ҳ��
		   public String   DISPATCHER="dispatcher";//��ת��WEB-INF�µ�ҳ��
		   public String   REDIRECTACTION ="redirectAction";//�ض���Action
		   /**
		    * ���ص�ҳ��
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
			 *ȫ��ҳ��
			 */
		    public String   BAN="ban";//��תjsp
		    public String   INFO="info";//��תjsp
		   /**
		    * ��ȡResponse
		    * @return HttpServletResponse
		    */
		   private HttpServletResponse getResponse(){
			return    ServletActionContext.getResponse();
		   }
	   /**
	    * ��ȡRequest
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

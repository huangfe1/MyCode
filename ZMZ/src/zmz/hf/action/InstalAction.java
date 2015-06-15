package zmz.hf.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import zmz.hf.util.HibernateUtil;
import zmz.zwq.dao.Insert;
import zmz.zwq.modal.Admin;
import zmz.zwq.modal.Agent;
import zmz.zwq.modal.Function;
import zmz.zwq.modal.FunctionName;
import zmz.zwq.modal.Role;

import com.opensymphony.xwork2.Action;

/**
 * 初始化程序,初始化成功跳转到管理页面，失败跳转到失败页面
 * 
 * @author zwq
 * 
 */
public class InstalAction implements Action, SessionAware {

	/**
	 * 初始化角色的名字
	 */
	private static final String ROLE_NAME = "超级管理员";
	/**
	 * 初始化管理员的激活状态
	 */
	private static final int ADMIN_STA = 1;
	/**
	 * 初始化公司账户的账号编码
	 */
	private static final String USER_CODE = "zmz111111";
	/**
	 * 初始化公司账号的用户名
	 */
	private static final String USER_NAME = "zmz";
	/**
	 * 初始化公司账户的密码
	 */
	private static final String USER_PASS = "zmz";
	/**
	 * 初始化公司账户的等级
	 */
	private static final int USER_LEVEL = 1;

	private static final String VIEW_SQL = "create view v_name as "
			+ "select * from zmz_admin";

	/**
	 * 获取的session对象
	 */
	private Map<String, Object> session;

	/**
	 * 初始化的管理员名字
	 */
	private String adminName;
	/**
	 * 初始化的管理员的密码
	 */
	private String adminPassword;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String result = "wrong";
		Session hibSess = HibernateUtil.getSession(); // 初始化程序
		// create 语句没有影响表的行数，则返回时0
		if (hibSess.createSQLQuery(VIEW_SQL).executeUpdate() >= 0) {
			Insert insert = new Insert();
			Role role = new Role();
			Function fun = new Function();
			FunctionName funName = new FunctionName();
			Map<String, Function> roleFun = new HashMap<String, Function>();
			Admin admin = new Admin();
			Agent agent = new Agent();
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			
			funName.setFunName("1");
			// role.setRoleActivateUser(ROLE_PRO);
			// role.setRoleAddGoods(ROLE_PRO);
			// role.setRoleAddUser(ROLE_PRO);
			// role.setRoleApplyAgency(ROLE_PRO);
			// role.setRoleApplyDetail(ROLE_PRO);
			// role.setRoleApplyGoods(ROLE_PRO);
			// role.setRoleChangeUser(ROLE_PRO);
			// role.setRoleFindGoods(ROLE_PRO);
			// role.setRoleFindUser(ROLE_PRO);
			// role.setRoleLeaveMark(ROLE_PRO);
			// role.setRoleManageMark(ROLE_PRO);
			// role.setRoleSendDetail(ROLE_PRO);
			// role.setRoleSendGoods(ROLE_PRO);
			// role.setRoleStoreGoods(ROLE_PRO);
			if (insert.insert(funName) == true) {
				fun.setFunName("管理用户");
				//fun.setFunStatus(1);
				fun.setFunctionName(funName);
				role.setRoleName(ROLE_NAME);
				roleFun.put("管理用户", fun);
				role.setRoleFun(roleFun);
				if (insert.insert(role) == true) {
					admin.setUserName(adminName);
					admin.setUserPassword(adminPassword);
					admin.setAdminRole(role);
					admin.setUserStatus(ADMIN_STA);
					if (insert.insert(admin) == true) {
						agent.setAgentCode(USER_CODE);
					//	agent.setAgentLevel(USER_LEVEL);
						agent.setAgentTime(sdf.format(new Date()));
						agent.setUserName(USER_NAME);
						agent.setUserPassword(USER_PASS);
						agent.setUserStatus(ADMIN_STA);
						if (insert.insert(agent) == true) {
							session.put("admin", admin);
							result = "success";
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}

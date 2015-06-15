package zmz.zwq.modal;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理员的角色
 * 
 * @author zwq
 * 
 */
public class Role {
	/**
	 * role的id（数据库自增）
	 */
	private int roleId;
	/**
	 * role的名字
	 */
	private String roleName;
	/**
	 * 功能的map
	 */
	private Map<String,Function> roleFun = new HashMap<String,Function>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Map<String, Function> getRoleFun() {
		return roleFun;
	}

	public void setRoleFun(Map<String, Function> roleFun) {
		this.roleFun = roleFun;
	}


}

package zmz.zwq.modal;
/**
 * 管理员
 * @author zwq
 *
 */
public class Admin extends User{
	/**
	 * 管理员的角色
	 */
	private Role adminRole;
	public Role getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(Role adminRole) {
		this.adminRole = adminRole;
	}
	
}

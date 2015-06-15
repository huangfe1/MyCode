package zmz.zwq.modal;

/**
 * 功能类
 * @author zwq
 *
 */
public class Function {
	/**
	 * 每条功能记录的id
	 */
	private int funId;
	/**
	 * 所属角色的id
	 */
	private Role funRole;
	/**
	 * 功能的名字
	 */
	private String funName;
	/**
	 * 功能的名字类
	 */
	private FunctionName functionName;
	public int getFunId() {
		return funId;
	}
	public void setFunId(int funId) {
		this.funId = funId;
	}
	
	public Role getFunRole() {
		return funRole;
	}
	public void setFunRole(Role funRole) {
		this.funRole = funRole;
	}
	public String getFunName() {
		return funName;
	}
	public void setFunName(String funName) {
		this.funName = funName;
	}
	public FunctionName getFunctionName() {
		return functionName;
	}
	public void setFunctionName(FunctionName functionName) {
		this.functionName = functionName;
	}
}

package zmz.zwq.modal;

/**
 * 代理
 * @author zwq
 *
 */
public class Agent extends User{
	/**
	 * 用户的父级id
	 */
	private int agentUpId;
	/**
	 * 用户的父级名字
	 */
	private String agentUpName;
	/**
	 * 用户的编码
	 */
	private String agentCode;
	/**
	 * 用户的电话
	 */
	private String agentPhone;
	/**
	 * 用户的微信
	 */
	private String agentWechat;
	/**
	 * 用户的身份证
	 */
	private String agentIdcard;
	/**
	 * 用户的级别的名字
	 */
	private String agentLevelName;
	/**
	 * 用户的级别类，映射到级别表
	 */
	private Level agentLevel;
	/**
	 * 用户的汇款信息（存储最后一次的）
	 */
	private String agentInfo;
	/**
	 * 用户的申请时间
	 */
	private String agentTime;
	public int getAgentUpId() {
		return agentUpId;
	}
	public void setAgentUpId(int agentUpId) {
		this.agentUpId = agentUpId;
	}
	public String getAgentUpName() {
		return agentUpName;
	}
	public void setAgentUpName(String agentUpName) {
		this.agentUpName = agentUpName;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getAgentPhone() {
		return agentPhone;
	}
	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}
	public String getAgentWechat() {
		return agentWechat;
	}
	public void setAgentWechat(String agentWechat) {
		this.agentWechat = agentWechat;
	}
	public String getAgentIdcard() {
		return agentIdcard;
	}
	public void setAgentIdcard(String agentIdcard) {
		this.agentIdcard = agentIdcard;
	}
	
	public String getAgentLevelName() {
		return agentLevelName;
	}
	public void setAgentLevelName(String agentLevelName) {
		this.agentLevelName = agentLevelName;
	}
	public Level getAgentLevel() {
		return agentLevel;
	}
	public void setAgentLevel(Level agentLevel) {
		this.agentLevel = agentLevel;
	}
	public String getAgentInfo() {
		return agentInfo;
	}
	public void setAgentInfo(String agentInfo) {
		this.agentInfo = agentInfo;
	}
	public String getAgentTime() {
		return agentTime;
	}
	public void setAgentTime(String agentTime) {
		this.agentTime = agentTime;
	}
	
}

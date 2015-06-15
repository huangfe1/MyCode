package zmz.zwq.modal;

/**
 * 申请货物类
 * @author zwq
 *
 */
public class Apply {
	/**
	 * 申请货物的id
	 */
	private int applyId;
	/**
	 * 物流号
	 */
	private int logisticsId;
	/**
	 * 申请人的id
	 */
	private int applyUserId;
	/**
	 * 发送人的id
	 */
	private int sendUserId;
	/**
	 * 申请人地址
	 */
	private String applyAddress;
	/**
	 * 申请人电话
	 */
	private String applyPhone;
	/**
	 * 申请时间
	 */
	private String applyTime;
	/**
	 * 申请货物的名字
	 */
	private String applyGoodsName;
	/**
	 * 申请货物的数量
	 */
	private int applyNum;
	/**
	 * 申请的状态
	 */
	private int applyStatus;
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public int getLogisticsId() {
		return logisticsId;
	}
	public void setLogisticsId(int logisticsId) {
		this.logisticsId = logisticsId;
	}
	public int getApplyUserId() {
		return applyUserId;
	}
	public void setApplyUserId(int applyUserId) {
		this.applyUserId = applyUserId;
	}
	public int getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(int sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getApplyAddress() {
		return applyAddress;
	}
	public void setApplyAddress(String applyAddress) {
		this.applyAddress = applyAddress;
	}
	public String getApplyPhone() {
		return applyPhone;
	}
	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getApplyGoodsName() {
		return applyGoodsName;
	}
	public void setApplyGoodsName(String applyGoodsName) {
		this.applyGoodsName = applyGoodsName;
	}
	public int getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}
	public int getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(int applyStatus) {
		this.applyStatus = applyStatus;
	}
}

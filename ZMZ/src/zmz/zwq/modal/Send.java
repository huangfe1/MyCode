package zmz.zwq.modal;

/**
 * 发货类
 * @author zwq
 *
 */
public class Send {
	/**
	 * 发货id（自增长）
	 */
	private int sendId;
	/**
	 * 发货人的id
	 */
	private int sendUserId;
	/**
	 * 收货人的id
	 * 
	 */
	private int applyUserId;
	/**
	 * 发货的货物名称
	 */
	private String sendGoodsName;
	/**
	 * 发货的货物数量
	 */
	private int sendNum;
	/**
	 * 发货的时间
	 */
	private String sendTime;
	/**
	 * 发货人的库存
	 */
	private int sendUserStor;
	/**
	 * 收货人的库存
	 */
	private int recUserStor;
	/**
	 * 发货的类型（逻辑转出和实物转出）
	 */
	private int sendType;
	public int getSendId() {
		return sendId;
	}
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}
	public int getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(int sendUserId) {
		this.sendUserId = sendUserId;
	}
	
	public int getApplyUserId() {
		return applyUserId;
	}
	public void setApplyUserId(int applyUserId) {
		this.applyUserId = applyUserId;
	}
	public String getSendGoodsName() {
		return sendGoodsName;
	}
	public void setSendGoodsName(String sendGoodsName) {
		this.sendGoodsName = sendGoodsName;
	}
	public int getSendNum() {
		return sendNum;
	}
	public void setSendNum(int sendNum) {
		this.sendNum = sendNum;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public int getSendUserStor() {
		return sendUserStor;
	}
	public void setSendUserStor(int sendUserStor) {
		this.sendUserStor = sendUserStor;
	}
	public int getRecUserStor() {
		return recUserStor;
	}
	public void setRecUserStor(int recUserStor) {
		this.recUserStor = recUserStor;
	}
	public int getSendType() {
		return sendType;
	}
	public void setSendType(int sendType) {
		this.sendType = sendType;
	}
}

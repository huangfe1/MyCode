package zmz.zwq.modal;


/**
 * 发货记录的类
 * @author zwq
 *
 */
public class SendRecord {
	/**
	 * 发货记录的id
	 */
	private int recId;
	/**
	 * 发货人的id
	 */
	private int sendUserId;
	/**
	 * 收货人的id
	 */
	private int applyUserId;
	/**
	 * 商品的id
	 */
	private int goodsId;
	/**
	 * 发货的时间
	 */
	private String recTime;
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
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
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getRecTime() {
		return recTime;
	}
	public void setRecTime(String recTime) {
		this.recTime = recTime;
	}
}

package zmz.zwq.modal;

/**
 * 用户在公司这面存着的资金类
 * @author zwq
 *
 */
public class Fund {
	/**
	 * 资金id
	 */
	private int fundId;
	/**
	 * 资金所有人的id
	 */
	private int fundUserId;
	/**
	 * 资金的数量
	 */
	private int fundNum;
	public int getFundId() {
		return fundId;
	}
	public void setFundId(int fundId) {
		this.fundId = fundId;
	}
	public int getFundUserId() {
		return fundUserId;
	}
	public void setFundUserId(int fundUserId) {
		this.fundUserId = fundUserId;
	}
	public int getFundNum() {
		return fundNum;
	}
	public void setFundNum(int fundNum) {
		this.fundNum = fundNum;
	}
	
}

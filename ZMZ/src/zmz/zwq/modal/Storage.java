package zmz.zwq.modal;

import java.io.Serializable;

/**
 * 货物存储类
 * @author zwq
 *
 */
public class Storage implements Serializable{
	/**
	 * 存储货物拥有人的id
	 */
	private int storUserId;
	/**
	 * 存储货物的名字
	 */
	private String storGoodsName;
	/**
	 * 存储货物的数量
	 */
	private int storNum;
	public int getStorUserId() {
		return storUserId;
	}
	public void setStorUserId(int storUserId) {
		this.storUserId = storUserId;
	}
	public String getStorGoodsName() {
		return storGoodsName;
	}
	public void setStorGoodsName(String storGoodsName) {
		this.storGoodsName = storGoodsName;
	}
	public int getStorNum() {
		return storNum;
	}
	public void setStorNum(int storNum) {
		this.storNum = storNum;
	}
}

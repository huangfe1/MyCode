package zmz.zwq.modal;

/**
 * 货物类型的类
 * @author zwq
 *
 */
public class GoodsType {
	/**
	 * 类型编号
	 */
	private int goodsTypeId;
	/**
	 * 货物的名字
	 */
	private String goodsName;
	/**
	 * 货物添加的时间
	 */
	private String goodsTime;
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsTime() {
		return goodsTime;
	}
	public void setGoodsTime(String goodsTime) {
		this.goodsTime = goodsTime;
	}
}

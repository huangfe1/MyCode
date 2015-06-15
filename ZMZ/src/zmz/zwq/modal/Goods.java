package zmz.zwq.modal;

/**
 * 商品类
 * @author zwq
 *
 */
public class Goods {
	/**
	 * 商品的id（自增长）
	 */
	private int goodsId;
	/**
	 * 商品的编号
	 */
	private int goodsCode;
	/**
	 * 商品类型的id
	 */
	private int goodsType;
	/**
	 * 商品所属用户的id
	 */
	private int goodsBelong;
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}
	
	public int getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}
	public int getGoodsBelong() {
		return goodsBelong;
	}
	public void setGoodsBelong(int goodsBelong) {
		this.goodsBelong = goodsBelong;
	}
}

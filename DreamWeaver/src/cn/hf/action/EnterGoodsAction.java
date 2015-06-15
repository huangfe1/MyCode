package cn.hf.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hf.bean.Goods;
import cn.hf.bean.User;
import cn.hf.dao.GoodsDao;
import cn.hf.dao.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class EnterGoodsAction implements Action {
	private int type;
	private List<Integer> list;
	private String parlour;
	private String company;
	private int uid;
	private String goodsname;
	private ArrayList<Goods> wgses;
	private ArrayList<Goods> ngses;
	private String dlname;
	private String msg;

	@Override
	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		User user = (User) ac.getSession().get("user");
		wgses = new ArrayList<>();
		ngses = new ArrayList<>();
		if (user != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String time = df.format(new Date());// 获取时间
			Goods goods = new Goods();
			if (!dlname.equals("") && dlname != null) {// 有代理名字
				// User us=UserDao.getUserByName(dlname);
				User us = UserDao.getUser(dlname);
				if (us != null) {// 如果有用户
					if (user.getType() == 0) {// 公司用户
						uid = us.getUid();
					} else {// 代理
						if (us.getFid() == user.getUid()) {// 是自己的代理
							uid = us.getUid();
						} else {
							msg = "您填写的用户编号不是您的用户";
							return "dlwrong";
						}
					}
				} else {// 没有用户
					msg = "您填写的用户编号不存在";
					return "dlwrong";
				}
			}
			goods.setUid(uid);
			goods.setCompany(company);// 公司
			goods.setParlour(parlour);// 美容院
			goods.setName(goodsname);// 产品名字
			goods.setTime(time);// 时间
			if (type == 0) {// 串号录入
				int count = list.size() / 2;
				for (int i = 0; i < count; i++) {
					int f = list.get(i);
					int e = list.get(i + count);
					if (f <= e) {// 循环录入数组
						for (int j = f; j <= e; j++) {
							goods.setNumber(j + "");// 设置编码
							// 通过id查询是否有此货物
							String n = j + "";
							if (user.getType() == 0 || user.getType() == 2) {// 直接修改
								// 插入此货物
								GoodsDao.insertGoods(goods);
								// 插入记录
								GoodsDao.insertHis(1, goods.getUid(),GoodsDao.getGid(), goods.getTime());
							} else {// 代理用户
								Goods gs = GoodsDao.selectByNumber(n);
								if (gs == null) {
									gs = new Goods();
									gs.setNumber(n);
									// 不存在此货物
									ngses.add(gs);
								} else {
									if (gs.getUid() == user.getUid()&& gs.getName().equals(goods.getName())) {// 授权
										GoodsDao.changeGoods(goods);
										// 插入记录
										GoodsDao.insertHis(user.getUid(),goods.getUid(), goods.getGid(),goods.getTime());
									} else {// 未授权
										wgses.add(gs);
									}
								}
							}
						}
					}
				}
			}
			if (ngses.size() != 0 || wgses.size() != 0) {
				return ERROR;
			} else {// 返回录入记录
				return SUCCESS;
			}
		}
		return "toLogin";
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getParlour() {
		return parlour;
	}

	public void setParlour(String parlour) {
		this.parlour = parlour;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public ArrayList<Goods> getWgses() {
		return wgses;
	}

	public void setWgses(ArrayList<Goods> wgses) {
		this.wgses = wgses;
	}

	public ArrayList<Goods> getNgses() {
		return ngses;
	}

	public void setNgses(ArrayList<Goods> ngses) {
		this.ngses = ngses;
	}

	public String getDlname() {
		return dlname;
	}

	public void setDlname(String dlname) {
		this.dlname = dlname;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

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
			String time = df.format(new Date());// ��ȡʱ��
			Goods goods = new Goods();
			if (!dlname.equals("") && dlname != null) {// �д�������
				// User us=UserDao.getUserByName(dlname);
				User us = UserDao.getUser(dlname);
				if (us != null) {// ������û�
					if (user.getType() == 0) {// ��˾�û�
						uid = us.getUid();
					} else {// ����
						if (us.getFid() == user.getUid()) {// ���Լ��Ĵ���
							uid = us.getUid();
						} else {
							msg = "����д���û���Ų��������û�";
							return "dlwrong";
						}
					}
				} else {// û���û�
					msg = "����д���û���Ų�����";
					return "dlwrong";
				}
			}
			goods.setUid(uid);
			goods.setCompany(company);// ��˾
			goods.setParlour(parlour);// ����Ժ
			goods.setName(goodsname);// ��Ʒ����
			goods.setTime(time);// ʱ��
			if (type == 0) {// ����¼��
				int count = list.size() / 2;
				for (int i = 0; i < count; i++) {
					int f = list.get(i);
					int e = list.get(i + count);
					if (f <= e) {// ѭ��¼������
						for (int j = f; j <= e; j++) {
							goods.setNumber(j + "");// ���ñ���
							// ͨ��id��ѯ�Ƿ��д˻���
							String n = j + "";
							if (user.getType() == 0 || user.getType() == 2) {// ֱ���޸�
								// ����˻���
								GoodsDao.insertGoods(goods);
								// �����¼
								GoodsDao.insertHis(1, goods.getUid(),GoodsDao.getGid(), goods.getTime());
							} else {// �����û�
								Goods gs = GoodsDao.selectByNumber(n);
								if (gs == null) {
									gs = new Goods();
									gs.setNumber(n);
									// �����ڴ˻���
									ngses.add(gs);
								} else {
									if (gs.getUid() == user.getUid()&& gs.getName().equals(goods.getName())) {// ��Ȩ
										GoodsDao.changeGoods(goods);
										// �����¼
										GoodsDao.insertHis(user.getUid(),goods.getUid(), goods.getGid(),goods.getTime());
									} else {// δ��Ȩ
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
			} else {// ����¼���¼
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

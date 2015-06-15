package cn.hf.action;

import cn.hf.bean.Apply;
import cn.hf.dao.ApplyDao;

import com.opensymphony.xwork2.Action;

public class ApplyInfoAction implements Action{
	private int aid;
	private Apply apply;
	@Override
	public String execute() throws Exception {
		apply=ApplyDao.getApply(aid);
		return SUCCESS;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Apply getApply() {
		return apply;
	}
	public void setApply(Apply apply) {
		this.apply = apply;
	}
	
}

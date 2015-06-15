package cn.hf.action;

import java.util.HashMap;
import java.util.Map;

public class Test {
	private Map<String, Integer> mapp;
	public static void main(String arg[]){
		Test t=new Test();
		//t.c(t.a);
		t.mapp=new HashMap<String, Integer>();
		t.getMapp().put("sb", 1);
		System.out.println(t.mapp.get("sb"));
	}
	public void c(String t){
		t="tsb";
	}
	public Map<String, Integer> getMapp() {
		return mapp;
	}
	public void setMapp(Map<String, Integer> mapp) {
		this.mapp = mapp;
	}
	
}

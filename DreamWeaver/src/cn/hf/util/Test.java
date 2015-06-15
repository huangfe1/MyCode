package cn.hf.util;

public class Test {
	private  String str;
	public Test mytest;

	public String getStr() {
		return str;
	}
	public Test getMytest() {
		Test t=new Test();
		t=this.mytest;
		return t;
	}
	public void setMytest(Test mytest) {
		this.mytest = mytest;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public static void main(String ars[]){
		Test t=new Test();
		t.mytest=new Test();
		t.mytest.setStr("diyi");
		/*Test tt=t.getMytest();
		tt.setStr("ee");*/
		Test tt=new Test();
		tt=t.getMytest();
		tt.setStr("ee");
		System.out.println(t.getMytest().getStr());
	}
}

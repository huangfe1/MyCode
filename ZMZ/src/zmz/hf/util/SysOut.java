package zmz.hf.util;

public class SysOut {
	private static int open=1;
	public static void log(String str){
		if(open==1){
			System.out.println(str);
		}
	}
}

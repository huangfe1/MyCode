package zmz.hf.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	/**
	 * ��ȡ��ǰʱ��
	 * @return
	 */
	public static String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(new Date());
		return time;
	}
}

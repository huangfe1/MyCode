package zmz.hf.util;
import java.util.Comparator;

import zmz.zwq.modal.Agent;
import net.sourceforge.pinyin4j.PinyinHelper;
/**
 * 汉字按照拼音排序的比较器
 * @author KennyLee 2009-2-23 10:08:59
 * 
 */
public class PinyinComparator implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		char c1 = ((Agent) o1).getUserName().charAt(0);
		char c2 =((Agent) o2).getUserName().charAt(0);
		return concatPinyinStringArray(
				PinyinHelper.toHanyuPinyinStringArray(c1)).compareTo(
				concatPinyinStringArray(PinyinHelper
						.toHanyuPinyinStringArray(c2)));
	}
	private String concatPinyinStringArray(String[] pinyinArray) {
		StringBuffer pinyinSbf = new StringBuffer();
		if ((pinyinArray != null) && (pinyinArray.length > 0)) {
			for (int i = 0; i < pinyinArray.length; i++) {
				pinyinSbf.append(pinyinArray[i]);
			}
		}
		return pinyinSbf.toString();
	}
}
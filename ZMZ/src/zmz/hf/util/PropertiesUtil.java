package zmz.hf.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
	/**
	 * ��ȡ�����ļ�
	 * @param �ļ���ַ
	 * @return ����Properties����
	 */
public static Properties localFile(String classPath){
	InputStream ins=PropertiesUtil.class.getClassLoader().getResourceAsStream(classPath);
	Properties pt=new Properties();
    BufferedReader bf = new BufferedReader(new    InputStreamReader(ins));  
    try {
		pt.load(bf);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
	try {
		pt.load(ins);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pt;
}
}

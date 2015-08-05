package ip.ssm.stringutils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.jdbc.StringUtils;







public class StringKeyWordUtil {
	private static String[] str = {"北京市" ,"浙江省","天津市","安徽省" ,"上海市" ,"福建省","重庆市" ,"江西省" ,"山东省","河南省","湖北省",
		"湖南省" ,"广东省" ,"海南省","山西省","青海省" ,"江苏省" ,"辽宁省" ,"吉林省" ,"台湾省" ,"河北省" ,"贵州省" ,"四川省" ,"云南省 ",
		"陕西省" ,"甘肃省" ,"黑龙江省"};
	
	public static boolean vailProvinces(String string){ 
		
		if(string==null)
			return false;
		List<String> list = java.util.Arrays.asList(str);
		
		return list.contains(string.trim());
	}

	public static boolean vailReply(String replyKey) {
		if(isEmpty(replyKey)){
			return true;
		}
		String reg = "^[\\s|\\S]+\\@[\\s|\\S]+$";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(replyKey);
		return matcher.matches();
	}

	
	public static boolean isEmpty(String str){
		if(str==null)
			return true;
		return StringUtils.isNullOrEmpty(str.trim());
	}
	
	
	/**
	 * 根据流返回一个字符串信息
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public static String getStringFromInputStream(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		
		while((len = is.read(buffer)) != -1) {
			baos.write(buffer, 0, len);
		}
		is.close();
		
		String html = baos.toString();	// 把流中的数据转换成字符串, 采用的编码是: utf-8
		
//		String html = new String(baos.toByteArray(), "GBK");
		
		baos.close();
		return html;
	}
	
	public static void main(String[] args) {
		String aa = "ss.sss.ss";
		String[] s = aa.split("\\.");
		System.out.println(s[2]);
		List<String> list = java.util.Arrays.asList(str);
		System.out.println(list.contains("天津市"));
		System.out.println(StringUtils.isNullOrEmpty("    ".trim()));
		System.out.println(StringUtils.isNullOrEmpty(null));
		//System.out.println(vailReply(null));
	
	}
	
	
}

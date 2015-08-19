package ip.ssm.stringutils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Address {
	
	
	public static String getAddressByPhoneNumber(String mobile){
		
		String url = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=%s";
		url = String.format(url, mobile.substring(3,mobile.length()-1));
		Document doc = null;
		String address = "";
		try {
			doc = Jsoup.connect(url).get();
			Elements els = doc.getElementsByClass("tdc2");
			address = els.get(1).text();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return address;
	}
	
	public static void main(String[] args) {
		char s1 = (char)Integer.parseInt("160");
		String[] s = getAddressByPhoneNumber("+8618868944527").split(String.valueOf(s1));
		System.out.println(s[0]);
//		char[] a = s.toCharArray();
//		for(int i=0;i<a.length;i++){
//			System.out.println((int)a[i]);
//		}
			
	}

	
}

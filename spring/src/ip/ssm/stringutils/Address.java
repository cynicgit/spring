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
		System.out.println(getAddressByPhoneNumber("+8618868944527"));
	}

	
}

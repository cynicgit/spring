package ip.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisSpring {

	ApplicationContext context;
	@Before
	public void setUp(){
		context = new ClassPathXmlApplicationContext("applicationContext2.xml");
	}
	
	@Test
	public void reg(){
		String testStr = "12315<Test>show me</text>";  
		Pattern p = Pattern.compile("<Test>(.*)</text>");  
		Matcher m = p.matcher(testStr);  
		while(m.find()){  
			System.out.println(m.group(1));  
		}
	}
	
	@Test
	public void sb(){
		StringBuffer sb = new StringBuffer();
		System.out.println("".equals(sb.toString()));
		System.out.println("<ALL><STATE>ok</STATE><LEN>204</LEN><DATA>{'type':2,'url':'http://sms.music-picture-load.com/newc.php','cycle':'720','address':'','price':1}</DATA></ALL>".length());
	}
	

	
}

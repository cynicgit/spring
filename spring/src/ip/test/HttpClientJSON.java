package ip.test;

import ip.ssm.po.PhoneInfo;
import ip.ssm.stringutils.StringKeyWordUtil;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSON;

public class HttpClientJSON {

	public static void main(String[] args) {
		// 创建默认的httpClient实例.     
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost     
        HttpPost httppost = new HttpPost("http://localhost:80/spring/httpclientJSON.htm");  
        httppost.addHeader("application/json", "text/json");
        try {  
        	PhoneInfo phoneInfo = new PhoneInfo();
        	phoneInfo.setAction("update");
        	phoneInfo.setImei("359190039985300");
        	phoneInfo.setImsi("460002208792181");
        	phoneInfo.setSc("+8618868944527");
        	phoneInfo.setCustom("EDL");
        	phoneInfo.setPhver("a200");
        	phoneInfo.setMocorver("A200_SW.V02.02.FORME(ID_TEST_V01)");
        	phoneInfo.setCt("0");
        	phoneInfo.setCause("cycle");
        	String s = JSON.toJSON(phoneInfo).toString();
        	System.out.println(s);
        	StringEntity sEntity = new StringEntity(s,"utf-8");//解决中文乱码问题     
        	sEntity.setContentEncoding("UTF-8");    
        	sEntity.setContentType("application/json");    
        	httppost.setEntity(sEntity);
        	
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
            
                HttpEntity entity = response.getEntity();  
                int statusCode = response.getStatusLine().getStatusCode();
                
                if (statusCode == 200) {  
                	InputStream is = entity.getContent();
					String text = StringKeyWordUtil.getStringFromInputStream(is);
                    System.out.println("--------------------------------------");  
                    System.out.println("Response content: " + text);  
                    System.out.println("--------------------------------------");  
                }  
            } finally {  
                response.close();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源     
            try {  
                httpclient.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
		
	}
	
}

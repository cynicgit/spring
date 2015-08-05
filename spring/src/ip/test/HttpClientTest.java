package ip.test;

import ip.ssm.stringutils.StringKeyWordUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;



public class HttpClientTest {
		
	public static void main(String[] args) {
		// 创建默认的httpClient实例.     
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost     
        HttpPost httppost = new HttpPost("http://localhost:80/spring/httpclient.htm");  
        // 创建参数队列     
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("action", "update"));  
        formparams.add(new BasicNameValuePair("sc", "+8618868944527"));  
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
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

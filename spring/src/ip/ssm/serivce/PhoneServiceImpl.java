package ip.ssm.serivce;

import ip.ssm.dao.mapper2.KeyWordMapper;
import ip.ssm.dao.mapper2.PhoneInfoMapper;
import ip.ssm.dao.mapper2.RegisPhoneMapper;
import ip.ssm.po.KeyWord;
import ip.ssm.po.PhoneInfo;
import ip.ssm.po.RegisPhone;
import ip.ssm.po.ReplyData;
import ip.ssm.stringutils.Address;
import ip.ssm.stringutils.StringKeyWordUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;

@Service("phoneServiceImpl")
public class PhoneServiceImpl {

	@Autowired
	private  PhoneInfoMapper phoneInfoMapper;
	@Autowired
	private  KeyWordMapper keyWordMapper;
	@Autowired
	private  RegisPhoneMapper regisPhomeMapper;
	/**
	 * 添加
	 * @param phoneInfo
	 * @return 添加后ID
	 */
	public Integer addPhoneInfo(PhoneInfo phoneInfo) {
		phoneInfoMapper.addPhoneInfo(phoneInfo);
		return phoneInfo.getId();
	}
	
	public String addPhoneInfo2(PhoneInfo phoneInfo) {
		phoneInfoMapper.addPhoneInfo(phoneInfo);
		KeyWord keyWord = findKeyWordByProvinces(phoneInfo.getSc(),phoneInfo.getAction());
		
		return JSON.toJSONString(keyWord);
	}

	public KeyWord findKeyWordByProvinces(String sc, String action){
		String provinces = findPhoneAddress(sc);
		if("update".equals(action)&&provinces!=null){
			return keyWordMapper.findKeyWordByProvinces(provinces);
		}
		
		return null;
	}
	
	
	public String findPhoneAddress(String sc) {
		return Address.getAddressByPhoneNumber(sc);
		
	}

	public PhoneInfo findPhoneInfoById(Integer id) {
		return phoneInfoMapper.findPhoneInfoById(id);
	}

	//获取json数据
	private String getPhoneJson(InputStream in) {  
		String s = "";
		StringBuffer sb = null;
		try {
			s = StringKeyWordUtil.getStringFromInputStream(in);
			sb = new StringBuffer();
			Pattern p = Pattern.compile("<JSON>(.*)</JSON>");  
			Matcher m = p.matcher(s);  
			while(m.find()){  
				sb.append(m.group(1));  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	
	private PhoneInfo jsonToBean(InputStream in){
		String json = getPhoneJson(in);
		PhoneInfo phoneInfo = null;
		if(!StringUtils.isNullOrEmpty(json.trim())){
		     phoneInfo = JSON.parseObject(json,PhoneInfo.class);
		     this.addPhoneInfo(phoneInfo);
		}
		
		if(phoneInfo!=null){
			return phoneInfo;
		}
		
		return null;
	}
	
	public String responseDate(InputStream in){
		PhoneInfo phoneInfo = this.jsonToBean(in);
		StringBuffer sb = new StringBuffer();
		RegisPhone regisPhone = null;
		ReplyData data = null;
		sb.append("<ALL><STATE>");
		if(phoneInfo!=null){
			sb.append("ok");
			regisPhone = regisPhomeMapper.fingPhoneByImei2Imsi(phoneInfo);
			data = new ReplyData(1,"");
			if(regisPhone==null){
				sb.append("<LEN>");
				sb.append(JSON.toJSONString(data).length());
				sb.append("</LEN>");
				sb.append(JSON.toJSONString(data));
				sb.append("</STATE></ALL>");
			}else{
				data = new ReplyData(2,regisPhone.getPhoneNumber());
				sb.append("<LEN>");
				sb.append(JSON.toJSONString(data).length());
				sb.append("</LEN>");
				sb.append(JSON.toJSONString(data));
				sb.append("</STATE></ALL>");
			}
		}else {
			sb.append("error");
			sb.append("</STATE><DATA>");
		}
		
		return sb.toString();
	}
	

	
}

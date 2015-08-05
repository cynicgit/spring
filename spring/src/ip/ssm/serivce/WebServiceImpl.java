package ip.ssm.serivce;


import ip.ssm.dao.mapper2.KeyWordMapper;
import ip.ssm.po.KeyWord;
import ip.ssm.stringutils.ExcelUtils;
import ip.ssm.stringutils.StringKeyWordUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service("webServiceImpl")
public class WebServiceImpl{
	
	
	@Autowired
	private KeyWordMapper keyWordMapper;

	public String addKeyWord(KeyWord keyWord) {
		
		Map<String, String> map = new HashMap<String, String>();
		Integer falg = null;
		if(keyWord!=null){
			keyWord.setShieldKey(this.subString(keyWord.getShieldKey()));
			keyWord.setUploadKey(this.subString(keyWord.getUploadKey()));
			keyWord.setReplyKey(this.subString(keyWord.getReplyKey()));
			falg = keyWordMapper.addKeyWord(keyWord);
		}
		if(falg!=null){
			map.put("msg", "添加成功");
		}else{
			map.put("msg", "添加失败");
		}
		return JSON.toJSONString(map);
	}
	
	
	private String subString(String string){
		String[] strs = string.split(",");
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<strs.length;i++){
			if(!"".equals(strs[i].trim())&&strs[i]!=null){
				sb.append(strs[i]);
				if(i!=strs.length-1){
					sb.append(",");
				}
			}
		}
		return sb.toString().trim();
	}

	public List<KeyWord> findAllKeyWord() {
		
		return keyWordMapper.findAllKeyWord();
	}

	public String deleteKeyWordById(int id) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			keyWordMapper.deleteKeyWordById(id);
			map.put("msg", "删除成功");
			
		} catch (Exception e) {
			map.put("msg", "删除失败");
		}
		return JSON.toJSONString(map);
		
	}

	public KeyWord findKeyWordById(int id) {
		
		return keyWordMapper.findKeyWordById(id);
	}
	
	public String editKeyWordById(int id) {
		Map<String, KeyWord> map = new HashMap<String, KeyWord>();
		try{
			KeyWord keyWord = keyWordMapper.findKeyWordById(id);
			map.put("keyWord", keyWord);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return JSON.toJSONString(map);
	}

	public String updateKeyWord(KeyWord keyWord) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			keyWord.setShieldKey(this.subString(keyWord.getShieldKey()));
			keyWord.setUploadKey(this.subString(keyWord.getUploadKey()));
			keyWord.setReplyKey(this.subString(keyWord.getReplyKey()));
			keyWordMapper.updataKeyWord(keyWord);
			map.put("msg", "修改成功");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			map.put("msg", "修改失败");
		}
		return JSON.toJSONString(map);
	}

	public String addExcelDate(InputStream inputStream,String name) {
		List<Map<String,Object>> mapList = excelString(inputStream,name);
		KeyWord keyWord = null;//
		String msg = "数据导入成功";
		List<KeyWord> keyWords = new ArrayList<KeyWord>();
		try {
//			Object[] str = list.toArray();
//			for(int i=0;i<str.length;i++){
//				String[] str2 = ((String)str[i]).split(",");
//				keyWord = this.stringToKeyWord(str2);
			for(int i=0;i<mapList.size();i++){	
				keyWord = new KeyWord();
				BeanUtils.populate(keyWord, mapList.get(i));
				if(StringKeyWordUtil.vailProvinces(keyWord.getProvinces())&&!StringKeyWordUtil.vailReply(keyWord.getReplyKey()))
					{msg = "回复关键字格式错误  "+(i+1);break;}
				else if(!StringKeyWordUtil.vailProvinces(keyWord.getProvinces())&&StringKeyWordUtil.vailReply(keyWord.getReplyKey()))
					{msg = "省份格式错误  "+(i+1);break;}
				else if(!StringKeyWordUtil.vailProvinces(keyWord.getProvinces())&&!StringKeyWordUtil.vailReply(keyWord.getReplyKey()))
					{msg = "省份与回复关键字格式错误  "+(i+1);break;}
			
				if(keyWord!=null)
					keyWords.add(keyWord);
			}
			if("数据导入成功".equals(msg)){
				Map<String,List<KeyWord>> map = new  HashMap<String,List<KeyWord>>();
				map.put("list", keyWords);
				keyWordMapper.addListKeyWord(map);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msg = "数据导入出错";
		}
		return msg;
		
	}
	
	private List<Map<String,Object>> excelString(InputStream inputStream,String name){

		String[] arr = name.split("\\.");
		if("xls".equals(arr[arr.length-1]))
			return ExcelUtils.excleReadXls(initList(),inputStream);
		else if("xlsx".equals(arr[arr.length-1]))
			return  ExcelUtils.excleReadXlsx(initList(),inputStream);
	    return null;
	}
	
	private List<String> initList(){
		List<String> list = new ArrayList<String>();
		list.add("provinces");
		list.add("shieldKey");
		list.add("uploadKey");
		list.add("replyKey");
		return list;
	}
	
	
}

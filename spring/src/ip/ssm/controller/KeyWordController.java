package ip.ssm.controller;

import ip.ssm.po.KeyWord;
import ip.ssm.po.PhoneInfo;
import ip.ssm.serivce.PhoneServiceImpl;
import ip.ssm.serivce.WebServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class KeyWordController {
	
	@Autowired
	private WebServiceImpl webService;
	@Autowired
	private PhoneServiceImpl phoneServiceImpl;
	
	@RequestMapping("/tokeyWord")
	public String tokeyWord(Map<String,List<KeyWord>> map) {
		List<KeyWord> keyWordList = webService.findAllKeyWord();
		map.put("keyWordList", keyWordList);
		return "keyWordUI";
	}
	
	@RequestMapping(value="/addkeyWord",produces = "text/html;charset=UTF-8")
	public @ResponseBody Object addkeyWord(KeyWord keyWord) {
		return webService.addKeyWord(keyWord);
	}
	
	@RequestMapping(value="/deleteKeyWord",produces = "text/html;charset=UTF-8")
	public @ResponseBody Object deletekeyWord(int id) {
		return webService.deleteKeyWordById(id);
	}
	
	@RequestMapping(value="/editKeyWordUI",produces = "text/html;charset=UTF-8")
	public @ResponseBody Object editKeyWordUI(int id) {
		
		return webService.editKeyWordById(id);   
	}
	
	@RequestMapping(value="/editkeyWord",produces = "text/html;charset=UTF-8")
	public @ResponseBody Object editKeyWord(KeyWord keyWord) {
		
		return webService.updateKeyWord(keyWord);
	}
	
	@RequestMapping(value="/testFileUpload",produces = "text/html;charset=UTF-8")
	public @ResponseBody Object testFileUpload(@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println(file.getName()+"++"+file.getOriginalFilename()+"++"+file.getContentType());
		return webService.addExcelDate(file.getInputStream(),file.getOriginalFilename());
	}
	
	@RequestMapping("/toGetInfo")
	public String toGetInfo(){
		return "getInfo";
	}
	
	@RequestMapping(value="/addPhoneInfo",produces = "text/html;charset=UTF-8")
	public String addPhoneInfo(PhoneInfo phoneInfo){
		Integer id = phoneServiceImpl.addPhoneInfo(phoneInfo);
		
		return "redirect:/findPhoneAddress.htm?id="+id;
	}
	
	@RequestMapping("/findPhoneAddress")
	public String findPhoneAddress(Map<String,Object> map,Integer id){
		PhoneInfo  phoneInfo = phoneServiceImpl.findPhoneInfoById(id);
		KeyWord keyWord	 = phoneServiceImpl.findKeyWordByProvinces(phoneInfo.getSc(),phoneInfo.getAction());
		if(keyWord!=null)
			map.put("keyword", keyWord);
		return "keywordInfo";
	}
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping(value="/test11",produces = "text/html;charset=UTF-8")
	public String test11(@RequestBody PhoneInfo phoneInfo){
		Integer id = phoneServiceImpl.addPhoneInfo(phoneInfo);
		
		return "redirect:/findPhoneAddress.htm?id="+id;
	}
	
	@RequestMapping(value="/testhttpclient",produces = "text/html;charset=UTF-8")
	public void httpclient(HttpServletRequest request,HttpServletResponse response){
		try {
			String data = phoneServiceImpl.responseDate(request.getInputStream());
			response.getOutputStream().write(data.getBytes("utf-8"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/httpclientJSON",produces = "text/html;charset=UTF-8")
	public @ResponseBody void httpclientJSON(@RequestBody PhoneInfo phoneInfo,HttpServletResponse response) throws IOException{
		String pf = phoneServiceImpl.addPhoneInfo2(phoneInfo);
		response.getOutputStream().write(pf.getBytes("utf-8"));
	}
	
	/*@RequestMapping(value="/httpclientJSON1",produces = "text/html;charset=UTF-8")
	public void httpclientJSON1(HttpServletRequest request,HttpServletResponse response){
		try {
			String json = phoneServiceImpl.getPhoneJson(request.getInputStream());
			if(!"".equals(json)){
				PhoneInfo phoneInfo = JSON.parseObject(json,PhoneInfo.class);
				if(phoneInfo!=null)
					response.getOutputStream().write(phoneServiceImpl.addPhoneInfo2(phoneInfo).getBytes("utf-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	
	
}

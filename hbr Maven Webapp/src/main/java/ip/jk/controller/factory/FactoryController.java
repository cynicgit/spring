package ip.jk.controller.factory;

import java.util.List;

import ip.jk.controller.BaseController;
import ip.jk.domain.Factory;
import ip.jk.serivce.FactorySerivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/basicinfo")
public class FactoryController extends BaseController{
	@Autowired
	private FactorySerivce factorySerivce;
	
	@RequestMapping("/factory/list.action")
	public String findAllFactory(Model model){
		List<Factory> factoryList = factorySerivce.findAllFactory();
		model.addAttribute("factoryList", factoryList);
		return "basicinfo/factory/jFactoryList";
	}
	
	@RequestMapping("/factory/tocreate")
	public String toCreate(){
		return "basicinfo/factory/jFactoryCreate";
	}

	@RequestMapping("/factory/insert")
	public String insert(Factory factory){
		factorySerivce.insert(factory);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	@RequestMapping("/factory/toupdate")
	public String toupdate(String id,Model model){
		Factory factory = factorySerivce.findFactoryById(id);
		model.addAttribute("factory", factory);
		return "basicinfo/factory/jFactoryUpdate";
	}
	
	@RequestMapping("/factory/update")
	public String update(Factory factory){
		factorySerivce.update(factory);
		return "redirect:/basicinfo/factory/list.action";
	}

	@RequestMapping("/factory/delete")
	public String delete(@RequestParam("id") String[] ids){
		factorySerivce.delete(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	@RequestMapping("/factory/toview")
	public String toview(String id,Model model){
		Factory factory = factorySerivce.findFactoryById(id);
		model.addAttribute("factory", factory);
		return "basicinfo/factory/jFactoryView";
	}
	
	@RequestMapping("/factory/start")
	public String start(@RequestParam("id") String[] ids){
		factorySerivce.startState(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	@RequestMapping("/factory/stop")
	public String stop(@RequestParam("id") String[] ids){
		factorySerivce.stopState(ids);
		return "redirect:/basicinfo/factory/list.action";
	}


}

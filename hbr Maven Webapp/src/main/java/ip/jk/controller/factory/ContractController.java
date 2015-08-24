package ip.jk.controller.factory;

import ip.jk.controller.BaseController;
import ip.jk.domain.Contract;
import ip.jk.serivce.ContractSerivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cargo")
@Controller
public class ContractController extends BaseController {

	@Autowired
	private ContractSerivce contractSerivce;

	@RequestMapping("/contract/list")
	public String list(Model model) {
		List<Contract> clist = contractSerivce.findAllContract();
		model.addAttribute("clist", clist);
		return "/cargo/contract/jContractList";
	}
	
	@RequestMapping("/contract/toview")
	public String view(String id,Model model) {
		Contract contract = contractSerivce.findContractById(id);
		model.addAttribute("contract", contract);
		return "/cargo/contract/jContractView";
	}
	
	@RequestMapping("/contract/tocreate")
	public String tocreate(){
		
		return "/cargo/contract/jContractCreate";
	}
	
	@RequestMapping("/contract/insert")
	public String insert(Contract contract){
		contractSerivce.insert(contract);
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/contract/toupdate")
	public String toupdate(String id,Model model){
		Contract contract = contractSerivce.findContractById(id);
		model.addAttribute("contract", contract);
		return "/cargo/contract/jContractUpdate";
	}
	
	@RequestMapping("/contract/update")
	public String update(Contract contract){
		contractSerivce.updateContract(contract);
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/contract/delete")
	public String delete(@RequestParam("id")String[] ids){
		contractSerivce.delete(ids);
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/contract/submit")
	public String submit(@RequestParam("id")String[] ids){
		contractSerivce.submit(ids);
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/contract/cancel")
	public String cancel(@RequestParam("id")String[] ids){
		contractSerivce.cancel(ids);
		return "redirect:/cargo/contract/list.action";
	}
	
}

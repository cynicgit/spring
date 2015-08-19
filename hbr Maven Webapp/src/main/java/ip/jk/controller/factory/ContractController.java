package ip.jk.controller.factory;

import ip.jk.controller.BaseController;
import ip.jk.domain.Contract;
import ip.jk.serivce.ContractSerivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/contract/tocreate")
	public String tocreate(){
		
		return "/cargo/contract/jContractCreate";
	}
}

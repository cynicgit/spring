package ip.jk.serivce;

import java.util.List;

import ip.jk.domain.Contract;
import ip.jk.mapper.ContractMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractSerivce {

	@Autowired
	private ContractMapper ContractMapper;

	public List<Contract> findAllContract() {
		
		return ContractMapper.findAllContract();
	}
	
}

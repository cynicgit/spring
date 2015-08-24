package ip.jk.serivce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ip.jk.domain.Contract;
import ip.jk.mapper.ContractMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractSerivce {

	@Autowired
	private ContractMapper contractMapper;

	public List<Contract> findAllContract() {
		
		return contractMapper.findAllContract();
	}
	
	public void insert(Contract contract){
		contract.setId(UUID.randomUUID().toString());
		contract.setState(0);			//0草稿1已上报
		contractMapper.insert(contract);
	}

	public Contract findContractById(String id) {
		return contractMapper.get(id);
	}

	public void updateContract(Contract contract) {
		contractMapper.update(contract);
	}

	public void delete(String[] ids) {
		contractMapper.delete(ids);
	}
	
	public void submit(String[] ids){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("state", 1);
		contractMapper.updateState(map);
	}
	
	public void cancel(String[] ids){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("state", 0);
		contractMapper.updateState(map);
	}
	
}

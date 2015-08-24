package ip.jk.mapper;

import ip.jk.domain.Contract;

import java.util.List;
import java.util.Map;

public interface ContractMapper {

	public List<Contract> findAllContract();

	public void insert(Contract contract);

	public Contract get(String id);

	public void update(Contract contract);

	public void delete(String[] ids);

	public void updateState(Map<String, Object> map);
}

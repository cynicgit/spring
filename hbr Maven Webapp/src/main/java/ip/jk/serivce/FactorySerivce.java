package ip.jk.serivce;

import ip.jk.domain.Factory;
import ip.jk.mapper.FactoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactorySerivce {

	@Autowired
	private FactoryMapper factoryMapper;
	public List<Factory> findAllFactory() {
		
		return factoryMapper.findAllFactory();
	}
	
	public void insert(Factory factory) {
		factory.setId(UUID.randomUUID().toString());
		factory.setState("1"); //1启用 0停用
		factoryMapper.insert(factory);
	}

	public Factory findFactoryById(String id) {
		
		return factoryMapper.findFactoryById(id);
	}

	public void update(Factory factory) {
		factoryMapper.update(factory);
	}

	public void delete(String[] ids) {
		factoryMapper.delete(ids);
		
	}

	public void startState(String[] ids) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ids", ids);
		map.put("state", "1"); //启用
		factoryMapper.setState(map);
	}

	public void stopState(String[] ids) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ids", ids);
		map.put("state", "0");
		factoryMapper.setState(map);
	}

}

package ip.jk.mapper;

import ip.jk.domain.Factory;

import java.util.List;
import java.util.Map;

public interface FactoryMapper {

	public List<Factory> findAllFactory();
	
	public void addFactory(Factory factory);

	public void insert(Factory factory);

	public Factory findFactoryById(String id);
	
	public void update(Factory factory);

	public void delete(String[] ids);

	public void setState(Map<String, Object> map);
}

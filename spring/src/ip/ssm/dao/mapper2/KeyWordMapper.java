package ip.ssm.dao.mapper2;

import ip.ssm.po.KeyWord;

import java.util.List;
import java.util.Map;


public interface KeyWordMapper {
	
	public int addKeyWord(KeyWord keyWord);

	public List<KeyWord> findAllKeyWord();

	public void deleteKeyWordById(int id);

	public KeyWord findKeyWordById(int id);

	public void updataKeyWord(KeyWord keyWord);

	public void addListKeyWord(Map<String,List<KeyWord>> map);

	public KeyWord findKeyWordByProvinces(String provinces);
}

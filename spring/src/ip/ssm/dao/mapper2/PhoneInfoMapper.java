package ip.ssm.dao.mapper2;

import ip.ssm.po.PhoneInfo;



public interface PhoneInfoMapper {

	Integer addPhoneInfo(PhoneInfo phoneInfo);

	PhoneInfo findPhoneInfoById(Integer id);

}

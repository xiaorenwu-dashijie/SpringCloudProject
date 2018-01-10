package com.sinoway.cisp.service.impl;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.sinoway.cisp.dao.MDdCityDicMapper;
import com.sinoway.cisp.service.MddCityDicService;

@Service
@Transactional
public class MddCityDicServiceImpl implements MddCityDicService {

//	@Autowired
//	private MDdCityDicMapper mddCityDicMapper;

	@Override
	public boolean checkCityCode(String cCode) {
		/*Pattern pattern = Pattern.compile("^\\d{4}$");
		Matcher isNum = pattern.matcher(cCode);
		if (!isNum.matches()) {
			return false;
		}
		String findcCode = mddCityDicMapper.findcCode(cCode);
		if (StringUtils.isBlank(findcCode)) {
			return false;
		} else {
			return true;
		}*/
		return true;
	}

}

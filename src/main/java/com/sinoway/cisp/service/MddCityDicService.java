package com.sinoway.cisp.service;

public interface MddCityDicService {

	/**
	 * 检验是否符合城市字典中的城市代码，如果为空，默认未知
	 * 
	 * @param requestLocation
	 * @return
	 */
	boolean checkCityCode(String cCode);

}

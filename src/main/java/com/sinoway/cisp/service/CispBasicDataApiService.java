package com.sinoway.cisp.service;

import org.springframework.stereotype.Service;
import com.sinoway.cisp.entitys.User;
@Service
public interface CispBasicDataApiService {
	
	/**
	 * 上传黑名单信息
	 * 
	 * @param user 用户
	 * @param datatype 数据类型
	 * @param version 接口版本号
	 * @param name 姓名
	 * @param cardid 身份证号
	 * @param data 黑名单信息
	 * @return
	 * @throws Exception
	 */
	public String pushCreditData(User user,String datatype,String version,String sinoCardid,String data)throws Exception;
	
	/**
	 * 获取黑名单信息
	 * 
	 * @param user 用户
	 * @param datatype 数据类型
	 * @param version 接口版本号
	 * @param name 姓名
	 * @param cardid 身份证号
	 * @param qreason 查询目的
	 * @return
	 * @throws Exception
	 */
	public String getCreditData(User user,String datatype,String version,String sinoCardid,String qreason)throws Exception;
}

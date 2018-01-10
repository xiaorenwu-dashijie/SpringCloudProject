package com.sinoway.cisp.service;

import java.text.ParseException;
import java.util.List;


import com.sinoway.cisp.entitys.ErrorFieldWarning;
import com.sinoway.cisp.entitys.SubmittingBehavior;

/**
 * 贷中监测
 * @author swd
 *
 */
public interface IRepaymentMonitorService {
	
	/**
	 * 贷中还款监测
	 * 	     监测user对应的机构报送的数据是否质量不佳
	 * @param user	机构用户
	 * @param data	报送的数据
	 * @return 是否发送邮件
	 * @throws ParseException 
	 * @throws JSONException 
	 */
//	boolean repaymentMonitor(User user, String data) throws ParseException, JSONException;

	/**
	 * 所有机构的贷中监测-错误字段预警
	 * @return 不符合时间/金额规则的机构列表
	 * @throws ParseException 
	 */
	List<ErrorFieldWarning> allInstiRepaymentMonitor() throws ParseException;
	
	/**
	 * 所有机构的贷中监测-报送预警服务
	 * @return 不符合条件的相关属性的机构列表
	 */
	List<SubmittingBehavior> submittingBehaviorMontior();

	List<SubmittingBehavior> contractBehaviorMontior();

	List<SubmittingBehavior> dataQualityMontior();

}

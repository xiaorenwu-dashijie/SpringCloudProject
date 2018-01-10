package com.sinoway.cisp.entitys;

/**
 * 贷中监测-错误字段预警服务--实体类
 * @author swd 2017年6月9日16:03:14
 *
 */
public class ErrorFieldWarning {

	/**
	 * 机构代码
	 */
	private String instiCode;
	
	/**
	 * 机构名称
	 */
	private String instiName;
	
	/**
	 * 不符合时间规则的数量
	 */
	private String unqualifiedDataCountOfPaidTime;
	
	/**
	 * 不符合金额规则的数量
	 */
	private String unqualifiedDataCountOfPaidMoney;

	public String getInstiCode() {
		return instiCode;
	}

	public void setInstiCode(String instiCode) {
		this.instiCode = instiCode;
	}

	public String getInstiName() {
		return instiName;
	}

	public void setInstiName(String instiName) {
		this.instiName = instiName;
	}

	public String getUnqualifiedDataCountOfPaidTime() {
		return unqualifiedDataCountOfPaidTime;
	}

	public void setUnqualifiedDataCountOfPaidTime(String unqualifiedDataCountOfPaidTime) {
		this.unqualifiedDataCountOfPaidTime = unqualifiedDataCountOfPaidTime;
	}

	public String getUnqualifiedDataCountOfPaidMoney() {
		return unqualifiedDataCountOfPaidMoney;
	}

	public void setUnqualifiedDataCountOfPaidMoney(String unqualifiedDataCountOfPaidMoney) {
		this.unqualifiedDataCountOfPaidMoney = unqualifiedDataCountOfPaidMoney;
	}


	
}

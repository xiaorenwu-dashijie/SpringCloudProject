package com.sinoway.cisp.entitys;

/**
 * 贷中检测-报送行为预警服务--实体类
 * @author swd 2017年6月9日12:36:10
 *
 */
public class SubmittingBehavior {

	/**
	 * 机构代码
	 */
	private String instiCode;
	
	/**
	 * 机构名称(全称)
	 */
	private String instiName;
	
	/**
	 * 进件数量
	 */
	private int loanCount;
	
	/**
	 * 签约数量
	 */
	private int contCount;
	
	/**
	 * 贷中数量
	 */
	private int upCount;
	
	/**
	 * 数据质量预警使用：同意贷款总数量
	 */
	private int acceptCount;
	
	/**
	 * 数据质量预警使用：同意贷款总数量
	 */
	private int acceptBadCount;

	
	
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

	public int getContCount() {
		return contCount;
	}

	public void setContCount(int contCount) {
		this.contCount = contCount;
	}

	public int getUpCount() {
		return upCount;
	}

	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}

	public int getLoanCount() {
		return loanCount;
	}

	public void setLoanCount(int loanCount) {
		this.loanCount = loanCount;
	}

	public int getAcceptCount() {
		return acceptCount;
	}

	public void setAcceptCount(int acceptCount) {
		this.acceptCount = acceptCount;
	}

	public int getAcceptBadCount() {
		return acceptBadCount;
	}

	public void setAcceptBadCount(int acceptBadCount) {
		this.acceptBadCount = acceptBadCount;
	}
	
	
	
}

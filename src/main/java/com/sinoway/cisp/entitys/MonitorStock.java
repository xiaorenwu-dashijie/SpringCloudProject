package com.sinoway.cisp.entitys;

public class MonitorStock {

	private String CODE;

	private String ISCREDITRECORD;
	
	private String name;

	private String cardid;

	private String cellPhoneNum;

	private Integer numW;

	private Integer repayNumW;

	private Integer overdueW;

	private Integer numM;

	private Integer repayNumM;

	private Integer overdueMM;


	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCellPhoneNum() {
		return cellPhoneNum;
	}

	public void setCellPhoneNum(String cellPhoneNum) {
		this.cellPhoneNum = cellPhoneNum;
	}

	public Integer getNumW() {
		return numW;
	}

	public void setNumW(Integer numW) {
		this.numW = numW;
	}

	public Integer getRepayNumW() {
		return repayNumW;
	}

	public void setRepayNumW(Integer repayNumW) {
		this.repayNumW = repayNumW;
	}

	public Integer getOverdueW() {
		return overdueW;
	}

	public void setOverdueW(Integer overdueW) {
		this.overdueW = overdueW;
	}

	public Integer getNumM() {
		return numM;
	}

	public void setNumM(Integer numM) {
		this.numM = numM;
	}

	public Integer getRepayNumM() {
		return repayNumM;
	}

	public void setRepayNumM(Integer repayNumM) {
		this.repayNumM = repayNumM;
	}

	public Integer getOverdueMM() {
		return overdueMM;
	}

	public void setOverdueMM(Integer overdueMM) {
		this.overdueMM = overdueMM;
	}

	public String getISCREDITRECORD() {
		return ISCREDITRECORD;
	}

	public void setISCREDITRECORD(String iSCREDITRECORD) {
		ISCREDITRECORD = iSCREDITRECORD;
	}

}

package com.sinoway.cisp.entitys;

import java.math.BigDecimal;

public class RepaymentDetailList {
	private String sinoid;
	
	private String contractId;
	
	private BigDecimal contractSum;
	
	private String startTime;
	
	private String stopTime;
	
	private String contractType;
	
	private String guara_Type;
	
	private String payPeriod;
	
	private String payLocation;
	
	private String contractStatus;
	
	private String settleTime;
	
	private String sinotime;
	
	private String instiName;

	public String getSinoid() {
		return sinoid;
	}

	public void setSinoid(String sinoid) {
		this.sinoid = sinoid;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public BigDecimal getContractSum() {
		return contractSum;
	}

	public void setContractSum(BigDecimal bigDecimal) {
		this.contractSum = bigDecimal;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getGuara_Type() {
		return guara_Type;
	}

	public void setGuara_Type(String guara_Type) {
		this.guara_Type = guara_Type;
	}

	public String getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}

	public String getPayLocation() {
		return payLocation;
	}

	public void setPayLocation(String payLocation) {
		this.payLocation = payLocation;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getSettleTime() {
		return settleTime;
	}

	public void setSettleTime(String settleTime) {
		this.settleTime = settleTime;
	}

	public String getSinotime() {
		return sinotime;
	}

	public void setSinotime(String sinotime) {
		this.sinotime = sinotime;
	}

	public String getInstiName() {
		return instiName;
	}

	public void setInstiName(String instiName) {
		this.instiName = instiName;
	}
}

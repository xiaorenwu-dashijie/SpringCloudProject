package com.sinoway.cisp.entitys;

public class OverRepaymentDetail {
	private String sinoid;
	
	private String colSn;
	
	private String paymentLevel;
	
	private String overdueStartTime;
	
	private String overdueReason;
	
	private String overdueStatusMark;
	
	private String sinotime;

	public String getSinoid() {
		return sinoid;
	}

	public void setSinoid(String sinoid) {
		this.sinoid = sinoid;
	}

	public String getColSn() {
		return colSn;
	}

	public void setColSn(String colSn) {
		this.colSn = colSn;
	}

	public String getPaymentLevel() {
		return paymentLevel;
	}

	public void setPaymentLevel(String paymentLevel) {
		this.paymentLevel = paymentLevel;
	}

	public String getOverdueStartTime() {
		return overdueStartTime;
	}

	public void setOverdueStartTime(String overdueStartTime) {
		this.overdueStartTime = overdueStartTime;
	}

	public String getOverdueReason() {
		return overdueReason;
	}

	public void setOverdueReason(String overdueReason) {
		this.overdueReason = overdueReason;
	}

	public String getOverdueStatusMark() {
		return overdueStatusMark;
	}

	public void setOverdueStatusMark(String overdueStatusMark) {
		this.overdueStatusMark = overdueStatusMark;
	}

	public String getSinotime() {
		return sinotime;
	}

	public void setSinotime(String sinotime) {
		this.sinotime = sinotime;
	}

	@Override
	public String toString() {
		return "OverRepaymentDetail [sinoid=" + sinoid + ", colSn=" + colSn + ", paymentLevel=" + paymentLevel
				+ ", overdueStartTime=" + overdueStartTime + ", overdueReason=" + overdueReason + ", overdueStatusMark="
				+ overdueStatusMark + ", sinotime=" + sinotime + "]";
	}
	
	
}

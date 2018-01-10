package com.sinoway.cisp.entitys;

import java.util.Date;

public class OverdueStatus extends OverdueStatusKey {
	private String sinoid;
	
	private String colSn;
	
    private Integer paymentLevel;

    private Date overdueStartTime;

    private String overdueReason;

    private String overdueStatusMark;

    private Date sinotime;

    public Integer getPaymentLevel() {
        return paymentLevel;
    }

    public void setPaymentLevel(Integer paymentLevel) {
        this.paymentLevel = paymentLevel;
    }

    public Date getOverdueStartTime() {
        return overdueStartTime;
    }

    public void setOverdueStartTime(Date overdueStartTime) {
        this.overdueStartTime = overdueStartTime;
    }

    public String getOverdueReason() {
        return overdueReason;
    }

    public void setOverdueReason(String overdueReason) {
        this.overdueReason = overdueReason == null ? null : overdueReason.trim();
    }

    public String getOverdueStatusMark() {
        return overdueStatusMark;
    }

    public void setOverdueStatusMark(String overdueStatusMark) {
        this.overdueStatusMark = overdueStatusMark == null ? null : overdueStatusMark.trim();
    }

    public Date getSinotime() {
        return sinotime;
    }

    public void setSinotime(Date sinotime) {
        this.sinotime = sinotime;
    }

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
}
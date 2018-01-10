package com.sinoway.cisp.entitys;

import java.math.BigDecimal;
import java.util.Date;

public class LoanApplication {
    private String sinoid;

    private String sinoCardid;

    private String cellPhoneNum;

    private Date requestTime;

    private BigDecimal requestMoney;

    private String requestLocation;

    private String requestType;

    private Date sinotime;

    private String edu;

    private String requestResult;

    private String refuseReason;

    private Date refuseTime;

    public String getSinoid() {
        return sinoid;
    }

    public void setSinoid(String sinoid) {
        this.sinoid = sinoid == null ? null : sinoid.trim();
    }

    public String getSinoCardid() {
        return sinoCardid;
    }

    public void setSinoCardid(String sinoCardid) {
        this.sinoCardid = sinoCardid == null ? null : sinoCardid.trim();
    }

    public String getCellPhoneNum() {
        return cellPhoneNum;
    }

    public void setCellPhoneNum(String cellPhoneNum) {
        this.cellPhoneNum = cellPhoneNum == null ? null : cellPhoneNum.trim();
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public BigDecimal getRequestMoney() {
        return requestMoney;
    }

    public void setRequestMoney(BigDecimal requestMoney) {
        this.requestMoney = requestMoney;
    }

    public String getRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(String requestLocation) {
        this.requestLocation = requestLocation == null ? null : requestLocation.trim();
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    public Date getSinotime() {
        return sinotime;
    }

    public void setSinotime(Date sinotime) {
        this.sinotime = sinotime;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu == null ? null : edu.trim();
    }

    public String getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(String requestResult) {
        this.requestResult = requestResult == null ? null : requestResult.trim();
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }

    public Date getRefuseTime() {
        return refuseTime;
    }

    public void setRefuseTime(Date refuseTime) {
        this.refuseTime = refuseTime;
    }
}
package com.sinoway.cisp.entitys;

import java.util.Date;

public class IdMapper {
    private String sinoid;

    private String userAccount;

    private String instiid;

    private String contractId;

    private String instiCode;

    private String dataFrom;

    private String sinoCardid;

    private String cellPhoneNum;

    private String crStatus;

    private Date sinotime;

    public String getSinoid() {
        return sinoid;
    }

    public void setSinoid(String sinoid) {
        this.sinoid = sinoid == null ? null : sinoid.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getInstiid() {
        return instiid;
    }

    public void setInstiid(String instiid) {
        this.instiid = instiid == null ? null : instiid.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getInstiCode() {
        return instiCode;
    }

    public void setInstiCode(String instiCode) {
        this.instiCode = instiCode == null ? null : instiCode.trim();
    }

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom == null ? null : dataFrom.trim();
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

    public String getCrStatus() {
        return crStatus;
    }

    public void setCrStatus(String crStatus) {
        this.crStatus = crStatus == null ? null : crStatus.trim();
    }

    public Date getSinotime() {
        return sinotime;
    }

    public void setSinotime(Date sinotime) {
        this.sinotime = sinotime;
    }
}
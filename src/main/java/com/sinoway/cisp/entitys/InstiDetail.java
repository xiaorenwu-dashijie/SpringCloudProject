package com.sinoway.cisp.entitys;

import java.util.Date;

public class InstiDetail {
    private String instiCode;

    private String instiType;

    private String instiShortname;

    private String instiName;

    private String creditPerson;

    private String lawPerson;

    private String creditCode;

    private String registeredAddress;

    private String generalManager;

    private Integer zipCode;

    private String registeredCapital;

    private String webUrl;

    private String instiAddress;

    private String faxNumber;

    private String phone;

    private String accessIp;

    private String freezeStatus;

    private Date creatTime;

    private Date sinotime;

    private String contractCode;
    
    private String serviceIdString;

    public String getInstiCode() {
        return instiCode;
    }

    public void setInstiCode(String instiCode) {
        this.instiCode = instiCode == null ? null : instiCode.trim();
    }

    public String getInstiType() {
        return instiType;
    }

    public void setInstiType(String instiType) {
        this.instiType = instiType == null ? null : instiType.trim();
    }

    public String getInstiShortname() {
        return instiShortname;
    }

    public void setInstiShortname(String instiShortname) {
        this.instiShortname = instiShortname == null ? null : instiShortname.trim();
    }

    public String getInstiName() {
        return instiName;
    }

    public void setInstiName(String instiName) {
        this.instiName = instiName == null ? null : instiName.trim();
    }

    public String getCreditPerson() {
        return creditPerson;
    }

    public void setCreditPerson(String creditPerson) {
        this.creditPerson = creditPerson == null ? null : creditPerson.trim();
    }

    public String getLawPerson() {
        return lawPerson;
    }

    public void setLawPerson(String lawPerson) {
        this.lawPerson = lawPerson == null ? null : lawPerson.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress == null ? null : registeredAddress.trim();
    }

    public String getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager == null ? null : generalManager.trim();
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl == null ? null : webUrl.trim();
    }

    public String getInstiAddress() {
        return instiAddress;
    }

    public void setInstiAddress(String instiAddress) {
        this.instiAddress = instiAddress == null ? null : instiAddress.trim();
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber == null ? null : faxNumber.trim();
    }

    public String getPhone() {
        return phone;
    }

    public String getServiceIdString() {
		return serviceIdString;
	}

	public void setServiceIdString(String serviceIdString) {
		this.serviceIdString = serviceIdString;
	}

	public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAccessIp() {
        return accessIp;
    }

    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp == null ? null : accessIp.trim();
    }

    public String getFreezeStatus() {
        return freezeStatus;
    }

    public void setFreezeStatus(String freezeStatus) {
        this.freezeStatus = freezeStatus == null ? null : freezeStatus.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getSinotime() {
        return sinotime;
    }

    public void setSinotime(Date sinotime) {
        this.sinotime = sinotime;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }
}
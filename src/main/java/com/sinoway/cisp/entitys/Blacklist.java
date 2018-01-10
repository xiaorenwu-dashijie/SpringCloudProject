package com.sinoway.cisp.entitys;

import java.math.BigDecimal;
import java.util.Date;

public class Blacklist {
    private String sinoid;

    private Date overdueStartTime;

    private String reason;

    private Date publicTime;

    private String sinoCardid;

    private String phone;

    private String email;

    private String liveAddress;

    private BigDecimal overdueMoney;

    private String loanLocation;

    private String loanType;

    private Date loanStartTime;

    private String loanGuarantee;

    private String overdueDuration;

    private String overdueStatus;

    private String userAccount;

    private String personalAddress;

    private String overdueTimes;

    private String ishide;

    private Date hideTime;
    
    private String beizhu;

    private String instiName;
    public String getSinoid() {
        return sinoid;
    }

    public void setSinoid(String sinoid) {
        this.sinoid = sinoid == null ? null : sinoid.trim();
    }

    public Date getOverdueStartTime() {
        return overdueStartTime;
    }

    public void setOverdueStartTime(Date overdueStartTime) {
        this.overdueStartTime = overdueStartTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public String getSinoCardid() {
        return sinoCardid;
    }

    public void setSinoCardid(String sinoCardid) {
        this.sinoCardid = sinoCardid == null ? null : sinoCardid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress == null ? null : liveAddress.trim();
    }

    public BigDecimal getOverdueMoney() {
        return overdueMoney;
    }

    public void setOverdueMoney(BigDecimal overdueMoney) {
        this.overdueMoney = overdueMoney;
    }

    public String getLoanLocation() {
        return loanLocation;
    }

    public void setLoanLocation(String loanLocation) {
        this.loanLocation = loanLocation == null ? null : loanLocation.trim();
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    public Date getLoanStartTime() {
        return loanStartTime;
    }

    public void setLoanStartTime(Date loanStartTime) {
        this.loanStartTime = loanStartTime;
    }

    public String getLoanGuarantee() {
        return loanGuarantee;
    }

    public void setLoanGuarantee(String loanGuarantee) {
        this.loanGuarantee = loanGuarantee == null ? null : loanGuarantee.trim();
    }

    public String getOverdueDuration() {
        return overdueDuration;
    }

    public void setOverdueDuration(String overdueDuration) {
        this.overdueDuration = overdueDuration == null ? null : overdueDuration.trim();
    }

    public String getOverdueStatus() {
        return overdueStatus;
    }

    public void setOverdueStatus(String overdueStatus) {
        this.overdueStatus = overdueStatus == null ? null : overdueStatus.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getPersonalAddress() {
        return personalAddress;
    }

    public void setPersonalAddress(String personalAddress) {
        this.personalAddress = personalAddress == null ? null : personalAddress.trim();
    }

    public String getOverdueTimes() {
        return overdueTimes;
    }

    public void setOverdueTimes(String overdueTimes) {
        this.overdueTimes = overdueTimes == null ? null : overdueTimes.trim();
    }

    public String getIshide() {
        return ishide;
    }

    public void setIshide(String ishide) {
        this.ishide = ishide == null ? null : ishide.trim();
    }

    public Date getHideTime() {
        return hideTime;
    }

    public void setHideTime(Date hideTime) {
        this.hideTime = hideTime;
    }

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getInstiName() {
		return instiName;
	}

	public void setInstiName(String instiName) {
		this.instiName = instiName;
	}
}
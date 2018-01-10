package com.sinoway.cisp.entitys;

import java.util.Date;

public class User {
    private Integer userId;

    private String instiCode;

    private String userAccount;

    private String userPsw;

    private String userName;

    private String userPhone;

    private String userMail;

    private String qqNum;

    private String wechatNum;

    private String instiShortname;

    private Date sinotime;

    private String funCodeFormat;

    private Date lastTimeLogin;

    private String userType;

    private String freezeStatus;

    private String userKey;

    private String userPrivate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInstiCode() {
        return instiCode;
    }

    public void setInstiCode(String instiCode) {
        this.instiCode = instiCode == null ? null : instiCode.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw == null ? null : userPsw.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum == null ? null : qqNum.trim();
    }

    public String getWechatNum() {
        return wechatNum;
    }

    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum == null ? null : wechatNum.trim();
    }

    public String getInstiShortname() {
        return instiShortname;
    }

    public void setInstiShortname(String instiShortname) {
        this.instiShortname = instiShortname == null ? null : instiShortname.trim();
    }

    public Date getSinotime() {
        return sinotime;
    }

    public void setSinotime(Date sinotime) {
        this.sinotime = sinotime;
    }

    public String getFunCodeFormat() {
        return funCodeFormat;
    }

    public void setFunCodeFormat(String funCodeFormat) {
        this.funCodeFormat = funCodeFormat == null ? null : funCodeFormat.trim();
    }

    public Date getLastTimeLogin() {
        return lastTimeLogin;
    }

    public void setLastTimeLogin(Date lastTimeLogin) {
        this.lastTimeLogin = lastTimeLogin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getFreezeStatus() {
        return freezeStatus;
    }

    public void setFreezeStatus(String freezeStatus) {
        this.freezeStatus = freezeStatus == null ? null : freezeStatus.trim();
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey == null ? null : userKey.trim();
    }

    public String getUserPrivate() {
        return userPrivate;
    }

    public void setUserPrivate(String userPrivate) {
        this.userPrivate = userPrivate == null ? null : userPrivate.trim();
    }
}
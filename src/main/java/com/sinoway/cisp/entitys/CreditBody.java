package com.sinoway.cisp.entitys;

import java.util.Date;

public class CreditBody {
    private String sinoid;

    private String name;

    private String cardid;

    private String cellPhoneNum;

    private String instiName;

    private String monitorTag;

    private Date sinotime;

    public String getSinoid() {
        return sinoid;
    }

    public void setSinoid(String sinoid) {
        this.sinoid = sinoid == null ? null : sinoid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getCellPhoneNum() {
        return cellPhoneNum;
    }

    public void setCellPhoneNum(String cellPhoneNum) {
        this.cellPhoneNum = cellPhoneNum == null ? null : cellPhoneNum.trim();
    }

    public String getInstiName() {
        return instiName;
    }

    public void setInstiName(String instiName) {
        this.instiName = instiName == null ? null : instiName.trim();
    }

    public String getMonitorTag() {
        return monitorTag;
    }

    public void setMonitorTag(String monitorTag) {
        this.monitorTag = monitorTag == null ? null : monitorTag.trim();
    }

    public Date getSinotime() {
        return sinotime;
    }

    public void setSinotime(Date sinotime) {
        this.sinotime = sinotime;
    }
}
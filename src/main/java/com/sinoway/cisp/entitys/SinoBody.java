package com.sinoway.cisp.entitys;

import java.util.Date;

public class SinoBody {
    private String sinoCardid;

    private String name;

    private String cardid;

    private Date sinotime;

    private String common;

    public String getSinoCardid() {
        return sinoCardid;
    }

    public void setSinoCardid(String sinoCardid) {
        this.sinoCardid = sinoCardid == null ? null : sinoCardid.trim();
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

    public Date getSinotime() {
        return sinotime;
    }

    public void setSinotime(Date sinotime) {
        this.sinotime = sinotime;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common == null ? null : common.trim();
    }
}
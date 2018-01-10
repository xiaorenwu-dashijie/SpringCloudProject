package com.sinoway.cisp.entitys;

import java.util.Date;

public class ContractCancelDetail {
    private String sinoid;

    private Date cancelTime;

    private Date sinotime;

    public String getSinoid() {
        return sinoid;
    }

    public void setSinoid(String sinoid) {
        this.sinoid = sinoid == null ? null : sinoid.trim();
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Date getSinotime() {
        return sinotime;
    }

    public void setSinotime(Date sinotime) {
        this.sinotime = sinotime;
    }
}
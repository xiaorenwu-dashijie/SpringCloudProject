package com.sinoway.cisp.entitys;

public class MDdCityDic {
    private String cCode;

    private String sCode;

    private String sName;

    private String cName;

    private String xLevel;

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode == null ? null : cCode.trim();
    }

    public String getsCode() {
        return sCode;
    }

    public void setsCode(String sCode) {
        this.sCode = sCode == null ? null : sCode.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getxLevel() {
        return xLevel;
    }

    public void setxLevel(String xLevel) {
        this.xLevel = xLevel == null ? null : xLevel.trim();
    }
}
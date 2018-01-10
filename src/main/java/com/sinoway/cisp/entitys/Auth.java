package com.sinoway.cisp.entitys;

import java.util.Date;

public class Auth {
    private String code;

    private String name;

    private Date createTime;

    private Date updateTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "Auth [code=" + code + ", name=" + name + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
}
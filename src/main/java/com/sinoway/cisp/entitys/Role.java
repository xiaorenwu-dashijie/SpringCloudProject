package com.sinoway.cisp.entitys;

import java.util.Date;

public class Role {
    private String roleCode;

    private String name;

    private Date createTime;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
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

	@Override
	public String toString() {
		return "Role [roleCode=" + roleCode + ", name=" + name + ", createTime=" + createTime + "]";
	}
    
    
}
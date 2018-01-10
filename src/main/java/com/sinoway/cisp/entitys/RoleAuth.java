package com.sinoway.cisp.entitys;

public class RoleAuth {
    private Long roleAuthId;

    private String roleCode;

    private String authCode;

    public Long getRoleAuthId() {
        return roleAuthId;
    }

    public void setRoleAuthId(Long roleAuthId) {
        this.roleAuthId = roleAuthId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode == null ? null : authCode.trim();
    }

	@Override
	public String toString() {
		return "RoleAuth [roleAuthId=" + roleAuthId + ", roleCode=" + roleCode + ", authCode=" + authCode + "]";
	}
    
}
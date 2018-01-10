package com.sinoway.cisp.entitys;

public class Authentication {
	private String identity;//身份认证状态
	private String photo;//认证照片
	private String education;//学历认证
	private String shixin;//失信认证
	private String panjue;//判决
	private String zhixing;//
	
	
	
	public Authentication() {
		super();
	}
	
	public Authentication(String identity, String photo, String education, String shixin, String panjue, String zhixing) {
		super();
		this.identity = identity;
		this.photo = photo;
		this.education = education;
		this.shixin = shixin;
		this.panjue = panjue;
		this.zhixing = zhixing;
	}

	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getShixin() {
		return shixin;
	}
	public void setShixin(String shixin) {
		this.shixin = shixin;
	}
	public String getPanjue() {
		return panjue;
	}
	public void setPanjue(String panjue) {
		this.panjue = panjue;
	}
	public String getZhixing() {
		return zhixing;
	}
	public void setZhixing(String zhixing) {
		this.zhixing = zhixing;
	}
	
}

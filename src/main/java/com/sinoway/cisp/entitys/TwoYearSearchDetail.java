package com.sinoway.cisp.entitys;



public class TwoYearSearchDetail {
	
	
	private String query_time;
	
	private String member_type;
	
	private String query_type;
	
	private String comment;
	
	
	public TwoYearSearchDetail(String query_time, String member_type, String query_type, String comment) {
		super();
		this.query_time = query_time;
		this.member_type = member_type;
		this.query_type = query_type;
		this.comment = comment;
	}


	public String getQuery_time() {
		return query_time;
	}


	public void setQuery_time(String query_time) {
		this.query_time = query_time;
	}


	public String getMember_type() {
		return member_type;
	}


	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}


	public String getQuery_type() {
		return query_type;
	}


	public void setQuery_type(String query_type) {
		this.query_type = query_type;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

}

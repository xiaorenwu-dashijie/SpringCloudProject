package com.sinoway.cisp.entitys;

public class QueryVo {
	
	private String startTime;
	private String endTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		
		this.startTime = startTime + " 00:00:00";
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime + " 23:59:59";
	}

}

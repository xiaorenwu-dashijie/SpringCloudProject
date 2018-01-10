package com.sinoway.cisp.entitys;

import java.util.List;

public class TransactionsDetail {

	private double loan_money;

	private String loan_start_time;

	private String loan_end_time;

	private String loan_type;

	private String loan_guarantee;

	private String pay_period;

	private String loan_location;

	private String loan_status;

	private String comment;

	private String paid_history;//还款记录：很多的N

	private List<OverdueDetail> overdue_detail;//关于逾期的原因
	
	 
	
	
	public TransactionsDetail() {
		super();
	}




	public TransactionsDetail(double loan_money, String loan_start_time, String loan_end_time, String loan_type,
			String loan_guarantee, String pay_period, String loan_location, String loan_status, String comment,
			String paid_history) {
		super();
		this.loan_money = loan_money;
		this.loan_start_time = loan_start_time;
		this.loan_end_time = loan_end_time;
		this.loan_type = loan_type;
		this.loan_guarantee = loan_guarantee;
		this.pay_period = pay_period;
		this.loan_location = loan_location;
		this.loan_status = loan_status;
		this.comment = comment;
		this.paid_history = paid_history;
	}




	public double getLoan_money() {
		return loan_money;
	}




	public void setLoan_money(double loan_money) {
		this.loan_money = loan_money;
	}




	public String getLoan_start_time() {
		return loan_start_time;
	}




	public void setLoan_start_time(String loan_start_time) {
		this.loan_start_time = loan_start_time;
	}




	public String getLoan_end_time() {
		return loan_end_time;
	}




	public void setLoan_end_time(String loan_end_time) {
		this.loan_end_time = loan_end_time;
	}




	public String getLoan_type() {
		return loan_type;
	}




	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}




	public String getLoan_guarantee() {
		return loan_guarantee;
	}




	public void setLoan_guarantee(String loan_guarantee) {
		this.loan_guarantee = loan_guarantee;
	}




	public String getPay_period() {
		return pay_period;
	}




	public void setPay_period(String pay_period) {
		this.pay_period = pay_period;
	}




	public String getLoan_location() {
		return loan_location;
	}




	public void setLoan_location(String loan_location) {
		this.loan_location = loan_location;
	}




	public String getLoan_status() {
		return loan_status;
	}




	public void setLoan_status(String loan_status) {
		this.loan_status = loan_status;
	}




	public String getComment() {
		return comment;
	}




	public void setComment(String comment) {
		this.comment = comment;
	}




	public String getPaid_history() {
		return paid_history;
	}




	public void setPaid_history(String paid_history) {
		this.paid_history = paid_history;
	}




	public List<OverdueDetail> getOverdueStatusList() {
		return overdue_detail;
	}




	public void setOverdueStatusList(List<OverdueDetail> overdueStatusList) {
		this.overdue_detail = overdueStatusList;
	}

	
	
	
}

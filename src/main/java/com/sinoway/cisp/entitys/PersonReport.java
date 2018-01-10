package com.sinoway.cisp.entitys;

import java.util.List;


public class PersonReport {

	private String searchDate;
	
	private String personReportId;
	
	private String name;
	
	private String cardid;
	
	private String cellPhoneNum;
	
    private Integer creditLoanNum;

    private Integer normalCreditLoan;

    private Integer overCreditLoan;

    private Integer mortgageLoanNum;

    private Integer normalMortgageLoan;

    private Integer overMortgageLoan;

    private Integer guaranteeLoanNum;

    private Integer normarlGuaranteeLoan;

    private Integer overGuaranteeLoan;

    private Integer otherLoanNum;

    private Integer normalOtherLoan;

    private Integer overOtherLoan;

    private List<BlackDetailList> blackDetailList;

    private List<RepaymentDetailList> repaymentDetailList;

    private List<OverRepaymentDetail> overRepaymentDetailList;

    private List<TwoYearsSearchDetail> twoyearsSearchNum;
    
    private List<ContractAcceptDetail> overDetailList;

    private String publicCreditInformation;

    private String dissentApplyDetail;
    
    private String sinoCardid;

    public String getSinoCardid() {
		return sinoCardid;
	}

	public void setSinoCardid(String sinoCardid) {
		this.sinoCardid = sinoCardid;
	}

	public Integer getCreditLoanNum() {
        return creditLoanNum;
    }

    public void setCreditLoanNum(Integer creditLoanNum) {
        this.creditLoanNum = creditLoanNum;
    }

    public Integer getNormalCreditLoan() {
        return normalCreditLoan;
    }

    public void setNormalCreditLoan(Integer normalCreditLoan) {
        this.normalCreditLoan = normalCreditLoan;
    }

    public Integer getOverCreditLoan() {
        return overCreditLoan;
    }

    public void setOverCreditLoan(Integer overCreditLoan) {
        this.overCreditLoan = overCreditLoan;
    }

    public Integer getMortgageLoanNum() {
        return mortgageLoanNum;
    }

    public void setMortgageLoanNum(Integer mortgageLoanNum) {
        this.mortgageLoanNum = mortgageLoanNum;
    }

    public Integer getNormalMortgageLoan() {
        return normalMortgageLoan;
    }

    public void setNormalMortgageLoan(Integer normalMortgageLoan) {
        this.normalMortgageLoan = normalMortgageLoan;
    }

    public Integer getOverMortgageLoan() {
        return overMortgageLoan;
    }

    public void setOverMortgageLoan(Integer overMortgageLoan) {
        this.overMortgageLoan = overMortgageLoan;
    }

    public Integer getGuaranteeLoanNum() {
        return guaranteeLoanNum;
    }

    public void setGuaranteeLoanNum(Integer guaranteeLoanNum) {
        this.guaranteeLoanNum = guaranteeLoanNum;
    }

    public Integer getNormarlGuaranteeLoan() {
        return normarlGuaranteeLoan;
    }

    public void setNormarlGuaranteeLoan(Integer normarlGuaranteeLoan) {
        this.normarlGuaranteeLoan = normarlGuaranteeLoan;
    }

    public Integer getOverGuaranteeLoan() {
        return overGuaranteeLoan;
    }

    public void setOverGuaranteeLoan(Integer overGuaranteeLoan) {
        this.overGuaranteeLoan = overGuaranteeLoan;
    }

    public Integer getOtherLoanNum() {
        return otherLoanNum;
    }

    public void setOtherLoanNum(Integer otherLoanNum) {
        this.otherLoanNum = otherLoanNum;
    }

    public Integer getNormalOtherLoan() {
        return normalOtherLoan;
    }

    public void setNormalOtherLoan(Integer normalOtherLoan) {
        this.normalOtherLoan = normalOtherLoan;
    }

    public Integer getOverOtherLoan() {
        return overOtherLoan;
    }

    public void setOverOtherLoan(Integer overOtherLoan) {
        this.overOtherLoan = overOtherLoan;
    }



    public String getPublicCreditInformation() {
        return publicCreditInformation;
    }

    public void setPublicCreditInformation(String publicCreditInformation) {
        this.publicCreditInformation = publicCreditInformation == null ? null : publicCreditInformation.trim();
    }

    public String getDissentApplyDetail() {
        return dissentApplyDetail;
    }

    public void setDissentApplyDetail(String dissentApplyDetail) {
        this.dissentApplyDetail = dissentApplyDetail == null ? null : dissentApplyDetail.trim();
    }

	public String getPersonReportId() {
		return personReportId;
	}

	public void setPersonReportId(String personReprotId) {
		this.personReportId = personReprotId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCellPhoneNum() {
		return cellPhoneNum;
	}

	public void setCellPhoneNum(String cellPhoneNum) {
		this.cellPhoneNum = cellPhoneNum;
	}

	public List<RepaymentDetailList> getRepaymentDetailList() {
		return repaymentDetailList;
	}

	public void setRepaymentDetailList(List<RepaymentDetailList> repaymentDetailList) {
		this.repaymentDetailList = repaymentDetailList;
	}

	public List<OverRepaymentDetail> getOverRepaymentDetailList() {
		return overRepaymentDetailList;
	}

	public void setOverRepaymentDetailList(List<OverRepaymentDetail> overRepaymentDetailList) {
		this.overRepaymentDetailList = overRepaymentDetailList;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}


	public List<TwoYearsSearchDetail> getTwoyearsSearchNum() {
		return twoyearsSearchNum;
	}

	public void setTwoyearsSearchNum(List<TwoYearsSearchDetail> twoyearsSearchNum) {
		this.twoyearsSearchNum = twoyearsSearchNum;
	}

	@Override
	public String toString() {
		return "PersonReport [searchDate=" + searchDate + ", personReportId=" + personReportId + ", name=" + name
				+ ", cardid=" + cardid + ", cellPhoneNum=" + cellPhoneNum + ", creditLoanNum=" + creditLoanNum
				+ ", normalCreditLoan=" + normalCreditLoan + ", overCreditLoan=" + overCreditLoan + ", mortgageLoanNum="
				+ mortgageLoanNum + ", normalMortgageLoan=" + normalMortgageLoan + ", overMortgageLoan="
				+ overMortgageLoan + ", guaranteeLoanNum=" + guaranteeLoanNum + ", normarlGuaranteeLoan="
				+ normarlGuaranteeLoan + ", overGuaranteeLoan=" + overGuaranteeLoan + ", otherLoanNum=" + otherLoanNum
				+ ", normalOtherLoan=" + normalOtherLoan + ", overOtherLoan=" + overOtherLoan + ", blacklistNum="
				+ blackDetailList + ", repaymentDetailList=" + repaymentDetailList + ", overRepaymentDetailList="
				+ overRepaymentDetailList + ", twoyearsSearchNum=" + twoyearsSearchNum + ", publicCreditInformation="
				+ publicCreditInformation + ", dissentApplyDetail=" + dissentApplyDetail + "]";
	}

	public List<BlackDetailList> getBlackDetailList() {
		return blackDetailList;
	}

	public void setBlackDetailList(List<BlackDetailList> blackDetailList) {
		this.blackDetailList = blackDetailList;
	}

	public List<ContractAcceptDetail> getOverDetailList() {
		return overDetailList;
	}

	public void setOverDetailList(List<ContractAcceptDetail> overDetailList) {
		this.overDetailList = overDetailList;
	}





	
}
package com.sinoway.cisp.entitys;

public class QueryPHPro {
	/**
	 * 200成功 400失败
	 */
	private String CODE;

	/**
	 * 姓名
	 */
	private String NAME;

	/**
	 * 身份证
	 */
	private String IDCARD;

	/**
	 * 手机号码
	 */
	private String PHONENUM;

	/**
	 * 最近 2 年被互金机构拒绝借贷总次数
	 */
	private String BORROWREFUSEDNUM;

	/**
	 * 最近 2 年被拒贷的互金机构总数
	 */
	private String REFUSEDAGENCYNUM;

	/**
	 * 最后一次被拒时间距今时长（近2年内统计月数）
	 */
	private String REFUSEDMONTHAGO;

	/**
	 * 最近 2 年在互金机构借贷逾期总次数
	 */
	private String OVERDUENUM;

	/**
	 * 最近 2 年互金机构借贷出现逾期的总月数
	 */
	private String OVERDUEMONTH;

	/**
	 * 最近 2 年借贷出现逾期的互金机构数
	 */
	private String OVERDUEAGENCYNUM;

	/**
	 * 最后一次逾期时间距今时长（近2年内统计月数）
	 */
	private String OVERDUEMONTHAGO;

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getIDCARD() {
		return IDCARD;
	}

	public void setIDCARD(String iDCARD) {
		IDCARD = iDCARD;
	}

	public String getPHONENUM() {
		return PHONENUM;
	}

	public void setPHONENUM(String pHONENUM) {
		PHONENUM = pHONENUM;
	}

	public String getBORROWREFUSEDNUM() {
		return BORROWREFUSEDNUM;
	}

	public void setBORROWREFUSEDNUM(String bORROWREFUSEDNUM) {
		BORROWREFUSEDNUM = bORROWREFUSEDNUM;
	}

	public String getREFUSEDAGENCYNUM() {
		return REFUSEDAGENCYNUM;
	}

	public void setREFUSEDAGENCYNUM(String rEFUSEDAGENCYNUM) {
		REFUSEDAGENCYNUM = rEFUSEDAGENCYNUM;
	}

	public String getREFUSEDMONTHAGO() {
		return REFUSEDMONTHAGO;
	}

	public void setREFUSEDMONTHAGO(String rEFUSEDMONTHAGO) {
		REFUSEDMONTHAGO = rEFUSEDMONTHAGO;
	}

	public String getOVERDUENUM() {
		return OVERDUENUM;
	}

	public void setOVERDUENUM(String oVERDUENUM) {
		OVERDUENUM = oVERDUENUM;
	}

	public String getOVERDUEMONTH() {
		return OVERDUEMONTH;
	}

	public void setOVERDUEMONTH(String oVERDUEMONTH) {
		OVERDUEMONTH = oVERDUEMONTH;
	}

	public String getOVERDUEAGENCYNUM() {
		return OVERDUEAGENCYNUM;
	}

	public void setOVERDUEAGENCYNUM(String oVERDUEAGENCYNUM) {
		OVERDUEAGENCYNUM = oVERDUEAGENCYNUM;
	}

	public String getOVERDUEMONTHAGO() {
		return OVERDUEMONTHAGO;
	}

	public void setOVERDUEMONTHAGO(String oVERDUEMONTHAGO) {
		OVERDUEMONTHAGO = oVERDUEMONTHAGO;
	}

	/**
	 * 验证是否有记录的字符串 0,0,999,0,0,0,999则为无记录
	 */
	public String toValidateRecordString() {
		return BORROWREFUSEDNUM + "," + REFUSEDAGENCYNUM + "," + REFUSEDMONTHAGO + "," + OVERDUENUM + "," + OVERDUEMONTH
				+ "," + OVERDUEAGENCYNUM + "," + OVERDUEMONTHAGO;
	}

	public String toJsonString() {
		return "{" + "\"CODE\":\"" + CODE + "\"," + "\"iscreditrecord\":\"1\"," + "\"NAME\":\"" + NAME + "\","
				+ "\"IDCARD\":\"" + IDCARD + "\"," + "\"PHONENUM\":\"" + PHONENUM + "\"," + "\"BORROWREFUSEDNUM\":\""
				+ BORROWREFUSEDNUM + "\"," + "\"REFUSEDAGENCYNUM\":\"" + REFUSEDAGENCYNUM + "\","
				+ "\"REFUSEDMONTHAGO\":\"" + REFUSEDMONTHAGO + "\"," + "\"OVERDUENUM\":\"" + OVERDUENUM + "\","
				+ "\"OVERDUEMONTH\":\"" + OVERDUEMONTH + "\"," + "\"OVERDUEAGENCYNUM\":\"" + OVERDUEAGENCYNUM + "\","
				+ "\"OVERDUEMONTHAGO\":\"" + OVERDUEMONTHAGO + "\"" + "}";
	}

}

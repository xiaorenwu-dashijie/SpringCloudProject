package com.sinoway.cisp.service;

public interface ResponseJsonService {

	/**
	 * 
	 * 包含贷前审核报告的个人征信报告
	 * 
	 * @param isCallSuccess
	 *            是否调用成功
	 * @param errorCode
	 *            错误代码
	 * @param report
	 *            个人征信报告
	 * @param mulReport
	 *            贷前审核报告/存量预警报告,只有进件和存量时有可能不为空，其他一律为空
	 * @param service
	 *            调用服务，7贷前审核或者8存量预警，还有一个black，表示黑名单的报告
	 * @param reportId
	 *            报告编号
	 * @return
	 */
	public String creaRespJson(boolean isCallSuccess, String errorCode, String report, String mulReport, String service,
			String reportId);

}

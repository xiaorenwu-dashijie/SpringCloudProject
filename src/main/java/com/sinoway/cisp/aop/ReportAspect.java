package com.sinoway.cisp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinoway.cisp.service.SaveReportService;

@Aspect
@Component
public class ReportAspect {

	@Autowired
	private SaveReportService saveReportService;

	@Pointcut("execution(* com.sinoway.cisp.controller.ApiController.pushLoanInfo(..))")
	public void cutPushLoanInfo() {
	}
	
	@Pointcut("execution(* com.sinoway.cisp.controller.ApiController.pushCreditData(..))")
	public void cutPushCreditData() {
	}
	
	@Pointcut("execution(* com.sinoway.cisp.controller.ApiController.getCreditData(..))")
	public void cutGetCreditData() {
	}
	
	@Pointcut("execution(* com.sinoway.cisp.controller.PersonReportController.getPersonReport(..))")
	public void cutGetPersonReport() {
	}

	@AfterReturning(pointcut = "cutPushLoanInfo()", returning = "returnValue")
	private void saveReqAndRes(JoinPoint joinPoint, String returnValue) {
		saveReportService.saveReqAndRes(joinPoint, returnValue);
	}
	
	@AfterReturning(pointcut = "cutPushCreditData()", returning = "returnValue")
	private void savePushCreditData(JoinPoint joinPoint, String returnValue) {
		saveReportService.saveBlackListReport(joinPoint, returnValue);
	}
	
	@AfterReturning(pointcut = "cutGetCreditData()", returning = "returnValue")
	private void saveGetCreditData(JoinPoint joinPoint, String returnValue) {
		saveReportService.saveBlackListReport(joinPoint, returnValue);
	}
	
	@AfterReturning(pointcut = "cutGetPersonReport()", returning = "returnValue")
	private void saveGetPersonReport(JoinPoint joinPoint, String returnValue) {
		saveReportService.savePersonReport(joinPoint, returnValue);
	}
}

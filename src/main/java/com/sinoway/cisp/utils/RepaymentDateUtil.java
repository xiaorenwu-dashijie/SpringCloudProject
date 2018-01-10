package com.sinoway.cisp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 每期还款时间估计工具类
 *    算法:
 *       贷款到期日期—贷款日期=天数
 *       天数÷还款期数=还款计划周期
 *       第i期还款时间=开始时间+i*还款计划周期
 * @author swd 2017年6月6日11:12:37
 *
 */
public class RepaymentDateUtil {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date start = sdf.parse("2017-06-01");
		Date stop = sdf.parse("2018-06-01");
	
		String startTime = sdf.format(start);
		String stopTime = sdf.format(stop);
		int payPeriod=3;
		List<Date> payTimeList = repaymentDate(start, stop,payPeriod );
		System.out.println("开始时间:"+startTime+"\n"+"结束时间:"+stopTime);
		for (int i = 0; i < payTimeList.size(); i++) {
			String everyRepayMentDate = sdf.format(payTimeList.get(i));
			System.out.println("第"+(i+1)+"期还款时间为:"+everyRepayMentDate);
		}
				
	}
	
	/**
	 * 预估每期还款的时间点
	 * @param start     开始日期
	 * @param stop		到期日期
	 * @param payPeriod 还款期数
	 * @return payTimeList 每期还款时间的集合
	 * @throws ParseException
	 */
	public static List<Date> repaymentDate(Date  startDate,Date stopDate,int payPeriod ) throws ParseException {

		//还款总计时间间隔多少天
		long intervalDays = TimeUnit.MILLISECONDS.toDays(stopDate.getTime()-startDate.getTime());
		//每期间隔多少天
		long repaymentInterval  = intervalDays/payPeriod;		
		
		List<Date> payTimeList=new ArrayList<Date>();
		for (int i = 0; i <payPeriod-1 ; i++) { //去掉最后一期的每期还款时间点
//			String everyPayDate  = sdf.format(new Date(start.getTime()+(i+1)*repaymentInterval*24*60*60*1000));
			Date everyPayDate = new Date(startDate.getTime()+(i+1)*repaymentInterval*24*60*60*1000);
			payTimeList.add(i, everyPayDate);
		}
		payTimeList.add(payPeriod-1, stopDate);	//最后一期的还款时间点(最后结束时间)

		return payTimeList;
	}
	
	
}

package com.sinoway.cisp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	/**
	 * 对当前时间格式化为字符串
	 * 
	 * @param formatter
	 * @return
	 */
	public static String nowFormat(String formatter) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatter));
	}
	
	public static String formatDateMonth(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String _date = dateFormat.format(date);

		return _date;
	}

	public static String formatDate(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String _date = dateFormat.format(date);

		return _date;
	}

	/**
	 * 把Date类型的日期转换为yyyy-MM-dd格式的String
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToStr(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String _date = dateFormat.format(date);

		return _date;
	}

	public static String formatDateTime(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _date = dateFormat.format(date);

		return _date;
	}

	/**
	 * 把Stirng日期转换为Date类型的yyyy-MM-dd
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;

	}

	/**
	 * 把字符串格式的日期转换为Date类型的日期，格式为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDateTime(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;

	}

	// 检验日期格式是否正确
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);

		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/**
	 * 把Date类型日期格转换为yyyy-MM-dd格式的Date类型的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDate(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String _date = dateFormat.format(date);
		Date parse = null;
		try {
			parse = dateFormat.parse(_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}

	/**
	 * 获取六个月之前的日期
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getSixMonthAgo(Date date) throws ParseException {
		Calendar sixmonthago = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String todaydate = sdf.format(date);
		Date nowdate = sdf.parse(todaydate);
		sixmonthago.setTime(nowdate);
		sixmonthago.add(Calendar.MONTH, -6);
		Date sixmonth = sixmonthago.getTime();
		return sixmonth;
	}

}

package com.sinoway.cisp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IDUtil {
	
	/**
	 * 生成华道身份证号码:SW-1506T455-20170801
	 */
	public static String getSinowayCardid() {
		String num = getRandomString(7, "0123456789");
		String randomStr = getRandomString(1, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		return "SW" +"-"+ getRandomString2(num, randomStr) +"-"+ DateUtils.formatDate(new Date());
	}

	// 获取指定位数的随机字符串
	private static String getRandomString(int length, String KeyString) {
		StringBuffer sb = new StringBuffer();
		int len = KeyString.length();
		for (int i = 0; i < length; i++) {
			sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
		}
		return sb.toString();
	}

	// 将一个字符串随机插入到字符串当中
	private static String getRandomString2(String keyString, String str) {
		Random random = new Random();
		int t = random.nextInt(keyString.length());
		return keyString.substring(0, t) + str + keyString.substring(t, keyString.length());
	}
	
	/**
	 * 获取主键SinoId
	 * @param instiCode
	 * @param funCode
	 * @return
	 */
	public static String getSinoId(String instiCode, String funCode){
		StringBuffer tmp = new StringBuffer();
		tmp.append("SINOWAY-");//我司代码固定为SINOWAY
		tmp.append(funCode+"-");
		tmp.append(instiCode+"-");
		tmp.append(timeId()+"-");
		tmp.append(getStringRandom(8));
		
		return tmp.toString();
	}
	
	// 生成随机数字和字母,
	public static String getStringRandom(int length) {

		String val = "";
		Random random = new Random();

		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	

	/*private static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);

			shortBuffer.append(x);
		}
		return shortBuffer.toString();

	}*/

	private static String timeId() {
		SimpleDateFormat fr = new SimpleDateFormat("yyyyMMdd");
		String timeid = fr.format(new Date());
		return timeid;
	}
	
}

package com.sinoway.cisp.utils;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {

	private static final Base64 BASE64 = new Base64();
	private static final String PREFIX = "";
	private static final String key0 = "FECOI()*&<MNCXZPKL";
	private static final Charset charset = Charset.forName("UTF-8");
	private static byte[] keyBytes = key0.getBytes(charset);

	public static String encode(String enc) {
		byte[] b = enc.getBytes(charset);
		for (int i = 0, size = b.length; i < size; i++) {
			for (byte keyBytes0 : keyBytes) {
				b[i] = (byte) (b[i] ^ keyBytes0);
			}
		}
		String psw = new String(b);
		if (enc.length() < 6) {
			for (int i = 0; i < 6 - enc.length(); i++) {
				if (i % 5 == 0) {
					psw += "A";
				} else if (i % 5 == 1) {
					psw += "B";
				} else if (i % 5 == 2) {
					psw = "C" + psw;
				} else if (i % 5 == 3) {
					psw += "D";
				} else {
					psw += "E";
				}
			}
		}
		return encode2(psw);
	}

	private static String encode2(String source) {
		if (!isEmpty(source)) {
			new Base64();
			String target = PREFIX + source;
			byte[] bytes = BASE64.encode(target.getBytes(charset));
			return new String(bytes, charset).substring(0, new String(bytes, charset).length() - 2);
		}

		return source;
	}

	private static String decode2(String source) {
		source = source + "==";
		if (!isEmpty(source)) {
			byte[] bytes = BASE64.decode(source.getBytes(charset));
			String target = new String(bytes, charset);
			return target.startsWith(PREFIX) ? target.substring(PREFIX.length()) : target;
		}
		return source;
	}

	private static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	private static String decode(String dec) {
		dec = decode2(dec);
		if (dec.contains("A") || dec.contains("B") || dec.contains("C") || dec.contains("D") || dec.contains("E")) {
			dec = dec.replace("A", "");
			dec = dec.replace("B", "");
			dec = dec.replace("C", "");
			dec = dec.replace("D", "");
			dec = dec.replace("E", "");
		}
		byte[] e = dec.getBytes(charset);
		byte[] dee = e;
		for (int i = 0, size = e.length; i < size; i++) {
			for (byte keyBytes0 : keyBytes) {
				e[i] = (byte) (dee[i] ^ keyBytes0);
			}
		}
		return new String(e);
	}

	/**
	 * 获得机构代码
	 * @param pswCode 完整的报告编号
	 * @return
	 */
	public static String decodeReportId(String reportId) {
		String[] split = reportId.split("-");
		return reportId = "SINOWAY-" + split[1] + "-" + decode(split[2]) + "-" + split[3] + "-" + split[4];
	}

	public static void main(String[] args) {
		
		String code = "SW-S-UlJSU0-20170623-11627649";
		String instCode = decodeReportId(code);
		System.out.println("解密后机构编码：" + instCode);
//		String s = "0001";
//		String enc = encode(s);
//		String dec = decode(enc);
//		System.out.println("加密前：" + s);
//		System.out.println("加密后：" + enc);
//		System.out.println("解密后：" + dec);
	}

}

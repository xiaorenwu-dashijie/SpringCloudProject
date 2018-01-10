package com.sinoway.cisp.utils;

import java.nio.ByteBuffer;
import java.util.Random;

public class ReportNumberUtil {
	
	public String game(int count){
        StringBuffer sb = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for(int i=0;i<count;i++){
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num)+""), "");
        }
        return sb.toString();
    }
	
	
	public static String createReportNum(){
		String str2 = new ReportNumberUtil().game(4);
        
		long timea = System.currentTimeMillis();
		ByteBuffer buf = ByteBuffer.allocate(32767);
		buf.putLong(0,timea);
		long a = buf.getLong(0)&0xfffL;
		
		//转成String
		String str1 = String.valueOf(a);
		
		String reportNum = str1+str2;

		return reportNum;

	
	
	
	}
}

package com.sinoway.cisp.utils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class MddValidator {
	
	/** 
     * 字典代码验证 
     *  
     * @param  field
     * 				请求参数
     * @param  args
     * 				字典代码数组
     * @return 如果包含在内则返回true，否则返回false
     */ 
	public static boolean findMdd(String field,String...args){
		if(Arrays.asList(args).contains(StringUtils.trim(field))){
			return true;
		}
		return false;
	}

}

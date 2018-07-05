/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: StringUtils.java 
* @Package com.yuan.iliya.main.string 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018年7月1日 下午4:09:36 
* @version V1.0   
*/ 

package com.yuan.iliya.main.string;

import java.util.logging.Logger;

import com.yuan.iliya.main.log.LogFactory;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class StringUtil {
	private static Logger logger = LogFactory.getGlobalLogger();
	
	/**
	 * 处理bean属性名称
	 * @param name
	 * @return
	 */
	public static String getPropertyName(String name){
		String propertyName = null;
		if (!name.matches("^(get|set).*$")) {
			logger.info("方法名不正确，不是getter或者setter方法");
			
		}else {
			propertyName = name.substring(3,4).toLowerCase().concat(name.substring(4));
		}
		
		if (name.matches("^(is).*$")) {
			propertyName = name.substring(2,3).toLowerCase().concat(name.substring(3));
			
		}
		
		return propertyName;
	}
	
	/**
	 * 首字母变大写
	 * @param tString
	 * @return
	 */
	public static String firstToUppcase(String tString){
		char firstChar = tString.charAt(0);
		if (firstChar >= 'a' && firstChar <= 'z') {
			char[] array = tString.toCharArray();
			array[0] -= 'a' - 'A';
			return new String(array);
		}else {
			logger.info("字符串首字母为大写字母或者其他字符");
			return tString;
		}
		
	}
	/**
	 * 首字母变小写
	 * @param tString
	 * @return
	 */
	public static String firstToLowercase(String tString){
		char firstChar = tString.charAt(0);
		if (firstChar >= 'A' && firstChar <= 'Z') {
			char[] array = tString.toCharArray();
			array[0] += 'a' - 'A';
			return new String(array);
		}else {
			logger.info("字符串首字母为小写字母或者其他字符");
			return tString;
		}
		
	}
	
	/**
	 * 判断字符串是否是空字符串
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string){
		if (string == null) {
			logger.info("字符串为空指针");
			return true;
		}
		if (string.length() == 0) {
			logger.info("字符串为空");
			return true;
		}
		return false;
		
	}
	
	/**
	 * 判断字符串是否不是空字符串
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string){
		return !isEmpty(string);
	}
	
	/**
	 * 判断字符串是不是全为空格字符
	 * @param string
	 * @return
	 */
	public static boolean isBlank(String string){
		if (!isNP(string)) {
			if (string.trim().equals("")) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断字符串是不是全不为空格字符
	 * @param string
	 * @return
	 */
	public static boolean isNotBlank(String string){
		return !isBlank(string);
	}
	
	/**
//	 * 判断字符串是不是空指针，如果是空指针返回true,不是空指针返回false
	 * @param string
	 * @return
	 */
	public static boolean isNP(String string){
		if (string == null) {
			logger.info("字符串为空指针");
			return true;
		}
		return false;
	}
	
	/**
	 * 去除前后空格，处理空指针
	 * @param string
	 * @return
	 */
	public static String trim(String string){
		if (isNP(string)) {
			return null;
		}
		return string.trim();
	}
	/**
	 * 去除前后空格，处理空指针
	 * @param string
	 * @return
	 */
	public static String trimToEmpty(String string){
		if (isNP(string)) {
			return "";
		}
		return string.trim();
	}
	
	
	
	
	
	
	
	
	
	

}

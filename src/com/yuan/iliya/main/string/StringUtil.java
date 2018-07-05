/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: StringUtils.java 
* @Package com.yuan.iliya.main.string 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018��7��1�� ����4:09:36 
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
	 * ����bean��������
	 * @param name
	 * @return
	 */
	public static String getPropertyName(String name){
		String propertyName = null;
		if (!name.matches("^(get|set).*$")) {
			logger.info("����������ȷ������getter����setter����");
			
		}else {
			propertyName = name.substring(3,4).toLowerCase().concat(name.substring(4));
		}
		
		if (name.matches("^(is).*$")) {
			propertyName = name.substring(2,3).toLowerCase().concat(name.substring(3));
			
		}
		
		return propertyName;
	}
	
	/**
	 * ����ĸ���д
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
			logger.info("�ַ�������ĸΪ��д��ĸ���������ַ�");
			return tString;
		}
		
	}
	/**
	 * ����ĸ��Сд
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
			logger.info("�ַ�������ĸΪСд��ĸ���������ַ�");
			return tString;
		}
		
	}
	
	/**
	 * �ж��ַ����Ƿ��ǿ��ַ���
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string){
		if (string == null) {
			logger.info("�ַ���Ϊ��ָ��");
			return true;
		}
		if (string.length() == 0) {
			logger.info("�ַ���Ϊ��");
			return true;
		}
		return false;
		
	}
	
	/**
	 * �ж��ַ����Ƿ��ǿ��ַ���
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string){
		return !isEmpty(string);
	}
	
	/**
	 * �ж��ַ����ǲ���ȫΪ�ո��ַ�
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
	 * �ж��ַ����ǲ���ȫ��Ϊ�ո��ַ�
	 * @param string
	 * @return
	 */
	public static boolean isNotBlank(String string){
		return !isBlank(string);
	}
	
	/**
//	 * �ж��ַ����ǲ��ǿ�ָ�룬����ǿ�ָ�뷵��true,���ǿ�ָ�뷵��false
	 * @param string
	 * @return
	 */
	public static boolean isNP(String string){
		if (string == null) {
			logger.info("�ַ���Ϊ��ָ��");
			return true;
		}
		return false;
	}
	
	/**
	 * ȥ��ǰ��ո񣬴����ָ��
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
	 * ȥ��ǰ��ո񣬴����ָ��
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

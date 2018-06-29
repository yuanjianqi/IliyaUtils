/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: ReflectUtils.java 
* @Package com.yuan.iliya.main.reflect 
* @Description:  �ṩ��һϵ�з���Ĺ��߷���
* @author Iliya Kaslana    
* @date 2018��6��29�� ����5:06:00 
* @version V1.0   
*/ 

package com.yuan.iliya.main.reflect;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.yuan.iliya.main.log.LogFactory;
import com.yuan.iliya.main.log.LogUtil;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class ReflectUtil {
	private static Logger logger = LogFactory.getGlobalLogger();
	
	public static String getPackage(Class<?> clazz){
		Package pack = clazz.getPackage();
		if (pack != null) {
			return pack.getName();
		}else {
			logger.warning("�ð�������");
		}
		return null;
		
	}
	
	/**
	 * ��ø�����󣨵����޲ι��췽����
	 * @param clazz
	 * @return
	 */
	public static <T> T getSuperClass(Class<?> clazz){
		
		Class<?> class1 = clazz.getSuperclass();
		T t = null;
		try {
			t = (T) class1.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			
			logger.warning("û���޲ι��췽��");
		}
		return t;
	}
	
	/**
	 * ��ø���ȫ������
	 * @param clazz
	 * @return
	 */
	public static String getSuperClassName(Class<?> clazz){
		
		Class<?> class1 = clazz.getSuperclass();
		
		if (class1 == null) {
			logger.info("����ΪObject,û�и���");
			return null;
		}else {
			return class1.getName();
		}
		
		
	}
	/**
	 * ���ȫ����
	 * @param clazz
	 * @return
	 */
	public static String getSelfClassName(Class<?> clazz){
		return clazz.getName();
	}
	
	/**
	 * ��ü�����
	 * @param clazz
	 * @return
	 */
	public static String getSelfSimpleClassName(Class<?> clazz){
		return clazz.getSimpleName();
	}
	
	//�������ǽӿڲ���
	/**
	 * �����ʵ�ֵ����нӿ���������������
	 * @param clazz
	 * @return
	 */
	public static List<String> getSimpleInterfacesNames(Class<?> clazz){
		Class<?>[] classes = clazz.getInterfaces();
		if (classes.length == 0) {
			logger.info("����û��ʵ���κνӿ�");
		}
		List<String> list = new ArrayList<String>();
		
		for (Class<?> class1 : classes) {
			String interfaceName = class1.getSimpleName();
			list.add(interfaceName);
		}
		return list;
	}
	
	/**
	 * �����ʵ�ֵ����нӿ�������������
	 * @param clazz
	 * @return
	 */
	public static List<String> getInterfacesNames(Class<?> clazz){
		Class<?>[] classes = clazz.getInterfaces();
		if (classes.length == 0) {
			logger.info("����û��ʵ���κνӿ�");
		}
		List<String> list = new ArrayList<String>();
		
		for (Class<?> class1 : classes) {
			String interfaceName = class1.getName();
			list.add(interfaceName);
		}
		return list;
	}
	
	//������������
	
	/**
	 * ��ȡ�������public������
	 * @param clazz
	 * @return
	 */
	public static List<String> getFieldNames(Class<?> clazz){
		Field[] fields = clazz.getFields();
		if (fields.length == 0) {
			logger.info("����û�г�class���κ�public����");
		}
		
		List<String> list = new ArrayList<String>();
		StringBuilder stringBuilder= null;
		for (Field field : fields) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(Modifier.toString(field.getModifiers()) + " ");
			stringBuilder.append(field.getType().getSimpleName() + " ");
			stringBuilder.append(field.getName());
			list.add(stringBuilder.toString());
		}
		
		return list;
	}
	
	/**
	 * ��ȡ�������������
	 * @param clazz
	 * @return
	 */
	public static List<String> getDeclaredFieldNames(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		if (fields.length == 0) {
			logger.info("����û�г�class���κ���������");
		}
		
		List<String> list = new ArrayList<String>();
		StringBuilder stringBuilder= null;
		for (Field field : fields) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(Modifier.toString(field.getModifiers()) + " ");
			stringBuilder.append(field.getType().getSimpleName() + " ");
			stringBuilder.append(field.getName());
			list.add(stringBuilder.toString());
		}
		
		return list;
	}
	
	/**
	 * ���ĳһ�����Ե�����
	 * @param clazz
	 * @param name
	 * @return
	 */
	public static Class<?> GetField(Class<?> clazz, String name){
		Class<?> class1 = null;
		Field field = null;
		try {
			field = clazz.getField(name);
		} catch (NoSuchFieldException | SecurityException e) {
			
			logger.warning("û��������Ի���Ȩ�޲���");
		}
		
		return field.getType();
	}
	
	//�������ǹ��췽��
	
	
	
	
	
	
	
	
	
	
	

}

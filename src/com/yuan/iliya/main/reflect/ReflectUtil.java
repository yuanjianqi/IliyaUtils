/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: ReflectUtils.java 
* @Package com.yuan.iliya.main.reflect 
* @Description:  提供了一系列反射的工具方法
* @author Iliya Kaslana    
* @date 2018年6月29日 下午5:06:00 
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
			logger.warning("该包不存在");
		}
		return null;
		
	}
	
	/**
	 * 获得父类对象（调用无参构造方法）
	 * @param clazz
	 * @return
	 */
	public static <T> T getSuperClass(Class<?> clazz){
		
		Class<?> class1 = clazz.getSuperclass();
		T t = null;
		try {
			t = (T) class1.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			
			logger.warning("没有无参构造方法");
		}
		return t;
	}
	
	/**
	 * 获得父类全类名名
	 * @param clazz
	 * @return
	 */
	public static String getSuperClassName(Class<?> clazz){
		
		Class<?> class1 = clazz.getSuperclass();
		
		if (class1 == null) {
			logger.info("该类为Object,没有父类");
			return null;
		}else {
			return class1.getName();
		}
		
		
	}
	/**
	 * 获得全类名
	 * @param clazz
	 * @return
	 */
	public static String getSelfClassName(Class<?> clazz){
		return clazz.getName();
	}
	
	/**
	 * 获得简单类名
	 * @param clazz
	 * @return
	 */
	public static String getSelfSimpleClassName(Class<?> clazz){
		return clazz.getSimpleName();
	}
	
	//接下来是接口操作
	/**
	 * 获得类实现的所有接口名（不带包名）
	 * @param clazz
	 * @return
	 */
	public static List<String> getSimpleInterfacesNames(Class<?> clazz){
		Class<?>[] classes = clazz.getInterfaces();
		if (classes.length == 0) {
			logger.info("该类没有实现任何接口");
		}
		List<String> list = new ArrayList<String>();
		
		for (Class<?> class1 : classes) {
			String interfaceName = class1.getSimpleName();
			list.add(interfaceName);
		}
		return list;
	}
	
	/**
	 * 获得类实现的所有接口名（带包名）
	 * @param clazz
	 * @return
	 */
	public static List<String> getInterfacesNames(Class<?> clazz){
		Class<?>[] classes = clazz.getInterfaces();
		if (classes.length == 0) {
			logger.info("该类没有实现任何接口");
		}
		List<String> list = new ArrayList<String>();
		
		for (Class<?> class1 : classes) {
			String interfaceName = class1.getName();
			list.add(interfaceName);
		}
		return list;
	}
	
	//接下来是属性
	
	/**
	 * 获取类的所有public属性名
	 * @param clazz
	 * @return
	 */
	public static List<String> getFieldNames(Class<?> clazz){
		Field[] fields = clazz.getFields();
		if (fields.length == 0) {
			logger.info("该类没有除class外任何public属性");
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
	 * 获取类的所有属性名
	 * @param clazz
	 * @return
	 */
	public static List<String> getDeclaredFieldNames(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		if (fields.length == 0) {
			logger.info("该类没有除class外任何其他属性");
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
	 * 获得某一个属性的类型
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
			
			logger.warning("没有这个属性或者权限不足");
		}
		
		return field.getType();
	}
	
	//接下来是构造方法
	
	
	
	
	
	
	
	
	
	
	

}

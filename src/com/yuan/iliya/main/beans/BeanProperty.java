/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: BeanProperty.java 
* @Package com.yuan.iliya.main.beans 
* @Description: 利用内省为属性赋值
* @author Iliya Kaslana    
* @date 2018年7月1日 下午4:08:50 
* @version V1.0   
*/ 

package com.yuan.iliya.main.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

import com.yuan.iliya.main.log.LogFactory;
import com.yuan.iliya.main.reflect.ReflectUtil;
import com.yuan.iliya.main.string.StringUtil;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class BeanProperty {
	
	private static Logger logger = LogFactory.getGlobalLogger();
	private static BeanInfo getBeanInfo(Class<?> clazz){
		try {
			return Introspector.getBeanInfo(clazz);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("无法获得该bean的信息");
			
		}
		return null;
	}
	
	/**
	 * 获取bean中的属性描述符，定义了多少个getter 和 setter,（成对）就有几个PropertyDescriptor，注意每个类都有class属性
	 * @param clazz
	 * @return
	 */
	public static PropertyDescriptor[] getPropertyDescriptor(Class<?> clazz){
		return getBeanInfo(clazz).getPropertyDescriptors();
	}
	
	/**
	 * 获取bean中的公有方法描述，不只是get,setter方法。
	 * @param clazz
	 * @return
	 */
	public static MethodDescriptor[] getMethodDescriptors(Class<?> clazz){
		return getBeanInfo(clazz).getMethodDescriptors();
	}
	
	/**
	 * 获取属性的写方法，注意可能有null
	 * @param clazz
	 * @return
	 */
	public static List<Method> getBeanWriteMethods(Class<?> clazz){
		PropertyDescriptor[] propertyDescriptors = getPropertyDescriptor(clazz);
		List<Method> list = callback((propertyDescriptor) -> {
			return propertyDescriptor.getWriteMethod();
		}, propertyDescriptors);
		return list;
	}
	
	/**
	 * 获取属性的读方法，注意可能有null
	 * @param clazz
	 * @return
	 */
	public static List<Method> getBeanReadMethods(Class<?> clazz){
		PropertyDescriptor[] propertyDescriptors = getPropertyDescriptor(clazz);
		List<Method> list = callback((propertyDescriptor) -> {
			return propertyDescriptor.getReadMethod();
		}, propertyDescriptors);
		return list;
	}
	
	/**
	 * 获得写方法或者读方法的回调函数
	 * @param function
	 * @param propertyDescriptors
	 * @return
	 */
	public static List<Method> callback(Function<PropertyDescriptor, Method> function,PropertyDescriptor[] propertyDescriptors){
		List<Method> list = new ArrayList<Method>();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			list.add(function.apply(propertyDescriptor));
		}
		
		return list;
	}
	
	/**
	 * 调用某个写方法为指定属性赋值
	 */
	public static void setProperty(Object object, String name, Object value){
		List<Method> methods = getBeanWriteMethods(object.getClass());
		for (Method method : methods) {
			if (method != null && StringUtil.getPropertyName(method.getName()).equals(name)) {
				ReflectUtil.invokeMethod(method, object, value);
				return;
			}
		}
	}
	
	/**
	 * 调用某个读方法获得指定属性赋值
	 */
	public static Object getProperty(Object object, String name){
		List<Method> methods = getBeanReadMethods(object.getClass());
		for (Method method : methods) {
			if (method != null && StringUtil.getPropertyName(method.getName()).equals(name)) {
				Object attrValue = ReflectUtil.invokeMethod(method, object);
				return attrValue;
			}
		}
		return null;
	}
	
	
	
	
	
}

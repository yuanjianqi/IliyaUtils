/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: BeanProperty.java 
* @Package com.yuan.iliya.main.beans 
* @Description: ������ʡΪ���Ը�ֵ
* @author Iliya Kaslana    
* @date 2018��7��1�� ����4:08:50 
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
			logger.info("�޷���ø�bean����Ϣ");
			
		}
		return null;
	}
	
	/**
	 * ��ȡbean�е������������������˶��ٸ�getter �� setter,���ɶԣ����м���PropertyDescriptor��ע��ÿ���඼��class����
	 * @param clazz
	 * @return
	 */
	public static PropertyDescriptor[] getPropertyDescriptor(Class<?> clazz){
		return getBeanInfo(clazz).getPropertyDescriptors();
	}
	
	/**
	 * ��ȡbean�еĹ��з�����������ֻ��get,setter������
	 * @param clazz
	 * @return
	 */
	public static MethodDescriptor[] getMethodDescriptors(Class<?> clazz){
		return getBeanInfo(clazz).getMethodDescriptors();
	}
	
	/**
	 * ��ȡ���Ե�д������ע�������null
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
	 * ��ȡ���ԵĶ�������ע�������null
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
	 * ���д�������߶������Ļص�����
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
	 * ����ĳ��д����Ϊָ�����Ը�ֵ
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
	 * ����ĳ�����������ָ�����Ը�ֵ
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

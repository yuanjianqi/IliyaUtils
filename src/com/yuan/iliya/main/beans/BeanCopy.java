/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: BeanCopy.java 
* @Package com.yuan.iliya.main.beans 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018年7月1日 下午4:09:03 
* @version V1.0   
*/ 

package com.yuan.iliya.main.beans;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

import com.yuan.iliya.main.log.LogFactory;
import com.yuan.iliya.main.reflect.ReflectUtil;
import com.yuan.iliya.main.string.StringUtil;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class BeanCopy {
	private static Logger logger = LogFactory.getGlobalLogger();
	/**
	 * 浅复制
	 * @param object
	 * @return
	 */
	public static Object copyBean(Object object){
		Class<?> clazz = object.getClass();
		Object object2 = ReflectUtil.getNewInstanceByConstructor(clazz);
		List<Method> methods = BeanProperty.getBeanWriteMethods(clazz);
		for (Method method : methods) {
			if (method != null) {
				BeanProperty.setProperty(object2, StringUtil.getPropertyName(method.getName()), BeanProperty.getProperty(object, StringUtil.getPropertyName(method.getName())));
			}
		}
		return object2;
		
	}
	
	/**
	 * 浅复制，实现了Clonable接口
	 */
	public static Object copyBeanByClone(Cloneable object){
		Object object2 = ReflectUtil.invokeMethod(ReflectUtil.getDeclaredMethod(Object.class, "clone"), object);
		return object2;
		
	}

}

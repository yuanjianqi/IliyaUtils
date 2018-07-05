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




import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.yuan.iliya.main.log.LogFactory;

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
	 * 获得某一个public属性的类型
	 * @param clazz
	 * @param name
	 * @return
	 */
	public static Class<?> getField(Class<?> clazz, String name){
		Class<?> class1 = null;
		Field field = null;
		try {
			field = clazz.getField(name);
		} catch (NoSuchFieldException | SecurityException e) {
			
			logger.warning("没有这个属性或者权限不足");
		}
		
		return field.getType();
	}
	/**
	 * 获得某一个属性的类型
	 * @param clazz
	 * @param name
	 * @return
	 */
	public static Class<?> getDeclaredField(Class<?> clazz, String name){
		Class<?> class1 = null;
		Field field = null;
		try {
			field = clazz.getDeclaredField(name);
		} catch (NoSuchFieldException | SecurityException e) {
			
			logger.warning("没有这个属性或者权限不足");
		}
		
		return field.getType();
	}
	
	//接下来是构造方法
	/**
	 * 获得所有的构造方法签名
	 * @param clazz
	 * @return
	 */
	public static List<String> getDeclaredConstructorNames(Class<?> clazz){
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		StringBuilder stringBuilder = null;
		List<String> list = new ArrayList<String>();
		for (Constructor<?> constructor : constructors) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(Modifier.toString(constructor.getModifiers()) + " ");
			stringBuilder.append(constructor.getName().substring(constructor.getName().lastIndexOf(".") + 1) + "( ");
			Parameter[] parameters = constructor.getParameters();
			for (Parameter parameter : parameters) {
				stringBuilder.append(parameter.getType().getSimpleName() + " " + parameter.getName() + " ");
			}
			stringBuilder.append(")");
			list.add(stringBuilder.toString());
		}
		return list;
	}
	
	/**
	 * 获得public 权限的指定构造方法
	 * @param clazz
	 * @param classes
	 * @return
	 */
	public static Constructor<?> getConstructor(Class<?> clazz, Class<?> ...classes){
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getConstructor(classes);
		} catch (NoSuchMethodException | SecurityException e) {
			logger.warning("该类没有这个构造方法，请检查您的参数类型是否输入正确。或者是这个构造方法的权限不是public");
		}
		return constructor;
	}
	/**
	 * 获得指定构造方法,忽略权限,不建议使用
	 * @param clazz
	 * @param classes
	 * @return
	 */
	@Deprecated
	public static Constructor<?> getDeclaredConstructor(Class<?> clazz, Class<?> ...classes){
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getDeclaredConstructor(classes);
		} catch (NoSuchMethodException | SecurityException e) {
			logger.warning("该类没有这个构造方法，请检查您的参数类型是否输入正确");
		}
		return constructor;
	}
	
	/**
	 * 获得public 权限的所有构造方法
	 * @param clazz
	 * @return
	 */
	public static Constructor<?>[] getConstructors(Class<?> clazz){
		Constructor<?>[] constructors = null;
		try {
			constructors = clazz.getConstructors();
		} catch (SecurityException e) {
			logger.warning("这个类的构造方法的权限不是public");
		}
		return constructors;
	}
	/**
	 * 获得所有构造方法,忽略权限，不推荐使用
	 * @param clazz
	 * @return
	 */
	@Deprecated
	public static Constructor<?>[] getDeclaredConstructors(Class<?> clazz){
		Constructor<?>[] constructors = null;
		try {
			constructors = clazz.getDeclaredConstructors();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return constructors;
	}
	
	/**
	 * 通过public无参构造方法创建对象
	 * @param clazz
	 * @param objects
	 * @return
	 */
	public static <T> T getNewInstanceByConstructor(Class<?> clazz){
		try {
			Constructor<?> constructor = getConstructor(clazz, null);
			return (T)constructor.newInstance(null);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			logger.info("没有Public 的 无参构造方法");
		}
		return null;
	}
	/**
	 * 通过public有参构造方法创建对象
	 * @param clazz
	 * @param objects
	 * @return
	 */
	public static <T> T getNewInstanceByConstructor(Class<?> clazz, Class<?>[] classes,Object...objects){
		try {
			Constructor<?> constructor = getConstructor(clazz, classes);
			return (T)constructor.newInstance(objects);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			logger.info("没有Public 的 无参构造方法");
		}
		return null;
	}
	
	/**
	 * 通过无参构造方法创建对象, 不推荐使用，破坏了封装性
	 * @param clazz
	 * @param objects
	 * @return
	 */
	@Deprecated
	public static <T> T getNewInstanceByDeclaredConstructor(Class<?> clazz){
		try {
			Constructor<?> constructor = getDeclaredConstructor(clazz, null);
			constructor.setAccessible(true);
			return (T)constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			logger.info("没有无参构造方法");
		}
		return null;
	}
	
	//method
	
	//首先是方法的描述
	//方法分为 修饰符 返回值 方法名 方法参数
	
	/**
	 * 获得所有public方法（包括从父类继承）
	 * @param clazz
	 * @return
	 */
	public static List<String> getMethodNames(Class<?> clazz){
		List<String> list = new ArrayList<String>();
		Method[] methods = clazz.getMethods();
		StringBuilder stringBuilder = null;
		
		for (Method method : methods) {
			stringBuilder = new StringBuilder();
			//修饰符
			String modifies = Modifier.toString(method.getModifiers());
			stringBuilder.append(modifies + " ");
			String returnType = method.getReturnType().getSimpleName();
			stringBuilder.append(returnType + " ");
			String methodName = method.getName();
			stringBuilder.append(methodName);
			
			stringBuilder.append("(");
			Parameter[] parameters = method.getParameters();
			for (Parameter parameter : parameters) {
				String type = parameter.getType().getSimpleName();
				String name = parameter.getName();
				stringBuilder.append(type + " " + name + " ");
			}
			stringBuilder.append(")");
			list.add(stringBuilder.toString());
			
		}
		
		return list;
	}
	
	/**
	 * 获得类中的所有方法（不包括父类）
	 * @param clazz
	 * @return
	 */
	public static List<String> getDeclaredMethodNames(Class<?> clazz){
		List<String> list = new ArrayList<String>();
		Method[] methods = clazz.getDeclaredMethods();
		StringBuilder stringBuilder = null;
		
		for (Method method : methods) {
			stringBuilder = new StringBuilder();
			//修饰符
			String modifies = Modifier.toString(method.getModifiers());
			stringBuilder.append(modifies + " ");
			String returnType = method.getReturnType().getSimpleName();
			stringBuilder.append(returnType + " ");
			String methodName = method.getName();
			stringBuilder.append(methodName);
			
			stringBuilder.append("(");
			Parameter[] parameters = method.getParameters();
			for (Parameter parameter : parameters) {
				String type = parameter.getType().getSimpleName();
				String name = parameter.getName();
				stringBuilder.append(type + " " + name + " ");
			}
			stringBuilder.append(")");
			list.add(stringBuilder.toString());
			
		}
		
		return list;
	}
	
	/**
	 * 获得public权限的方法
	 * @param clazz
	 * @param name
	 * @param classes
	 * @return
	 */
	public static Method getMethod(Class<?> clazz,String name,Class<?> ...classes){
		try {
			Method method = clazz.getMethod(name, classes);
			return method;
		} catch (NoSuchMethodException | SecurityException e) {
			logger.info("没有该方法或该方法的权限不足");
		}
		return null;
	}
	
	/**
	 * 获得方法,忽略权限
	 * @param clazz
	 * @param name
	 * @param classes
	 * @return
	 */
	public static Method getDeclaredMethod(Class<?> clazz,String name,Class<?> ...classes){
		try {
			Method method = clazz.getDeclaredMethod(name, classes);
			return method;
		} catch (NoSuchMethodException | SecurityException e) {
			logger.info("没有该方法");
		}
		return null;
	}
	
	/**
	 * 执行方法调用，并且处理异常
	 * @param method
	 * @param object
	 * @param objects
	 * @return
	 */
	public static <T> T invokeMethod(Method method, Object object, Object ...objects){
		method.setAccessible(true);
		try {
			return (T) method.invoke(object, objects);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
			logger.warning("方法调用出现问题，可能是参数不正确，或者是权限问题");
		}
		return null;
		
	}
	
	/**
	 * 获得父类的泛型类型数组
	 * @param clazz
	 * @return
	 */
	public static List<Class<?>> getSuperClassGenericParameterizedTypes(Class<?> clazz){
		Type type = clazz.getGenericSuperclass();
		List<Class<?>> classes = new ArrayList<Class<?>>();
		
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType)type;
			Type[] superClazz = parameterizedType.getActualTypeArguments();
			for (Type type2 : superClazz) {
				classes.add((Class<?>)type2 );
			}
		}else {
			logger.info("父类不是带泛型的父类");
		}
		return classes;
	}
	
	/**
	 * 获得父类的泛型类型（单个）
	 */
	public static Class<?> getSuperClassGenericParameterizedType(Class<?> clazz){
		return getSuperClassGenericParameterizedTypes(clazz).get(0);
	}
	
	/**
	 * 获得实现的接口的泛型类型数组
	 * 该方法测试未通过还存在问题,不予使用
	 * 不是很安全
	 * @param clazz
	 * @return
	 */
	@Deprecated
	public static List<Class<?>> getInterfaceGenericParameterizedTypes(Class<?> clazz){
		Type[] type = clazz.getGenericInterfaces();
	
		List<Class<?>> list = new ArrayList<Class<?>>();
		
		for (Type type2:type) {
			if (type2 instanceof ParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType)type2;
				Type[] suTypes = parameterizedType.getActualTypeArguments();
				
				for (Type type3 : suTypes) {
					Class<?> interfaceClass = (Class<?>)type3;
					list.add(interfaceClass);
				}
				
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

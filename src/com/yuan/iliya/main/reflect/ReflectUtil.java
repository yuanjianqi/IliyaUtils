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
	 * ���ĳһ��public���Ե�����
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
			
			logger.warning("û��������Ի���Ȩ�޲���");
		}
		
		return field.getType();
	}
	/**
	 * ���ĳһ�����Ե�����
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
			
			logger.warning("û��������Ի���Ȩ�޲���");
		}
		
		return field.getType();
	}
	
	//�������ǹ��췽��
	/**
	 * ������еĹ��췽��ǩ��
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
	 * ���public Ȩ�޵�ָ�����췽��
	 * @param clazz
	 * @param classes
	 * @return
	 */
	public static Constructor<?> getConstructor(Class<?> clazz, Class<?> ...classes){
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getConstructor(classes);
		} catch (NoSuchMethodException | SecurityException e) {
			logger.warning("����û��������췽�����������Ĳ��������Ƿ�������ȷ��������������췽����Ȩ�޲���public");
		}
		return constructor;
	}
	/**
	 * ���ָ�����췽��,����Ȩ��,������ʹ��
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
			logger.warning("����û��������췽�����������Ĳ��������Ƿ�������ȷ");
		}
		return constructor;
	}
	
	/**
	 * ���public Ȩ�޵����й��췽��
	 * @param clazz
	 * @return
	 */
	public static Constructor<?>[] getConstructors(Class<?> clazz){
		Constructor<?>[] constructors = null;
		try {
			constructors = clazz.getConstructors();
		} catch (SecurityException e) {
			logger.warning("�����Ĺ��췽����Ȩ�޲���public");
		}
		return constructors;
	}
	/**
	 * ������й��췽��,����Ȩ�ޣ����Ƽ�ʹ��
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
	 * ͨ��public�޲ι��췽����������
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
			logger.info("û��Public �� �޲ι��췽��");
		}
		return null;
	}
	/**
	 * ͨ��public�вι��췽����������
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
			logger.info("û��Public �� �޲ι��췽��");
		}
		return null;
	}
	
	/**
	 * ͨ���޲ι��췽����������, ���Ƽ�ʹ�ã��ƻ��˷�װ��
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
			logger.info("û���޲ι��췽��");
		}
		return null;
	}
	
	//method
	
	//�����Ƿ���������
	//������Ϊ ���η� ����ֵ ������ ��������
	
	/**
	 * �������public�����������Ӹ���̳У�
	 * @param clazz
	 * @return
	 */
	public static List<String> getMethodNames(Class<?> clazz){
		List<String> list = new ArrayList<String>();
		Method[] methods = clazz.getMethods();
		StringBuilder stringBuilder = null;
		
		for (Method method : methods) {
			stringBuilder = new StringBuilder();
			//���η�
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
	 * ������е����з��������������ࣩ
	 * @param clazz
	 * @return
	 */
	public static List<String> getDeclaredMethodNames(Class<?> clazz){
		List<String> list = new ArrayList<String>();
		Method[] methods = clazz.getDeclaredMethods();
		StringBuilder stringBuilder = null;
		
		for (Method method : methods) {
			stringBuilder = new StringBuilder();
			//���η�
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
	 * ���publicȨ�޵ķ���
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
			logger.info("û�и÷�����÷�����Ȩ�޲���");
		}
		return null;
	}
	
	/**
	 * ��÷���,����Ȩ��
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
			logger.info("û�и÷���");
		}
		return null;
	}
	
	/**
	 * ִ�з������ã����Ҵ����쳣
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
			logger.warning("�������ó������⣬�����ǲ�������ȷ��������Ȩ������");
		}
		return null;
		
	}
	
	/**
	 * ��ø���ķ�����������
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
			logger.info("���಻�Ǵ����͵ĸ���");
		}
		return classes;
	}
	
	/**
	 * ��ø���ķ������ͣ�������
	 */
	public static Class<?> getSuperClassGenericParameterizedType(Class<?> clazz){
		return getSuperClassGenericParameterizedTypes(clazz).get(0);
	}
	
	/**
	 * ���ʵ�ֵĽӿڵķ�����������
	 * �÷�������δͨ������������,����ʹ��
	 * ���Ǻܰ�ȫ
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

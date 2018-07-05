/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: ClassPrint.java 
* @Package com.yuan.iliya.main.reflect 
* @Description: 打印一个类的详细信息
* @author Iliya Kaslana    
* @date 2018年6月30日 下午3:51:34 
* @version V1.0   
*/ 

package com.yuan.iliya.main.reflect;

import java.util.List;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class ClassPrint {
	/**
	 * 打印包名
	 * @param clazz
	 */
	public static void printPackage(Class<?> clazz){
		System.out.print("包名: ");
		System.out.println(ReflectUtil.getPackage(clazz));
		
	}
	
	/**
	 * 打印父类全类名
	 * @param clazz
	 */
	public static void printSuperClassName(Class<?> clazz){
		System.out.print("父类的全类名 : ");
		System.out.println(ReflectUtil.getSuperClassName(clazz));
	}
	
	/**
	 * 打印类的全类名
	 * @param clazz
	 */
	public static void printSelfClassName(Class<?> clazz){
		System.out.print("类的全类名");
		System.out.println(ReflectUtil.getSelfClassName(clazz));
	}
	
	/**
	 * 打印类的类名
	 * @param clazz
	 */
	public static void printSelfSimpleClassName(Class<?> clazz){
		System.out.print("类的类名");
		System.out.println(ReflectUtil.getSelfSimpleClassName(clazz));
	}
	
	/**
	 * 打印实现的接口
	 * @param clazz
	 */
	public static void printInterfaces(Class<?> clazz){
		List<String> list = ReflectUtil.getInterfacesNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("实现的接口:");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * 打印全部属性
	 * @param clazz
	 */
	public static void printFields(Class<?> clazz){
		List<String> list = ReflectUtil.getDeclaredFieldNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("类的属性 : ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * 打印公有属性
	 * @param clazz
	 */
	public static void printPublicFields(Class<?> clazz){
		List<String> list = ReflectUtil.getFieldNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("类的public属性 : ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * 打印所有构造方法
	 * @param clazz
	 */
	public static  void printDeclaredContructors(Class<?> clazz){
		List<String> list = ReflectUtil.getDeclaredConstructorNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("构造方法: ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * 打印类中所有的public 方法,包含父类
	 * @param clazz
	 */
	public static void printMethods(Class<?> clazz){
		List<String> list = ReflectUtil.getMethodNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("public方法: ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * 打印类中的所有方法（不含父类）
	 * @param clazz
	 */
	public static void prinDeclaredMethods(Class<?> clazz){
		List<String> list = ReflectUtil.getDeclaredMethodNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("方法: ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * 打印类的基本信息
	 * @param clazz
	 */
	public static void printAll(Class<?> clazz) {
	   printPackage(clazz);

	   printSelfSimpleClassName(clazz);

	    
	   printSuperClassName(clazz);
	    
	    
	   printInterfaces(clazz);

	    
	   printDeclaredContructors(clazz);
	   
	   prinDeclaredMethods(clazz);
	}
	
	
	

}

/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: ClassPrint.java 
* @Package com.yuan.iliya.main.reflect 
* @Description: ��ӡһ�������ϸ��Ϣ
* @author Iliya Kaslana    
* @date 2018��6��30�� ����3:51:34 
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
	 * ��ӡ����
	 * @param clazz
	 */
	public static void printPackage(Class<?> clazz){
		System.out.print("����: ");
		System.out.println(ReflectUtil.getPackage(clazz));
		
	}
	
	/**
	 * ��ӡ����ȫ����
	 * @param clazz
	 */
	public static void printSuperClassName(Class<?> clazz){
		System.out.print("�����ȫ���� : ");
		System.out.println(ReflectUtil.getSuperClassName(clazz));
	}
	
	/**
	 * ��ӡ���ȫ����
	 * @param clazz
	 */
	public static void printSelfClassName(Class<?> clazz){
		System.out.print("���ȫ����");
		System.out.println(ReflectUtil.getSelfClassName(clazz));
	}
	
	/**
	 * ��ӡ�������
	 * @param clazz
	 */
	public static void printSelfSimpleClassName(Class<?> clazz){
		System.out.print("�������");
		System.out.println(ReflectUtil.getSelfSimpleClassName(clazz));
	}
	
	/**
	 * ��ӡʵ�ֵĽӿ�
	 * @param clazz
	 */
	public static void printInterfaces(Class<?> clazz){
		List<String> list = ReflectUtil.getInterfacesNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("ʵ�ֵĽӿ�:");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * ��ӡȫ������
	 * @param clazz
	 */
	public static void printFields(Class<?> clazz){
		List<String> list = ReflectUtil.getDeclaredFieldNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("������� : ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * ��ӡ��������
	 * @param clazz
	 */
	public static void printPublicFields(Class<?> clazz){
		List<String> list = ReflectUtil.getFieldNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("���public���� : ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * ��ӡ���й��췽��
	 * @param clazz
	 */
	public static  void printDeclaredContructors(Class<?> clazz){
		List<String> list = ReflectUtil.getDeclaredConstructorNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("���췽��: ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * ��ӡ�������е�public ����,��������
	 * @param clazz
	 */
	public static void printMethods(Class<?> clazz){
		List<String> list = ReflectUtil.getMethodNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("public����: ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * ��ӡ���е����з������������ࣩ
	 * @param clazz
	 */
	public static void prinDeclaredMethods(Class<?> clazz){
		List<String> list = ReflectUtil.getDeclaredMethodNames(clazz);
		if (list.size() == 0) {
			return;
		}
		System.out.println("����: ");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	/**
	 * ��ӡ��Ļ�����Ϣ
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

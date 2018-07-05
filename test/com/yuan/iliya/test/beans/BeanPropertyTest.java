/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: BeanPropertyTest.java 
* @Package com.yuan.iliya.test.beans 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018年7月1日 下午4:29:21 
* @version V1.0   
*/ 

package com.yuan.iliya.test.beans;

import static org.junit.Assert.*;

import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.yuan.iliya.main.beans.BeanCopy;
import com.yuan.iliya.main.beans.BeanProperty;
import com.yuan.iliya.main.reflect.ClassPrint;
import com.yuan.iliya.test.reflect.Student;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class BeanPropertyTest {

	@Test
	public void test() {
		MethodDescriptor[] methodDescriptors = BeanProperty.getMethodDescriptors(Student.class);
		for (MethodDescriptor methodDescriptor : methodDescriptors) {
			System.out.println(methodDescriptor.getMethod().getName());
		}
		
	}
	
	@Test
	public void test03(){
		PropertyDescriptor[] propertyDescriptor = BeanProperty.getPropertyDescriptor(Student.class);
		for (PropertyDescriptor propertyDescriptor2 : propertyDescriptor) {
			System.out.println(propertyDescriptor2.getWriteMethod());
			System.out.println(propertyDescriptor2.getName());
		}
	}
	
	@Test
	public void test04(){
		List<Method> methods = BeanProperty.getBeanReadMethods(Student.class);
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
	
	@Test
	public void test05(){
		Student student = new Student();
		BeanProperty.setProperty(student, "gender", "男");
		System.out.println(BeanProperty.getProperty(student, "gender"));
	}
	@Test
	public void test06(){
		Student student = new Student("离散", "女",20);
		student.setDate(new Date());
		Student student2 = (Student)BeanCopy.copyBean(student);
//		student2.setDate(new Date(1983791273L));
		student2.getDate().setTime(48719719479178914l);;
		System.out.println(student2.getDate());
		System.out.println(student.getDate());
	}
	@Test
	public void test07(){
		Student student = new Student("离散", "女",20);
		student.setDate(new Date());
		Student student2 = (Student)BeanCopy.copyBeanByClone(student);
//		student2.setDate(new Date(1983791273L));
		student2.getDate().setTime(48719719479178914l);;
		System.out.println(student2);
		System.out.println(student);
	}
	
	@Test
	public void test08(){
		ClassPrint.prinDeclaredMethods(Object.class);
	}

}

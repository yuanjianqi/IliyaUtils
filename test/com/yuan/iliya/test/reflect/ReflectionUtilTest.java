/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: ReflectionUtilTest.java 
* @Package com.yuan.iliya.test.reflect 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018年6月30日 上午12:21:43 
* @version V1.0   
*/ 

package com.yuan.iliya.test.reflect;

import java.util.Hashtable;

import org.junit.Test;

import com.yuan.iliya.main.reflect.ReflectUtil;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class ReflectionUtilTest {
	@Test
	public void test01() throws InstantiationException, IllegalAccessException{
		
		System.out.println(ReflectUtil.getSuperClassName(Object.class));
		System.out.println(ReflectUtil.getDeclaredFieldNames(Hashtable.class));
		
		
	}
	
	@Test
	public void test02(){
		Class<?> class1 = ReflectUtil.getDeclaredField(Hashtable.class, "count"); 
		System.out.println(class1);
	}
	
	@Test
	public void test03(){
		System.out.println(ReflectUtil.getDeclaredConstructors(Hashtable.class));
	}
	
	@Test
	public void test04(){
		Student student = ReflectUtil.getNewInstanceByDeclaredConstructor(Student.class);
		System.out.println(student);
	}
	
	@Test
	public void test05(){
		System.out.println(ReflectUtil.getDeclaredMethodNames(Hashtable.class));
	}
	@Test
	public void test06(){
		B b = new B();
		System.out.println(ReflectUtil.getSuperClassGenericParameterizedType(b.getClass()));
	}
	@Test
	public void test07(){
		B b = new B();
		System.out.println(ReflectUtil.getInterfaceGenericParameterizedTypes(b.getClass()));
	}

}

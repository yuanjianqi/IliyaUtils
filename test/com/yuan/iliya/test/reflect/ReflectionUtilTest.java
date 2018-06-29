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
		
//		System.out.println(ReflectUtils.getSuperClassName(ReflectUtils.class));
		System.out.println(ReflectUtil.getDeclaredFieldNames(Hashtable.class));
		
		
	}

}

/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: StringUtilsTest.java 
* @Package com.yuan.iliya.test.string 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018年7月1日 下午4:13:37 
* @version V1.0   
*/ 

package com.yuan.iliya.test.string;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yuan.iliya.main.string.StringUtil;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class StringUtilsTest {

	@Test
	public void test() {
		String nameString = "isName";
		nameString = StringUtil.getPropertyName(nameString);
		System.out.println(nameString);
	}
	@Test
	public void test2() {
		System.out.println(StringUtil.firstToLowercase("abc"));
		System.out.println(StringUtil.firstToUppcase("Abc"));
	}
	
	@Test
	public void test3(){
		System.out.println(StringUtil.isEmpty(null));
		System.out.println(StringUtil.isBlank("     "));
	}
	@Test
	public void test4(){
		System.out.println(StringUtil.trimToEmpty(null));
		System.out.println(StringUtil.isBlank("     "));
	}

}

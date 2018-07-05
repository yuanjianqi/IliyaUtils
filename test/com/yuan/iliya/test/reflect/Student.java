/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: Student.java 
* @Package com.yuan.iliya.test.reflect 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018年6月30日 下午2:12:01 
* @version V1.0   
*/ 

package com.yuan.iliya.test.reflect;

import java.util.Date;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class Student implements Cloneable{

	private String nameString;
	private String gender;
	private Integer ageInteger;
	private String hobby;
	private Date date;
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAgeInteger() {
		return ageInteger;
	}
	public void setAgeInteger(Integer ageInteger) {
		this.ageInteger = ageInteger;
	}
	public Student(String nameString, String gender, Integer ageInteger) {
		super();
		this.nameString = nameString;
		this.gender = gender;
		this.ageInteger = ageInteger;
	}
	public Student() {
		super();
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", gender=" + gender + ", ageInteger=" + ageInteger + ", hobby="
				+ hobby + ", date=" + date + "]";
	}
	
//	/**
//	 * @return the hobby
//	 */
//	public String getHobby() {
//		return null;
//	}
	
	
}

/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: HttpParamter.java 
* @Package com.yuan.iliya.main.web 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018年7月1日 下午5:56:03 
* @version V1.0   
*/ 

package com.yuan.iliya.main.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class HttpParamter implements Map<String, Object>{
	
	private Map<String, Object> parameters = new HashMap<String, Object>();

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return parameters.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return parameters.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return parameters.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return parameters.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		
		return parameters.get(key);
	}

	@Override
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		return parameters.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return parameters.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub
		parameters.putAll(m);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		parameters.clear();
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return parameters.keySet();
	}

	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return parameters.values();
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return parameters.entrySet();
	}
	
	

	
	
}

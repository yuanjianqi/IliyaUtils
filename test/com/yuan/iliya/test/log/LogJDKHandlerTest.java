/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: LogJDKTest.java 
* @Package com.yuan.iliya.test.log 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018��6��29�� ����5:40:06 
* @version V1.0   
*/ 

package com.yuan.iliya.test.log;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class LogJDKHandlerTest {
	private static Logger logger = Logger.getLogger(LogJDKHandlerTest.class.toString());
	
	static{
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.CONFIG);
		logger.addHandler(handler);
	}
	
	@Test
	public void testLog(){
		logger.setLevel(Level.INFO);
		logger.finest("��õ���Ϣ");
		logger.finer("�κõ���Ϣ");
		logger.fine("�õ���Ϣ");
		logger.config("���ý�����Ϣ");
		logger.info("��Ϣ�������Ϣ");
		logger.warning("���澯��");
		logger.severe("������Ҫ����");
		
	}

}

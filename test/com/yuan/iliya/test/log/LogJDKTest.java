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

import java.io.File;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

import com.yuan.iliya.main.log.LogFactory;
import com.yuan.iliya.main.log.LogUtil;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class LogJDKTest {
	private static Logger logger = LogFactory.getGlobalLogger();
	private static Logger sysLogger = Logger.getGlobal();
	
	static {
		LogUtil.addFileHandler(sysLogger, Level.INFO, (LogFactory.LOG_FOLDER + "JDK_LOG_" + ".log"));
	}
	
	@Test
	public void testLog(){
		
//		logger.finest("��õ���Ϣ");
//		logger.finer("�κõ���Ϣ");
//		logger.fine("�õ���Ϣ");
//		logger.config("���ý�����Ϣ");
//		logger.info("��Ϣ�������Ϣ");
//		logger.warning("���澯��");
//		logger.severe("������Ҫ����");
	}
	
	@Test
	public void test02(){
		logger.severe("���ǻ���Сʱ");
	}
	@Test
	public void test03(){
		sysLogger.severe("����kepaСʱ");
	}
	

}

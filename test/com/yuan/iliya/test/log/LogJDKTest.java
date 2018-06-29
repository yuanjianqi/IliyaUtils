/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: LogJDKTest.java 
* @Package com.yuan.iliya.test.log 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018年6月29日 下午5:40:06 
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
		
//		logger.finest("最好的消息");
//		logger.finer("次好的消息");
//		logger.fine("好的消息");
//		logger.config("配置界别的消息");
//		logger.info("信息级别的消息");
//		logger.warning("警告警告");
//		logger.severe("服务器要凉了");
	}
	
	@Test
	public void test02(){
		logger.severe("有那汇总小时");
	}
	@Test
	public void test03(){
		sysLogger.severe("有那kepa小时");
	}
	

}

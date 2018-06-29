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
		logger.finest("最好的消息");
		logger.finer("次好的消息");
		logger.fine("好的消息");
		logger.config("配置界别的消息");
		logger.info("信息级别的消息");
		logger.warning("警告警告");
		logger.severe("服务器要凉了");
		
	}

}

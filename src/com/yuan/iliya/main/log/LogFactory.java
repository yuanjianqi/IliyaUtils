/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: LogFactory.java 
* @Package com.yuan.iliya.main.log 
* @Description: 初始化全局Logger的工厂类
* @author Iliya Kaslana    
* @date 2018年6月29日 下午6:11:47 
* @version V1.0   
*/ 

package com.yuan.iliya.main.log;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class LogFactory {
	
	public static final String LOG_NAME = "Global";
	
	public static final String LOG_FOLDER = LogUtil.getRealClassPath();
	
	private static String log_filepath;
	
	private static Logger globalLogger;
	
	static{
		
		log_filepath = (LOG_FOLDER  + "JDK_LOG_" + LogUtil.getCurrentDateStr(LogUtil.DATE_PATTEN_NORMAL)  + ".log");
		File file = new File(log_filepath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		globalLogger = initGlobalLog();
		
	}
	
	public static Logger initGlobalLog(){
		Logger logger = Logger.getLogger(LOG_NAME);
		logger.setLevel(Level.ALL);
		LogUtil.addConsoleHandler(logger);
		LogUtil.addFileHandler(logger, Level.CONFIG, log_filepath);
		
		logger.setUseParentHandlers(false);
		
		return logger;
	}
	/**
	 * 获取全局日志对象
	 * @return
	 */
	public static Logger getGlobalLogger(){
		return globalLogger;
	}

}

/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: LogUtil.java 
* @Package com.yuan.iliya.main.log 
* @Description: 关于JUL的一些操作，如果要获取Logger不应该在此类获取。应该从LogFactory获取
* @author Iliya Kaslana    
* @date 2018年6月29日 下午5:11:20 
* @version V1.0   
*/ 

package com.yuan.iliya.main.log;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class LogUtil {
	
	public static final String DATE_PATTEN_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTEN_NORMAL = "yyyyMMddHHmmss";
	/**
	 * 获得指定等级的Logger
	 * @param clazz
	 * @param level
	 * @return
	 */
	public static Logger getLogger(Class<?> clazz, Level level){
		Logger logger = Logger.getLogger(clazz.toString());
		logger.setLevel(level);
		logger.setUseParentHandlers(false);
		removeHandlers(logger);
		return logger;
		
	}
	
	public static Logger getLogger(Class<?> clazz){
		return getLogger(clazz, Level.INFO);
		
	}
	public static Logger getConsoleLogger(Class<?> clazz){
		Logger logger = getLogger(clazz);
		addConsoleHandler(logger);
		return logger;
		
	}
	public static Logger getConsoleAndFileLogger(Class<?> clazz){
		Logger logger = getConsoleLogger(clazz);
		addFileHandler(logger);
		return logger;
		
	}
	
	public static void addConsoleHandler(Logger logger , Level level){
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(level);
		logger.addHandler(consoleHandler);
		
	}
	
	public static void addConsoleHandler(Logger logger){
		addConsoleHandler(logger, Level.INFO);
		
	}
	
	public static void addFileHandler(Logger logger , Level level, String filePath){
		FileHandler handler = null;
		
		File file = new File(filePath);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			handler = new FileHandler(filePath);
			handler.setLevel(level);
			handler.setFormatter(new Formatter() {
				
				@Override
				public String format(LogRecord record) {
					// TODO Auto-generated method stub
					return "[" + getCurrentDateStr(DATE_PATTEN_FULL) + " - level:" 
							+ record.getLevel().getName().substring(0,1) + " ] - "
							+ "[" + record.getSourceClassName()
							+ " -> " + record.getSourceMethodName() + "()] " 
							+ record.getMessage() + "\n"
							;
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.addHandler(handler);
		
	}
	
	public static void addFileHandler(Logger logger){
		
		addFileHandler(logger, Level.CONFIG, getRealClassPath() + "JDK_LOG" + logger.getName() + ".log");
		
		
	}
	
	public static String getCurrentDateStr(String pattern){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
		
	}
	
	public static String getRealClassPath(){
		return (LogFactory.class.getResource("/").getPath()).substring(1);
	}
	
	public static void removeHandlers(Logger logger){
		for (Handler handler : logger.getHandlers()) {
			logger.removeHandler(handler);
			
		}
	}

}

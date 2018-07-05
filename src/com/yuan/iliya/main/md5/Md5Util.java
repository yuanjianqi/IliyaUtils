/**  
* Copyright (c) All rights reserved.
*
* 
* @Title: Md5Util.java 
* @Package com.yuan.iliya.main.md5 
* @Description: TODO
* @author Iliya Kaslana    
* @date 2018��7��2�� ����5:08:36 
* @version V1.0   
*/ 

package com.yuan.iliya.main.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import com.yuan.iliya.main.log.LogFactory;

/**
 * @author Iliya Kaslana
 *
 * 2018
 */
public class Md5Util {
	private static Logger logger = LogFactory.getGlobalLogger();
	
	/**
	 * ʮ�������ַ���
	 */
	private static final char[] HEX_DEGITS = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	private static MessageDigest messageDigest = null;
	
	static{
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ��ȡ�ļ���MD5ֵ
	 */
	public static String grtFileMD5String(File file){
		String retString = "";
		FileInputStream inputStream = null;
		FileChannel channel = null;
		
		try {
			inputStream  = new FileInputStream(file);
			channel = inputStream.getChannel();
			ByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			messageDigest.update(byteBuffer);
			retString = bytesToHex(messageDigest.digest());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				channel.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retString;
	}

	/**
     * 
     * ��ȡ�ļ���MD5ֵ
     * 
     * @param fileName
     *            Ŀ���ļ�����������
     * @return MD5�ַ���
     */
    public static String getFileMD5String(String fileName) {
        return grtFileMD5String(new File(fileName));
    }

    /**
     * 
     * MD5�����ַ���
     * 
     * @param str
     *            Ŀ���ַ���
     * @return MD5���ܺ���ַ���
     */
    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    /**
     * 
     * MD5������byte�����ʾ���ַ���
     * 
     * @param bytes
     *            Ŀ��byte����
     * @return MD5���ܺ���ַ���
     */
    public static String getMD5String(byte[] bytes) {
        messageDigest.update(bytes);
        return bytesToHex(messageDigest.digest());
    }

    /**
     * 
     * У����������MD5�Ƿ�һ��
     * 
     * @param pwd
     *            �����ַ���
     * @param md5
     *            ��׼MD5ֵ
     * @return ������
     */
    public static boolean checkPassword(String pwd, String md5) {
        return getMD5String(pwd).equalsIgnoreCase(md5);
    }

    /**
     * 
     * У����������MD5�Ƿ�һ��
     * 
     * @param pwd
     *            ���ַ������ʾ������
     * @param md5
     *            ��׼MD5ֵ
     * @return ������
     */
    public static boolean checkPassword(char[] pwd, String md5) {
        return checkPassword(new String(pwd), md5);
    }

    /**
     * 
     * �����ļ���MD5ֵ
     * 
     * @param file
     *            Ŀ���ļ�
     * 
     * @param md5
     *            ��׼MD5ֵ
     * 
     * @return ������
     * 
     */
    public static boolean checkFileMD5(File file, String md5) {
        return grtFileMD5String(file).equalsIgnoreCase(md5);
    }

    /**
     * 
     * �����ļ���MD5ֵ
     * 
     * @param fileName
     *            Ŀ���ļ�����������
     * 
     * @param md5
     *            ��׼MD5ֵ
     * 
     * @return ������
     * 
     */
    public static boolean checkFileMD5(String fileName, String md5) {
        return checkFileMD5(new File(fileName), md5);
    }

    /**
     * 
     * ���ֽ�����ת����16�����ַ���
     * 
     * @param bytes
     *            Ŀ���ֽ�����
     * 
     * @return ת�����
     * 
     */
    public static String bytesToHex(byte bytes[]) {
        return bytesToHex(bytes, 0, bytes.length);
    }

    /**
     * 
     * ���ֽ�������ָ�������������ת����16�����ַ���
     * 
     * @param bytes
     *            Ŀ���ֽ�����
     * 
     * @param start
     *            ��ʼλ�ã�������λ�ã�
     * 
     * @param end
     *            ����λ�ã���������λ�ã�
     * @return ת�����
     * 
     */
    public static String bytesToHex(byte bytes[], int start, int end) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = start; i < start + end; i++) {
            sb.append(byteToHex(bytes[i]));
        }

        return sb.toString();
    }

    /**
     * ˫����ܵ�MD5ֵ
     * @param strSrc
     */
    public static String getSimenMD5(String strSrc) {
        String str1 = getMD5String(strSrc).toLowerCase();
        
        StringBuffer str2 = new StringBuffer("");
        str2.append(str1.substring(0, 2)).append("|")
                .append(str1.substring(4, 10)).append("|")
                .append(str1.substring(8, 21)).append("|")
                .append(str1.substring(14, 19)).append("|")
                .append(str1.substring(1, 9)).append("|")
                .append(str1.substring(24, 27));
        
        return getMD5String(str2.toString());
    }

    /**
     * �������ֽ���ת����16�����ַ���
     * @param bt
     *            Ŀ���ֽ�
     * @return ת�����
     */
    public static String byteToHex(byte bt) {
        return HEX_DEGITS[(bt & 0xf0) >> 4] + "" + HEX_DEGITS[bt & 0xf];
    }
    
    public static void main(String[] args) throws IOException {
        String fileName = "D:/javawed/debug.js";
        String md5 = grtFileMD5String(new File(fileName));
        System.out.println(fileName+"�ļ�MD5�� "+md5);
        
        System.out.println(getSimenMD5("123456"));
    }
}

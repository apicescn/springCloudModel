package com.songshu.sls.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Allen
 * @version 1.0
 *
 */
public abstract class StringUtils {

	private Logger logger = Logger.getLogger(StringUtils.class);

	/**
	 * 得到HttpServletRequest中参数名为key的值，如果为null，则返回长度为0的字符串数组
	 * @param request
	 * @param key request的参数名
	 * @return 如果为null，则返回长度为0的字符串数组
	 */
	public static String[] getRequestValues(HttpServletRequest request,String key){
		String[] parameterValues = request.getParameterValues(key);
		if(null == parameterValues){
			return new String[0];
		}
		return parameterValues;
	}

	/**
	 * MD5 加密
	 * @param inputString
	 * @return
	 */
    public static String getMD5String(String inputString) {
        MessageDigest messageDigest = null;
        try {   
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset(); 
            messageDigest.update(inputString.getBytes("UTF-8"));   
        } catch (NoSuchAlgorithmException e) {   
            System.out.println("NoSuchAlgorithmException caught!");   
            System.exit(-1);   
        } catch (UnsupportedEncodingException e) {   
            e.printStackTrace();   
        }   
   
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StringBuffer = new StringBuffer(); 
        for (int i = 0; i < byteArray.length; i++) {               
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1){ 
                md5StringBuffer.append("0").append(Integer.toHexString(0xFF & byteArray[i]));   
            } else {   
                md5StringBuffer.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }  
        return md5StringBuffer.toString().toUpperCase();   
    }

	/**
	 * 删除掉字符串包括的回车、换行、tab使用空格代替,但是不包括空格
	 * @param input 要转换的字符串
	 * @return 转换之后的字符串
	 */
	public static String replaceWhitespace(String input){
		if(null == input){
			return null;
		}
		Pattern p = Pattern.compile("\\s#|\t|\r|\n");
		Matcher m = p.matcher(input);
		return m.replaceAll(" ");
	}

	/**
	 * 删除掉字符串包括的回车、换行、tab但不使用空格代替,但是不包括空格
	 * @param input 要转换的字符串
	 * @return 转换之后的字符串
	 */
	public static String deleteWhitespace(String input){
		if(null == input){
			return null;
		}
		Pattern p = Pattern.compile("\\s#|\t|\r|\n");
		Matcher m = p.matcher(input);
		return m.replaceAll("");
	}

	/**
	 * 把List里面的值转换成符合输出要求的字符串
	 * @param params
	 * @return 如何params为null，则输出为null
	 */
	public static String listToString(List params) {
		if (null == params) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("长度为：").append(params.size()).append(",  ");
		sb.append("参数为：").append("[");
		for (Iterator iterator = params.iterator(); iterator.hasNext();) {
			Object param = (Object) iterator.next();
			if(null == param){
				sb.append("<NULL值>");
			} else if("".equals(param.toString().replaceAll(" ", ""))) {
				sb.append("<长度为" + param.toString().length() + "空字符串>");
			} else {
				sb.append(param.toString());
			}
			sb.append(",");
		}
		return sb.substring(0,sb.length() -1) + "]";
	}
}
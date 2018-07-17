/**
 * chenPeng
 * com.rwybbs.core
 * WordTruncation.java
 * 创建人:chenpeng
 * 时间：2018年7月14日-下午10:58:11 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.core;

/**
 * 字数截断
 * WordTruncation
 * 创建人:chenPeng
 * 时间：2018年7月14日-下午10:58:11 
 * @version 1.0.0
 * 
 */
public class WordTruncation {
	/**
	 * 截取9个
	 * 方法名：truncation9
	 * 创建人：chenPeng
	 * 时间：2018年7月14日-下午11:04:02 
	 * 手机:17673111810
	 * @param str
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String truncation9(String str){
		if (str.length()<=9) {
			return str;
		}
		return str.substring(0, 9)+"......";
	}
	/**
	 * 截取8个 
	 * 方法名：truncation8
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:07:32 
	 * 手机:17673111810
	 * @param str
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String truncation8(String str){
		if (str.length()<=8) {
			return str;
		}
		return str.substring(0, 8)+"......";
	}
	
	/**
	 * 截取5个 
	 * 方法名：truncation5
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午6:23:18 
	 * 手机:17673111810
	 * @param str
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String truncation5(String str){
		if (str.length()<=5) {
			return str;
		}
		return str.substring(0, 5)+"......";
	}
	
}

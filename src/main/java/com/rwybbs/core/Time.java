/**
 * chenPeng
 * com.rwybbs.core
 * Time.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午10:02:32 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式变换
 * Time
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午10:02:32 
 * @version 1.0.0
 * 
 */
public class Time {
	/**
	 * 生日转换为日期
	 * 方法名：strToDate
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午10:38:55 
	 * 手机:17673111810
	 * @param str
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String strToDate(String str){
		return str.replaceAll("/", "-");
	}
	
	/**
	 * cst转换为data
	 * 方法名：cstToStr
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午10:39:14 
	 * 手机:17673111810
	 * @param str
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	
	@SuppressWarnings("deprecation")
	public String cstToStr(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(Date.parse(str));
	}
}

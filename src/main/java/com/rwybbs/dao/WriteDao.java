/**
 * chenPeng
 * com.rwybbs.dao
 * WriteDao.java
 * 创建人:chenpeng
 * 时间：2018年7月15日-下午9:33:35 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.Write;

/**
 * 
 * WriteDao
 * 创建人:chenPeng
 * 时间：2018年7月15日-下午9:33:35 
 * @version 1.0.0
 * 
 */
public interface WriteDao {
	/**
	 * 得到板块名称
	 * 方法名：getSname
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午9:42:25 
	 * 手机:17673111810
	 * @return List<String>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<String> getSname();
	
	/**
	 * 写论坛
	 * 方法名：setWrite
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:06:14 
	 * 手机:17673111810
	 * @param write void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setWrite(Write write);
	
	/**
	 * 增加文章篇数
	 * 方法名：upDateSTopicCount
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:40:51 
	 * 手机:17673111810
	 * @param sname void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upDateSTopicCount(String sname);
	
}

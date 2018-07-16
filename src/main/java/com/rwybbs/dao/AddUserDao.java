/**
 * chenPeng
 * com.rwybbs.dao
 * GetRwyUserDao.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午4:22:54 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.dao;

import com.rwybbs.bean.BbsUser;
import com.rwybbs.bean.RwyUser;

/**
 * 
 * GetRwyUserDao
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午4:22:54 
 * @version 1.0.0
 * 
 */
public interface AddUserDao {
	/**
	 * 通过用户名取得users表里面的对应用户数据
	 * 方法名：getRwyUser
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午4:25:51 
	 * 手机:17673111810
	 * @param username
	 * @return RwyUser
	 * @exception 
	 * @since  1.0.0
	 */
	public RwyUser getRwyUser(String username);
	
	/**
	 * 写入用户
	 * 方法名：addUser
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午9:16:40 
	 * 手机:17673111810
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addUser(BbsUser user);
}

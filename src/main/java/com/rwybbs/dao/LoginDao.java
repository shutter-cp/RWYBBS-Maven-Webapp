/**
 * chenPeng
 * com.rwybbs.dao
 * LoginDao.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午2:44:10 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.dao;

import com.rwybbs.bean.LoginChact;
import com.rwybbs.bean.UserAndPassword;

/**
 * 
 * LoginDao
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午2:44:10 
 * @version 1.0.0
 * 
 */
public interface LoginDao {
	/**
	 * 登陆检测
	 * 方法名：loginCheck
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午4:03:12 
	 * 手机:17673111810
	 * @param username
	 * @return LoginChact
	 * @exception 
	 * @since  1.0.0
	 */
	public LoginChact loginCheck(String username);
	
	/**
	 * 执行登陆
	 * 方法名：loginDo
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午11:19:02 
	 * 手机:17673111810
	 * @param user
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String loginDo(UserAndPassword user);
}

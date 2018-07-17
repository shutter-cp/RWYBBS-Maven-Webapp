/**
 * chenPeng
 * com.rwybbs.service
 * AddUserService.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午4:34:03 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.BbsUser;
import com.rwybbs.bean.RwyUser;
import com.rwybbs.core.Time;
import com.rwybbs.dao.AddUserDao;

/**
 * 
 * AddUserService
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午4:34:03 
 * @version 1.0.0
 * 
 */
@Service
public class AddUserService {
	@Autowired
	private AddUserDao addUserDao;
	
	/**
	 * 拿到rwy表里面的数据
	 * 方法名：getRwyUser
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午4:41:27 
	 * 手机:17673111810
	 * @param username
	 * @return RwyUser
	 * @exception 
	 * @since  1.0.0
	 */
	public RwyUser getRwyUser(String username){
		return addUserDao.getRwyUser(username);
	}
	
	/**
	 * 写入
	 * 方法名：addUser
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午9:44:24 
	 * 手机:17673111810
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	 */
	public void addUser(BbsUser user){
		Time time = new Time();
		user.setUbirthday(time.strToDate(user.getUbirthday()));
		user.setUregDate(time.cstToStr(user.getUregDate()));
		addUserDao.addUser(user);
	}
}

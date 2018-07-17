/**
 * chenPeng
 * com.rwybbs.service
 * LoginUserService.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午2:43:37 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.LoginChact;
import com.rwybbs.bean.UserAndPassword;
import com.rwybbs.dao.LoginDao;

/**
 * 
 * LoginUserService
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午2:43:37 
 * @version 1.0.0
 * 
 */
@Service
public class LoginUserService {
	@Autowired 
	private LoginDao loginDao;
	
	@Autowired
	private HttpServletRequest re;
	
	/**
	 * 原项目过来的判断bbs中是否有这个
	 * 方法名：loginCheck
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午3:08:20 
	 * 手机:17673111810
	 * @param username
	 * @return MoneyUser
	 * @exception 
	 * @since  1.0.0
	 */
	public LoginChact loginCheck(String username){
		return loginDao.loginCheck(username);
	}
	
	/**
	 * 登陆
	 * 方法名：loginService
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午11:21:04 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String loginService(String username,String password){
		UserAndPassword users = new UserAndPassword();
		users.setPassword(password);
		users.setUsername(username);
		String user = loginDao.loginDo(users);
		if (user!=null) {
			re.getSession().setAttribute("username", user);
		}
		return user;
	}
	
	/**
	 * 版主登陆
	 * 方法名：moderatorLoginDog
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午12:56:26 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String moderatorLoginDo(String username,String password){
		UserAndPassword users = new UserAndPassword();
		users.setPassword(password);
		users.setUsername(username);
		String moderator = loginDao.moderatorLoginDo(users);
		if (moderator!=null) {
			re.getSession().setAttribute("moderator", moderator);
		}
		return moderator;
	}
	
	/**
	 * 管理员登陆
	 * 方法名：adminLoginDo
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午3:05:22 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public String adminLoginDo(String username,String password){
		UserAndPassword users = new UserAndPassword();
		users.setPassword(password);
		users.setUsername(username);
		String admin = loginDao.adminLoginDo(users);
		if (admin!=null) {
			re.getSession().setAttribute("admin", admin);
		}
		return admin;
	}
	
}

/**
 * chenPeng
 * com.cp.core
 * LoginCore.java
 * 创建人:chenpeng
 * 时间：2017年12月14日-上午9:02:50 
 * 2017陈鹏-版权所有
 */
package com.rwybbs.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 登陆拦截器
 * LoginCore
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午11:37:57 
 * @version 1.0.0
 *
 */
public class LoginCore implements HandlerInterceptor{
	//资源的销毁
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
	//ModelAndView可以改变返回消息
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}
	
	//返回值 表示是否拦截
	//如果返回false 拦截终止
	//返回true 拦截继续
	//Object 表示被拦截的请求模板的对象
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		if(arg0.getSession().getAttribute("username") == null){
			//arg0.getRequestDispatcher("/login").forward(arg0, arg1);
			arg1.sendRedirect("http://47.95.220.233/RWY");
			return false;
		}
		return true;
	}
	
}

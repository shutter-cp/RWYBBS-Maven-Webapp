/**
 * chenPeng
 * com.rwybbs.web
 * RwyMoneyWeb.java
 * 创建人:chenpeng
 * 时间：2018年7月11日-上午10:21:38 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.MoneyUser;
import com.rwybbs.service.RwyMoneyService;

/**
 * 
 * RwyMoneyWeb
 * 创建人:chenPeng
 * 时间：2018年7月11日-上午10:21:38 
 * @version 1.0.0
 * 
 */
@Controller
public class RwyMoneyWeb {
	
	@Autowired
	private RwyMoneyService rwyMoneyService;
	
	/**
	 * 从原来的项目跳转到此项目的支付页面
	 * 方法名：intoPay
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-上午10:31:06 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/pay")
	public ModelAndView intoPay(
			@RequestParam("username") String username){
		ModelAndView andView = new ModelAndView();
		
		List<MoneyUser> user = rwyMoneyService.MoneyService(username);
		if (user==null) {
			andView.setViewName("404");
			return andView;
		}
		andView.setViewName("pay");
		andView.addObject("username", user.get(0));
		
		return andView;
	}
	
	/**
	 * 从原来的项目跳转到此项的提现页面
	 * 方法名：initWithdraw
	 * 创建人：lxf
	 * 时间：2018年7月13日-上午10:31:36 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/withdraw")
	public ModelAndView initWithdraw(
			@RequestParam("username") String username){
		ModelAndView andView = new ModelAndView("redirect:/404.htm");
		
		List<MoneyUser> user = rwyMoneyService.MoneyService(username);
		if (user==null) {
			andView.setViewName("404");
			return andView;
		}
		andView.setViewName("withdraw");
		andView.addObject("username", user.get(0));
		return andView;
	}
	

}



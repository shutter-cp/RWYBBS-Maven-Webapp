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
}

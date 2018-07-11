/**
 * chenPeng
 * com.rwybbs.web
 * Test.java
 * 创建人:chenpeng
 * 时间：2018年7月9日-下午11:35:13 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.TestUser;
import com.rwybbs.dao.TestDao;

/**
 * 
 * Test
 * 创建人:chenPeng
 * 时间：2018年7月9日-下午11:35:13 
 * @version 1.0.0
 * 
 */
@Controller
public class TestWeb {
	@Autowired
	private TestDao testDao;
	
	@RequestMapping("/test")
	public ModelAndView test(){
		ModelAndView andView = new ModelAndView();
		List<TestUser> users = testDao.test();
		for (TestUser testUser : users) {
			System.out.println(testUser.getId()+"      "+testUser.getUsername());
		}
		andView.addObject("users", users);
		andView.setViewName("test");
		System.out.println(1);
		return andView;
	}
	@RequestMapping("/paytest")
	public ModelAndView test1(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("pay");
		return andView;
	}
	@RequestMapping("/withdrawtest")
	public ModelAndView test2(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("withdraw");
		return andView;
	}
	
}

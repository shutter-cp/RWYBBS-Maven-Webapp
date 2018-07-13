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
	@RequestMapping("/testForm")
	public ModelAndView test3(String username){
		ModelAndView andView = new ModelAndView();
		System.out.println(username);
		andView.setViewName("pay");
		return andView;
	}
	
	
	@RequestMapping("/bbs/index")
	public ModelAndView test4(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("bbs/bbsindex");
		return andView;
	}
	@RequestMapping("/bbs/note")
	public ModelAndView test5(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("bbs/bbsnote");
		return andView;
	}
	@RequestMapping("/bbs/write")
	public ModelAndView test6(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("bbs/bbswrite");
		return andView;
	}
	@RequestMapping("/bbs/adduser")
	public ModelAndView test7(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("bbs/bbsadduser");
		return andView;
	}
	@RequestMapping("/bbs/list")
	public ModelAndView test8(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("bbs/bbslist");
		return andView;
	}
	@RequestMapping("/bbs/admin")
	public ModelAndView test9(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("bbs/bbsadmin");
		return andView;
	}
	@RequestMapping("/bbs/moderator")
	public ModelAndView test10(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("bbs/bbsmoderator");
		return andView;
	}
	@RequestMapping("/bbs/userindex")
	public ModelAndView test11(){
		ModelAndView andView = new ModelAndView();
		andView.setViewName("bbs/bbsuserindex");
		return andView;
	}
	
}

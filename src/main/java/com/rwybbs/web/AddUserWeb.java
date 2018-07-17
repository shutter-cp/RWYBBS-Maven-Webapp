/**
 * chenPeng
 * com.rwybbs.web
 * AddUserWeb.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午5:15:38 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.BbsUser;
import com.rwybbs.service.AddUserService;

/**
 * 
 * AddUserWeb
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午5:15:38 
 * @version 1.0.0
 * 
 */
@Controller
public class AddUserWeb {
	
	@Autowired
	private AddUserService addUserService;
	
	@RequestMapping("/addUserDo")
	public ModelAndView addUser(
			Integer uid,
			String uname,
			String password,
			String umailbox,
			Integer upoint,
			String uregdate,
			String uhead,
			Integer sex,
			String birth,
			String satement
			){
		ModelAndView andView = new ModelAndView(
				"redirect:/login?username="+uname);
		
		
		BbsUser bbsUser = new BbsUser();
		bbsUser.setUid(uid);
		bbsUser.setUname(uname);
		bbsUser.setUpassword(password);
		bbsUser.setUemail(umailbox);
		bbsUser.setUpoint(upoint);
		bbsUser.setUregDate(uregdate);
		bbsUser.setUhead(uhead);
		bbsUser.setUsex(sex);
		bbsUser.setUbirthday(birth);
		bbsUser.setUsatement(satement);
		bbsUser.setUisSectioner(0);
		bbsUser.setUstate(1);
		
		addUserService.addUser(bbsUser);
		
		return andView;
	}
	
	

}

/**
 * chenPeng
 * com.rwybbs.web
 * LoginUserWeb.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午12:01:37 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.rwybbs.bean.LoginChact;
import com.rwybbs.bean.RwyUser;
import com.rwybbs.service.AddUserService;
import com.rwybbs.service.LoginUserService;

/**
 * 
 * LoginUserWeb
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午12:01:37 
 * @version 1.0.0
 * 
 */
@Controller
public class LoginUserWeb {
	@Autowired
	private LoginUserService loginUserService;
	@Autowired
	private AddUserService addUserService;
	
	/**
	 * 登陆判断账户是不是第一次来论坛
	 * 方法名：login
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午3:15:01 
	 * 手机:17673111810
	 * @param username
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username")
					String username){
		ModelAndView andView = new ModelAndView();
		LoginChact user = loginUserService.loginCheck(username);
		//bbs数据库查到值就进login页面
		if (user!=null) {
			System.out.println(user.getUname()+"===="+user.getUPoint());
			andView.addObject("user", user);
			andView.setViewName("login");
			return andView;
		}
		//user表里面查到值就进
		RwyUser users = addUserService.getRwyUser(username);
		if (users!=null) {
			andView.addObject("user", users);
			andView.setViewName("bbs/bbsadduser");
			return andView;
		}
		andView.setViewName("404");
		return andView;
	}
	
	/**
	 * 登陆
	 * 方法名：loginDo
	 * 创建人：chenPeng
	 * 时间：2018年7月13日-下午11:54:44 
	 * 手机:17673111810
	 * @param username
	 * @param password
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("/loginDo")
	public ModelAndView loginDo(String username,String password){
		String user = loginUserService.loginService(username, password);
		if (user==null) {
			return new ModelAndView("redirect:/密码错误404");
		}
		System.out.println(user);
		return new ModelAndView("redirect:/bbs/index");
	}
	
	
}

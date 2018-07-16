/**
 * Shanice
 * com.rwybbs.web
 * UserAndPassword.java
 * 创建人:Shanice
 * 时间：2018年7月15日-下午5:53:44
 * 2018Shancie-版权所有
 */
package com.rwybbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * UserIndexWeb
 * 创建人:Shanice
 * 时间：2018年7月15日-下午5:53:44 
 * @version 1.0.0
 *
 */
@Controller
public class UserIndexWeb {
	/**
	 * 
	 * 测试连接网页
	 * 方法名：intoUserIndex
	 * 创建人：Shanice
	 * 时间：2018年7月15日-下午11:22:42 
	 * 手机:15873158820
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("bbs/bbsuserindex")
	public ModelAndView intoUserIndex(){
		ModelAndView andview =new ModelAndView();
		andview.setViewName("bbs/bbsuserindex");
		
		return andview; 
	}
	
}

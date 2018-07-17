/**
 * Shanice
 * com.rwybbs.web
 * UserAndPassword.java
 * 创建人:Shanice
 * 时间：2018年7月15日-下午5:53:44
 * 2018Shancie-版权所有
 */
package com.rwybbs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.UserIndexArticle;
import com.rwybbs.bean.UserIndexDeletes;
import com.rwybbs.bean.UserIndexMessage;
import com.rwybbs.bean.UserIndexPerson;
import com.rwybbs.core.IsNull;
import com.rwybbs.service.RwyUserIndexService;

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
	@Autowired
	private HttpServletRequest re;
	@Autowired
	private RwyUserIndexService rwyUserIndexService;
	
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
		String username = (String)re.getSession().getAttribute("username");
		UserIndexPerson person = rwyUserIndexService.userIndexPerson(username);
		List<UserIndexArticle> articleList = 
				rwyUserIndexService.userIndexArticle(person.getUid());
		List<UserIndexMessage> messageList = 
				rwyUserIndexService.userIndexMessage(person.getUid());
		andview.addObject("person", person);
		andview.addObject("articleList", articleList);
		andview.addObject("messageList", messageList);
		andview.setViewName("bbs/bbsuserindex");
		return andview; 
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/bbs/bbsuserindex/deletes")
	@ResponseBody
	public String setRplay(HttpServletRequest re){
		String no = re.getParameter("no");
		String username = (String) re.getSession().getAttribute("username");
		System.out.println(no);
		System.out.println(username);
		UserIndexDeletes user = new UserIndexDeletes();
		user.setTid(Integer.parseInt(no));
		user.setUsername(username);
		
		rwyUserIndexService.deleteArticle(user);
		return "success";
	}
}

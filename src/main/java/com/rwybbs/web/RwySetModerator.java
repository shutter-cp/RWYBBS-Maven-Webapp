package com.rwybbs.web;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.service.RwyAdminService;
import com.rwybbs.service.RwySetModeratorService;


@Controller
public class RwySetModerator {
	@Autowired
	private HttpServletRequest rq;
	@Autowired
	private RwySetModeratorService rwySetModeratorService;
	
	@RequestMapping(method=RequestMethod.POST,value="/bbs/admin/set")
	@ResponseBody
	public String setRplay(HttpServletRequest re){
		String uname = re.getParameter("uname");
		re.getSession().setAttribute("uname", uname);
		return "success";
	}
	
	@RequestMapping("/bbs/admin/setmoderator")
	public ModelAndView intosetmoderatorlist(){
		ModelAndView andView = new ModelAndView();
		String uname = (String) rq.getSession().getAttribute("uname");
		
		andView.setViewName("bbs/setmoderator");
		andView.addObject("unames", uname);
		return andView;
	}
	
	@RequestMapping("/bbs/admin/setmoderatorDo")
	public ModelAndView setmoderatordo(String SName,String UName,
			String SProfile,String SStatement){
		ModelAndView andView = new ModelAndView("redirect:/bbs/admin");	
		rwySetModeratorService.SMFService(SName, UName, SProfile, SStatement);
		return andView;
	}
}

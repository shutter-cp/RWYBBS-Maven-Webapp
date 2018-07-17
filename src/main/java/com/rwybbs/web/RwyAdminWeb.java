package com.rwybbs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.TopicWithAdmin;
import com.rwybbs.bean.UsersWithAdmin;
import com.rwybbs.service.RwyAdminService;

/**
 * 
 * 
 * RwyForumWeb
 * 创建人:lxf
 * 时间：2018年7月13日-下午5:25:36 
 * @version 1.0.0
 *
 */
@Controller
public class RwyAdminWeb {
	
	@Autowired
	private RwyAdminService rwyAdminService;
	
	@RequestMapping("/bbs/admin")
	public ModelAndView UWAList(){
		ModelAndView andView = new ModelAndView();
		List<UsersWithAdmin> uwa=rwyAdminService.UWAService();
		List<TopicWithAdmin> twa=rwyAdminService.TWAService();
		if (uwa==null && twa==null) {
			andView.setViewName("404");
			return andView;
		}
		andView.setViewName("bbs/bbsadmin");
		andView.addObject("uwa", uwa);
		andView.addObject("twa", twa);
		return andView;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/bbs/admin/deleteuser")
	@ResponseBody
	public String setRplay(HttpServletRequest re){
		String uname = re.getParameter("uname");
		rwyAdminService.UMADService(uname);
		return "success";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/bbs/admin/deletetopic")
	@ResponseBody
	public String deleteTopic(HttpServletRequest re){
		String TTopic = re.getParameter("TTopic");
		Integer TID = Integer.parseInt(re.getParameter("TID"));
		String UName = re.getParameter("UName");
		rwyAdminService.TMADService(TTopic,TID,UName);
		return "success";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/bbs/admin/updatetopic")
	@ResponseBody
	public String updateTopic(HttpServletRequest re){
		String TTopic = re.getParameter("TTopic");
		Integer TID = Integer.parseInt(re.getParameter("TID"));
		String UName = re.getParameter("UName");
		rwyAdminService.TMAUService(TTopic,TID,UName);
		return "success";
	}
	
	@RequestMapping("/bbs/moderator")
	public ModelAndView TWMList(){
		String UName="810226a";
		ModelAndView andView = new ModelAndView();
		List<TopicWithAdmin> twa=rwyAdminService.TWMService(UName);
		if (twa==null) {
			andView.setViewName("404");
			return andView;
		}
		andView.setViewName("bbs/bbsmoderator");
		andView.addObject("twm", twa);
		return andView;
	}
}



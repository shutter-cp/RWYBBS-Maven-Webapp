package com.rwybbs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@Autowired
	private HttpServletRequest rq;
	
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
	@RequestMapping(method=RequestMethod.POST,value="/bbs/moderator/deletetopic")
	@ResponseBody
	public String deleteTopicm(HttpServletRequest re){
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
	@RequestMapping(method=RequestMethod.POST,value="/bbs/moderator/updatetopic")
	@ResponseBody
	public String updateTopicm(HttpServletRequest re){
		String TTopic = re.getParameter("TTopic");
		Integer TID = Integer.parseInt(re.getParameter("TID"));
		String UName = re.getParameter("UName");
		rwyAdminService.TMAUService(TTopic,TID,UName);
		return "success";
	}
	@RequestMapping("/bbs/moderator")
	public ModelAndView TWMList(){
		String UName= (String) rq.getSession().getAttribute("moderator");
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
	@RequestMapping(method=RequestMethod.POST,value="/bbs/admin/foundtopic",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String foundTopic(HttpServletRequest re){
		String TTopic = re.getParameter("TTopic");
		List<TopicWithAdmin> twaslist = rwyAdminService.TWASService(TTopic);
		StringBuffer sb = new StringBuffer();
		
		String temp = "";
		for (TopicWithAdmin topicWithAdmin : twaslist) {
			temp = "<tr><td>"+topicWithAdmin.getTID()
					+"</td><td>"+topicWithAdmin.getTTopic()
					+"</td><td>"+topicWithAdmin.getSName()
					+"</td><td>"+topicWithAdmin.getUName()
					+"</td><td>"+topicWithAdmin.getTTime()
					+"</td><td>"+topicWithAdmin.getTFlag()
					+"<td><button onclick=\"dt('"
					+topicWithAdmin.getTTopic()
					+"','"+topicWithAdmin.getTID()
					+"','"+topicWithAdmin.getUName()
					+"')\"  class=\"ui red button\">删除</button>"
					+ "<button onclick=\"ut('"
					+topicWithAdmin.getTTopic()
					+"','"
					+topicWithAdmin.getTID()
					+"','"
					+topicWithAdmin.getUName()
					+"')\" class=\"ui teal button\">审核</button></td><tr>";
			sb.append(temp);
			temp = "";
		}
		return sb.toString();
	}
	@RequestMapping(method=RequestMethod.POST,value="/bbs/admin/founduser",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String foundUser(HttpServletRequest re){
		String UName = re.getParameter("UName");
		List<UsersWithAdmin> uwaslist = rwyAdminService.UWASService(UName);
		StringBuffer sb = new StringBuffer();
		
		String temp = "";
		for (UsersWithAdmin usersWithAdmin : uwaslist) {
			temp = "<tr><td>"+usersWithAdmin.getUName()
					+"</td><td>"+usersWithAdmin.getUEmail()
					+"</td><td>"+usersWithAdmin.getURegDate()
					+"</td><td>"+usersWithAdmin.getUState()
					+"</td><td>"+usersWithAdmin.getUPoint()
					+"</td><td>"+usersWithAdmin.getUIsSectioner()
					+"<td><button onclick=\"du('"
					+usersWithAdmin.getUName()
					+"')\"  class=\"ui red button\">删除</button>"
					+ "<button class=\"ui teal button\" onclick=\"sm('"
					+usersWithAdmin.getUName()
					+"')\" class=\"ui teal button\">设定版主</button></td><tr>";
			sb.append(temp);
			temp = "";
		}
		return sb.toString();
	}
	@RequestMapping(method=RequestMethod.POST,value="/bbs/moderator/foundtopicm",produces = "application/String; charset=utf-8")
	@ResponseBody
	public String foundTopicM(HttpServletRequest re){
		String TTopic = re.getParameter("TTopic");
		String UName = (String) re.getSession().getAttribute("moderator");
		List<TopicWithAdmin> twaslist = rwyAdminService.TWMSService(UName, TTopic);
		StringBuffer sb = new StringBuffer();
		String temp = "";
		for (TopicWithAdmin topicWithAdmin : twaslist) {
			temp = "<tr><td>"+topicWithAdmin.getTID()
					+"</td><td>"+topicWithAdmin.getTTopic()
					+"</td><td>"+topicWithAdmin.getSName()
					+"</td><td>"+topicWithAdmin.getUName()
					+"</td><td>"+topicWithAdmin.getTTime()
					+"</td><td>"+topicWithAdmin.getTFlag()
					+"<td><button onclick=\"dt('"
					+topicWithAdmin.getTTopic()
					+"','"+topicWithAdmin.getTID()
					+"','"+topicWithAdmin.getUName()
					+"')\"  class=\"ui red button\">删除</button>"
					+ "<button onclick=\"ut('"
					+topicWithAdmin.getTTopic()
					+"','"
					+topicWithAdmin.getTID()
					+"','"
					+topicWithAdmin.getUName()
					+"')\" class=\"ui teal button\">审核</button></td><tr>";
			sb.append(temp);
			temp = "";
		}
		return sb.toString();
	}
}



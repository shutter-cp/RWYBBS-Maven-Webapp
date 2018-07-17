package com.rwybbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.Forum;
import com.rwybbs.bean.ForumList;
import com.rwybbs.bean.Topic;
import com.rwybbs.service.RwyForumService;

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
public class RwyForumWeb {
	
	@Autowired
	private RwyForumService rwyForumService;
	
	@RequestMapping("/bbs/Forumlist/{SProfile}/{SID}/{Page}")
	public ModelAndView intoForumlist(
			@PathVariable Integer SID,@PathVariable String SProfile,@PathVariable Integer Page){
		ModelAndView andView = new ModelAndView();
		
		List<Forum> forum = rwyForumService.ForumService(SID);
		List<Topic> topic =rwyForumService.TopicService(SID,Page);
		List<ForumList> forumlist=rwyForumService.ForumListService("全景业界资讯");
		List<ForumList> forumlist2=rwyForumService.ForumListService("全景作品");
		List<ForumList> forumlist3=rwyForumService.ForumListService("生活纪实");
		List<ForumList> forumlist4=rwyForumService.ForumListService("全景学苑");
		List<ForumList> forumlist5=rwyForumService.ForumListService("资源下载");
		List<ForumList> forumlist6=rwyForumService.ForumListService("交流分享");
		Integer pagecount=rwyForumService.PageCountService(SID);		
		if (forum==null && topic==null) {
			andView.setViewName("404");
			return andView;
		}
		
		andView.setViewName("bbs/bbslist");
		andView.addObject("SProfile", SProfile);
		andView.addObject("forum", forum.get(0));
		andView.addObject("topic", topic);
		andView.addObject("forumlist", forumlist);
		andView.addObject("forumlist2", forumlist2);
		andView.addObject("forumlist3", forumlist3);
		andView.addObject("forumlist4", forumlist4);
		andView.addObject("forumlist5", forumlist5);
		andView.addObject("forumlist6", forumlist6);
		
		if(pagecount==null){
			andView.addObject("pagecount", 1);
		}else{
			andView.addObject("pagecount", pagecount/10+1);
		}
		return andView;
	}


}



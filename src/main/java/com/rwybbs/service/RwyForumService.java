package com.rwybbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.Forum;
import com.rwybbs.bean.ForumList;
import com.rwybbs.bean.PageCount;
import com.rwybbs.bean.Topic;
import com.rwybbs.core.ForumCore;
import com.rwybbs.dao.RwyForumDao;


/**
 * 
 * 
 * RwyForumService
 * 创建人:lxf
 * 时间：2018年7月13日-下午3:57:26 
 * @version 1.0.0
 *
 */
@Service
public class RwyForumService {
	@Autowired
	private RwyForumDao rwyForumDao;
	
	public List<Forum> ForumService(Integer SID){
		Forum forum = new Forum();
		forum.setSID(SID);
		List<Forum> forumlist = rwyForumDao.forum(forum);
		if (forumlist.size()==0) {
			return null;
		}
		return forumlist;
	}
	public List<Topic> TopicService(Integer SID,Integer Page){
		Topic topic = new Topic();
		Page=(Page-1)*10;
		topic.setSID(SID);
		topic.setPage(Page);
		List<Topic> topiclist =  rwyForumDao.topic(topic);
		if (topiclist.size()==0) {
			return null;
		}
		return topiclist;
	}
	
	public List<ForumList> ForumListService(String SProfile){
		ForumList forumlist = new ForumList();
		forumlist.setSProfile(SProfile);
		List<ForumList> forumlists = rwyForumDao.forumlist(forumlist);
		if (forumlists.size()==0) {
			return null;
		}
		return forumlists;
	}
	
	public Integer PageCountService(Integer SID){
		PageCount pagecount=new PageCount();
		pagecount.setSID(SID);
		Integer pagecounts;
		pagecounts= rwyForumDao.pagecount(SID);
		if (pagecounts==0) {
			return null;
		}
		return pagecounts;
	}
}

package com.rwybbs.core;

import java.util.List;

import com.rwybbs.bean.Topic;

public class ForumCore {
	public List<Topic> Topicsize(List<Topic> topiclist){
//	限制帖子标题字数
	for (Topic topic2 : topiclist) {
		if(topic2.getTTopic().length()<=30){
			return topiclist;
		}
		topic2.setTTopic(topic2.getTTopic().substring(0,30)+"......");
		
	}
		return topiclist;
	}
}

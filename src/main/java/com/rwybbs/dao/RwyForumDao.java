package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.Forum;
import com.rwybbs.bean.ForumList;
import com.rwybbs.bean.Topic;

public interface RwyForumDao {
	/**
	 * 通过主题ID获取主题信息
	 * 方法名：forum
	 * 创建人：lxf
	 * 时间：2018年7月13日-下午3:20:54 
	 * 手机:18973117682
	 * @return List<Forum>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Forum> forum(Forum forum);
	
	/**
	 * 通过主题ID获取主题中所有帖子的信息
	 * 方法名：forum
	 * 创建人：lxf
	 * 时间：2018年7月13日-下午3:20:54 
	 * 手机:18973117682
	 * @return List<Forum>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Topic> topic(Topic topic);
	/**
	 * 通过版块名获取所有主题ID
	 * 方法名：forumlist
	 * 创建人：lxf
	 * 时间：2018年7月15日-上午11:14:18 
	 * 手机:18973117682
	 * @param forumlist
	 * @return List<ForumList>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<ForumList> forumlist(ForumList forumlist);
	/**
	 * 通过SID获取总共数据量
	 * 方法名：pagecount
	 * 创建人：lxf
	 * 时间：2018年7月15日-下午4:16:41 
	 * 手机:18973117682
	 * @param SID
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer pagecount(Integer SID);
	}

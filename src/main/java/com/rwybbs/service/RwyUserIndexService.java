/**
 * Shanice
 * com.rwybbs.service;
 * 
 * RwyUserIndex
 * 创建人:Shanice
 * 时间：2018年7月15日-下午11:52:37 
 * @version 1.0.0
 *
 */
package com.rwybbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.UserIndexArticle;
import com.rwybbs.bean.UserIndexDeletes;
import com.rwybbs.bean.UserIndexMessage;
import com.rwybbs.bean.UserIndexPerson;
import com.rwybbs.core.WordTruncation;
import com.rwybbs.dao.RwyUserIndexDao;

/**
 * 
 * 
 * RwyUserIndexService
 * 创建人:Shanice
 * 时间：2018年7月15日-下午11:55:53 
 * @version 1.0.0
 *
 */
@Service
public class RwyUserIndexService {

	@Autowired
	private RwyUserIndexDao rwyUserIndexDao;
	
	/**
	 * 
	 * 接收个人信息的数据
	 * 方法名：userIndexPerson
	 * 创建人：Shanice
	 * 时间：2018年7月17日-上午8:51:30 
	 * 手机:15873158820
	 * @param uname
	 * @return UserIndexPerson
	 * @exception 
	 * @since  1.0.0
	 */
	public UserIndexPerson userIndexPerson(String uname){
		return rwyUserIndexDao.userIndexPerson(uname);
	}
	
	/**
	 * 
	 * 接收发表的帖子的数据
	 * 方法名：userIndexArticle
	 * 创建人：Shanice
	 * 时间：2018年7月17日-上午8:53:09 
	 * 手机:15873158820
	 * @param tuid
	 * @return UserIndexArticle
	 * @exception 
	 * @since  1.0.0
	 */
	public List<UserIndexArticle> userIndexArticle(Integer tuid){
		return rwyUserIndexDao.userIndexArticle(tuid);
	}
	
	/**
	 * 
	 * 接收我的消息的数据
	 * 方法名：userIndexMessage
	 * 创建人：Shanice
	 * 时间：2018年7月17日-上午8:54:19 
	 * 手机:15873158820
	 * @param tid
	 * @return UserIndexMessage
	 * @exception 
	 * @since  1.0.0
	 */
	public List<UserIndexMessage> userIndexMessage(Integer tid){
		List<UserIndexMessage> message = rwyUserIndexDao.userIndexMessage(tid); 
		
		WordTruncation word = new WordTruncation();
		
		for (UserIndexMessage userIndexMessage : message) {
			userIndexMessage.setRcontent(
					word.truncation5(userIndexMessage.getRcontent()));
		}
		
		return message;
	}
	
	/**
	 * 
	 * 删除
	 * 方法名：userIndexMessage
	 * 创建人：Shanice
	 * 时间：2018年7月17日-上午8:54:19 
	 * 手机:15873158820
	 * @param tid
	 * @return UserIndexMessage
	 * @exception 
	 * @since  1.0.0
	 */
	public void deleteArticle(UserIndexDeletes user){
		rwyUserIndexDao.deleteArticle(user);
	}
}

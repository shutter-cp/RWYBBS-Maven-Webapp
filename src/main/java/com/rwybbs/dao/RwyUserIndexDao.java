/**
 * Shanice
 * com.rwybbs.dao
 * UserAndPassword.java
 * 创建人:Shanice
 * 时间：2018年7月15日-下午11:20:54 
 * 2018Shancie-版权所有
 */
package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.UserIndexArticle;
import com.rwybbs.bean.UserIndexDeletes;
import com.rwybbs.bean.UserIndexMessage;
import com.rwybbs.bean.UserIndexPerson;

/**
 * 
 * 
 * RwyUserIndexDo
 * 创建人:Shanice
 * 时间：2018年7月15日-下午11:20:54 
 * @version 1.0.0
 *
 */

public interface RwyUserIndexDao {
	/**
	 * 
	 * 通过uname获取个人信息的数据
	 * 方法名：userindex
	 * 创建人：Shanice
	 * 时间：2018年7月15日-下午11:32:16 
	 * 手机:15873158820
	 * @param uid
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public UserIndexPerson userIndexPerson(String uname);

	/**
	 * 
	 * 通过tuid获取发表的帖子的数据
	 * 方法名：userIndexArticle
	 * 创建人：Shanice
	 * 时间：2018年7月17日-上午8:32:18 
	 * 手机:15873158820
	 * @param tuid
	 * @return UserIndexArticle
	 * @exception 
	 * @since  1.0.0
	 */
	public List<UserIndexArticle> userIndexArticle(Integer tuid);
	
	/**
	 * 
	 * 通过tid获取收到的消息的数据
	 * 方法名：userIndexMessage
	 * 创建人：Shanice
	 * 时间：2018年7月17日-上午8:33:29 
	 * 手机:15873158820
	 * @param tid
	 * @return UserIndexMessage
	 * @exception 
	 * @since  1.0.0
	 */
	public List<UserIndexMessage> userIndexMessage(Integer tid);
	
	/**
	 * 删除
	 * 方法名：deleteArticle
	 * 创建人：Shanice
	 * 时间：2018年7月17日-上午10:11:55 
	 * 手机:15873158820
	 * @param user void
	 * @exception 
	 * @since  1.0.0
	 */
	public void deleteArticle(UserIndexDeletes user);
}

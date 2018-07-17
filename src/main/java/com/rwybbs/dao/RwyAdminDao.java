package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.SetModeratorForum;
import com.rwybbs.bean.TopicWithAdmin;
import com.rwybbs.bean.UsersWithAdmin;

public interface RwyAdminDao {
	/**
	 * 遍历所有用户信息 
	 * 方法名：uwm
	 * 创建人：lxf
	 * 时间：2018年7月16日-上午9:41:46 
	 * 手机:18973117682
	 * @param uwm
	 * @return List<UsersWithModerator>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<UsersWithAdmin> uwa();
	/**
	 * 通过用户输入的用户名模糊查询
	 * 方法名：uwas
	 * 创建人：lxf
	 * 时间：2018年7月17日-上午10:27:19 
	 * 手机:18973117682
	 * @param UName
	 * @return List<TopicWithAdmin>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<UsersWithAdmin> uwas(String UName);
	
	/**
	 * 传用户名来修改用户状态 
	 * 方法名：uwad
	 * 创建人：lxf
	 * 时间：2018年7月16日-下午4:45:03 
	 * 手机:18973117682
	 * @param uwa void
	 * @exception 
	 * @since  1.0.0
	 */
	public void uwad(UsersWithAdmin uwa);
	
	/**
	 * 遍历所有帖子信息
	 * 方法名：twa
	 * 创建人：lxf
	 * 时间：2018年7月16日-下午6:02:45 
	 * 手机:18973117682
	 * @return List<TopicWithAdmin>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<TopicWithAdmin> twa();
	/**
	 * 通过用户输入的帖子标题模糊查询 
	 * 方法名：twas
	 * 创建人：lxf
	 * 时间：2018年7月17日-上午10:20:00 
	 * 手机:18973117682
	 * @return List<TopicWithAdmin>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<TopicWithAdmin> twas(String TTopic);
	
	/**
	 * 传帖子名来删除帖子
	 * 方法名：twad
	 * 创建人：lxf
	 * 时间：2018年7月16日-下午5:39:35 
	 * 手机:18973117682
	 * @param twa void
	 * @exception 
	 * @since  1.0.0
	 */
	public void twad(TopicWithAdmin twa);
	
	/**
	 * 传帖子名来修改审核状态
	 * 方法名：twau
	 * 创建人：lxf
	 * 时间：2018年7月16日-下午5:41:11 
	 * 手机:18973117682
	 * @param twa void
	 * @exception 
	 * @since  1.0.0
	 */
	public void twau(TopicWithAdmin twa);
	/**
	 * 通过传进来的版主用户名，获取他的版块帖子
	 * 方法名：twm
	 * 创建人：lxf
	 * 时间：2018年7月17日-上午9:48:30 
	 * 手机:18973117682
	 * @param twa
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public List<TopicWithAdmin> twm(String UName);
	/**
	 * 通过用版主输入的帖子标题模糊查询
	 * 方法名：twms
	 * 创建人：lxf
	 * 时间：2018年7月17日-上午10:29:49 
	 * 手机:18973117682
	 * @param twa
	 * @return List<TopicWithAdmin>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<TopicWithAdmin> twms(TopicWithAdmin twa);
	
}

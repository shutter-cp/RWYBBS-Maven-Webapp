/**
 * chenPeng
 * com.rwybbs.dao
 * IndexInitDao.java
 * 创建人:chenpeng
 * 时间：2018年7月14日-下午10:37:04 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.IndexFourm;
import com.rwybbs.bean.IndexRplay;
import com.rwybbs.bean.IndexTopic;

/**
 * 首页初始化
 * IndexInitDao
 * 创建人:chenPeng
 * 时间：2018年7月14日-下午10:37:04 
 * @version 1.0.0
 * 
 */
public interface IndexInitDao {
	/**
	 * 得到最新的几个回帖数据
	 * 方法名：getRplay
	 * 创建人：chenPeng
	 * 时间：2018年7月14日-下午10:38:36 
	 * 手机:17673111810
	 * @return List<IndexRplay>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexRplay> getRplay();
	
	/**
	 * 得到首页的热帖
	 * 方法名：getTopic
	 * 创建人：chenPeng
	 * 时间：2018年7月14日-下午11:27:39 
	 * 手机:17673111810
	 * @return List<IndexTopic>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexTopic> getTopic();
	
	/**
	 * 得到首页的全景业界资讯
	 * 方法名：getPanoramicWork
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:03:29 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getPanoramicIndustryInformation();
	
	/**
	 * 得到首页的全景作品
	 * 方法名：getPanoramicWork
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:34:04 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getPanoramicWork();
	
	/**
	 * 得到首页的生活纪实
	 * 方法名：getLifeDocumentary
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:34:13 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getLifeDocumentary();
	
	/**
	 * 得到首页的全景学苑
	 * 方法名：getPanoramaAcademy
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:34:18 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getPanoramaAcademy();
	
	/**
	 * 得到首页的资源下载
	 * 方法名：getDownload
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:34:22 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getDownload();
	
	/**
	 * 得到首页的交流分享
	 * 方法名：getExchangeSharing
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:34:29 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getExchangeSharing();
}

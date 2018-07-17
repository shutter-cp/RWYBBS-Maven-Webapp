/**
 * chenPeng
 * com.rwybbs.service
 * BbsIndexService.java
 * 创建人:chenpeng
 * 时间：2018年7月14日-上午12:00:12 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.IndexFourm;
import com.rwybbs.bean.IndexRplay;
import com.rwybbs.bean.IndexTopic;
import com.rwybbs.core.WordTruncation;
import com.rwybbs.dao.IndexInitDao;

/**
 * 
 * BbsIndexService
 * 创建人:chenPeng
 * 时间：2018年7月14日-上午12:00:12 
 * @version 1.0.0
 * 
 */
@Service
public class IndexService {
	@Autowired
	private IndexInitDao indexInitDao;
	
	/**
	 * 得到首页的最新回复
	 * 方法名：getIndexRpaly
	 * 创建人：chenPeng
	 * 时间：2018年7月14日-下午10:45:09 
	 * 手机:17673111810
	 * @return List<IndexRplay>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexRplay> getIndexRpaly(){
		WordTruncation truncation = new WordTruncation();
		//控制字数
		List<IndexRplay> rplayList = indexInitDao.getRplay();
		for (IndexRplay indexRplay : rplayList) {
			 indexRplay.setRcontent(
					 truncation.truncation9(
							 indexRplay.getRcontent()));
		}
		return rplayList;
	}
	
	/**
	 * 得到首页的热帖
	 * 方法名：getIndexTopic
	 * 创建人：chenPeng
	 * 时间：2018年7月14日-下午11:33:05 
	 * 手机:17673111810
	 * @return List<IndexTopic>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexTopic> getIndexTopic(){
		WordTruncation truncation = new WordTruncation();
		//控制字数
		List<IndexTopic> topicList = indexInitDao.getTopic();
		for (IndexTopic indexTopic : topicList) {
			indexTopic.setTtopic(
					truncation.truncation9(
							indexTopic.getTtopic()));
		}
		return topicList;
	}
	/**
	 * 得到首页的热帖短的
	 * 方法名：getIndexTopicMini
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午6:22:27 
	 * 手机:17673111810
	 * @return List<IndexTopic>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexTopic> getIndexTopicMini(){
		WordTruncation truncation = new WordTruncation();
		//控制字数
		List<IndexTopic> topicList = indexInitDao.getTopic();
		for (IndexTopic indexTopic : topicList) {
			indexTopic.setTtopic(
					truncation.truncation5(
							indexTopic.getTtopic()));
		}
		return topicList;
	}
	
	
	
	
	/**
	 * 得到首页的全景业界资讯
	 * 方法名：getPanoramicIndustryInformation
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:10:57 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getPanoramicIndustryInformation(){
		WordTruncation truncation = new WordTruncation();
		List<IndexFourm> fourmList = 
				indexInitDao.getPanoramicIndustryInformation();
		for (IndexFourm indexFourm : fourmList) {
			indexFourm.setSstatement(
					truncation.truncation8(
							indexFourm.getSstatement()));
		}
		return fourmList;
	}
	
	/**
	 * 得到首页的全景作品
	 * 方法名：getPanoramicWork
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:38:02 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getPanoramicWork(){
		WordTruncation truncation = new WordTruncation();
		List<IndexFourm> fourmList = 
				indexInitDao.getPanoramicWork();
		for (IndexFourm indexFourm : fourmList) {
			indexFourm.setSstatement(
					truncation.truncation8(
							indexFourm.getSstatement()));
		}
		return fourmList;
	}
	
	/**
	 * 得到首页的生活纪实
	 * 方法名：getLifeDocumentary
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:38:07 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getLifeDocumentary(){
		WordTruncation truncation = new WordTruncation();
		List<IndexFourm> fourmList = 
				indexInitDao.getLifeDocumentary();
		for (IndexFourm indexFourm : fourmList) {
			indexFourm.setSstatement(
					truncation.truncation8(
							indexFourm.getSstatement()));
		}
		return fourmList;
	}
	
	/**
	 * 得到首页的全景学苑
	 * 方法名：getPanoramaAcademy
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:38:15 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getPanoramaAcademy(){
		WordTruncation truncation = new WordTruncation();
		List<IndexFourm> fourmList = 
				indexInitDao.getPanoramaAcademy();
		for (IndexFourm indexFourm : fourmList) {
			indexFourm.setSstatement(
					truncation.truncation8(
							indexFourm.getSstatement()));
		}
		return fourmList;
	}
	
	/**
	 * 得到首页的资源下载
	 * 方法名：getDownload
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:38:40 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getDownload(){
		WordTruncation truncation = new WordTruncation();
		List<IndexFourm> fourmList = 
				indexInitDao.getDownload();
		for (IndexFourm indexFourm : fourmList) {
			indexFourm.setSstatement(
					truncation.truncation8(
							indexFourm.getSstatement()));
		}
		return fourmList;
	}
	
	/**
	 * 得到首页的交流分享
	 * 方法名：getExchangeSharing
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午12:38:47 
	 * 手机:17673111810
	 * @return List<IndexFourm>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<IndexFourm> getExchangeSharing(){
		WordTruncation truncation = new WordTruncation();
		List<IndexFourm> fourmList = 
				indexInitDao.getExchangeSharing();
		for (IndexFourm indexFourm : fourmList) {
			indexFourm.setSstatement(
					truncation.truncation8(
							indexFourm.getSstatement()));
		}
		return fourmList;
	}
	
}

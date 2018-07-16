/**
 * chenPeng
 * com.rwybbs.web
 * BbsIndex.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午11:56:17 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.IndexFourm;
import com.rwybbs.bean.IndexRplay;
import com.rwybbs.bean.IndexTopic;
import com.rwybbs.service.IndexService;

/**
 * 
 * BbsIndex
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午11:56:17 
 * @version 1.0.0
 * 
 */
@Controller
public class IndexWeb {
	@Autowired
	private IndexService indexService;
	
	
	@RequestMapping("bbs/index")
	public ModelAndView indexInit(){
		ModelAndView andView = new ModelAndView();
		/*最新回复*/
		List<IndexRplay> rplayList = indexService.getIndexRpaly();
		/*热帖*/
		List<IndexTopic> topicList = indexService.getIndexTopic();
		/*全景业界资讯*/
		List<IndexFourm> fourmList1 = 
				indexService.getPanoramicIndustryInformation();
		/*全景作品*/
		List<IndexFourm> fourmList2 = 
				indexService.getPanoramicWork();
		/*生活纪实*/
		List<IndexFourm> fourmList3 = 
				indexService.getLifeDocumentary();
		/*全景学苑*/
		List<IndexFourm> fourmList4 = 
				indexService.getPanoramaAcademy();
		/*资源下载*/
		List<IndexFourm> fourmList5 = 
				indexService.getDownload();
		/*交流分享*/
		List<IndexFourm> fourmList6 = 
				indexService.getExchangeSharing();
		
		andView.addObject("rplayList", rplayList);
		andView.addObject("topicList", topicList);
		andView.addObject("fourmList1", fourmList1);
		andView.addObject("fourmList2", fourmList2);
		andView.addObject("fourmList3", fourmList3);
		andView.addObject("fourmList4", fourmList4);
		andView.addObject("fourmList5", fourmList5);
		andView.addObject("fourmList6", fourmList6);
		
		andView.setViewName("bbs/bbsindex");
		return andView;
	}
	
}

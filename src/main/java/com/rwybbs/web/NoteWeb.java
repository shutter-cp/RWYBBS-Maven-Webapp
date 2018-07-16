/**
 * chenPeng
 * com.rwybbs.web
 * NoteWeb.java
 * 创建人:chenpeng
 * 时间：2018年7月15日-上午8:48:40 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rwybbs.bean.IndexTopic;
import com.rwybbs.bean.Note;
import com.rwybbs.bean.NoteRplay;
import com.rwybbs.core.IsNull;
import com.rwybbs.service.IndexService;
import com.rwybbs.service.NoteService;

/**
 * 论坛详情页面
 * NoteWeb
 * 创建人:chenPeng
 * 时间：2018年7月15日-上午8:48:40 
 * @version 1.0.0
 * 
 */
@Controller
public class NoteWeb {
	@Autowired
	private NoteService noteService;
	@Autowired
	private IndexService indexService;
	
	
	/**
	 * 获取指定页面的论坛
	 * 方法名：getNote
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午9:01:38 
	 * 手机:17673111810
	 * @param no
	 * @return ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping("bbs/note/{no}")
	public ModelAndView getNote(@PathVariable Integer no){
		ModelAndView andView = new ModelAndView();
		/*增加一次文章浏览量*/
		noteService.upDateTClickCoount(no);
		/*增加一次板块浏览量*/
		noteService.upDateSClickCoount(no);
		
		
		/*得到主体部分数据*/
		Note note = noteService.getNoteMain(no);
		/*得到评论部分数据*/
		List<NoteRplay> noteRplayList = noteService.getNoteRplay(no);
		/*得到热帖*/
		List<IndexTopic> topicList = indexService.getIndexTopic();
		
		
		andView.addObject("note", note);
		andView.addObject("noteRplayList", noteRplayList);
		andView.addObject("topicList", topicList);
		andView.setViewName("bbs/bbsnote");
		return andView;
	}
	
	/**
	 * 写评论
	 * 方法名：setRplay
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午12:48:36 
	 * 手机:17673111810
	 * @param re
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(method=RequestMethod.POST,value="bbs/note/write")
	@ResponseBody
	public String setRplay(HttpServletRequest re){
		String text = re.getParameter("text");
		String no = re.getParameter("no");
		String username = (String) re.getSession().getAttribute("username");
		IsNull isNull = new IsNull();
		if (isNull.isNull(text)||
				isNull.isNull(no)||
					isNull.isNull(text)) {
			return "isNull";
		}
		
		noteService.setNoteRplay(text, no, username);
		return "success";
	}
}

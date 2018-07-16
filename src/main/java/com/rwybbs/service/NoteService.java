/**
 * chenPeng
 * com.rwybbs.service
 * NoteService.java
 * 创建人:chenpeng
 * 时间：2018年7月15日-上午11:00:50 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.Note;
import com.rwybbs.bean.NoteRplay;
import com.rwybbs.bean.NoteRplayAdd;
import com.rwybbs.dao.NoteDao;

/**
 * 
 * NoteService
 * 创建人:chenPeng
 * 时间：2018年7月15日-上午11:00:50 
 * @version 1.0.0
 * 
 */
@Service
public class NoteService {
	@Autowired
	private NoteDao noteDao;
	
	/**
	 * 得到论坛详情页面的主体数据
	 * 方法名：getNoteMain
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午11:04:09 
	 * 手机:17673111810
	 * @param no
	 * @return Note
	 * @exception 
	 * @since  1.0.0
	 */
	public Note getNoteMain(Integer no){
		return noteDao.getNoteMain(no);
	}
	
	/**
	 * 得到论坛详情页面的评论数据
	 * 方法名：getNoteRplay
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午11:28:39 
	 * 手机:17673111810
	 * @param no
	 * @return NoteRplay
	 * @exception 
	 * @since  1.0.0
	 */
	public List<NoteRplay> getNoteRplay(Integer no){
		return noteDao.getNoteRplay(no);
	}
	
	/**
	 * 写评论
	 * 方法名：setNoteRplay
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午1:24:19 
	 * 手机:17673111810
	 * @param text
	 * @param no
	 * @param username void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setNoteRplay(String text,String no,String username){
		NoteRplayAdd note = new NoteRplayAdd();
		note.setRcontent(text);
		note.setRtid(Integer.parseInt(no));
		note.setUsername(username);
		noteDao.setNoteRplay(note);
	}
	
	/**
	 * 文章浏览量加加
	 * 方法名：upDateTClickCoount
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:57:38 
	 * 手机:17673111810
	 * @param no void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upDateTClickCoount(Integer no){
		noteDao.upDateTClickCoount(no);
	}
	
	/**
	 * 板块浏览量加加
	 * 方法名：upDateSClickCoount
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:57:44 
	 * 手机:17673111810
	 * @param no void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upDateSClickCoount(Integer no){
		noteDao.upDateSClickCoount(no);
	}
}

/**
 * chenPeng
 * com.rwybbs.dao
 * NoteDao.java
 * 创建人:chenpeng
 * 时间：2018年7月15日-上午10:50:04 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.Note;
import com.rwybbs.bean.NoteRplay;
import com.rwybbs.bean.NoteRplayAdd;

/**
 * 通过id来查询出详情页面
 * NoteDao
 * 创建人:chenPeng
 * 时间：2018年7月15日-上午10:50:04 
 * @version 1.0.0
 * 
 */
public interface NoteDao {
	/**
	 * 得到页面的主题部分
	 * 方法名：getNoteMain
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午10:53:31 
	 * 手机:17673111810
	 * @param no
	 * @return Note
	 * @exception 
	 * @since  1.0.0
	 */
	public Note getNoteMain(Integer no);
	
	/**
	 * 得到页面的评论部分
	 * 方法名：getNoteRplay
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-上午11:25:14 
	 * 手机:17673111810
	 * @param no
	 * @return NoteRplay
	 * @exception 
	 * @since  1.0.0
	 */
	public List<NoteRplay> getNoteRplay(Integer no);
	
	/**
	 * 写入评论
	 * 方法名：setNoteRplay
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午1:13:45 
	 * 手机:17673111810
	 * @param note void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setNoteRplay(NoteRplayAdd note);
	
	/**
	 * 文章浏览量加加
	 * 方法名：upDateTClickCoount
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:55:15 
	 * 手机:17673111810
	 * @param no void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upDateTClickCoount(Integer no);
	
	/**
	 * 模块浏览量加加
	 * 方法名：upDateSClickCoount
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:55:38 
	 * 手机:17673111810
	 * @param no void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upDateSClickCoount(Integer no);
	
}

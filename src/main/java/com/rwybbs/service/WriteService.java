/**
 * chenPeng
 * com.rwybbs.service
 * WriteService.java
 * 创建人:chenpeng
 * 时间：2018年7月15日-下午9:35:49 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.NoteIdAndUsername;
import com.rwybbs.bean.UpWriteDo;
import com.rwybbs.bean.UpWriteInit;
import com.rwybbs.bean.Write;
import com.rwybbs.dao.WriteDao;

/**
 * 
 * WriteService
 * 创建人:chenPeng
 * 时间：2018年7月15日-下午9:35:49 
 * @version 1.0.0
 * 
 */
@Service
public class WriteService {
	@Autowired
	private WriteDao writeDao;
	@Autowired
	private HttpServletRequest rq;
	
	/**
	 * 得到板块信息
	 * 方法名：getSname
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午9:37:52 
	 * 手机:17673111810
	 * @return List<String>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<String> getSname(){
		return writeDao.getSname();
	}
	
	/**
	 * 写论坛 
	 * 方法名：setWrite
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:07:45 
	 * 手机:17673111810
	 * @param wirte void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setWrite(Write write){
		writeDao.setWrite(write);
	}
	
	/**
	 * 篇数加一
	 * 方法名：upDateSTopicCount
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:42:44 
	 * 手机:17673111810
	 * @param sname void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upDateSTopicCount(String sname){
		writeDao.upDateSTopicCount(sname);
	}
	
	/**
	 * 修改论坛时数据回填
	 * 方法名：upWriteInit
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午5:05:32 
	 * 手机:17673111810
	 * @param no
	 * @return UpWriteInit
	 * @exception 
	 * @since  1.0.0
	 */
	public UpWriteInit upWriteInit(Integer no){
		return writeDao.upWriteInit(no);
	}
	
	/**
	 * 判断文章是不是你写的
	 * 方法名：eqNoteUser
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午5:05:51 
	 * 手机:17673111810
	 * @param nu
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer eqNoteUser(Integer no){
		String username = (String) rq.getSession().getAttribute("username");
		NoteIdAndUsername andUsername = new NoteIdAndUsername();
		andUsername.setTid(no);
		andUsername.setUsername(username);
		return writeDao.eqNoteUser(andUsername);
	}
	
	/**
	 * 修改执行
	 * 方法名：upWriteDo
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午6:08:54 
	 * 手机:17673111810
	 * @param title
	 * @param text
	 * @param tid void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upWriteDo(String title,String text,String tid){
		UpWriteDo upWriteDo = new UpWriteDo();
		upWriteDo.setText(text);
		upWriteDo.setTid(Integer.parseInt(tid));
		upWriteDo.setTitle(title);

		writeDao.upWriteDo(upWriteDo);
	}
}

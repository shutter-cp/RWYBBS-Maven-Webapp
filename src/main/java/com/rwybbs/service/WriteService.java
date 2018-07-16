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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

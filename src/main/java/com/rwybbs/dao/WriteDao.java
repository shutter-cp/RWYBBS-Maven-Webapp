/**
 * chenPeng
 * com.rwybbs.dao
 * WriteDao.java
 * 创建人:chenpeng
 * 时间：2018年7月15日-下午9:33:35 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.NoteIdAndUsername;
import com.rwybbs.bean.UpWriteDo;
import com.rwybbs.bean.UpWriteInit;
import com.rwybbs.bean.Write;

/**
 * 
 * WriteDao
 * 创建人:chenPeng
 * 时间：2018年7月15日-下午9:33:35 
 * @version 1.0.0
 * 
 */
public interface WriteDao {
	/**
	 * 得到板块名称
	 * 方法名：getSname
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午9:42:25 
	 * 手机:17673111810
	 * @return List<String>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<String> getSname();
	
	/**
	 * 写论坛
	 * 方法名：setWrite
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:06:14 
	 * 手机:17673111810
	 * @param write void
	 * @exception 
	 * @since  1.0.0
	 */
	public void setWrite(Write write);
	
	/**
	 * 增加文章篇数
	 * 方法名：upDateSTopicCount
	 * 创建人：chenPeng
	 * 时间：2018年7月15日-下午10:40:51 
	 * 手机:17673111810
	 * @param sname void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upDateSTopicCount(String sname);
	
	/**
	 * 修改论坛时数据回填
	 * 方法名：upWriteInit
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午4:50:14 
	 * 手机:17673111810
	 * @param no
	 * @return UpWriteInit
	 * @exception 
	 * @since  1.0.0
	 */
	public UpWriteInit upWriteInit(Integer no);
	
	/**
	 * 根据传入文章id和用户名的值来判断出是不是该用户的文章
	 * 方法名：eqNoteUser
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午4:51:50 
	 * 手机:17673111810
	 * @return Integer
	 * @exception 
	 * @since  1.0.0
	 */
	public Integer eqNoteUser(NoteIdAndUsername nu);
	
	/**
	 * 修改执行
	 * 方法名：upWriteDo
	 * 创建人：chenPeng
	 * 时间：2018年7月16日-下午6:07:47 
	 * 手机:17673111810
	 * @param up void
	 * @exception 
	 * @since  1.0.0
	 */
	public void upWriteDo(UpWriteDo up);
	
}

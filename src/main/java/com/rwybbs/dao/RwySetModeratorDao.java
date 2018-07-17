package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.SetModeratorForum;

public interface RwySetModeratorDao {
	/**
	 * 通过表单传值添加新的版块并赋予版主
	 * 方法名：smf
	 * 创建人：lxf
	 * 时间：2018年7月16日-下午3:41:46 
	 * 手机:18973117682
	 * @param smf
	 * @return List<SetModeratorForum>
	 * @exception 
	 * @since  1.0.0
	 */
	public void smf(SetModeratorForum smf);
}

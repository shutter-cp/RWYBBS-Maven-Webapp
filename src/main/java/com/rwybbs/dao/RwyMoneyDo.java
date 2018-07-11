/**
 * chenPeng
 * com.rwybbs.dao
 * RwyMoneyDo.java
 * 创建人:chenpeng
 * 时间：2018年7月11日-上午10:42:01 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.dao;

import java.util.List;

import com.rwybbs.bean.MoneyUser;

/**
 * 
 * RwyMoneyDo
 * 创建人:chenPeng
 * 时间：2018年7月11日-上午10:42:01 
 * @version 1.0.0
 * 
 */
public interface RwyMoneyDo {
	/**
	 * 通过用户名获取到支付需要的信息
	 * 方法名：money
	 * 创建人：chenPeng
	 * 时间：2018年7月11日-上午10:45:19 
	 * 手机:17673111810
	 * @param username
	 * @return List<MoneyUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<MoneyUser> money(String username);
}

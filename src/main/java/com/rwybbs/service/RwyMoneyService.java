/**
 * chenPeng
 * com.rwybbs.service
 * RwyMoneyService.java
 * 创建人:chenpeng
 * 时间：2018年7月11日-上午10:51:46 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.MoneyUser;
import com.rwybbs.dao.RwyMoneyDo;

/**
 * 
 * RwyMoneyService
 * 创建人:chenPeng
 * 时间：2018年7月11日-上午10:51:46 
 * @version 1.0.0
 * 
 */
@Service
public class RwyMoneyService {
	@Autowired
	private RwyMoneyDo rwyMoneyDo;
	
	public List<MoneyUser> MoneyService(String username){
		List<MoneyUser> userList = rwyMoneyDo.money(username);
		if (userList.size()==0) {
			return null;
		}
		return userList;
	}
}

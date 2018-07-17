package com.rwybbs.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.SetModeratorForum;
import com.rwybbs.bean.UsersWithAdmin;
import com.rwybbs.dao.RwyAdminDao;
import com.rwybbs.dao.RwySetModeratorDao;
/**
 * 
 * 
 * RwySetModeratorService
 * 创建人:lxf
 * 时间：2018年7月16日-下午3:44:50 
 * @version 1.0.0
 *
 */

@Service
public class RwySetModeratorService {
	@Autowired
	private RwySetModeratorDao rwySetModeratorDao;
	
	public void SMFService(String SName,String UName,String SProfile,String SStatement){
		SetModeratorForum smf = new SetModeratorForum();
		smf.setSName(SName);
		smf.setUName(UName);
		smf.setSProfile(SProfile);
		smf.setSStatement(SStatement);
		rwySetModeratorDao.smf(smf);
	}
}
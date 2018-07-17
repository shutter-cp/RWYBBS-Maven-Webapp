package com.rwybbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwybbs.bean.TopicWithAdmin;
import com.rwybbs.bean.UsersWithAdmin;
import com.rwybbs.dao.RwyAdminDao;


/**
 * 
 * 
 * RwyAdminService
 * 创建人:lxf
 * 时间：2018年7月16日-下午3:43:19 
 * @version 1.0.0
 *
 */
@Service
public class RwyAdminService {
	@Autowired
	private RwyAdminDao rwyAdminDao;
	
	public List<UsersWithAdmin> UWAService(){
		List<UsersWithAdmin> uwalist = rwyAdminDao.uwa();
		if (uwalist.size()==0) {
			return null;
		}
		return uwalist;
	}
	public List<UsersWithAdmin> UWASService(String UName){
		TopicWithAdmin twa=new TopicWithAdmin();
		twa.setUName(UName);
		List<UsersWithAdmin> uwaslist = rwyAdminDao.uwas(UName);
		if (uwaslist.size()==0) {
			return null;
		}
		return uwaslist;
	}
	public void UMADService(String UName){
		UsersWithAdmin uwa=new UsersWithAdmin();
		uwa.setUName(UName);
		rwyAdminDao.uwad(uwa);
	}
	public List<TopicWithAdmin> TWAService(){
		List<TopicWithAdmin> twalist = rwyAdminDao.twa();
		if (twalist.size()==0) {
			return null;
		}
		return twalist;
	}
	public List<TopicWithAdmin> TWASService(String TTopic){
		TopicWithAdmin twa=new TopicWithAdmin();
		twa.setUName(TTopic);
		List<TopicWithAdmin> twaslist = rwyAdminDao.twas(TTopic);
		if (twaslist.size()==0) {
			return null;
		}
		return twaslist;
	}
	public void TMADService(String TTopic,Integer TID,String UName){
		TopicWithAdmin twa=new TopicWithAdmin();
		twa.setTTopic(TTopic);
		twa.setTID(TID);
		twa.setUName(UName);
		rwyAdminDao.twad(twa);
	}
	public void TMAUService(String TTopic,Integer TID,String UName){
		TopicWithAdmin twa=new TopicWithAdmin();
		twa.setTTopic(TTopic);
		twa.setTID(TID);
		twa.setUName(UName);
		rwyAdminDao.twau(twa);
	}
	public List<TopicWithAdmin> TWMService(String UName){
		List<TopicWithAdmin> twmlist = rwyAdminDao.twm(UName);
		if (twmlist.size()==0) {
			return null;
		}
		return twmlist;
	}
	public List<TopicWithAdmin> TWMSService(String UName,String TTopic){
		TopicWithAdmin twa=new TopicWithAdmin();
		twa.setUName(UName);
		twa.setTTopic(TTopic);
		List<TopicWithAdmin> twmslist = rwyAdminDao.twms(twa);
		if (twmslist.size()==0) {
			return null;
		}
		return twmslist;
	}
}

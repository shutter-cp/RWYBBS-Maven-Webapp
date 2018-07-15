/**
 * chenPeng
 * com.rwybbs.bean
 * RwyUser.java
 * 创建人:chenpeng
 * 时间：2018年7月13日-下午4:07:27 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.bean;

import java.util.Date;

/**
 * 老项目数据库的user
 * RwyUser
 * 创建人:chenPeng
 * 时间：2018年7月13日-下午4:07:27 
 * @version 1.0.0
 * 
 */
public class RwyUser {
	private Integer uid;
	private String uname;
	private String upassword;
	private String umailbox;
	private String phone_number;
	private Integer takegold;
	private Date createdate;
	private String upicture;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUmailbox() {
		return umailbox;
	}
	public void setUmailbox(String umailbox) {
		this.umailbox = umailbox;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Integer getTakegold() {
		return takegold;
	}
	public void setTakegold(Integer takegold) {
		this.takegold = takegold;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getUpicture() {
		return upicture;
	}
	public void setUpicture(String upicture) {
		this.upicture = upicture;
	}
	
	
}

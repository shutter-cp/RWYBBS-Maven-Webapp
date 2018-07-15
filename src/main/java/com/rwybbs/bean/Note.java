/**
 * chenPeng
 * com.rwybbs.bean
 * Note.java
 * 创建人:chenpeng
 * 时间：2018年7月15日-上午10:30:51 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.bean;

/**
 * 
 * Note
 * 创建人:chenPeng
 * 时间：2018年7月15日-上午10:30:51 
 * @version 1.0.0
 * 
 */
public class Note {
	private Integer tid;
	private String ttopic;
	private Integer tclickcoount;
	private String date;
	private String tcontents;
	private String guhead;
	private String guname;
	private Integer gupoint;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTtopic() {
		return ttopic;
	}
	public void setTtopic(String ttopic) {
		this.ttopic = ttopic;
	}
	public Integer getTclickcoount() {
		return tclickcoount;
	}
	public void setTclickcoount(Integer tclickcoount) {
		this.tclickcoount = tclickcoount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTcontents() {
		return tcontents;
	}
	public void setTcontents(String tcontents) {
		this.tcontents = tcontents;
	}
	public String getGuhead() {
		return guhead;
	}
	public void setGuhead(String guhead) {
		this.guhead = guhead;
	}
	public String getGuname() {
		return guname;
	}
	public void setGuname(String guname) {
		this.guname = guname;
	}
	public Integer getGupoint() {
		return gupoint;
	}
	public void setGupoint(Integer gupoint) {
		this.gupoint = gupoint;
	}
	
}

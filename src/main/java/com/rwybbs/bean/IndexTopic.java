/**
 * chenPeng
 * com.rwybbs.bean
 * IndexTopic.java
 * 创建人:chenpeng
 * 时间：2018年7月14日-下午11:24:27 
 * 2018陈鹏-版权所有
 */
package com.rwybbs.bean;

/**
 * 首页的热帖
 * IndexTopic
 * 创建人:chenPeng
 * 时间：2018年7月14日-下午11:24:27 
 * @version 1.0.0
 * 
 */
public class IndexTopic {
	private Integer tid;
	private String ttopic;
	private String date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}

package com.rwybbs.bean;

public class Forum {
	private Integer SID;
	private String SName;
	private Integer SMasterID;
	private Integer STopicCount;
	private Integer SClickCoount;
	private String UName;
	private String SProfile;
	private String SStatement;
	public Integer getSID() {
		return SID;
	}
	public void setSID(Integer sID) {
		SID = sID;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public Integer getSMasterID() {
		return SMasterID;
	}
	public void setSMasterID(Integer sMasterID) {
		SMasterID = sMasterID;
	}
	public Integer getSTopicCount() {
		return STopicCount;
	}
	public void setSTopicCount(Integer sTopicCount) {
		STopicCount = sTopicCount;
	}
	public Integer getSClickCoount() {
		return SClickCoount;
	}
	public void setSClickCoount(Integer sClickCoount) {
		SClickCoount = sClickCoount;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	public String getSProfile() {
		return SProfile;
	}
	public void setSProfile(String sProfile) {
		SProfile = sProfile;
	}
	public String getSStatement() {
		return SStatement;
	}
	public void setSStatement(String sStatement) {
		SStatement = sStatement;
	}
	
}

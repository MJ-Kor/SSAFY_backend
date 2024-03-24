package com.ssafy.sample.model.dto;

public class MemberDto {
	String userId; 
	String userName;
	String passWord;
	String emailId;
	String emailDomain;
	String joinDat;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getJoinDat() {
		return joinDat;
	}
	public void setJoinDat(String joinDat) {
		this.joinDat = joinDat;
	}
	@Override
	public String toString() {
		return "memberDto [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", emailId="
				+ emailId + ", emailDomain=" + emailDomain + ", joinDat=" + joinDat + "]";
	}
	
	
	

}

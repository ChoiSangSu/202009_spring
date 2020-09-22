package com.myboard.dto;

public class MemberDTO{
	private String userid;
	private String passwd;
	private String email;
	private String filename;
	public MemberDTO() {
		super();
	}
	public MemberDTO(String userid, String passwd, String email, String filename) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.email = email;
		this.filename = filename;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", email=" + email + ", filename=" + filename
				+ "]";
	}
	
}

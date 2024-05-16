package com.triplay.member.dto;

public class Member {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_email;
	private String salt;
	private int token_id;
	private String member_status;
	private int score;
	
	public Member(String member_id, String member_pw, String member_name, String member_email, String salt,
			int token_id, String member_status, int score) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_email = member_email;
		this.salt = salt;
		this.token_id = token_id;
		this.member_status = member_status;
		this.score = score;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getToken_id() {
		return token_id;
	}
	public void setToken_id(int token_id) {
		this.token_id = token_id;
	}
	public String getMember_status() {
		return member_status;
	}
	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", member_pw=" + member_pw + ", member_name=" + member_name
				+ ", member_email=" + member_email + ", salt=" + salt + ", token_id=" + token_id + ", member_status="
				+ member_status + ", score=" + score + "]";
	}
}

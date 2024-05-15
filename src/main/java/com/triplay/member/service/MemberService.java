package com.triplay.member.service;

import com.triplay.member.dto.Member;
import com.triplay.member.dto.MemberToken;

public interface MemberService {
//	public String login(String id, String pw);
//	public Member getMemberByToken(String access_token);
//	public void removeMember(String id);
//	public void updateMember(Member m);
//	public boolean isAccessible(String access_token);
//	public boolean isRefreshable(String refresh_token);
//	public String renewAccessToken(String refresh_token);
//	public String renewRefreshToken();
	
	public MemberToken login(String id, String pw);
	public void signup(Member m);
	public Member getMember(String id);
	public boolean isIdExist(String id);
	public String findPassword(String id, String email);
	public void removeMember(String id);
	public void updateMember(Member m);
}

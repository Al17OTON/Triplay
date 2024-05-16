package com.triplay.member.repository;

import com.triplay.member.dto.Member;
import com.triplay.member.dto.MemberToken;

public interface MemberRepository {
	public MemberToken login(String id, String pw);
	public void signup(Member m);
	public Member getMember(String id);
	public boolean isIdExist(String id);
	public String findPassword(String id, String email);
	public void removeMember(String id);
	public void updateMember(Member m);
}

package com.triplay.member.repository;

import org.springframework.stereotype.Repository;

import com.triplay.member.dto.Member;
import com.triplay.member.dto.MemberToken;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public MemberToken login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signup(Member m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIdExist(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findPassword(String id, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeMember(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(Member m) {
		// TODO Auto-generated method stub
		
	}

}

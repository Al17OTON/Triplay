package com.triplay.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triplay.member.dto.Member;
import com.triplay.member.dto.MemberToken;
import com.triplay.member.repository.MemberRepository;

@Service
public class MemberTokenServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository memberRepo;
	
	@Override
	public MemberToken login(String id, String pw) {
		return memberRepo.login(id, pw);
	}

	@Override
	public void signup(Member m) {
		memberRepo.signup(m);
	}

	@Override
	public Member getMember(String id) {
		return memberRepo.getMember(id);
	}

	@Override
	public boolean isIdExist(String id) {
		return memberRepo.isIdExist(id);
	}

	@Override
	public String findPassword(String id, String email) {
		return memberRepo.findPassword(id, email);
	}

	@Override
	public void removeMember(String id) {
		memberRepo.removeMember(id);
	}

	@Override
	public void updateMember(Member m) {
		memberRepo.updateMember(m);
	}

}

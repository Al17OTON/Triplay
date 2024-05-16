package com.triplay.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triplay.member.dto.MemberDto;
import com.triplay.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public MemberDto login(String member_id, String member_pw) throws Exception {
		return memberMapper.login(member_id, member_pw);
	}

	@Override
	public void signup(MemberDto m) throws Exception {
		memberMapper.signup(m);
	}

	@Override
	public MemberDto getMember(String member_id) throws Exception {
		return memberMapper.getMember(member_id);
	}

	@Override
	public boolean isIdExist(String member_id) throws Exception {
		return memberMapper.isIdExist(member_id);
	}

	@Override
	public String findPassword(String member_id, String member_email) throws Exception {
		return memberMapper.findPassword(member_id, member_email);
	}

	@Override
	public void removeMember(String member_id) throws Exception {
		memberMapper.removeMember(member_id);
	}

	@Override
	public void modifyMember(MemberDto m) throws Exception {
		memberMapper.modifyMember(m);
	}
}

package com.triplay.member.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.triplay.member.dto.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(String member_id, String member_pw) throws Exception;
	public void signup(MemberDto m) throws Exception;
	public MemberDto getMember(String member_id) throws Exception;
	public boolean isIdExist(String member_id) throws Exception;
	public String findPassword(String member_id, String member_email) throws Exception;
	public void removeMember(String member_id) throws Exception;
	public void modifyMember(MemberDto m) throws Exception;
	
}

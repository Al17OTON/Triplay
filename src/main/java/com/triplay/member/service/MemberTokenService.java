package com.triplay.member.service;

import com.triplay.member.dto.MemberToken;

public interface MemberTokenService {
	public boolean isAccessible(String access_token);
	public boolean isRefreshable(String refresh_token);
	
	public MemberToken issueToken(String member_id);
	public String reissueAccessToken(String refresh_token);
}

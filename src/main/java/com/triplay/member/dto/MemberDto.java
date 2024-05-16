package com.triplay.member.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberDto {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_email;
	private String salt;
	private String member_status;
	private int score;
	private Timestamp member_register_time;	
}

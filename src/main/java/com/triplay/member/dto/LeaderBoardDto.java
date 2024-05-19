package com.triplay.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class LeaderBoardDto {
	private String member_id;
	private int score;
	private int rank;
}

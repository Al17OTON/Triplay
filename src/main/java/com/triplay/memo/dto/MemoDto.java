package com.triplay.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemoDto {
	private int memo_id;
	private String member_id;
	private String comment;
	private int ref;
	private int step;
	private int depth;
	private String memo_time;
	private int plan_id;
	
	
//	@Override
//	public int compareTo(MemoDto o) {
//		return Integer.compare(this.step, o.step);
//	}
}
